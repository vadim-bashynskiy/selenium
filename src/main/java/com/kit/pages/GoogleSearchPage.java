package com.kit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by testu on 6/9/2017.
 */
public class GoogleSearchPage {
    private WebDriver webDriver;
    private WebElement searchField;
    By searchLocator = By.name("q");

    public GoogleSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void open (String url){
        webDriver.get(url);
    }
    public void fillAndSubmitSearchData(String searchText){
        searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
    }
}
