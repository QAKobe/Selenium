package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void multipleTabsPractice() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");
        //String mainId = driver.getWindowHandle();
        //BrowserUtils.switchById(driver, mainId); this one will not work for more than 2 web pages

        BrowserUtils.switchByTitle(driver, "About Us");
        System.out.println(driver.getTitle().trim());
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        System.out.println(driver.getTitle());


    }
}
