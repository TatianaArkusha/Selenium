package com.google;

import Selenium.core.WebDriverTestBase;
import Selenium.pages.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ThomascookTest extends WebDriverTestBase {

    private String inputText = "Italy";

    @Test
    public void dragenDrop() throws InterruptedException {

//открыть сайт
        webDriver.get("https://www.thomascook.com");
        webDriver.navigate().refresh();

//найти поле для ввода и кликнуть мышкой
        By searchLocator = By.xpath("//*[@id=\'SearchbarForm-destinationContainer\']/div/div/div/tc-typeahead/div/div[2]");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.click();
//измененное состоянние поля после клика мышкой и ввести значение
        By searchLocator2 = By.xpath("//*[@id=\'SearchbarForm-goingTo\']");
        WebElement searchField2 = webDriver.findElement(searchLocator2);
        searchField2.sendKeys(inputText);

        Thread.sleep(2000);
        searchField2.sendKeys(Keys.DOWN);
        searchField2.sendKeys(Keys.ENTER);

//найти кнопку и нажать на нее
        By searchLocatorButton = By.id("SearchbarForm-submitBtn");
        WebElement searchButton = webDriver.findElement(searchLocatorButton);
        searchButton.click();

    }

}
