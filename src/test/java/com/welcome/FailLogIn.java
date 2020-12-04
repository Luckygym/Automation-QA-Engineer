package com.welcome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FailLogIn {
    public static WebDriver webDriver;
    public static LoginPage loginPage;
    public String name = "1";
    public String pass = "";
    public String baseUrl="http://demo.hospitalrun.io/";
    private static String error = "incorrect";

    @BeforeTest
    @Parameters("browser")
    public void openSuite(String browser){
        if (browser.contains("Chrome")) {
            System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
            webDriver = new ChromeDriver();
        }else {
            System.setProperty("webdriver.driver.firefox", "geckodriver.exe");
            webDriver = new FirefoxDriver();
        }
        loginPage = new LoginPage(webDriver);
        webDriver.get(baseUrl);
        webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    @Test
    public void errorLoginTest(){
        loginPage
                .errorLogin(name, pass)
                .checkUrl("login")
                .checkMessage(error);
    }

    @AfterTest
    public void closeTest(){
        webDriver.quit();
    }
}
