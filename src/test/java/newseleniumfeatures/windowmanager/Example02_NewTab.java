/**
 * User: Gladson Antony
 * Date: 02-May-2020
 * Time: 19:33
 */
package newseleniumfeatures.windowmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Example02_NewTab {
    @Test
    public void test_ChromeNewTab() throws Exception {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.navigate().to("https://www.google.co.in");
        chromeDriver.switchTo().newWindow(WindowType.TAB);
        chromeDriver.navigate().to("https://www.selenium.dev/");
        chromeDriver.quit();
    }

    @Test
    public void test_FirefoxNewTab() throws Exception {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./target/FirefoxLog.txt");
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.navigate().to("https://www.google.com");
        firefoxDriver.manage().window().maximize();
        firefoxDriver.switchTo().newWindow(WindowType.TAB);
        firefoxDriver.navigate().to("https://www.selenium.dev/");
        firefoxDriver.quit();
    }
}
