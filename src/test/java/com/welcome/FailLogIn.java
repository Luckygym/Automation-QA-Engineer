package com.welcome;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;
@Listeners(BaseTest.class)
public class FailLogIn extends BaseTest {

    @Test(retryAnalyzer = com.welcome.RetryTests.class)
    public void errorLoginTest(){
        System.out.println("====================================================");
            loginPage
                    .errorLogin(failName, failPass)
                    .checkUrl("login")
                    .checkMessage(error);

    }
}
