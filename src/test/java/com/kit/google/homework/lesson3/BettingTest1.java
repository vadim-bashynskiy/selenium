package com.kit.google.homework.lesson3;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.BettingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by admin on 06.07.2017.
 */
public class BettingTest1 extends WebDriverTestBase {
    String pattern = "https://rgs.betradar.com/vdr/statistic/race_calendar/\\d+/";
    By imageLocator = By.id("racecal_statistic");

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{"https://www.trbet55.com/tr/virtual-sports#greyhounds", "FUTBOL", "tr"},
                new Object[]{"https://www.trbet55.com/en/virtual-sports#greyhounds", "SOCCER", "en"},
                new Object[]{"https://www.bettilt2.com/en/virtual-sports#greyhounds", "SOCCER", "en"},
                new Object[]{"https://www.bettilt2.com/pt/virtual-sports#greyhounds", "FUTEBOL", "pt"},
        };
    }

    @Test(dataProvider = "testData")
    public void virtualSportsActive(String url, String testWorldLang, String lang) throws Exception {
        BettingPage bettingPage = new BettingPage(webDriver);
        bettingPage.open(url);
        assertTrue(bettingPage.checkActiveTab().contains("active"));

    }

    @Test(dataProvider = "testData")
    public void localeLanguage(String url, String testWorldLang, String lang) throws Exception {
        BettingPage bettingPage = new BettingPage(webDriver);
        bettingPage.open(url);
        assertTrue(bettingPage.checkLanguageLocale().equals(testWorldLang));


    }

    @Test(dataProvider = "testData")
    public void checkPattern(String url, String testWorldLang, String lang) throws IOException, InterruptedException {
        BettingPage bettingPage = new BettingPage(webDriver);
        bettingPage.open(url);
        //input path to our iFrame and check pattern link
        Thread.sleep(10000);
        assertTrue(bettingPage.checkPattern().matches(pattern + lang));



    }
}
