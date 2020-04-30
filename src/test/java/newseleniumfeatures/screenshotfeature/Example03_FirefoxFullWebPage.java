/**
 * User: Gladson Antony
 * Date: 30-April-2020
 * Time: 19:30
 */
package newseleniumfeatures.screenshotfeature;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Example03_FirefoxFullWebPage {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.firefox.silentOutput", "true");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void test_FirefoxFullWebPageScreenshot() throws Exception {
        driver.navigate().to("https://www.selenium.dev/");
        File file = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./target/SeleniumDevFullPageCapture.png"));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
