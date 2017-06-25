package com.kit.google.classwork.lesson3PageObject;

import com.kit.core.TestListener;
import com.kit.core.WebDriverTestBase;
import com.kit.pages.google.GoogleSearchPage;
import com.kit.pages.google.GoogleSearchPageFactoryPage;
import com.kit.pages.google.GoogleSearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/**
 * Created by testu on 6/9/2017.
 */
@Features("Gogole search")
@Stories("WEB-777")
//@Listeners({com.kit.core.TestListener.class})
public class GoogleSearchTest extends WebDriverTestBase {
    private String googleSearch= "https://www.google.com.ua";
    private String searchText = "Selenium";
    @Title("Google search test - positive scenario")
    @Description("Searches any text on google.com")
    //перед тестом (enabled = false) если еще в разработке и не хочешь что бы выполнялось
    @Test
    public void searchTest(){
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);
        googleSearchPage.open(googleSearch);
        googleSearchPage.fillAndSubmitSearchData(searchText);
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(webDriver);
     //   googleSearchResultPage.takeScreenshot(searchText);
        assertTrue(googleSearchResultPage.getLinkText().contains(searchText));
        List<WebElement> webElementList = webDriver.findElements(By.cssSelector(".r>adfgfdg"));
        if (!webElementList.isEmpty()) {
            for (WebElement webElement : webElementList) {
                assertTrue(webElement.getText().toLowerCase().contains(searchText.toLowerCase()));
            }
        }else {
            assertFalse("Elements not found", true);
        }
    }
    @Title("Google search test enabled")
    @Description("Searches any text on google.com")
    @Test()
    public void searchTestExample(){
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);
        googleSearchPage.open(googleSearch);
        googleSearchPage.fillAndSubmitSearchData(searchText);
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(webDriver);
        //   googleSearchResultPage.takeScreenshot(searchText);
        assertTrue(googleSearchResultPage.getLinkText().contains(searchText));
        List<WebElement> webElementList = webDriver.findElements(By.cssSelector(".r>adfgfdg"));
        if (!webElementList.isEmpty()) {
            for (WebElement webElement : webElementList) {
                assertTrue(webElement.getText().toLowerCase().contains(searchText.toLowerCase()));
            }
        }else {
            assertFalse("Elements not found", true);
        }
    }
}
