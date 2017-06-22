package com.kit.google.classwork.lesson4PageFactory;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.google.GoogleResultPageFactoryPage;
import com.kit.pages.google.GoogleSearchPageFactoryPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by testu on 6/13/2017.
 */
public class GoogleSearchPageFactoryTest extends WebDriverTestBase {
    private String googleSearch= "https://www.google.com.ua";
    private String searchText = "Selenium";
    @Test
    public void searchTest(){
        GoogleSearchPageFactoryPage factoory = PageFactory.initElements(webDriver,GoogleSearchPageFactoryPage.class);
        factoory.open(googleSearch);
        factoory.fillAndSubmitSearchData(searchText);
        GoogleResultPageFactoryPage resultPage = PageFactory.initElements(webDriver, GoogleResultPageFactoryPage.class);
        assertTrue(resultPage.getLinkText().contains(searchText));
    }
}
