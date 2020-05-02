/**
 * User: Gladson Antony
 * Date: 02-May-2020
 * Time: 19:40
 */
package newseleniumfeatures.windowmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example03_MinimizeWindow {
    @Test
    public void test_ChromeMinimize() throws Exception {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.navigate().to("https://www.google.co.in");
        chromeDriver.manage().window().minimize();
        chromeDriver.switchTo().newWindow(WindowType.TAB);
        chromeDriver.manage().window().maximize();
        chromeDriver.navigate().to("https://www.selenium.dev/");
        chromeDriver.manage().window().minimize();
        chromeDriver.quit();
    }
}
