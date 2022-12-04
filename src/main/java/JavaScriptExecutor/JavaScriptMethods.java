package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.nashorn.internal.scripts.JS;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class JavaScriptMethods {
    /*
    NOTE: JS is really efficient once your normal Selenium methods are not working as expected
    NOTE: JS should be your last option to use, since your main language is Java and using JS too much will not
    make you look professional in real job.
     */

//    WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }

    //Get title method from JS
    @Test
    public void GetTitle() {
//        driver.get("https://www.techtorialacademy.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        System.out.println("Get title with 'Driver' " + driver.getTitle());

        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        //We are casting into JSExecutor. Meaning telling our driver to work as JSExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println("Get title with 'JS' " + title);
    }

    @Test
    public void clickJS() {

//        driver.get("https://www.techtorialacademy.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement studentLogin = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", studentLogin);

    }

    //This is the most common interview technical and verbal question.******************
    @Test
    public void scrollIntoView() {
//        driver.get("https://www.techtorialacademy.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyRight = driver.findElement(By.xpath("//p[.='© Copyrights 2022 Techtorial - All Rights Reserved']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", copyRight);
    }

    @Test
    public void scrollIntoViewTask() {
//        driver.get("https://www.techtorialacademy.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement browseCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", browseCourse);
        js.executeScript("arguments[0].click()", browseCourse);
        String title = js.executeScript("return document.title").toString();
        System.out.println("Get title with 'JS' " + title);
        WebElement info = driver.findElement(By.xpath("//h2[.='information']"));
        js.executeScript("arguments[0].scrollIntoView(true)", info);

    }

    @Test
    public void JSShortCut() {
//        driver.get("https://www.techtorialacademy.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement browseCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
        BrowserUtils.scrollViewWithJS(driver, browseCourse);
        BrowserUtils.clickWithJS(driver, browseCourse);
        WebElement info = driver.findElement(By.xpath("//h2[.='information']"));
        BrowserUtils.scrollViewWithJS(driver, info);
        String str = BrowserUtils.getTitleWithJS(driver);
        Assert.assertEquals(str, "Programs - Techtorial");
        WebElement studentLogin = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        BrowserUtils.scrollViewWithJS(driver, studentLogin);
    }

    @Test
    public void task() throws InterruptedException {
//        driver.get("https://www.techtorialacademy.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement browser = driver.findElement(By.xpath("//a[.='Browse Course']"));
        BrowserUtils.scrollViewWithJS(driver, browser);
        BrowserUtils.clickWithJS(driver, browser);
        WebElement getStartedSDET = driver.findElement(By.xpath("//h4[.='SDET Course']//..//a[.='Get Started']"));//remember this one!!!!!!!
        BrowserUtils.scrollViewWithJS(driver, getStartedSDET);
        BrowserUtils.clickWithJS(driver, getStartedSDET);
        String actualTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle = "Apply To Techtorial - Techtorial";
        Assert.assertEquals(actualTitle, expectedTitle);

    }


}
