package com.kit.google.homework.lesson3;

import au.com.bytecode.opencsv.CSVReader;
import com.kit.core.WebDriverTestBase;
import com.kit.pages.BettingPage;
import com.kit.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by VBashynskyi on 05.07.2017.
 */
public class test extends WebDriverTestBase{
   private String pattern = "https://rgs.betradar.com/vdr/statistic/race_calendar/\\d+/";

    @DataProvider
    public Object[][] testData() throws IOException {
               return WebDriverUtil.csvRead(WebDriverUtil.csvPath());
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
