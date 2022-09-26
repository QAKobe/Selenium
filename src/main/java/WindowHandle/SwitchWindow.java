package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SwitchWindow {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void practice(){
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement text = driver.findElement(By.tagName("h3"));
        String mainPageId = driver.getWindowHandle();
        System.out.println(mainPageId);
        Set<String> allPageIDs = driver.getWindowHandles();
        System.out.println(allPageIDs);
        // this works only for 2 pages!!!!
        for (String id : allPageIDs){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        text = driver.findElement(By.tagName("h3"));
        System.out.println(text.getText().trim());
    }


}
