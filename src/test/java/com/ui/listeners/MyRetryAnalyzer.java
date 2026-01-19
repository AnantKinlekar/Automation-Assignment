package com.ui.listeners;

import static com.constants.Env.*;

import com.utility.JSONUtil;
import com.utility.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
    private static final int MAX_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(QA, "MAX_ATTEMPTS"));
//    private static final int MAX_ATTEMPTS = JSONUtil.readJson(QA).getMAX_ATTEMPTS();
    private static int currentAttempt = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(currentAttempt <= MAX_ATTEMPTS){
            currentAttempt++;
            return true;
        }
        return false;
    }
}
