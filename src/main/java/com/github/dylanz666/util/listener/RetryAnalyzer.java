package com.github.dylanz666.util.listener;

import org.springframework.stereotype.Component;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author : dylanz
 * @since : 09/03/2020
 */
public class RetryAnalyzer implements IRetryAnalyzer {
    private static int retryCount = 1;
    private static final int maxRetryCount = 3;

    public boolean retry(ITestResult result) {
        if (retryCount <= maxRetryCount) {
            System.out.println("It's the " + retryCount + " time failed!");
            retryCount++;
            return true;
        }
        return false;
    }
}
