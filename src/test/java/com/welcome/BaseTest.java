package com.welcome;

import com.fasterxml.jackson.databind.util.ByteBufferBackedInputStream;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import okhttp3.WebSocket;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Description;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;


import javax.naming.ldap.LdapReferralException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest extends DriverFactory implements ITestListener {

    protected static LoginPage loginPage;
    protected static HomePage homePage;
    public static MedicationPage medicationPage;
    protected String baseUrl = "http://demo.hospitalrun.io/";
    protected String ppc= "https://login-dev.cheq-platform.com/?scopes=userpass&returnUrl=https%3A%2F%2Fclicktrue-dev.cheq-platform.com%2Fdashboard";
    protected String name = "hr.doctor@hospitalrun.io";
    protected String pass = "HRt3st12";
    protected String failName = "aaaa";
    protected String failPass = "1a1a1a";
    protected String error = "incorrect";
    public byte[] scrFile;


    @BeforeTest(alwaysRun = true)
    @Parameters({"browser","url"})
    @Step("Open Suite")
    public void openSuite(@Optional ("Chrome") String browser, @Optional("") String url) throws MalformedURLException {
        initDriver(browser,url);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        //driver.get(baseUrl);
        driver.get(ppc);
        loginPage = new LoginPage(driver);
    }

   // @AfterTest
    @Step("Close Suite")
    public void closeTest(){
        driver.quit();
    }

    @Attachment(value = "Fail", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        takeScreenshot();
    }
}

