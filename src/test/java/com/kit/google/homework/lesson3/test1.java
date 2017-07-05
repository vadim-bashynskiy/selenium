package com.kit.google.homework.lesson3;

import au.com.bytecode.opencsv.CSVReader;
import com.kit.core.WebDriverTestBase;
import com.kit.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.FileReader;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by VBashynskyi on 05.07.2017.
 */
public class test1 extends WebDriverTestBase{
    String workingDirectory = System.getProperty("user.dir");
    String pathToFile = "\\src\\main\\resources\\testList.csv";
    String CSV_Path = workingDirectory + pathToFile;
    // String CSV_Path = "D:\\kitcenterCourses\\selenium\\src\\main\\resources\\testList.csv";

    @Test
    public void testBetting() throws Exception {
        int exceptionCount = 0;
        int assertException = 0;
        String pattern = "https://rgs.betradar.com/vdr/statistic/race_calendar/\\d+/";
        By frameLocator = By.className("betradarFrame");
        By frameLocator2 = By.id("gameFrame");
        By frameLocator3 = By.id("frame");
        By frameLocator4 = By.id("vdrframe");
        By locator = By.cssSelector(".virtual-sports.active");
        By langLocator = By.cssSelector(".soccer");
        By imageLocator = By.id("racecal_statistic");
        WebDriverUtil webDriverUtil = new WebDriverUtil(webDriver);

        CSVReader reader = new CSVReader(new FileReader(CSV_Path));
        String[] csvCell;

        while ((csvCell = reader.readNext()) != null) {
            String url = csvCell[0];
            String testWorldLang = csvCell[1];
            String lang = csvCell[2];

            try {
                webDriver.get(url);
                //check virtual sports is active
                WebElement element = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(locator));
                assertTrue(element.getAttribute("class").contains("active"));
                //check locale matches the language in the site
                element = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(langLocator));
                System.out.println(element.getText() + "=" + testWorldLang);
                assertTrue(element.getText().equals(testWorldLang));
                //input path to our iFrame
                Thread.sleep(15000);
                WebElement iframe = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(frameLocator));
                webDriver.switchTo().frame(iframe);
                WebElement iframe2 = webDriver.findElement(frameLocator2);
                webDriver.switchTo().frame(iframe2);
                WebElement iframe3 = webDriver.findElement(frameLocator3);
                webDriver.switchTo().frame(iframe3);
                WebElement iframe4 = webDriver.findElement(frameLocator4);
                webDriver.switchTo().frame(iframe4);
                //find calendar element with link
                element = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(imageLocator));
                //check patern link
                assertTrue(element.getAttribute("href").matches(pattern + lang));

            } catch (Exception e) {
                exceptionCount++;
                e.printStackTrace();
                System.out.println("errors for this link :" + url);
            } catch (AssertionError j) {
                assertException++;
                j.printStackTrace();
                System.out.println("assertError for this link" + url);
            }

        }

        if (exceptionCount > 0 || assertException > 0) {
            assertTrue(false);
        }
    }
}
