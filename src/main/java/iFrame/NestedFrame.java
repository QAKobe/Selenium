package iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {

    WebDriver driver;

    @BeforeMethod
    public void SetUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void nestedFramePractice() {

        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement nestedFrame = driver.findElement(By.partialLinkText("Nested"));
        nestedFrame.click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement text = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        softAssert.assertEquals(BrowserUtils.getText(text), "LEFT");
        //Assert.assertTrue(BrowserUtils.getText(text).equals("LEFT"));

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-top"); // instead of 'frame-top' we could use indexing 0
        driver.switchTo().frame("frame-middle"); // instead of 'frame-middle' we could use indexing 1
        WebElement middleText = driver.findElement(By.xpath("//div[@id='content']"));
        Assert.assertTrue(BrowserUtils.getText(middleText).equals("MIDDLE"));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightText = driver.findElement(By.xpath("//body[contains(text(), 'RIGHT')]"));
        softAssert.assertEquals(BrowserUtils.getText(rightText), "RIGHT");
       // Assert.assertTrue(BrowserUtils.getText(rightText).equals("RIGHT"));
//        driver.switchTo().parentFrame(); // top frame
//        driver.switchTo().parentFrame(); // main html
        // we can use the following code instead of parentFrame() all the time.
        driver.switchTo().defaultContent(); // it directly goes to HTML(most useful one)
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        //Assert.assertTrue(BrowserUtils.getText(bottom).equals("BOTTOM"));
        softAssert.assertEquals(BrowserUtils.getText(bottom), "BOTTOM");
        System.out.println("it completed everything");
        softAssert.assertAll();
    }

}
