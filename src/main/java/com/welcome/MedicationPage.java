package com.welcome;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarOutputStream;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MedicationPage extends AdditionalFunc {

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

    @FindBy (id = "patientTypeAhead-ember1321")
    private WebElement patientLabel;

    @FindBy (id = "ember1357")
    private WebElement labelClick;

    @FindBy (id = "inventoryItemTypeAhead-ember1388")
    private WebElement  medicationLabel;

    @FindBy (css  = "div.tt-suggestion.tt-selectable")
    private List<WebElement> patientList;

    @FindBy (css = "tt-dataset-1")
    private List<WebElement> medicationList;

    @FindBy (css = ".tt-dataset-0")
    private WebElement tab;

    @FindBy (id = "prescription-ember1420")
    private WebElement prescriptions;

    @FindBy (id = "display_prescriptionDate-ember1443")
    private WebElement data;

    @FindBy (css = ".pika-single")
    private WebElement dataWidget;

    @FindBy (tagName = "td")
    private List<WebElement> columns;

    @FindBy (css = ".btn.on-white")
    private WebElement addBtn;

    @FindBy (id = "quantity-ember1462")
    private WebElement qR;

    @FindBy (id = "refills-ember1469")
    private WebElement refils;

    @FindBy (css = ".octicon-x")
    private WebElement cross;

    @FindBy (css = ".btn.on-white")
    private WebElement addButtonConfirm;

    @FindBy (css = "button.on-white")
    private WebElement addBtn1;

    public MedicationPage isContains() {
        System.out.println(completed.isDisplayed() && requests.isDisplayed() && newRequests.isDisplayed() && returnMedication.isDisplayed());
        Assert.assertTrue(completed.isDisplayed());
        return this;
    }

    public MedicationPage setNewRequests() {
          newRequests.click();

        typeWord("Test Patient", patientLabel,500);
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

    public MedicationPage assertConfirm(){
        System.out.println(cross.isEnabled() && addButtonConfirm.isEnabled());
        Assert.assertTrue(cross.isEnabled() && addButtonConfirm.isEnabled());

        waitUntilClickable(cross);
        cross.click();


        Actions actions = new Actions(driver);
        waitUntilClickable(addBtn1);
        actions.moveToElement(addBtn1).click();
        //addBtn1.click();

        waitUntilClickable(addBtn);
        addBtn.click();

        return this;
    }

    public MedicationPage confirmPop(){
        Assert.assertTrue(driver.getCurrentUrl().contains("new"));
        return this;
    }

}
