package com.kit.pages;

import com.kit.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 05.07.2017.
 */
public class BettingBasePage {
    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;

    public BettingBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);
    }

    public void open(String url) {
        webDriver.get(url);
    }

}
