package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.text.BreakIterator;
import java.time.Duration;
import java.util.Set;

public class SwitchWindowPractice {
    /*
TASK:
  1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
  2-Click Open New Tab under Button2
  3-Get the title of the newTab and validate"
  4-Get the header of the newTab and validate "AlertsDemo"
  5-Close the newTab
  6-Validate the Header of MainPage(which you navigated first) with "Window Handles Practice"
 */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void practice() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement openNewTabButton = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        BrowserUtils.scrollWithPoint(driver, openNewTabButton);
        openNewTabButton.click();
        String mainPageId = driver.getWindowHandle();
        System.out.println(mainPageId);
//        Set<String> allPageIDs = driver.getWindowHandles();
//        System.out.println(allPageIDs);
//        // this works only for 2 pages!!!!
//        for (String id : allPageIDs) {
//            if (!id.equals(mainPageId)) {
//                driver.switchTo().window(id);
//            }
//        }
        BrowserUtils.switchById(driver, mainPageId);
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "AlertsDemo - H Y R Tutorials";

        WebElement header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "AlertsDemo";
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualHeader, expectedHeader);
        driver.quit();
    }
}
