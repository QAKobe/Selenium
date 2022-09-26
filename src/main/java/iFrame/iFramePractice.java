package iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class iFramePractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void iFramePractice() {
        //NOTE: iFRAME will give no such element exception if it fails
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        System.out.println(header.getText());
        driver.switchTo().frame("mce_0_ifr");
        WebElement message = driver.findElement(By.tagName("p"));
        message.clear();
        message.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        WebElement selenium = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        selenium.click();
    }

    @Test
    public void task1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://skpatro.github.io/demo/iframes/");
        WebElement pavilionButton = driver.findElement(By.xpath("//a[@href='http://qavalidation.com/']"));
        pavilionButton.click();
        BrowserUtils.switchByTitle(driver, "Home - qavalidation"); // //*[@id="primary-menu"]/li[2]/a/span/span/text()
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        WebElement selenium = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']//span")); // remember this one
        actions.moveToElement(selenium).perform();
        WebElement seleniumJava = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']//span"));
        actions.moveToElement(selenium).click(seleniumJava).perform();
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Tutorial')]"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualHeader, expectedHeader);
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "iframes");

        //switching into iFrame
        driver.switchTo().frame("Frame1");
        WebElement category1 = driver.findElement(By.linkText("Category1"));
        category1.click();
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "SeleniumTesting Archives - qavalidation");
        WebElement headerFromCategory1 = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(headerFromCategory1), "Category Archives: SeleniumTesting");
        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3 = driver.findElement(By.linkText("Category3"));
        category3.click();
        driver.switchTo().parentFrame();
        BrowserUtils.switchByTitle(driver, "SoftwareTesting Archives - qavalidation");
        WebElement headerForC3 = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(headerForC3), "Category Archives: SoftwareTesting");


    }


}
