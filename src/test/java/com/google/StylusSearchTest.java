package com.google;

import Selenium.pages.AbstractPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;

import java.util.concurrent.TimeUnit;

import static Selenium.core.PropertiesCache.getProperty;
import static org.testng.Assert.assertTrue;

public class StylusSearchTest extends AbstractPage {
    private String siteSearch = "https://www.stylus.com.ua/";
    private String inputText = "Sony Z2";

    public StylusSearchTest(WebDriver webDriver) {
        super(webDriver);
    }
    private long implicitWait = Long.parseLong(getProperty("wait.implicit"));

    private long pageWait = Long.parseLong(getProperty("wait.page"));

    private long scriptWait = Long.parseLong(getProperty("wait.script"));

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tetiana\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();//открыть полное окно
        webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(scriptWait, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        if (webDriver != null) {
            //  webDriver.close();// закрывает вкладку
            webDriver.quit(); // закрывает браузер
        }
    }

    @Test
    public void searchTest() {

        webDriver.get(siteSearch);

        By searchLocator = By.xpath("//*[@id='head-search']/form/input[1]");

        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(inputText);

        By searchLocatorButton = By.xpath("//*[@id=\"head-search\"]/form/input[2]");

        webDriver.findElement(searchLocatorButton).click();

        //  WebDriverWait wait = new WebDriverWait(driver, 20);
        // WebElement searchField2 = wait.until(ExpectedConditions.presenceOfElementLocated(searchLocatorButton));

        By linkLocator = By.xpath("//*[@id=\"search-list\"]/ul/li[2]/a/span");

        WebElement link = webDriver.findElement(linkLocator);

        assertTrue(link.getText().contains("Смартфон Sony Xperia Z2 Black"));

        webDriver.findElement(linkLocator).click();

        By searchLocatorName = By.cssSelector(".title h1");

        WebElement link1 = webDriver.findElement(searchLocatorName);

        assertTrue(link1.getText().contains("Смартфон Sony Xperia Z2 Black"));

    }
}
