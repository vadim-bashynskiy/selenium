package com.kit.google.homework.lesson3;

import java.net.MalformedURLException;
import java.net.URL;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTestGrid extends WebDriverTestBase {

    //private WebDriver driver;

    @Parameters({ "platform","browser"})
    @BeforeTest(alwaysRun=true)
    public void setup(String platform, String browser) throws MalformedURLException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        if(platform.equalsIgnoreCase("WIN10")) {
            caps.setPlatform(Platform.WIN10);
            caps.setBrowserName(browser);
        }
        webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
    }

    @Test(description="Test Google")
    public void testGoogle() throws InterruptedException {
        webDriver.get("https://www.google.com.ua");
    }
}
