package com.kit.google.homework.lesson3;

import au.com.bytecode.opencsv.CSVReader;
import com.kit.core.WebDriverTestBase;
import com.kit.pages.BettingPage;
import com.kit.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by VBashynskyi on 03.07.2017.
 */

public class BettingTest extends WebDriverTestBase {
    BettingPage bettingPage = new BettingPage(webDriver);
    String pattern = "https://rgs.betradar.com/vdr/statistic/race_calendar/\\d+/";
    String workingDirectory = System.getProperty("user.dir");
    String pathToFile = "\\src\\main\\resources\\testList.csv";
    String CSV_Path = workingDirectory + pathToFile;
    CSVReader reader = new CSVReader(new FileReader(CSV_Path));
    String[] csvCell;
    String url = csvCell[0];
    String testWorldLang = csvCell[1];
    String lang = csvCell[2];

    public BettingTest() throws FileNotFoundException {
    }

    @Test
    public void virtualSportsActive() throws Exception {
        while ((csvCell = reader.readNext()) != null) {
            bettingPage.open(url);
            assertTrue(bettingPage.checkActiveTab().contains("active"));
        }
    }

    @Test
    public void localeLanguage() throws IOException {
        while ((csvCell = reader.readNext()) != null) {
            bettingPage.open(url);
            assertTrue(bettingPage.checkLanguageLocale().equals(testWorldLang));
        }
    }

    @Test
    public void checkPattern() throws IOException {
        while ((csvCell = reader.readNext()) != null) {
            bettingPage.open(url);
            //input path to our iFrame and check pattern link
            //Thread.sleep(15000);
            assertTrue(bettingPage.CheckPattern().matches(pattern + lang));
        }

    }
}
