package newseleniumfeatures.screenshotfeature;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Example01_ChromeWebElement {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void test_ChromeWebElementScreenshot() throws Exception {
        driver.navigate().to("https://www.google.co.in/");
        WebElement logo = driver.findElement(By.xpath("//div[@id='hplogo']"));

        File file = logo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./target/GoogleLogo.png"));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
