package com.kit.google.homework.lesson3;

import com.kit.core.WebDriverTestBase;
import com.kit.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by testu on 6/20/2017.
 */
public class TomCook extends WebDriverTestBase{
    @Test
    public void test() throws InterruptedException {
        WebDriverUtil webDriverUtil = new WebDriverUtil(webDriver);
        String g = "Hello";
        webDriver.get("https://www.thomascook.com/");
        WebElement element = webDriver.findElement(By.id("SearchbarForm-origin"));
       // element.sendKeys("Hello");
        webDriverUtil.jsClick("SearchbarForm-goingTo","id");
    }
}
