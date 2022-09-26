package ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.text.BreakIterator;
import java.time.Duration;

public class PointClass {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void pointClassScrollDown() throws InterruptedException {
        driver.navigate().to("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement information = driver.findElement(By.xpath("//h2[.='information']"));
        // BrowserUtils.scrollViewWithJS(driver, information);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Point point = information.getLocation();
//        int xCoordinate = point.getX();
//        int yCoordinate = point.getY();
//        System.out.println(xCoordinate);
//        System.out.println(yCoordinate);
//        js.executeScript("window.scrollTo(" + xCoordinate + "," + yCoordinate + ")");
        BrowserUtils.scrollWithPoint(driver, information);
    }
}
