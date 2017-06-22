package com.kit.pages.codeSchool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by testu on 6/12/2017.
 */
public class CodeSchoolMyBoardPage {
    private WebElement webElement;
    private WebDriver webDriver;
   By searchLocator = By.cssSelector("a[href='/account'][class='nav-item-link list-item-link']");

    public CodeSchoolMyBoardPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public String getProfileAtributeClass(){
        webElement = webDriver.findElement(searchLocator);
        return webElement.getAttribute("class");

    }
}
