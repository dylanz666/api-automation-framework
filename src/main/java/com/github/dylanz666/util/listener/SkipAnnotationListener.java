package com.github.dylanz666.util.listener;

import com.github.dylanz666.util.annotation.Skip;
import com.github.dylanz666.util.base.DateUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Ignore;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author : dylanz
 * @since : 09/03/2020
 */
public class SkipAnnotationListener implements IAnnotationTransformer {
    @Autowired
    private Runtime runtime;
    private static ITestAnnotation testAnnotation;

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private RetryAnalyzer retryAnalyzer;

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class testClass, Constructor testConstructor,
                          Method testMethod) {
        String env = "cm";
        testAnnotation = iTestAnnotation;
        System.out.println(123);
        /*if (!iTestAnnotation.getEnabled()) {
            return;
        }
        //skip when @Ignore is existing in class
        Annotation ignoreAnnotation = testClass.getAnnotation(Ignore.class);
        if (ignoreAnnotation != null) {
            iTestAnnotation.setEnabled(false);
            return;
        }

        Skip annotation = testMethod.getAnnotation(Skip.class);
        if (annotation == null) {
            setRetryListener();
            return;
        }
        String beforeDate = annotation.before();
        String whenDate = annotation.when();
        String afterDate = annotation.after();
        DateTime today = new DateTime();
        DateTime todayStartDateTime = new DateTime(today.getYear(), today.getMonthOfYear(), today.getDayOfMonth(), 0, 0, 0);
        //skip when no conditions
        if (annotation.env().length == 0 && beforeDate.equals("") && whenDate.equals("") && afterDate.equals("")) {
            iTestAnnotation.setEnabled(false);
            return;
        }
        //skip for date
        if (annotation.env().length == 0) {
            if (!beforeDate.equals("")) {
                DateTime beforeDateTime = new DateTime(beforeDate);
                int days = dateUtil.getDaysBetween(todayStartDateTime, beforeDateTime);
                iTestAnnotation.setEnabled(days < 0);
            }
            if (!whenDate.equals("")) {
                DateTime whenDateTime = new DateTime(whenDate);
                int days = dateUtil.getDaysBetween(todayStartDateTime, whenDateTime);
                iTestAnnotation.setEnabled(days != 0);
            }
            if (!afterDate.equals("")) {
                DateTime afterDateTime = new DateTime(afterDate);
                int days = dateUtil.getDaysBetween(todayStartDateTime, afterDateTime);
                iTestAnnotation.setEnabled(days > 0);
            }

            setRetryListener();
            return;
        }

        //skip for env and date
        for (String skipEnv : annotation.env()) {
            if (skipEnv != null && !env.equals(skipEnv)) {
                iTestAnnotation.setEnabled(true);

                setRetryListener();
                continue;
            }

            if (env.equals(skipEnv)) {
                if (!beforeDate.equals("")) {
                    DateTime beforeDateTime = new DateTime(beforeDate);
                    int days = dateUtil.getDaysBetween(todayStartDateTime, beforeDateTime);
                    iTestAnnotation.setEnabled(days < 0);

                    setRetryListener();
                    break;
                }
                if (!whenDate.equals("")) {
                    DateTime whenDateTime = new DateTime(whenDate);
                    int days = dateUtil.getDaysBetween(todayStartDateTime, whenDateTime);
                    iTestAnnotation.setEnabled(days != 0);

                    setRetryListener();
                    break;
                }
                if (!afterDate.equals("")) {
                    DateTime afterDateTime = new DateTime(afterDate);
                    int days = dateUtil.getDaysBetween(todayStartDateTime, afterDateTime);
                    iTestAnnotation.setEnabled(days > 0);

                    setRetryListener();
                    break;
                }
                iTestAnnotation.setEnabled(false);
                break;
            }
        }*/
    }

    private void setRetryListener() {
        if (testAnnotation.getEnabled()) {
            IRetryAnalyzer retry = testAnnotation.getRetryAnalyzer();
            if (retry == null) {
                testAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
            }
        }
    }
}