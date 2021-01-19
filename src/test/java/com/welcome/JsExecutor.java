package com.welcome;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JsExecutor extends BaseTest {

    @Test
    public void jsTesting() throws Exception {
        homePage = loginPage
                .successLogin(name,pass);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        patientPage = homePage.clickPatient();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
