package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class YahooInterviewQuestion {
    public static void main(String[] args) {


        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yahoo.com/");
        WebElement news = driver.findElement(By.id("root_2"));
        news.click();
        List<WebElement> allHeaders = driver.findElements(By.tagName("h3"));
        List<WebElement> allHeaders2 = driver.findElements(By.tagName("h2"));

        for (WebElement header : allHeaders){
            System.out.println(header.getText().trim());
        }
        for (WebElement header:allHeaders2){
            System.out.println(header.getText().trim());
        }









    }
}
