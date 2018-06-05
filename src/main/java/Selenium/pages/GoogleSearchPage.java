package Selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage extends AbstractPage {

    By searchLocator = By.xpath("//*[@id='lst-ib']");

    private WebElement searchField;

    //конструктор-метод
    public GoogleSearchPage(WebDriver webDriver) {

        super(webDriver);
    }

    //метод
    public void search(String searchText) {
        searchField = wait.until(ExpectedConditions.elementToBeClickable(searchLocator));
        searchField.sendKeys(searchText);//отправляем текст
        searchField.submit();//применить
    }

}
