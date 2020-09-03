package com.github.dylanz666.util.listener;

import com.github.dylanz666.App;
import com.github.dylanz666.util.base.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.testng.IAlterSuiteListener;
import org.testng.xml.*;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * @author : dylanz
 * @since : 09/03/2020
 */
public class AlterSuiteListener implements IAlterSuiteListener {
    private String groupId = "com.github.dylanz666";
    private String rootPath = groupId.replaceAll("\\.", "\\\\");

    @Autowired
    private FileUtil fileUtil;

    @Override
    public void alter(List<XmlSuite> suites) {
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\" + rootPath);
        File[] files = file.listFiles();

        //delete test result files in allure-results folder
//        fileUtil.deleteAllFiles(System.getProperty("user.dir") + "\\allure-results");

        XmlSuite suite = suites.get(0);
        XmlTest xmlTest = new XmlTest(suite);
        XmlClass xmlClass = new XmlClass();
        xmlTest.setName("Test");

        String groupTag = System.getProperty("tag");
        String suiteName = System.getProperty("suite");
        String suitePath = groupId + "." + suiteName;
        String packagePath = groupId + ".*";

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
                XmlPackage xmlPackage = new XmlPackage(suitePath);
                xmlTest.setPackages(Collections.singletonList(xmlPackage));
                return;
            }

            //set class scope when both tag and suite have value
            if (!suiteName.equals("") && !suiteName.toLowerCase().equals("all")) {
                xmlClass.setName(suitePath);
                xmlTest.setClasses(Collections.singletonList(xmlClass));
                return;
            }

            //set package scope
            XmlPackage xmlPackage = new XmlPackage(packagePath);
            xmlTest.setPackages(Collections.singletonList(xmlPackage));
            return;
        }

        //run by package, this is for suite is ended with "*"
        if (suiteName != null && !suiteName.equals("") && !suiteName.toLowerCase().equals("all") && suiteName.endsWith(".*")) {
            XmlPackage xmlPackage = new XmlPackage(suitePath);
            xmlTest.setPackages(Collections.singletonList(xmlPackage));
            return;
        }

        //run by classes, this is for groupTag is null or ""
        if (suiteName != null && !suiteName.equals("") && !suiteName.toLowerCase().equals("all")) {
            xmlClass.setName(suitePath);
            xmlTest.setClasses(Collections.singletonList(xmlClass));
        }

        //default run by package
        XmlPackage xmlPackage = new XmlPackage(packagePath);
        xmlTest.setPackages(Collections.singletonList(xmlPackage));
    }
}