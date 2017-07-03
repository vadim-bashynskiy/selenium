package com.kit.google.homework.lesson3;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by testu on 6/20/2017.
 */
public class TomCook extends WebDriverTestBase{
  //  @Test
    public void test() throws InterruptedException {
        String g = "Hello";
        webDriver.get("https://www.thomascook.com/");
        WebElement element = webDriver.findElement(By.xpath(".//*[@id='SearchbarForm-originContainer']/div/div/div/div[1]/tc-typeahead/div"));
        element.click();
        element.sendKeys("Hello");
    }
}
