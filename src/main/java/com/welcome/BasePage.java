package com.welcome;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class BasePage extends DriverFactory {
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

    @Step("Typing")
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
    @Step("Selecting Drop")
    protected void selectDrop(List<WebElement> webElement, String s){
        for (WebElement w: webElement){
            if (w.getText().contains(s)) {
                w.click();
                break;
            }
        }
    }
    @Step("Setting date")
    protected void setCalendar(List<WebElement> columns){
        int a = calendar.get(calendar.DATE) - 1;
        for(WebElement q: columns){
            if (q.getText().equals(String.valueOf(a))){
                q.click();
                break;
            }
        }
    }
    @Step("Random")
    protected String genereteNumber(int number){

        number +=(int)(Math.random()*5 - 0.1f);
        return String.valueOf(number);
    }
    @Step("Waiting to element")
    protected void waitUntilClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    @Step("Check Url")
    protected void waitUntillUrl(String s){
        WebDriverWait wait = new WebDriverWait(driver,3);
        System.out.println(driver.getCurrentUrl());
        wait.until(ExpectedConditions.urlContains(s));
    }


    public static File foto(WebDriver driver, WebElement element) throws Exception {
        // Делаем скриншот страницы
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        BufferedImage img = ImageIO.read(screen);
        Rectangle rectangle=new Rectangle(element.getLocation().x,element.getLocation().y,element.getSize().height,element.getSize().width);
        BufferedImage image=img.getSubimage(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
        ImageIO.write(image, "png", screen);
        FileUtils.copyFile(screen, new File("D:\\git\\screen1.png"));
        System.out.println("###############################################");
        return screen;
    }
}
