package testseleniumnewfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class RelativeTests {

    @Test
    public void test_Relative() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.swtestacademy.com");

        WebElement logo = driver.findElement(withTagName("article").toRightOf(By.id("blog-1-post-8383")));
        System.out.println(logo.findElement(By.cssSelector(".entry-title")).getText());


        logo = driver.findElement(withTagName("article").below(By.id("blog-1-post-8405")));
        System.out.println(logo.findElement(By.cssSelector(".entry-title")).getText());
    }

}
