package ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class MoveByOffSet {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void moveByOffSet() throws InterruptedException {

        // this code moves/slides the bar forward with Actions class
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        actions.clickAndHold(slider).moveByOffset(30, 0).perform();
        Thread.sleep(3000);
        actions.clickAndHold(slider).moveByOffset(-10, 0).perform();
    }

    @Test
    public void moveOffSetWithPointClass() throws InterruptedException {
        //This whole section of codes do not work, See PointClass in ActionsClass Package for solution
        driver.navigate().to("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement contactUs = driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[.='Contact Us']"));
        WebElement copyRight = driver.findElement(By.xpath("//p[contains(text(), '© Copyrights 2022 Techtorial - All Rights Reserved')]"));
        Point point = copyRight.getLocation();
        int xCoordinate = point.getX();
        int yCoordinate = point.getY();
        System.out.println(xCoordinate);
        System.out.println(yCoordinate);
        actions.moveByOffset(xCoordinate, yCoordinate);
    }

    @Test
    public void sliderShortCut() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement range = driver.findElement(By.id("range"));
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        String rangeNumber = "4";
        while (!BrowserUtils.getText(range).equals(rangeNumber)){
            Thread.sleep(1000);
           slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Assert.assertEquals(BrowserUtils.getText(range), rangeNumber);



    }


}
