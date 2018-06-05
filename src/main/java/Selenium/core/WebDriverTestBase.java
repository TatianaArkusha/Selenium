package Selenium.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static Selenium.core.PropertiesCache.getProperty;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;



public class WebDriverTestBase {
    protected WebDriver webDriver;

    private String browser = System.getProperty("browser", CHROME);

    private long implicitWait = Long.parseLong(getProperty("wait.implicit"));

    private long pageWait = Long.parseLong(getProperty("wait.page"));

    private long scriptWait = Long.parseLong(getProperty("wait.script"));

    @BeforeClass
    public void setUp() {
        switch (browser){
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();//открыть полное окно
                webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
                webDriver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);
                webDriver.manage().timeouts().setScriptTimeout(scriptWait, TimeUnit.SECONDS);
                break;
            case FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();//открыть полное окно
                webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
                webDriver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);
                webDriver.manage().timeouts().setScriptTimeout(scriptWait, TimeUnit.SECONDS);
                break;

        }

    }

    @AfterClass
    public void tearDown() {
        if (webDriver != null) {
            //webDriver.close();// закрывает вкладку
          webDriver.quit(); // закрывает браузер
        }
    }
}
