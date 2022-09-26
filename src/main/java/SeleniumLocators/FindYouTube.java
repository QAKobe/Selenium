package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindYouTube {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");

        WebElement song = driver.findElement(By.xpath("//input[@id='search']"));
        song.sendKeys("Linkin Park");
        WebElement search = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        Thread.sleep(2000);
        search.click();
        Thread.sleep(2000);



        List<WebElement> mySong = driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement songs:mySong){
            if (songs.getAttribute("title").equals("In The End [Official HD Music Video] - Linkin Park")){
                songs.click();
            }
        }



    }
}
