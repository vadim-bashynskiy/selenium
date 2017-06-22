package com.kit.google.homework.lesson1;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by testu on 6/6/2017.
 */
public class StylusSearchTest extends WebDriverTestBase {
    String googleSearch = "http://www.stylus.com.ua";

    @Test
    public void searchTest(){
        webDriver.get(googleSearch);
        //2.In the search field enter "Sony Z2" and click find button
        String searchText = "Sony Xperia Z2 Black";
        By searchLocator = By.cssSelector("#head-search>form>input");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        By linkLocator = By.cssSelector(".item.out-of-stock");
        WebElement link = webDriver.findElement(linkLocator);
        //3.On the result page verify that Sony Z2 found (choose any link with Sony Z2 and verify by it's content)
        assertTrue(link.getText().contains(searchText));
        //4.Click on the same Sony Z2 link
        link.click();
        //5. Verify that Sony Z2 page is opened
        linkLocator = By.className("code");
        link = webDriver.findElement(linkLocator);
        String content = "Код товара";
        //assertTrue(link.getText().contains(content));
    }

}
