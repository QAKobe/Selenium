package PracticeWithSamet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {

    @Test
    public void dragAndDrop() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://webdriveruniversity.com/Actions/index.html");
        WebElement dragMeButton = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropMePlace = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeButton, dropMePlace).perform();
        WebElement actualMessage = driver.findElement(By.xpath("//b[contains(text(),'Dropped!')]"));
        Thread.sleep(2000);
        String actualMessage1 = actualMessage.getText();
        String expectedMessage = "Dropped!";
        Assert.assertEquals(actualMessage1, expectedMessage);



    }
}
