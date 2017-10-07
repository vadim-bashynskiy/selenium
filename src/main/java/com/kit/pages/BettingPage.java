package com.kit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by admin on 05.07.2017.
 */
public class BettingPage extends BettingBasePage {
    private WebElement frameElement1;
    private WebElement frameElement2;
    private WebElement frameElement3;
    private WebElement frameElement4;
    private WebElement activeElement;
    private WebElement language;
    private WebElement image;
    By frameLocator1 = By.className("betradarFrame");
    By frameLocator2 = By.id("gameFrame");
    By frameLocator3 = By.id("frame");
    By frameLocator4 = By.id("vdrframe");
    By locator = By.cssSelector(".virtual-sports.active");
    By langLocator = By.cssSelector(".soccer");
    By imageLocator = By.id("racecal_statistic");

    public BettingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open(String url) {
        webDriver.get(url);
    }

    public String checkActiveTab() {
        activeElement = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(locator));
        return activeElement.getAttribute("class");
    }

    public String checkLanguageLocale() {
        language = webDriver.findElement(langLocator);
        return language.getText();
    }

    public String checkPattern() {
        //switch to our iFrame
        frameElement1 = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(frameLocator1));
        webDriver.switchTo().frame(frameElement1);
        frameElement2 = webDriver.findElement(frameLocator2);
        webDriver.switchTo().frame(frameElement2);
        frameElement3 = webDriver.findElement(frameLocator3);
        webDriver.switchTo().frame(frameElement3);
        frameElement4 = webDriver.findElement(frameLocator4);
        webDriver.switchTo().frame(frameElement4);
        //find calendar element with attribute href pattern
        image = webDriver.findElement(imageLocator);
        return image.getAttribute("href");
    }
}
