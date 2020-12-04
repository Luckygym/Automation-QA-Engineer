package com.welcome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    private static WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@id=\"identification\"]")
    private WebElement logInput;

    @FindBy (xpath = "//*[@id=\"password\"]")
    private WebElement passInput;

    @FindBy (xpath = "//*[@id=\"ember433\"]/div/form/div[2]/button")
    private WebElement logButton;

    @FindBy (css = ".alert")
    private WebElement errorMessage;

    public HomePage successLogin(String login, String pass) {
            logInput.sendKeys(login);
            passInput.sendKeys(pass);
            logButton.click();
            return new HomePage(driver);
    }

    public LoginPage errorLogin(String login, String pass) {
        logInput.sendKeys(login);
        passInput.sendKeys(pass);
        logButton.click();
        return new LoginPage(driver);
    }

    public LoginPage checkMessage(String error){
        System.out.println(errorMessage.getText());
        Assert.assertTrue(errorMessage.getText().contains(error));
        return this;
    }

    public LoginPage checkUrl(String url){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains(url));
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
        return this;
    }
}
