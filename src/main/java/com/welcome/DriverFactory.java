package com.welcome;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver driver;

    public void initDriver(String browser,String nodeURL) throws MalformedURLException {
        if (nodeURL.length()>5) {
            if (browser.contains("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--unlimited-storage");
                driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
            } else {
                System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--unlimited-storage");
                driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
            }
        } else
        {
            if (browser.contains("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--unlimited-storage");
                driver = new ChromeDriver(options);
            } else {
                System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--unlimited-storage");
                driver = new FirefoxDriver(options);
            }

        }
    }
}
