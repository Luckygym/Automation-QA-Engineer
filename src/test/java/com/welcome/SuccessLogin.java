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

public class SuccessLogin {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private String baseUrl = "http://demo.hospitalrun.io/";
    private String name = "hr.doctor@hospitalrun.io";
    private String pass = "HRt3st12";

    @BeforeTest
    @Parameters("browser")
    public void openSuite(String browser) {
        if (browser.contains("Chrome")) {
            System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
            driver = new ChromeDriver();
        }else{
            System.setProperty("webdriver.driver.firefox","geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        homePage = loginPage
                .successLogin(name,pass)
                .checkHome();

    }

    @AfterTest
    public void closeTest(){
        driver.quit();
    }
}
