package com.welcome;

import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;
@Listeners(BaseTest.class)
public class SuccessLogin extends BaseTest {

    @Test(retryAnalyzer = com.welcome.RetryTests.class)
    @Description("Login test")
    public void loginTest() throws Exception {
        homePage = loginPage
                .successLogin(name, pass)
                .checkHome();
    }

}
