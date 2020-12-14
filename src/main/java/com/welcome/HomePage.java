package com.welcome;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {

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

}
