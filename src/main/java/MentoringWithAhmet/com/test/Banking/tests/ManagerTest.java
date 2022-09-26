package MentoringWithAhmet.com.test.Banking.tests;

import MentoringWithAhmet.com.test.Banking.pages.LoginPageBank;
import MentoringWithAhmet.com.test.Banking.pages.ManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ManagerTest {

    @Test
    public void validateBankManager() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        LoginPageBank loginPageBank = new LoginPageBank(driver);
        loginPageBank.clickManagerButton();
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.addingCustomers("Kuba", "Abdy", "60656");
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Customer added successfully with customer id :6");
        alert.accept();
        // Opening Account page
        Thread.sleep(2000);
        managerPage.openAccountButton();
        Thread.sleep(2000);
        managerPage.openAccountSelect(driver);
        Assert.assertEquals(alert.getText(), "Account created successfully with account Number :1016");
        alert.accept();
        managerPage.customersButton();
       Assert.assertTrue(managerPage.getName().contains("Kuba Abdy 60656 1016"));


    }
}
