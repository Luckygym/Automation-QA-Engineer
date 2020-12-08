package com.welcome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogOut extends BaseTest {

    @Test
    public void logOutTest(){
        homePage = loginPage.successLogin(name,pass);
        loginPage = homePage
                .logout()
                .checkUrl("login");
    }
}
