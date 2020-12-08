package com.welcome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    protected WebDriver driver;

    public void initDriver(String browser){
        if (browser.contains("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--unlimited-storage");
            driver = new ChromeDriver(options);
        }else{
            System.setProperty("webdriver.gecko.driver","src//test//resources//geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--unlimited-storage");
            driver = new FirefoxDriver();
        }
    }
}
