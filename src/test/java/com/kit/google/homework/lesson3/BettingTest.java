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
    //WebDriverUtil webDriverUtil = new WebDriverUtil(webDriver);
    String pattern = "https://rgs.betradar.com/vdr/statistic/race_calendar/\\d+/";
    String workingDirectory = System.getProperty("user.dir");
    String pathToFile = "\\src\\main\\resources\\testList.csv";
    String CSV_Path = workingDirectory + pathToFile;
    By imageLocator = By.id("racecal_statistic");
    int i = 0;
    String url = null;

    @Test
    public void virtualSportsActive() throws Exception {
        BettingPage bettingPage = new BettingPage(webDriver);
        CSVReader reader = new CSVReader(new FileReader(CSV_Path));
        String[] csvCell;
        int errorCount = 0;
        while ((csvCell = reader.readNext()) != null) {
                url = csvCell[0];
                try {
                    System.out.println("active" + i++);

                    bettingPage.open(url);
                    assertTrue(bettingPage.checkActiveTab().contains("active"));
                } catch (AssertionError a) {
                    a.printStackTrace();
                    System.out.println("error with website :" + url);
                    errorCount++;
                }
            }
        if (errorCount >0){assertTrue(false);}

    }

    @Test
    public void localeLanguage() throws Exception {
        BettingPage bettingPage = new BettingPage(webDriver);
        CSVReader reader = new CSVReader(new FileReader(CSV_Path));
        String[] csvCell;
        int errorCount = 0;
        while ((csvCell = reader.readNext()) != null) {
            url = csvCell[0];
            String testWorldLang = csvCell[1];
            try {
                bettingPage.open(url);
                System.out.println("local" + i++);
                assertTrue(bettingPage.checkLanguageLocale().equals(testWorldLang));

            } catch (AssertionError a) {
                a.printStackTrace();
                System.out.println("error with website :" + url);
                errorCount++;
            }
        }
        if (errorCount >0){assertTrue(false);}
    }

    @Test
    public void checkPattern() throws IOException {
        BettingPage bettingPage = new BettingPage(webDriver);
        CSVReader reader = new CSVReader(new FileReader(CSV_Path));
        String[] csvCell;
        int errorCount = 0;
        while ((csvCell = reader.readNext()) != null) {
                url = csvCell[0];
                String lang = csvCell[2];
                try {
                    bettingPage.open(url);
                    //input path to our iFrame and check pattern link
                    Thread.sleep(10000);
                    System.out.println("pattern" + i++);
                    bettingPage.CheckPattern();
                    WebElement element = webDriver.findElement(imageLocator);
                    assertTrue(element.getAttribute("href").matches(pattern + lang));
                    System.out.println("our patern " + pattern+lang);
                    System.out.println("code patern " +  element.getAttribute("href"));
                } catch (AssertionError a) {
                    a.printStackTrace();
                    System.out.println("error with website :" + url);
                    errorCount++;
                }catch (Exception e){
                    e.printStackTrace();
                    errorCount++;
                }
            }
        if (errorCount >0){assertTrue(false);}
    }
}
