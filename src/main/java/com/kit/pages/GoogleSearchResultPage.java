package com.kit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by testu on 6/9/2017.
 */
public class GoogleSearchResultPage {
    WebDriver webDriver;
    By linkLocator = By.cssSelector(".r>a");
    private WebElement link;
    public GoogleSearchResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public String getLinkText(){
        link = webDriver.findElement(linkLocator);
        return link.getText();
    }
}
