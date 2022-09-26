package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocators {
    public static void main(String[] args) {

        //Xpath is the boss of locator
        //Absolute XPATH:
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement abTesting = driver.findElement(By.linkText("A/B Testing"));
        abTesting.click();
        WebElement paragraph = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        String str = paragraph.getText();
        System.out.println(str);

        WebElement selenium = driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']"));
        selenium.click();


    }
}
