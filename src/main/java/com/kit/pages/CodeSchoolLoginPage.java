package com.kit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by testu on 6/12/2017.
 */
public class CodeSchoolLoginPage {
    private WebElement input;
    private WebDriver webDriver;
    By emailLocator = By.id("user_login");
    By passLocator = By.id("user_password");
    By submit = By.cssSelector(".form-btn.btn.btn--l.mbm");

    public CodeSchoolLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openUrl(String url) {
        webDriver.get(url);
    }

    public void login(String login, String pass) {
        input = webDriver.findElement(emailLocator);
        input.sendKeys(login);
        input = webDriver.findElement(passLocator);
        input.sendKeys(pass);
        webDriver.findElement(submit).click();
    }
}
