package com.welcome;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;
@Listeners(BaseTest.class)
public class Medication extends BaseTest {

    @Test(retryAnalyzer = com.welcome.RetryTests.class)
    public void medicationTest() throws Exception {
           homePage = loginPage.successLogin(name, pass);
           medicationPage = homePage.medicationButtonClick();
           medicationPage
                   .isContains()
                   .setNewRequests()
                   .assertConfirm()
                   .confirmPop();

    }
}
