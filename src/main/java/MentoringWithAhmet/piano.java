package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class piano {
    @Test
    public void pianoMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.musicca.com/piano");
        List<WebElement>keys = driver.findElements(By.xpath("//span[@data-note]"));

        List<String> music = Arrays.asList("2c", "2c", "2g","2g", "3a", "3a", "2g","2g", "2f", "2f", "2e", "2e", "2d", "2d", "2c");
        Map<String, WebElement> keyBoard = new HashMap<>();

        for (WebElement key : keys){
            keyBoard.put( key.getAttribute("data-note"), key);
        }

        for (String notes : music){
            WebElement key = keyBoard.get(notes);
            key.click();
            Thread.sleep(800);
        }



    }
}
