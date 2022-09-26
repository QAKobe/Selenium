package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAndTag {
    public static void main(String[] args) throws InterruptedException {

        // TagName
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/Kubanych/Downloads/Techtorialhtml.html");
        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion);

        //LinkText--it will look for 'a' tag 'Java' and click it
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println(header.getText());


        // Task:
        /*
        1-go back go main page
        2-you need to click selenium link get  the title
        3-go back to main page and click cucumber and sout header of the page
        4-go back to main page and refresh the page
        6-close the page

         */

        // driver.navigate().back();

        driver.navigate().back();
        WebElement selenium = driver.findElement(By.linkText("Selenium"));
        selenium.click();
        driver.navigate().back();
        Thread.sleep(5000);
        javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        System.out.println(driver.getTitle()); // you can also use tagName for the title
        driver.navigate().back();
        WebElement cucumber = driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        WebElement headerCucumber = driver.findElement(By.tagName("h1"));
        System.out.println(headerCucumber.getText());
        driver.navigate().back();
        driver.navigate().refresh();

        //PartialLinkText
        WebElement restApi = driver.findElement(By.partialLinkText("Api"));
        restApi.click();
        driver.navigate().back();





//        Thread.sleep(5000);
//        driver.close();


    }
}
