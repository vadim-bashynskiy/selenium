package com.kit.google.homework.lesson1.lesson2;

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
 * Created by VBashynskyi on 08.06.2017.
 */
public class CodeSchoolSignInTest {
    private String googleSearch;
    private WebDriver webDriver;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","D:\\kitcenterCourses\\selenium\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1.Open http://stylus.com.ua/ in Chrome
        googleSearch = "https://www.codeschool.com/users/sign_in";
        webDriver.get(googleSearch);
    }
    @Test
    public void loginTest() throws InterruptedException {
        //2.
        String input = "underklon@mail.ru";
        By searchLocator = By.id("user_login");
        //find email field and input email
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(input);
        //find pass field and input pass
        input = "83115261990";
        By linkLocator = By.id("user_password");
        searchField = webDriver.findElement(linkLocator);
        searchField.sendKeys(input);
        Thread.sleep(2000);
        //log in
        webDriver.findElement(By.cssSelector(".form-btn.btn.btn--l.mbm")).click();
        searchField = webDriver.findElement(By.cssSelector("a[href='/account'][class='nav-item-link list-item-link']"));
        String getClass = "nav-item-link list-item-link";
        assertTrue(searchField.getAttribute("class").equals(getClass));

    }
    @AfterClass
    public void closeUp(){
        webDriver.close();
    }
}
