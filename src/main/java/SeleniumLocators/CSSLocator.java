package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;

public class CSSLocator {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void cssLocatorIDPractice(){

        driver.get("https://www.etsy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement searchBar = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBar.sendKeys("Seiko", Keys.ENTER);
    }

    @Test
    public void cssLocatorClassPractice(){

        driver.navigate().to("file:///C:/Users/Kubanych/Downloads/Techtorialhtml.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement allTools = driver.findElement(By.cssSelector(".group_checkbox"));
        System.out.println(BrowserUtils.getText(allTools));
    }

}
