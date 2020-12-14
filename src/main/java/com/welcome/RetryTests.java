package com.welcome;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class RetryTests extends DriverFactory implements IRetryAnalyzer{

    public int counter = 0;
    public int count = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (counter < count){
            counter++;
            return true;
        }
        return false;
    }
}
