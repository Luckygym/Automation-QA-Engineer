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

public class MedicationPage {


    private static WebDriver driver;
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

    public MedicationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (linkText = "Completed")
    private static WebElement completed;

    @FindBy (linkText = "Requests")
    private static WebElement requests;

    @FindBy (linkText = "New Request")
    private static WebElement newRequests;

    @FindBy (linkText = "Return Medication")
    private static WebElement returnMedication;

    @FindBy (id = "patientTypeAhead-ember1321")
    private static WebElement patientLabel;

    @FindBy (id = "ember1357")
    private static WebElement labelClick;

    @FindBy (id = "inventoryItemTypeAhead-ember1388")
    private static WebElement  medicationLabel;

    @FindBy (css  = "div.tt-suggestion.tt-selectable")
    private static List<WebElement> patientList;

    @FindBy (css = "tt-dataset-1")
    private static List<WebElement> medicationList;

    @FindBy (css = ".tt-dataset-0")
    private static WebElement tab;

    @FindBy (id = "prescription-ember1420")
    private static WebElement prescriptions;

    @FindBy (id = "display_prescriptionDate-ember1443")
    private static WebElement data;

    @FindBy (css = ".pika-single")
    private static WebElement dataWidget;

    @FindBy (tagName = "td")
    private static List<WebElement> columns;

    @FindBy (css = ".btn.on-white")
    private static WebElement addBtn;

    @FindBy (id = "quantity-ember1462")
    private static WebElement qR;

    @FindBy (id = "refills-ember1469")
    private static WebElement refils;

    @FindBy (css = ".octicon-x")
    private static WebElement cross;

    @FindBy (css = ".btn.on-white")
    private static WebElement addButtonConfirm;

    @FindBy (css = "button.on-white")
    private static WebElement addBtn1;

    public MedicationPage isContains() {
        System.out.println(completed.isDisplayed() && requests.isDisplayed() && newRequests.isDisplayed() && returnMedication.isDisplayed());
        Assert.assertTrue(completed.isDisplayed());
        return this;
    }

    protected void typeWord(String s, WebElement webElement,int i){
        for(String s1:s.split("")){
            webElement.sendKeys(s1);
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void selectDrop(List<WebElement> webElement, String s){
        for (WebElement w: webElement){
            if (w.getText().contains(s)) {
                w.click();
                break;
            }
        }
    }

    public MedicationPage setNewRequests() throws AWTException, InterruptedException {
          newRequests.click();

        typeWord("Test Patient", patientLabel,500);
        selectDrop(patientList,"- P00201");

        typeWord("Pramoxine",medicationLabel,100);
        selectDrop(patientList,"Pramoxine");

        data.click();
        int a = calendar.get(calendar.DATE) - 1;
        for(WebElement q: columns){
            if (q.getText().equals(String.valueOf(a))){
                q.click();
                break;
            }
        }

        prescriptions.sendKeys("Hello there");

        qR.sendKeys(String.valueOf(1+(int)(Math.random()*5 - 0.1)));
        refils.sendKeys(String.valueOf(6 + (int)(Math.random()*5 - 0.1)));

        addBtn.click();
        return this;
    }

    public MedicationPage assertConfirm(){
        System.out.println(cross.isEnabled() && addButtonConfirm.isEnabled());
        Assert.assertTrue(cross.isEnabled() && addButtonConfirm.isEnabled());
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cross));
        cross.click();
        try { //FireFox как то меняет размер страницы и кнопка падает ниже потом возвращаеться
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addBtn1.click();
        wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        addBtn.click();
        return this;
    }

    public MedicationPage confirmPop(){
        Assert.assertTrue(driver.getCurrentUrl().contains("new"));
        return this;
    }

}
