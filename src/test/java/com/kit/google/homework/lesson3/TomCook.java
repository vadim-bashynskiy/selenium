package com.kit.google.homework.lesson3;

import com.kit.core.WebDriverTestBase;
import com.kit.util.WebDriverUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/**
 * Created by testu on 6/20/2017.
 */
public class TomCook extends WebDriverTestBase{
    @Test
    public void test() throws InterruptedException {

        WebDriverUtil webDriverUtil = new WebDriverUtil(webDriver);
        webDriver.get("https://www.thomascook.com/");


        List<WebElement> webElementList = webDriver.findElements(By.cssSelector(".SearchbarForm-summary.ng-binding"));
        if (!webElementList.isEmpty()) {
            webElementList.get(1).click();
        }else {
            assertFalse("Elements not found", true);
        }

        //simple case with java script
       // WebElement element = webDriver.findElement(By.cssSelector(".SearchbarForm-summary.ng-binding"));
      //   element.click();
        webDriverUtil.jsClick("SearchbarForm-origin","id");
        webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(By.className("deliver-component-CloseButton-times"))).click();
    }
   /* document.getElementsByClassName("deliver-component-Modal")[0].remove()
        document.getElementsByClassName("deliver-overlay")[0].remove()*/
}
