package com.google;

import Selenium.core.WebDriverTestBase;
import Selenium.pages.GoogleResultPage;
import Selenium.pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertTrue;

public class GoogleSearchTest extends WebDriverTestBase {
    private String googleSearch = "https://www.google.com.ua/";
    public String searchText = "Selenium";

    @Test
    @Step ("Проверка поиска страницы")
    public void searchTest() {

        webDriver.get(googleSearch);

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);

        googleSearchPage.search(searchText);

        By linkLocator = By.xpath("//*[@id='rso']/div/div/div[1]/div/div/h3/a");
        WebElement link = webDriver.findElement(linkLocator);

        assertTrue(link.getText().contains(searchText));

        GoogleResultPage googleResultPage = new GoogleResultPage(webDriver);

        assertTrue(googleResultPage.getLink().getText().contains(searchText));

    }

}
