package com.kit.core;

import com.kit.util.PropertiesCache;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by testu on 6/9/2017.
 */
@Listeners({com.kit.core.TestListener.class})
public class WebDriverTestBase {
    //How to path System variable to Selenium Framework
    //mvn -Dbrowser=CHROME or -Dbrowser=FF  clean test - to run test on diff browsers
    protected WebDriver webDriver;
    private String browser = System.getProperty("browser");
    long implicitWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
    long pageLoadTimeout = Long.parseLong(PropertiesCache.getProperty("wait.pageload.timeout"));
    long scriptTimeOut = Long.parseLong(PropertiesCache.getProperty("wait.script.timeout"));
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
        setWebDriverSettings();
    }
    private void setWebDriverSettings(){
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(scriptTimeOut, TimeUnit.SECONDS);
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

   // @AfterClass
    public void tearDown() {
        //Closes a browser
         //webDriver.close();
        //closes a browser's tab
        webDriver.quit();
    }
}
