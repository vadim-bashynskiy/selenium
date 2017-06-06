package com.kit.google.classwork.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by testu on 6/2/2017.
 */
public class GoogleSearchTest {
    private String googleSearch;
    private WebDriver webDriver;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        googleSearch = "https://www.google.com.ua";
        webDriver.get(googleSearch);
    }
    @Test
    public void searchTest(){
        String searchText = "Selenium";
        By searchLocator = By.name("q");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        By linkLocator = By.cssSelector(".r>a");
        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.getText().contains(searchText));

    }
}
