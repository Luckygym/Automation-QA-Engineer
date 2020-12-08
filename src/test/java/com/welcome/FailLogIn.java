package com.welcome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FailLogIn extends BaseTest {

    @Test
    public void errorLoginTest(){
        loginPage
                .errorLogin(failName, failPass)
                .checkUrl("login")
                .checkMessage(error);
    }
}
