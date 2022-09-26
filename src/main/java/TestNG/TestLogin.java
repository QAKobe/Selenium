package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestLogin {

    @Test
    public void testing() throws NoSuchFieldException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        WebElement userNameField = driver.findElement(By.xpath("//input[@id='email']"));
        userNameField.sendKeys("sdasdasdad");
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='pass']"));
        passwordField.sendKeys("ereweqwq");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'incorrect')]"));

        if (!errorMessage.isDisplayed()){
            throw new NoSuchFieldException();
        }


    }
}
