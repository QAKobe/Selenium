package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) {

        /*
        Task1
        check if all the links work properly
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> elements = driver.findElements(By.tagName("li"));

        for (WebElement things : elements) {
            System.out.println(things.getText());

        }
        int count = 0;
        for (WebElement nums : elements){
            if (nums.getText().trim().length()<12){
                System.out.println(nums.getText().trim());

                count++;
            }
        }
        System.out.println( count);







    }
}
