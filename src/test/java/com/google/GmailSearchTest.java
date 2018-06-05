package com.google;

import Selenium.core.WebDriverTestBase;
import Selenium.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailSearchTest extends AbstractPage {

    private By emailLocator = By.cssSelector("input[type='email']");
    private By buttonLocator = By.cssSelector("");




    public GmailSearchTest(WebDriver webDriver) {
        super(webDriver);
    }
}
