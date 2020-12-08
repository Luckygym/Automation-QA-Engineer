package com.welcome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Medication extends BaseTest {

    @Test
    public void medicationTest() {
        homePage = loginPage.successLogin(name,pass);
        medicationPage = homePage.medicationButtonClick();
        medicationPage
                    .isContains()
                    .setNewRequests()
                    .assertConfirm()
                    .confirmPop();

    }
}
