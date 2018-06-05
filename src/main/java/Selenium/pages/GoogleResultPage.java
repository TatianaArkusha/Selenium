package Selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleResultPage extends AbstractPage {

    //находим первую линку Selenium на странице
    By searchLocator = By.cssSelector("#rso > div > div > div:nth-child(1) > div > div > h3 > a");

    public GoogleResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    //возвращаем линку
    public WebElement getLink() {

        WebElement link = webDriver.findElement(searchLocator);
        return link;

    }

    //проверяем загрузилась ли страница (true or false)
    public boolean title() {

        WebElement link = webDriver.findElement(searchLocator);
        return wait.until(ExpectedConditions.titleIs("selenium - Google Searche"));
    }
}