/**
 * User: Gladson Antony
 * Date: 02-May-2020
 * Time: 19:42
 */
package newseleniumfeatures.windowmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example04_FullScreen
{
    @Test
    public void test_ChromeFullScreen() throws Exception {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.navigate().to("https://www.google.co.in");
        chromeDriver.manage().window().fullscreen();
        Thread.sleep(5000);
        chromeDriver.switchTo().newWindow(WindowType.TAB);
        chromeDriver.manage().window().maximize();
        Thread.sleep(5000);
        chromeDriver.navigate().to("https://www.selenium.dev/");
        chromeDriver.manage().window().fullscreen();
        Thread.sleep(5000);
        chromeDriver.manage().window().minimize();
        Thread.sleep(5000);
        chromeDriver.quit();
    }
}
