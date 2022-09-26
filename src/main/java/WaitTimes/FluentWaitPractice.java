package WaitTimes;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class FluentWaitPractice {

    @Test
    public void practice(){
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove = driver.findElement(By.xpath("//button[.='Remove']"));
       remove.click();
        Wait<WebDriver>fluentWait = new FluentWait<>(driver).pollingEvery(Duration.ofSeconds(1)).withMessage("Text On The Page").withTimeout(Duration.ofSeconds(1));
        WebElement message = fluentWait.until(mydriver->driver.findElement(By.xpath("//p[contains(text(),'gone!')]")));
        Assert.assertEquals(BrowserUtils.getText(message), "It's gone!");
    }
}
