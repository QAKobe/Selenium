package AlertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;

public class AlertIntro {

    WebDriver driver;

    @BeforeMethod
    public void SetUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void alertAcceptAndGetText(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(@onclick, 'jsAlert()')]")); // another way to use contains
        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualText, expectedText);
        alert.accept();
        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println("header.getText() = " + header.getText());
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(BrowserUtils.getText(message), "You successfully clicked an alert");
    }

    @Test
    public void PopUpPractice(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();
        Alert alert = driver.switchTo().alert();
        String popUpMessage = alert.getText();
        Assert.assertEquals(popUpMessage, "I am a JS Confirm");
        alert.dismiss();
        WebElement actualMessage = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(BrowserUtils.getText(actualMessage), "You clicked: Cancel");
        WebElement promptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        promptButton.click();
        alert.sendKeys("Techtorial");
        alert.accept();
        WebElement actualMessage2 = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(BrowserUtils.getText(actualMessage2), "You entered: Techtorial");
    }



    @Test
    public void Task(){

        driver.get("https://sweetalert.js.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //also could use //button[contains(@onclick, 'alert')] for the following WebElement 'preview1'
        WebElement preview1 = driver.findElement(By.xpath("//button[@onclick=\"alert('Oops, something went wrong!')\"]"));
        //h5[contains(text(),'Normal Alert')]//..//button[@class='preview'] remember to use such methods too

        preview1.click();
        Alert alert = driver.switchTo().alert();
        String popUpMessage = alert.getText();
        Assert.assertEquals(popUpMessage, "Oops, something went wrong!");
        alert.accept();
        WebElement preview2= driver.findElement(By.xpath("//h5[contains(text(),'SweetAlert')]//..//button[@class='preview']"));
        preview2.click();
        WebElement popUpMessage2 = driver.findElement(By.xpath("//div[contains(text(),'Something went wrong!')]"));
        Assert.assertEquals(BrowserUtils.getText(popUpMessage2), "Something went wrong!");
        WebElement okButton = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
        okButton.click();


    }
}
