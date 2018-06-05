package com.google;

import Selenium.core.WebDriverTestBase;
import Selenium.pages.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class w3schoolsTest extends WebDriverTestBase {

    @Test
    public void dragenDrop() {

        webDriver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");
        webDriver.switchTo().frame(0);

        WebElement fromElemfromElem = webDriver.findElement(By.id("drag1"));
        WebElement toElem = webDriver.findElement(By.id("div1"));

        Actions builder = new Actions(webDriver);
        Action dragAndDrop =
                builder.clickAndHold(fromElemfromElem)
                        .moveToElement(toElem).release(toElem).build();
        dragAndDrop.perform();

    }

}
