package com.kit.google.homework;
import com.kit.core.WebDriverTestBase;
import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.fail;

/**
 * Created by admin on 05.07.2017.
 */
public class CsvTestNgTest extends WebDriverTestBase {
    String url = "https://www.codecademy.com/";

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                new Object[] {"nderklon1@mail.ru","5555555","Vados1","sign up and start coding in seconds."},
                new Object[] {"nderklon2@mail.ru","66666666","Vados2","ui-inited"},
                new Object[] {"nderklon3@mail.ru","677777777","Vados3","sign up and start coding in seconds."},
                new Object[] {"nderklon4@mail.ru","888888888","Vados4","ui-inited"},
                new Object[] {"nderklon5@mail.ru","999999999","Vados5","sign up and start coding in seconds."},
    };
    }



    @Test(dataProvider = "testData")
    public void testBMICalculator(String userEmail, String userPassword, String
            usernameMy, String category) {

            webDriver.get(url);
            WebElement heightField = webDriver.findElement(By.cssSelector("#user_emaillll"));
            heightField.clear();
            heightField.sendKeys(userEmail);

            WebElement weightField = webDriver.findElement(By.cssSelector("#user_password"));
            weightField.clear();
            weightField.sendKeys(userPassword);

            WebElement username = webDriver.findElement(By.cssSelector("#user_username"));
            username.clear();
            username.sendKeys(usernameMy);
            WebElement registrationForm = webDriver.findElement(By.cssSelector(".registration-form__title"));
            assertTrue(registrationForm.getText().toLowerCase().equals(category));
    }
}
