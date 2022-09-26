package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement horizontal = driver.findElement(By.linkText("Horizontal Slider"));
        horizontal.click();
        WebElement horizontal2 = driver.findElement(By.tagName("h3"));
        System.out.println(horizontal2.getText());
        Thread.sleep(3000);
        WebElement text = driver.findElement(By.tagName("h4"));
        System.out.println(text.getText());
        WebElement element = driver.findElement(By.linkText("Elemental Selenium"));
        element.click();


        if (driver.getCurrentUrl().equals("http://elementalselenium.com/")){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        Thread.sleep(3000);
        driver.quit(); // it closes all the pages that open druing automation






    }
}
