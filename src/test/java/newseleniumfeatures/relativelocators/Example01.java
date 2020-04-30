package newseleniumfeatures.relativelocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class Example01 {
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
    public void test_RelativeExample01() {
        driver.navigate().to("https://www.selenium.dev/");

        //Use of Relative Locator - Below
        System.out.println("To Demonstrate the use of Selenium 4 Relative Locator - Below");
        System.out.println("==============================================================================================");
        WebElement visible_LogoGreen = driver.findElement(By.xpath("//img[@class='logo logo-large']"));
        System.out.println("Green Logo URL: " + visible_LogoGreen.getAttribute("src"));

        WebElement visible_LogoRed = driver.findElement(withTagName("img")
                .below(visible_LogoGreen));
        System.out.println("Red Logo URL:   " + visible_LogoRed.getAttribute("src"));
        System.out.println("==============================================================================================");


        //Use of Relative Locator - toLeftOf/toRightOf
        System.out.println("\n\nTo Demonstrate the use of Selenium 4 Relative Locator - toLeftOf/toRightOf");
        System.out.println("==============================================================================================");
        WebElement seleniumIDE = driver.findElement(By.xpath("//div[@class='getting-started-topic']//h3[contains(text(),'IDE')]"));
        System.out.println("Center Element Selenium IDE:            " + seleniumIDE.getText());

        WebElement relativeSeleniumWebDriver = driver.findElement(withTagName("h3")
                .toLeftOf(seleniumIDE));
        System.out.println("Element to the Left of Selenium IDE:    " + relativeSeleniumWebDriver.getText());

        WebElement relativeSeleniumGrid = driver.findElement(withTagName("h3")
                .toRightOf(seleniumIDE));
        System.out.println("Element to the Right of Selenium IDE:   " + relativeSeleniumGrid.getText());
        System.out.println("==============================================================================================");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
