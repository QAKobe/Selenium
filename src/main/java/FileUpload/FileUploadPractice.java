package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void task() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
        Thread.sleep(2000);
        chooseFile.sendKeys("C:\\Users\\Kubanych\\OneDrive\\Desktop\\usa.png");
        WebElement uploadBtn = driver.findElement(By.id("file-submit"));
        uploadBtn.click();
        WebElement successMessage = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(BrowserUtils.getText(successMessage), "File Uploaded!");

    }

}
