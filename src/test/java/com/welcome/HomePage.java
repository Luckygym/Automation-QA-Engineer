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

public class HomePage {
    public static WebDriver driver;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (linkText = "Inventory")
    private static WebElement inventory;

    @FindBy (css = ".settings-trigger ")
    private static WebElement cogWheel;

    @FindBy (css = ".logout")
    private static WebElement logoutButton;

    //@FindBy (css = "#/medication")
    @FindBy (xpath = "//*[@id=\"ember767\"]")
    private static WebElement medicationButton;


    public HomePage checkHome(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("patients"));
        System.out.println(driver.getCurrentUrl());
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
