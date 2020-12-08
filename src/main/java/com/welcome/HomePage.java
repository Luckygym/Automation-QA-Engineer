package com.welcome;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage extends AdditionalFunc {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (linkText = "Inventory")
    private WebElement inventory;

    @FindBy (css = ".settings-trigger ")
    private WebElement cogWheel;

    @FindBy (css = ".logout")
    private WebElement logoutButton;

    @FindBy (xpath = "//*[@id=\"ember767\"]")
    private WebElement medicationButton;

    public HomePage checkHome(){
        waitUntillUrl("patients");
        Assert.assertTrue(driver.getCurrentUrl().contains("patients"));
        return this;
    }

    public LoginPage logout(){
        cogWheel.click();
        logoutButton.click();
        return new LoginPage(driver);
    }

    public MedicationPage medicationButtonClick(){
        medicationButton.click();
        return new MedicationPage(driver);
    }

}
