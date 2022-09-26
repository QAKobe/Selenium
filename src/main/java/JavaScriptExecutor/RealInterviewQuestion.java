package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class RealInterviewQuestion {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void task(){
        driver.get("https://www.thespruceeats.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement scroll = driver.findElement(By.xpath("//a[.='Warm-Weather Treats']"));
        BrowserUtils.scrollViewWithJS(driver, scroll);
        WebElement videoPlay = driver.findElement(By.xpath("//div[@class='jw-display-icon-container jw-display-icon-display jw-reset']//div[@role='button']"));
        videoPlay.click();


    }
}
