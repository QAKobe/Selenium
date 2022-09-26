package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate.to--> navigates to website without waiting for all elements from page.
        //get--> will get website but waits for elements to be loaded.(little slow though)
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000); // it will wait for 3 seconds on the page
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        System.out.println(driver.getPageSource());// this is the method that you access html of page








    }
}
