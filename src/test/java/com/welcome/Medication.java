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

public class Medication {

    private static WebDriver driver;
    private static LoginPage loginPage;
    public static HomePage homePage;
    public static MedicationPage medicationPage;
    private String baseUrl = "http://demo.hospitalrun.io/";
    private String name = "hr.doctor@hospitalrun.io";
    private String pass = "HRt3st12";

    @BeforeTest
    @Parameters("browser")
    public void loginTest(String browser){
        if (browser.contains("Chrome")) {
            System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--unlimited-storage");
            driver = new ChromeDriver(options);
        } else{
                System.setProperty("webdriver.driver.firefox","geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--unlimited-storage");
                driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        homePage = loginPage.successLogin(name,pass);
    }

    @Test
    public void medicationTest() throws AWTException {
       medicationPage = homePage.medicationButtonClick();
        try {
            medicationPage
                    .isContains()
                    .setNewRequests()
                    .assertConfirm()
                    .confirmPop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void closeTest(){
        driver.quit();
    }
}
