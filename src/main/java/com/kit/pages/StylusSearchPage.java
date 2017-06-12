package com.kit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by testu on 6/9/2017.
 */
public class StylusSearchPage {
    private WebDriver webDriver;
    private WebElement searchField;
    By searchLocator = By.cssSelector("#head-search>form>input");
    By linkLocator = By.cssSelector(".item.out-of-stock");

    public StylusSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openUrl(String url) {
        webDriver.get(url);
    }

    public void findAndSubmitSearchData(String searchText) {
        searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
    }

    public void clickFoundElement() {
        searchField = webDriver.findElement(linkLocator);
        searchField.click();
    }

    public String getLinkText() {
        searchField = webDriver.findElement(linkLocator);
        return searchField.getText();
    }
}
