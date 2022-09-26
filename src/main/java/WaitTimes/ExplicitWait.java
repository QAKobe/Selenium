package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitWait {

    @Test
    public void practice(){

        // here we use explicit because it allows us to wait until the text/button or anything to show up/load and then get the result
        // if we put less time then it will give timeOut exception.
        //Also learn the methods that are inside
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        WebElement text = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        text = wait.until(ExpectedConditions.visibilityOf(text));
        System.out.println(text.getText().trim());
        Assert.assertEquals(BrowserUtils.getText(text), "Hello World!");
    }

}
