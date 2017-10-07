package com.kit.google.homework.lesson3;
import com.kit.core.WebDriverTestBase;
import com.kit.pages.BettingPage;
import com.kit.util.WebDriverUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import java.io.IOException;


import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by VBashynskyi on 05.07.2017.
 */
public class TestBetting extends WebDriverTestBase {
    private String pattern = "https://rgs.betradar.com/vdr/statistic/race_calendar/\\d+/";

    @DataProvider
    //read from csv file
    public Object[][] testData() throws IOException {
        return WebDriverUtil.csvRead(WebDriverUtil.csvPath());
    }
    @Title("Greyhounds virtual sports item menu is highlighted")
    @Test(dataProvider = "testData")
    public void virtualSportsActive(String url, String testWorldLang, String lang) throws Exception {
        BettingPage bettingPage = new BettingPage(webDriver);
        bettingPage.open(url);
        //check then tab is active
        assertTrue(bettingPage.checkActiveTab().contains("active"));
    }
    @Title("locale matches the language used in the site.")
    @Test(dataProvider = "testData")
    public void localeLanguage(String url, String testWorldLang, String lang) throws Exception {
        BettingPage bettingPage = new BettingPage(webDriver);
        bettingPage.open(url);
        //check locale Language
        assertTrue(bettingPage.checkLanguageLocale().equals(testWorldLang));
    }
    @Title("bars icon on right of the race calendar header use the location with the following pattern.")
    @Test(dataProvider = "testData")
    public void checkPattern(String url, String testWorldLang, String lang) throws IOException, InterruptedException {
        BettingPage bettingPage = new BettingPage(webDriver);
        bettingPage.open(url);
        //input path to our iFrame and check pattern link
        assertTrue(bettingPage.checkPattern().matches(pattern + lang));
    }
}
