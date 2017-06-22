package com.kit.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by testu on 6/9/2017.
 */
public class WebDriverTestBase {
    protected WebDriver webDriver;
    private String browser = System.getProperty("browser");
    @BeforeClass
    public void setUp() {
       /* String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath;
        String pathToFile = "\\src\\main\\resources\\chromedriver.exe";
        absoluteFilePath = workingDirectory + pathToFile;
        System.setProperty("webdriver.chrome.driver", absoluteFilePath);*/
        //ChromeDriverManager.getInstance().setup();//Automatically download and set up latest driver
        //ChromeDriverManager.getInstance().version("2.26").setup(); set up some version
       // ChromeOptions options = new ChromeOptions();
       // options.addArguments("disable-infobars");
       // webDriver = new ChromeDriver(options);
        setBrowser();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public void setBrowser(){
        Browser runBrowser = EnumUtils.isValidEnum(Browser.class,browser) ?
                Browser.valueOf(browser.toUpperCase()): Browser.CHROME;
        switch (runBrowser){
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                webDriver = new ChromeDriver(options);
                break;
            case FF:
                FirefoxDriverManager.getInstance().version("0.16.0").setup();
                webDriver = new FirefoxDriver();
                break;
        }
    }

    @AfterClass
    public void tearDown() {
        //Closes a browser
         //webDriver.close();
        //closes a browser's tab
        webDriver.quit();
    }
}
