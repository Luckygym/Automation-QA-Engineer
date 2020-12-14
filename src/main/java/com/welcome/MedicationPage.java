package com.welcome;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.testng.Assert;

public class MedicationPage extends BasePage {

    public MedicationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (linkText = "Completed")
    private WebElement completed;

    @FindBy (linkText = "Requests")
    private WebElement requests;

    @FindBy (linkText = "New Request")
    private WebElement newRequests;

    @FindBy (linkText = "Return Medication")
    private WebElement returnMedication;

    //@FindBy (xpath = "//*[starts-with(@id, 'patientTypeAhead')]")
    @FindBy (css = "[id^=\"patientTypeAhead\"]")
    private WebElement patientLabel;

    @FindBy (id = "ember1357")
    private WebElement labelClick;

    //@FindBy (xpath = "//*[starts-with(@id, 'inventoryItemTypeAhead')]")
    @FindBy (css = "[id^='inventoryItemTypeAhead']")
    private WebElement  medicationLabel;

    @FindBy (css  = "div.tt-suggestion.tt-selectable")
    private List<WebElement> patientList;

    @FindBy (css = "tt-dataset-1")
    private List<WebElement> medicationList;

    @FindBy (css = ".tt-dataset-0")
    private WebElement tab;

    @FindBy (xpath = "//*[starts-with(@id, 'prescription')]")
    //@FindBy (css = "//*[id^='prescription'")
    private WebElement prescriptions;

    @FindBy (xpath = "//*[starts-with(@id, 'display_prescriptionDate')]")
    //@FindBy (xpath = "//$[id$='Date'")
    private WebElement data;

    @FindBy (css = ".pika-single")
    private WebElement dataWidget;

    @FindBy (tagName = "td")
    private List<WebElement> columns;

    @FindBy (css = ".btn.on-white")
    private WebElement addBtn;

    @FindBy (xpath = "//*[starts-with(@id, 'quantity')]")
    //@FindBy (css = "//^[id*=quantity]")
    private WebElement qR;

    @FindBy (xpath = "//*[starts-with(@id, 'refills')]")
    //@FindBy (css = "//^[id*=refills]")
    private WebElement refils;

    @FindBy (css = ".octicon-x")
    private WebElement cross;

    @FindBy (css = ".btn.on-white")
    private WebElement addButtonConfirm;

    @FindBy (css = "button.on-white")
    private WebElement addBtn1;

    @Step("Medication contains: Completed, Request, New Request, Return Medication")
    public MedicationPage isContains() {
        System.out.println(completed.isDisplayed() && requests.isDisplayed() && newRequests.isDisplayed() && returnMedication.isDisplayed());
        Assert.assertTrue(completed.isDisplayed());
        return this;
    }
    @Step("Setting new request")
    public MedicationPage setNewRequests() {
          newRequests.click();

        typeWord("Test Patient", patientLabel,600);
        selectDrop(patientList,"- P00201");

        typeWord("Pramoxine",medicationLabel,100);
        selectDrop(patientList,"available");

        prescriptions.sendKeys("Hello there");

        data.click();
        setCalendar(columns);

        qR.sendKeys(genereteNumber(1));
        refils.sendKeys(genereteNumber(6));
        addBtn.click();
        return this;
    }
    @Step("Confirm all button is enabled")
    public MedicationPage assertConfirm(){

        System.out.println(cross.isEnabled() && addButtonConfirm.isEnabled());
        Assert.assertTrue(cross.isEnabled() && addButtonConfirm.isEnabled());

        waitUntilClickable(cross);
        cross.click();

        Actions actions = new Actions(driver);

        waitUntilClickable(addBtn1);
        actions.moveToElement(addBtn1).click();

        waitUntilClickable(addBtn);
        actions.moveToElement(addBtn).click();
        return this;
    }
    @Step("Confirm new request page")
    public MedicationPage confirmPop(){
        Assert.assertTrue(driver.getCurrentUrl().contains("new"));
        return this;
    }

}
