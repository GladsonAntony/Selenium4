/**
 * User: Gladson Antony
 * Date: 02-May-2020
 * Time: 19:15
 */
package newseleniumfeatures.windowmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Example01_NewWindow
{
    @Test
    public void test_ChromeNewWindow() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.silentOutput","true");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.navigate().to("https://www.google.co.in");
        chromeDriver.switchTo().newWindow(WindowType.WINDOW);
        chromeDriver.navigate().to("https://www.selenium.dev/");
        chromeDriver.manage().window().maximize();
        chromeDriver.quit();
    }

    @Test
    public void test_FirefoxNewWindow() throws Exception
    {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"./target/FirefoxLog.txt");
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.navigate().to("https://www.google.com");
        firefoxDriver.manage().window().maximize();
        firefoxDriver.switchTo().newWindow(WindowType.WINDOW);
        firefoxDriver.navigate().to("https://www.selenium.dev/");
        firefoxDriver.manage().window().maximize();
        firefoxDriver.quit();
    }
}
