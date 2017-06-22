package com.kit.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;

import static com.google.common.io.Files.toByteArray;

/**
 * Created by testu on 6/16/2017.
 */
public class WebDriverUtil {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public WebDriverUtil(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver,10);
    }
    public WebElement waitForExpectedCondition(ExpectedCondition expectedCondition){
      return (WebElement) webDriverWait.until(expectedCondition);
    }

    @Attachment(value = "{0}")
    public byte[] saveScreenshot(String Name) {
        try {
            File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            return toByteArray(scrFile);
        } catch (Exception e) {
            System.out.println("Is not saved screenshot" + e);
        }
        return new byte[0];
    }

}
