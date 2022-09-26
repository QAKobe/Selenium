package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTestCaseExample {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Kubanych/OneDrive/Documents/Techtorial/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().minimize();
        driver.get("https://www.Godaddy.com/");

        String actualTitle = driver.getTitle();
        String expTitle = "Domain Names, Websites, Hosting & Online Marketing Tools GoDaddy";

        if (actualTitle.equals(expTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.godaddy.com/";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        System.out.println(driver.getTitle());









    }
}
