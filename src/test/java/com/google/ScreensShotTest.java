package com.google;

import Selenium.core.WebDriverTestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class ScreensShotTest extends WebDriverTestBase {
    String webPageWithAlert = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";


    @Test
    public void alertTest() {
        webDriver.get(webPageWithAlert);
        webDriver.switchTo().frame("iframeResult");
        WebElement tryItButton = webDriver.findElement(By.cssSelector("h2+button"));
        tryItButton.click();

        Alert alert1 = webDriver.switchTo().alert();
        alert1.accept();
        WebElement link1 = webDriver.findElement(By.id("demo"));
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile,
                    new File("C:\\Users\\Tetiana\\tmp\\failed\\Alert.png"));
        } catch (IOException e) {

        }
        assertTrue(link1.getText().equals("You pressed Cancel!"));
    }
}
