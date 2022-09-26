package PracticeWithSamet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestForNow {


    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://uitestpractice.com/");

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        Selectables selectables = new Selectables(driver);
        selectables.switchBoxes(driver);
    }

}
