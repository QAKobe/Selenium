package ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;
import utils.BrowserUtils;

public class ClickAndHold {

    @Test
    public void clickAndHoldMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(5000);
        WebElement closeCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
        actions.click(closeCookies).perform();
        actions.scrollByAmount(400, 400);
        Thread.sleep(2000);
        WebElement closeSurvey = driver.findElement(By.xpath("//div[contains(text(),'Not now')]"));
        closeSurvey.click();
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage = BrowserUtils.getText(blueBox);
        String expectedMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualMessage, expectedMessage);
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        actions.clickAndHold(drag).moveToElement(blueBox).release().perform();
        Thread.sleep(2000);
        String actualMessageAfter = BrowserUtils.getText(blueBox);
        String expectedMessageAfter = "You did great!";
        Assert.assertEquals(actualMessageAfter, expectedMessageAfter);

        String actualColor = blueBox.getCssValue("background-color");
        String expectedColor = "";
        Assert.assertEquals(actualColor, expectedColor);





    }

    @Test
    public void task() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropPlace = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        WebElement actualMessage = driver.findElement(By.xpath("//p[contains(text(), 'Drop here')]"));
        String actualMessage1 = actualMessage.getText();
        String expectedMessage1 = "Drop here";
        Assert.assertEquals(actualMessage1, expectedMessage1);
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, dropPlace).perform();
        WebElement actualDroppedMessage = driver.findElement(By.xpath("//p[contains(text(), 'Dropped!')]"));
        String actualMessageAfterDropped = BrowserUtils.getText(actualDroppedMessage);
        String expectedMessageAfterDrop = "Dropped!";
        Assert.assertEquals(actualMessageAfterDropped,expectedMessageAfterDrop);
        Thread.sleep(2000);

        String actualColor = dropPlace.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor, expectedColor);

    }

    @Test
    public void clickAndHoldPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement accept = driver.findElement(By.xpath("//a[contains(text(),'Accept')]"));
        accept.click();
        Thread.sleep(2000);
        WebElement dropHereMessage = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']"));
        String actualMessage = BrowserUtils.getText(dropHereMessage).trim();
        String expectedMessage = "Drop here";
        Assert.assertEquals(actualMessage, expectedMessage);
        WebElement drag = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        WebElement dropHere = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveToElement(dropHere).release().perform();
        dropHereMessage =  driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']"));
        String actualMessageAfterDrop = BrowserUtils.getText(dropHereMessage).trim();
        String expectedMessageAfterDropped = "Drop here";
        Assert.assertEquals(actualMessageAfterDrop, expectedMessageAfterDropped);
        WebElement acceptableDrag = driver.findElement(By.xpath("//div[@id='acceptable']"));
        WebElement acceptableDrop = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        actions.clickAndHold(acceptableDrag).moveToElement(acceptableDrop).release().perform();
        String actualMessageAfterDrop2 = BrowserUtils.getText(dropHereMessage).trim();
        String expectedMessageAfterDropped2 = "Dropped!";
        Assert.assertEquals(actualMessageAfterDrop2, expectedMessageAfterDropped2);

    }

}
