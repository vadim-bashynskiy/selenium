package com.kit.google.classwork.lesson3PageObject;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.GoogleSearchPage;
import com.kit.pages.GoogleSearchResultPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by testu on 6/9/2017.
 */
public class GoogleSearchTest extends WebDriverTestBase {
    private String googleSearch= "https://www.google.com.ua";
    private String searchText = "Selenium";
    @Test
    public void searchTest(){
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);
        googleSearchPage.open(googleSearch);
        googleSearchPage.fillAndSubmitSearchData(searchText);
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(webDriver);
        assertTrue(googleSearchResultPage.getLinkText().contains(searchText));
    }
}
