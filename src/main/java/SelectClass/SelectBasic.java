package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectBasic {

    //To be able to use Select Class you need to check the tag name of the element. It should be "Select"

    @Test
    public void practiceSelect() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
        dropDown.click();

        Select s = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        //Get options method
        List<WebElement> allOptions = s.getOptions();// it returns all options from box

        for (WebElement option : allOptions){
            System.out.println(option.getText().trim());
        }

        //GetFirstSelectedOptions
        WebElement firstDefaultOption = s.getFirstSelectedOption();
        String actualDefaultOption = firstDefaultOption.getText().trim();
        String expectedDefaultOption = "Please select an option";
        Assert.assertEquals(actualDefaultOption, expectedDefaultOption);

        //Selecting stuff from dropDown
        Thread.sleep(3000);
        //SelectByValue
        s.selectByValue("2");
        Thread.sleep(5000);

        //SelectByVisibleText
        s.selectByVisibleText("Option 1");
        Thread.sleep(3000);
        //SelectByIndex
        s.selectByIndex(1);
    }


}
