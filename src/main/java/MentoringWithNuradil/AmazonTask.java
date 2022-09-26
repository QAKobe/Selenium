package MentoringWithNuradil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class AmazonTask {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void purchase() {

        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement inputField = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        inputField.sendKeys("iphone 13 pro max case", Keys.ENTER);
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        listOfProducts.get(0).click();

        double actualTotal = 0;
        WebElement price1 = driver.findElement(By.xpath("//div[@id='newAccordionCaption_feature_div']//..//span[@class='a-offscreen']"));
        System.out.println(price1.getText().trim());
//        actualTotal += Double.parseDouble(BrowserUtils.getText(price1).replace("$", ""));
//        System.out.println(actualTotal);


    }

}
