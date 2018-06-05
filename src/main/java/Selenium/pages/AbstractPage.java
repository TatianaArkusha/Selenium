package Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver){
        this.webDriver = driver;
        wait = new WebDriverWait(this.webDriver, 30);
    }
}
