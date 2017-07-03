package com.kit.google.homework.lesson3;

import au.com.bytecode.opencsv.CSVReader;
import com.kit.core.WebDriverTestBase;
import com.kit.util.WebDriverUtil;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by VBashynskyi on 03.07.2017.
 */

public class BettingTest extends WebDriverTestBase {
    String CSV_Path = "D:\\kitcenterCourses\\selenium\\src\\main\\resources\\testList.csv";

    @Test
    public void testBetting() throws Exception {
        WebDriverUtil webDriverUtil = new WebDriverUtil(webDriver);
        CSVReader reader = new CSVReader(new FileReader(CSV_Path));
        String[] csvCell;

        while ((csvCell = reader.readNext()) != null) {
            String url = csvCell[0];
            String testWorldLang = csvCell[1];

            try {
                webDriver.get("http://noblockme.ru/");
                WebElement elementInput = webDriver.findElement(By.name("url"));
                elementInput.click();
                elementInput.sendKeys(url);
                elementInput.submit();
                By locator = By.cssSelector(".mainMenu li a:hover, .mainMenu li a.active");
                WebElement element = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(locator));
                assertTrue(element.getAttribute("class").contains("tyrytt"));

                element = webDriver.findElement(By.xpath(".//*"));
                System.out.println(element.getAttribute("lang"));

            } catch (NotFoundException e) {
                System.out.println("element not found");
            }catch (AssertionError j){
                j.printStackTrace();
            }
        }
    }
}