package ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class DragAndDrop {

    //Drag and Drop
    @Test
    public void dragAndDropPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(5000);
        WebElement closeCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
        actions.click(closeCookies).perform();
        actions.scrollByAmount(300, 300);
        Thread.sleep(2000);
        WebElement closeSurvey = driver.findElement(By.xpath("//div[contains(text(),'Not now')]"));
        closeSurvey.click();
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@class='test2']"));

        String actualMessage = BrowserUtils.getText(drop);
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage, expectedMessage);
        actions.dragAndDrop(drag, drop).perform();
        Thread.sleep(3000);
        drop = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualAfterDrop = BrowserUtils.getText(drop); // fixing stale exception
        System.out.println(actualAfterDrop);
        actions.scrollByAmount(100,100);
        String expectedAfterDrop = "You did great!";
        Assert.assertEquals(actualAfterDrop, expectedAfterDrop);

        // Test passed after multiple attempts, but before that it failed looks like due to page not scrolling down


    }


}
