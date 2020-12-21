package com.welcome;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@id=\"identification\"]")
    private WebElement logInput;

    @FindBy (xpath = "//*[@id=\"password\"]")
    private WebElement passInput;

    @FindBy (css = ".btn-lg")
    private WebElement logButton;

    @FindBy (css = ".alert")
    private WebElement errorMessage;

    @Step("Success Login")
    public HomePage successLogin(String login, String pass) {
            logInput.clear();
            logInput.sendKeys(login);
            passInput.clear();
            passInput.sendKeys(pass);
            logButton.click();
            return new HomePage(driver);
    }

    @Step("Success Login")
    public LoginPage errorLogin(String login, String pass) {
        logInput.sendKeys(login);
        passInput.sendKeys(pass);
        logButton.click();
        return new LoginPage(driver);
    }

    @Step("Error")
    public LoginPage checkMessage(String error){
        System.out.println("---------------------------------------------------------------");
        System.out.println(errorMessage.getText());
        Assert.assertTrue(errorMessage.getText().contains(error));
        return this;
    }

    @Step("Check Url")
    public LoginPage checkUrl(String url){
        WebDriverWait wait = new WebDriverWait(driver, 1);
        System.out.println("--------------------------------------------");
        wait.until(ExpectedConditions.urlContains(url));
        System.out.println("--------------------------------------------");
        System.out.println(driver.getCurrentUrl());
        System.out.println("--------------------------------------------");
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
        System.out.println("--------------------------------------------");
        return this;
    }
}
