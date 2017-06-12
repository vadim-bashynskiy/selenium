package com.kit.google.classwork.lesson2;

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
public class GoogleTest extends WebDriverTestBase {
    private String googleSearch = "https://www.google.com.ua";

    @Test
    public void searchTest() {
        webDriver.get(googleSearch);
        ////*[@data-pid="23"][@data-ved="0EMIuCBIoAA"] xpath атрибуты
        String text = "Sele";
        By linkLocator = By.className("logo-subtext");
        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.getText().contains("Україна"));
        linkLocator = By.name("q");
        link = webDriver.findElement(linkLocator);
        link.sendKeys(text);
        linkLocator = By.id("lst-ib");
        link = webDriver.findElement(linkLocator);
        link.sendKeys(text);
        webDriver.findElement(By.cssSelector("input[name='btnK'][jsaction='sf.chk']"));

    }

}
