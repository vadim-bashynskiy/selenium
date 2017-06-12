package com.kit.google.classwork.lesson3PageObject;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.StylusResultPage;
import com.kit.pages.StylusSearchPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by testu on 6/9/2017.
 */
public class NewStylusSearchTest extends WebDriverTestBase {
    private String googleSearch = "http://www.stylus.com.ua";
    private String searchText = "Sony Xperia Z2 Black";
    private String content = "Код товара";
    private String correctSearch = "Sony";

    @Test
    public void searchTest() {
        StylusSearchPage stylusSearchPage = new StylusSearchPage(webDriver);
        stylusSearchPage.openUrl(googleSearch);
        stylusSearchPage.findAndSubmitSearchData(searchText);
        assertTrue(stylusSearchPage.getLinkText().contains(correctSearch));
        stylusSearchPage.clickFoundElement();
        StylusResultPage stylusResultPage = new StylusResultPage(webDriver);
        assertTrue(stylusResultPage.getLinkText().contains(content));


    }
}
