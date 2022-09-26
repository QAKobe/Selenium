package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.DriverHelper;

public class ImplicitWait {

    @Test
    public void practice(){

        //driver.manage.timeouts().implicitWait(Duration.ofSeconds(10))
        //if we use implicit it waits only for elements but might ignore the result
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        WebElement text = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        System.out.println(text.getText().trim());
    }

}
