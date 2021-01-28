package com.welcome;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.TreeMap;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (linkText = "Inventory")
    private WebElement inventory;

    @FindBy(linkText =  "Billing")
    private WebElement bill;

    @FindBy (css = ".settings-trigger ")
    private WebElement cogWheel2;
    @FindBy (css = ".mega-octicon.octicon-gear")
    private WebElement cogWheel;

    @FindBy (css = ".logout")
    private WebElement logoutButton;

    @FindBy (xpath = "//*[@id=\"ember767\"]")
    private WebElement medicationButton;

    @Step("Check Home Page")
    public HomePage checkHome(){
        waitUntillUrl("patients");
        Assert.assertTrue(driver.getCurrentUrl().contains("patients"));
        return this;
    }
    @Step("Log out")
    public LoginPage logout(){
        cogWheel.click();
        logoutButton.click();
        return new LoginPage(driver);
    }
    @Step("Click Medication")
    public MedicationPage medicationButtonClick(){
        medicationButton.click();
        return new MedicationPage(driver);
    }
    public PatientPage clickPatient(){
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", bill);
            return new PatientPage();
    }

}
