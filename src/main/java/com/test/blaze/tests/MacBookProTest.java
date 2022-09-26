package com.test.blaze.tests;

import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import com.test.blaze.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;

//public class MacBookProTest {
//
//    WebDriver driver;
//
//    @BeforeMethod
//    public void SetUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/#");
//    }
//
//    @Test
//    public void validateProduct() throws InterruptedException {
//
//        MainPage mainPage = new MainPage(driver);
//        mainPage.clickLaptop();
//        LaptopPage laptopPage = new LaptopPage(driver);
//        laptopPage.chooseLaptop(driver, "MacBook Pro");
//        MacBookProPage macBookProPage = new MacBookProPage(driver);
//        Assert.assertEquals(macBookProPage.validationProductName(), "MacBook Pro");
//        Assert.assertEquals(macBookProPage.validationPrice(), "$1100 *includes tax");
//        Assert.assertEquals(macBookProPage.validationMoreInfo(), "Product description\n" +
//                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
//        macBookProPage.clickButton();
//        Thread.sleep(3000);
//        Alert alert = driver.switchTo().alert();
//        Assert.assertEquals(alert.getText(), "Product added");
//        alert.accept();
//        macBookProPage.clickCart();
//
//    }
//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(5000);
//        driver.quit();
//    }
//
//}
public class MacBookProTest extends TestBase{

    @Test
    public void validatingMacbookPage() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptop();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseLaptop(driver, "MacBook Pro");
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.clickButtonToAdd();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String popUpMess = alert.getText();
        Assert.assertEquals(popUpMess.trim(), "Product added");
        alert.accept();
        macBookProPage.clickCart();






    }








}










