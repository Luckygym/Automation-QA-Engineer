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

public class LogOut {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private String baseUrl = "http://demo.hospitalrun.io/";
    private String name = "hr.doctor@hospitalrun.io";
    private String pass = "HRt3st12";
    private static HomePage homePage;

    @BeforeTest
    @Parameters("browser")
    public void loginTest(String browser){
        if (browser.contains("Chrome")) {
            System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
            driver = new ChromeDriver();
        }else
        {
            System.setProperty("webdriver.driver.firefox", "geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        homePage = loginPage.successLogin(name,pass);
    }

    @Test
    public void logOutTest(){
        loginPage = homePage
                .logout()
                .checkUrl("login");
    }

    @AfterTest
    public void closeTest(){
        driver.quit();
    }


}
