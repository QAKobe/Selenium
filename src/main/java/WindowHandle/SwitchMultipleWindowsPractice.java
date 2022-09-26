package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SwitchMultipleWindowsPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void task1() throws InterruptedException {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement multipleButton = driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
        BrowserUtils.scrollWithPoint(driver, multipleButton);
        multipleButton.click();
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Basic Controls - H Y R Tutorials");
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstNameField.sendKeys("Kuba");
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastNameField.sendKeys("Abdy");
        WebElement languageField = driver.findElement(By.xpath("//input[@id='englishchbx']"));
        BrowserUtils.scrollWithPoint(driver, languageField);
        languageField.click();
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
        emailField.sendKeys("kubanin@yahoo.com");
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("12345");
        WebElement registerButton = driver.findElement(By.xpath("//button[@id='registerbtn']"));
        BrowserUtils.scrollWithPoint(driver, registerButton);
        Thread.sleep(2000);
        BrowserUtils.scrollWithPoint(driver, registerButton);
        registerButton.click();
        WebElement message = driver.findElement(By.xpath("//label[@id='msg']"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "Registration is Successful";
        Assert.assertEquals(actualMessage, expectedMessage);
        BrowserUtils.switchByTitle(driver, "AlertsDemo - H Y R Tutorials");
        Thread.sleep(2000);
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickMe.click();
        driver.quit();
        //if click not working due to scroll(when regular scroll can't help), go with JS click option.
        // It will go through the html codes and click no matter what
    }
}
