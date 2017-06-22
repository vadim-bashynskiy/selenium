package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by testu on 6/9/2017.
 */
public class GoogleSearchResultPage extends GoogleBasePage {
    By linkLocator = By.cssSelector(".r>a");
    private WebElement link;

    public GoogleSearchResultPage(WebDriver webDriver) {

        super(webDriver);
    }

    public String getLinkText() {
        link = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(linkLocator));
       // link = webDriver.findElement(linkLocator);
        return link.getText();
    }
}
