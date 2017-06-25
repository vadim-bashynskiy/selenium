package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by testu on 6/9/2017.
 */
public class GoogleSearchPage extends GoogleBasePage{
    private WebElement searchField;
    By searchLocator = By.name("q");

    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open (String url){
        webDriver.get(url);
    }
    //{0} параметр что принимает метод
    @Attachment(value = "{0}", type = "text/plain")
    @Step("Fills a search text \"{0}\" and presses the enter")
    public void fillAndSubmitSearchData(String searchText){
        searchField = webDriver.findElement(searchLocator);
        webDriverUtil.jsClick("q","name");
        //searchField.sendKeys(searchText);
        //searchField.submit();
    }

}
