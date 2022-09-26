package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DriverHelper;

import java.time.Duration;

public class LoginTest{

    @Test
    public void validatePositiveLogin(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM01", "sentrifugo");
        Assert.assertEquals(driver.getCurrentUrl(), "http://demo.sentrifugo.com/index.php/index/welcome");
    }

    @Test
    public void validateNegativeLogin1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        Assert.assertEquals(loginPage.usernameErrorMessage(), "Please enter username or email.");
        Assert.assertEquals(loginPage.passwordErrorMessage(), "Please enter password.");
        Assert.assertEquals(loginPage.usernameErrorColor(), "rgba(255, 0, 0, 1)");
        Assert.assertEquals(loginPage.passwordErrorColor(), "rgba(255, 0, 0, 1)");

    }


    @Test(dataProvider = "userNames", dataProviderClass = LoginTestDataProvider.class)
    public void validationOfLogin(String username, String password){

        WebDriver driver = DriverHelper.getDriver();
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertTrue(driver.getCurrentUrl().contains("welcome")); // you are testing
        driver.quit();
    }

    // This one is used if we extend to LoginTestDataProvider
//    @Test(dataProvider = "userNames")
//    public void validationOfLoginExtension(String username, String password){
//
//        WebDriver driver = DriverHelper.getDriver();
//        driver.get("http://demo.sentrifugo.com/index.php/");
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login(username, password);
//        Assert.assertTrue(driver.getCurrentUrl().contains("welcome")); // you are testing
//        driver.quit();
//    }


}
