package com.welcome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest extends DriverFactory {

    protected static LoginPage loginPage;
    protected static HomePage homePage;
    public static MedicationPage medicationPage;
    protected String baseUrl = "http://demo.hospitalrun.io/";
    protected String name = "hr.doctor@hospitalrun.io";
    protected String pass = "HRt3st12";
    protected String failName = "aaaa";
    protected String failPass = "1a1a1a";
    protected String error = "incorrect";


    @BeforeTest
    @Parameters("browser")
    public void openSuite(String browser){

        initDriver(browser);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void closeTest(){

        driver.quit();
    }



}
