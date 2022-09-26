package ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;
import utils.BrowserUtils;

import java.text.BreakIterator;
import java.time.Duration;
import java.util.*;

public class HoverOver {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void hoverOver() throws InterruptedException {

        driver.navigate().to("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();
        List<WebElement> userNames = driver.findElements(By.tagName("h5"));
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");
        //this section is exactly the same as we did in the code above. So, instead of adding on each line, we just put them elements in one line
        //of code using Arrays.asList();
//        expectedNames.add("name: user1");
//        expectedNames.add("name: user2");
//        expectedNames.add("name: user3");
        Actions actions = new Actions(driver);
        for (int i = 0; i < userNames.size(); i++) {
            Thread.sleep(5000);
            actions.moveToElement(images.get(i)).perform();
            actualNames.add(BrowserUtils.getText(userNames.get(i)));
            System.out.println(BrowserUtils.getText(userNames.get(i)));
        }
        Assert.assertEquals(actualNames, expectedNames);
    }

    @Test
    public void hoverOverPractice() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement closeCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        WebElement closeSurvey = driver.findElement(By.xpath("//div[@class='qual_x_close']"));
        Thread.sleep(2000);
        if (closeCookies.isDisplayed() && closeSurvey.isDisplayed()) {
            closeSurvey.click();
            Thread.sleep(1000);
            closeCookies.click();
        } else if (closeCookies.isDisplayed() || closeSurvey.isDisplayed()) {
            closeSurvey.click();
            Thread.sleep(1000);
            closeCookies.click();
        }

        Actions actions = new Actions(driver);
        List<WebElement> allImages = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        List<String> listOfNames = new ArrayList<>();
        List<Double> listOfPrices = new ArrayList<>();
        Map<String, Double> allNamesAndPrices = new HashMap<>();
        for (int i = 0; i < allImages.size(); i++) {
            actions.moveToElement(allImages.get(i)).perform();
            listOfNames.add(BrowserUtils.getText(allNames.get(i)));
            Thread.sleep(1000);
            listOfPrices.add(Double.parseDouble(BrowserUtils.getText(allPrices.get(i)).substring(1)));//intentionally fail
            allNamesAndPrices.put(listOfNames.get(i), listOfPrices.get(i));
        }
        Collections.sort(listOfNames);
        Collections.sort(listOfPrices);
        System.out.println(listOfPrices);
        System.out.println(listOfNames);
        System.out.println(allNamesAndPrices);

    }


}



