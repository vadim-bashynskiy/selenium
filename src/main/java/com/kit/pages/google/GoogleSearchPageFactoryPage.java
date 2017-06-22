package com.kit.pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by testu on 6/13/2017.
 */
public class GoogleSearchPageFactoryPage extends GoogleBasePage{
    @FindBy(name = "q")
    private WebElement searchField;

    public GoogleSearchPageFactoryPage(WebDriver webDriver) {

       super(webDriver);
    }

    public void fillAndSubmitSearchData(String searchText) {
        searchField.sendKeys(searchText);
        searchField.submit();
    }
}

