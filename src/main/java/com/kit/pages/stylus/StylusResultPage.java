package com.kit.pages.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by testu on 6/9/2017.
 */
public class StylusResultPage {
    private WebDriver webDriver;
    WebElement searchElement;
    By link = By.className("code");

    public StylusResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getLinkText() {
        searchElement = webDriver.findElement(link);
        return searchElement.getText();
    }
}
