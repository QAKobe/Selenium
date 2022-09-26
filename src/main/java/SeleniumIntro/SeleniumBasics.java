package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Kubanych/OneDrive/Documents/Techtorial/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        driver.navigate().to("https://techtorialacademy.com");
        driver.manage().window().minimize();

        driver.get("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle()); // getTitle method gives you the title of page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page - Techtorial";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Passed");

        }else {
            System.out.println("Failed");
        }

        //driver.getCurrentUrl--> it gives you the url of the page.
        //Ctrl+alt+L to organize the code
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.techtorialacademy.com/";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        driver.close();










    }
}
