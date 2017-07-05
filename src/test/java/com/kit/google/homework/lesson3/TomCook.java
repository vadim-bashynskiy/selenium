package com.kit.google.homework.lesson3;

import au.com.bytecode.opencsv.CSVReader;
import com.kit.core.WebDriverTestBase;
import com.kit.pages.BettingPage;
import com.kit.util.WebDriverUtil;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Created by testu on 6/20/2017.
 */
public class TomCook extends WebDriverTestBase {
    private String outText = "7 Nights";
    private String nextText = "Audi";
    String workingDirectory = System.getProperty("user.dir");
    String pathToFile = "\\src\\main\\resources\\testList.csv";
    String CSV_Path = workingDirectory + pathToFile;
    @Test
    public void test() throws InterruptedException {

        WebDriverUtil webDriverUtil = new WebDriverUtil(webDriver);
        webDriver.get("https://www.thomascook.com/");

        List<WebElement> webElementList = webDriver.findElements(By.cssSelector(".SearchbarForm-summary.ng-binding"));
        if (!webElementList.isEmpty()) {
            webElementList.get(1).click();
        } else {
            assertFalse("Elements not found", true);
        }

        //simple case with java script
        // WebElement element = webDriver.findElement(By.cssSelector(".SearchbarForm-summary.ng-binding"));
        //   element.click();
        webDriverUtil.jsClick("SearchbarForm-origin", "id");
        webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(By.className("deliver-component-CloseButton-times"))).click();

   /* document.getElementsByClassName("deliver-component-Modal")[0].remove()
        document.getElementsByClassName("deliver-overlay")[0].remove()*/
        WebElement element = webDriver.findElement(By.id("SearchbarForm-origin"));
        // element.sendKeys("Hello");
        webDriverUtil.jsClick("SearchbarForm-goingTo", "id");
    }

    @Test
    public void testDropDown() {

        WebDriverUtil webDriverUtil = new WebDriverUtil(webDriver);
        webDriver.get("https://www.thomascook.com/");
        WebElement element = webDriver.findElement(By.id("SearchbarForm-duration"));
        Select selectObject = new Select(element);
        selectObject.selectByVisibleText(outText);
        assertTrue(outText.equals(selectObject.getFirstSelectedOption().getText()));


        //work with alert
        /*//Alert alert = webDriver.switchTo().alert();

        String alertText = alert.getText();

        alert.accept();*/
        //find frame element
      /*  String frameName = "blbala";
        //select by frame name
        webDriver.switchTo().frame(frameName);
        //select by massive frame
        webDriver.switchTo().frame(0);
        //select by webelement
        WebElement element1 = webDriver.findElement(By.id("blabla"));
        webDriver.switchTo().frame(element);*/
    }

    @Test
    public void testFrame() {
        webDriver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        WebElement element1 = webDriver.findElement(By.id("iframeResult"));
        webDriver.switchTo().frame(element1);
        WebElement element = webDriver.findElement(By.xpath("html/body/select"));
        Select selectObject = new Select(element);
        selectObject.selectByVisibleText(nextText);
        assertTrue(nextText.equals(selectObject.getFirstSelectedOption().getText()));


    }
/*
    Actions builder = new Actions(webDriver);
        builder.clickAndHold(From).moveToElement(To)
    .release(To).build().perform();

*/

    @Test
    public void testDragDrop() throws InterruptedException {
        webDriver.get("https://gojs.net/latest/samples/htmlDragDrop.html?gclid=CLjWnLeG5tQCFUeVGwodCowEcA");
        WebElement From = webDriver.findElement(By.xpath(".//*[@id='sample']/div[1]/span[1]/div/div[1]"));
        WebElement To = webDriver.findElement(By.xpath(".//*[@id='myDiagramDiv']/canvas"));
        Actions builder = new Actions(webDriver);
        builder.clickAndHold(From).moveToElement(To).release(To).build().perform();

        webDriver.switchTo().defaultContent();
        builder.dragAndDrop(From, To);
    }

}

