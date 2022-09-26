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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartPageTest extends TestBase {


    @Parameters({"brand", "name", "country", "city", "cc", "mo", "year", "ty"})
    @Test
    public void validatePurchase(String brand, String name, String country, String city, String cc, String mo, String y, String ty) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.goBack(driver);
        mainPage.clickLaptop();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseLaptop(driver, brand);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        Thread.sleep(3000);
        macBookProPage.clickButtonToAdd();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Product added");
        alert.accept();
        macBookProPage.clickCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickPlaceOrderButton();
        cartPage.enterInformation(name, country, city, cc, mo, y);
        Assert.assertEquals(cartPage.validatePurchaseMessage(), ty);
        cartPage.ok();

    }

    @Test(dataProvider = "validationCustomer", dataProviderClass = CustomerDataProvider.class)
    public void validatePurchaseMessage(String brand, String name, String country, String city, String cc, String mo, String y, String ty) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.goBack(driver);
        mainPage.clickLaptop();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseLaptop(driver, brand);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        Thread.sleep(3000);
        macBookProPage.clickButtonToAdd();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Product added");
        alert.accept();
        macBookProPage.clickCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickPlaceOrderButton();
        cartPage.enterInformation(name, country, city, cc, mo, y);
        Assert.assertEquals(cartPage.validatePurchaseMessage(), ty);
        cartPage.ok();

    }
}
