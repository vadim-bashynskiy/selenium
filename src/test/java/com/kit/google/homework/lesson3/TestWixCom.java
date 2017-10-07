package com.kit.google.homework.lesson3;

import com.kit.core.WebDriverTestBase;
import com.kit.util.WebDriverUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VBashynskyi on 07.10.2017.
 */
public class TestWixCom extends WebDriverTestBase {
    public String  come(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;

        return (String) js.executeScript("document.card.score");
    }
    @Test
    public void findCombination() {
        WebDriverUtil webDriverUtil = new WebDriverUtil(webDriver);
        webDriver.get("http://puzzles.setgame.com/puzzle/set.htm");
        System.out.println(come());
        List<WebElement> webElementList = webDriver.findElements(By.cssSelector("html>body>center>form>table>tbody>tr>td>table>tbody>tr>td>input"));

        int count = 0;
        int image3 = 0;
        int image2 = 0;
        int image1 = 0;
        while (count == 0) {
            webElementList.get(image1).click();
            webElementList.get(image3+1).click();
            webElementList.get(image2+2).click();
            Alert alert = webDriver.switchTo().alert();
            if (alert.getText().contains("GREAT!")){

                System.out.println("Won combination : " + image1 + "" + image3+1 + "" + image2+2);
            }
            alert.accept();

            if (image3 + 1 < webElementList.size() - 2 && image2 + 2 < webElementList.size() - 1) {
                image2++;
            } else {
                image2 = image3 + 1;
                image3++;
            }
            if (image3 > webElementList.size() - 3) {
                image1++;
                image3 = 0;
                image2 = image3 + image1;
                image3 = image1;
                count = 0;
            }
            if (image1 == webElementList.size() - 2) {
                count = 2;
            }
        }
    }
}
