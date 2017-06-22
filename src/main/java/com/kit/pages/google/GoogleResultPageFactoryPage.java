package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by testu on 6/13/2017.
 */
public class GoogleResultPageFactoryPage extends GoogleBasePage {
    @FindBy(css = ".r>a")
    private WebElement link;
    public GoogleResultPageFactoryPage(WebDriver webDriver) {
        super(webDriver);
    }
    public String getLinkText(){
        return link.getText();
    }
}
