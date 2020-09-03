package com.github.dylanz666.util.listener;

import com.github.dylanz666.util.base.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.IAlterSuiteListener;
import org.testng.xml.*;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class AlterSuiteListener implements IAlterSuiteListener {
    @Autowired
    private FileUtil fileUtil;

    @Override
    public void alter(List<XmlSuite> suites) {
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\github\\dylanz666");
        File[] files = file.listFiles();

        //delete test result files in allure-results folder
//        fileUtil.deleteAllFiles(System.getProperty("user.dir") + "\\allure-results");

        XmlSuite suite = suites.get(0);
        XmlTest xmlTest = new XmlTest(suite);
        XmlClass xmlClass = new XmlClass();
        xmlTest.setName("Test");

        String groupTag = System.getProperty("tag");
        String suiteName = System.getProperty("suite");

        //run by group
        if (groupTag != null && !groupTag.equals("")) {
            //set groups
            if (!groupTag.toLowerCase().equals("all")) {
                XmlGroups xmlGroups = new XmlGroups();
                XmlRun xmlRun = new XmlRun();
                xmlRun.onInclude(groupTag);
                xmlGroups.setRun(xmlRun);
                xmlTest.setGroups(xmlGroups);
            }

            //run by package, this is for suite is ended with "*"
            if (!suiteName.equals("") && !suiteName.toLowerCase().equals("all") && suiteName.endsWith(".*")) {
                XmlPackage xmlPackage = new XmlPackage("com.github.dylanz666." + suiteName);
                xmlTest.setPackages(Collections.singletonList(xmlPackage));
                return;
            }

            //set class scope when both tag and suite have value
            if (!suiteName.equals("") && !suiteName.toLowerCase().equals("all")) {
                suiteName = "com.github.dylanz666." + suiteName;
                xmlClass.setName(suiteName);
                xmlTest.setClasses(Collections.singletonList(xmlClass));
                return;
            }

            //set package scope
            XmlPackage xmlPackage = new XmlPackage("com.github.dylanz666.*");
            xmlTest.setPackages(Collections.singletonList(xmlPackage));
            return;
        }

        //run by package, this is for suite is ended with "*"
        if (suiteName != null && !suiteName.equals("") && !suiteName.toLowerCase().equals("all") && suiteName.endsWith(".*")) {
            XmlPackage xmlPackage = new XmlPackage("com.github.dylanz666." + suiteName);
            xmlTest.setPackages(Collections.singletonList(xmlPackage));
            return;
        }

        //run by classes, this is for groupTag is null or ""
        if (suiteName != null && !suiteName.equals("") && !suiteName.toLowerCase().equals("all")) {
            suiteName = "com.github.dylanz666." + suiteName;
            xmlClass.setName(suiteName);
            xmlTest.setClasses(Collections.singletonList(xmlClass));
            return;
        }

        //default run by package
        XmlPackage xmlPackage = new XmlPackage("com.github.dylanz666.*");
        xmlTest.setPackages(Collections.singletonList(xmlPackage));
    }
}