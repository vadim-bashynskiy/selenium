package com.kit.pages.google;

import com.kit.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * Created by testu on 6/16/2017.
 */
public class GoogleBasePage {
    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;

    public GoogleBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);
    }

    public void open(String url) {
        webDriver.get(url);
    }

    public void takeScreenshot(String atachName){
        webDriverUtil.saveScreenshot(atachName);
    }

}
