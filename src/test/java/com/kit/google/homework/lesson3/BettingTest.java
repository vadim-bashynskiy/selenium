package com.kit.google.homework.lesson3;

import au.com.bytecode.opencsv.CSVReader;
import com.kit.core.WebDriverTestBase;
import com.kit.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;


import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by VBashynskyi on 03.07.2017.
 */

public class BettingTest extends WebDriverTestBase {
    String CSV_Path = "D:\\kitcenterCourses\\selenium\\src\\main\\resources\\testList.csv";
    @Test
    public void testBetting() throws Exception {
        int notFoundException = 0;
        int assertExeption = 0;
        int timeOutExeption = 0;
        By locator = By.cssSelector(".virtual-sports.active");
        By langLocator = By.cssSelector(".soccer");
        By imageLocator = By.cssSelector("#vhc.boxtitle.boxtitle_inner");
        WebDriverUtil webDriverUtil = new WebDriverUtil(webDriver);
        CSVReader reader = new CSVReader(new FileReader(CSV_Path));
        String[] csvCell;

        while ((csvCell = reader.readNext()) != null) {
            String url = csvCell[0];
            String testWorldLang = csvCell[1];

            try {
                webDriver.get(url);
               /* WebElement elementInput = webDriver.findElement(By.name("url"));
                elementInput.click();
                elementInput.sendKeys(url);
                elementInput.submit();*/
                //check virtual sports is active
                WebElement element = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(locator));
                assertTrue(element.getAttribute("class").contains("active"));
                //check locale matches the language in the site
                element = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(langLocator));
                System.out.println(element.getText() + "=" + testWorldLang);
                assertTrue(element.getText().equals(testWorldLang));
                //check patern link
                WebElement iframe = webDriver.findElement(By.id("vhcframe"));
                webDriver.switchTo().frame(iframe);
                element = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(imageLocator));
                assertTrue(element.getAttribute("href").matches("/vhc/statistic/race_calendar/\\d+/" + ""));


            } catch (NotFoundException e) {
                notFoundException++;
                e.printStackTrace();
                System.out.println("element not found for website" + url);
            } catch (AssertionError j) {
                assertExeption++;
                j.printStackTrace();
                System.out.println("assertError for website" + url);
            } catch (TimeoutException c) {
                timeOutExeption++;
                c.printStackTrace();
                System.out.println("element not found for website" + url);
            }

        }
        if (notFoundException > 0 || assertExeption > 0 || timeOutExeption > 0) {
            assertTrue(false);
        }
    }
}