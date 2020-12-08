package com.welcome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class AdditionalFunc {
    protected WebDriver driver;
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

    protected void typeWord(String s, WebElement webElement, int i){
        for(String s1:s.split("")){
            webElement.sendKeys(s1);
            try {
                Thread.sleep(i);
            } catch (Exception e){
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

    protected void setCalendar(List<WebElement> columns){
        int a = calendar.get(calendar.DATE) - 1;
        for(WebElement q: columns){
            if (q.getText().equals(String.valueOf(a))){
                q.click();
                break;
            }
        }
    }

    protected String genereteNumber(int number){

        number +=(int)(Math.random()*5 - 0.1f);
        return String.valueOf(number);
    }

    protected void waitUntilClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitUntillUrl(String s){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.urlContains(s));
    }

}
