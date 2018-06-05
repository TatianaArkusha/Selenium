package com.google;

import Selenium.core.WebDriverTestBase;
import org.openqa.selenium.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners({Selenium.core.TestListener.class})
public class AlertBox extends WebDriverTestBase {
    String webPageWithAlert = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";

    @Test
    public void alertTest() {
        webDriver.get(webPageWithAlert);
        webDriver.switchTo().frame("iframeResult");
        WebElement tryItButton = webDriver.findElement(By.cssSelector("h2+button"));
        tryItButton.click();

        Alert alert1 = webDriver.switchTo().alert();
        alert1.accept();
        //   alert1.getText();
        //   alert1.dismiss();
        WebElement link1 = webDriver.findElement(By.id("demo"));
        assertTrue(link1.getText().equals("You pressed OK!"));

        String js = "document.querySelector(\"h2+button\").click()";
        WebElement element;
        element = (WebElement) ((JavascriptExecutor) webDriver).executeScript(js);
        Alert alert2 = webDriver.switchTo().alert();
        alert2.dismiss();
        assertTrue(link1.getText().equals("You pressed Cancel!"));
    }

}
