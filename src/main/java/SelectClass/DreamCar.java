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

public class DreamCar {
    @Test
    public void validateCarDotCom() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");
        Select usedOrNew = new Select(driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']")));
        usedOrNew.selectByVisibleText("New & certified cars");
        Select chooseMake = new Select(driver.findElement(By.xpath("//select[@id='makes']")));
        chooseMake.selectByVisibleText("Mercedes-Benz");
        Select chooseModel = new Select(driver.findElement(By.xpath("//select[@id='models']")));
        chooseModel.selectByVisibleText("AMG GLE 63");
        WebElement noMaxPrice = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select noMaxPriceSelect = new Select(noMaxPrice);
        WebElement firstOption = noMaxPriceSelect.getFirstSelectedOption();
        String actualOption = firstOption.getText().trim();
        String expectedOption = "No max price";
        Assert.assertEquals(actualOption, expectedOption);
        Thread.sleep(3000);
        noMaxPrice= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        noMaxPriceSelect = new Select(noMaxPrice);
        firstOption = noMaxPriceSelect.getFirstSelectedOption();
        String actualText = firstOption.getText().trim();
        String expectedText = "No max price";
        Assert.assertEquals(actualText, expectedText);
        Select distance = new Select(driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']")));
        distance.selectByValue("50");
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60656");
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-new-and-cpo-make']"));
        searchButton.click();
        WebElement header = driver.findElement(By.xpath("//h1[contains(text(), 'New and certified' )]"));
        String actualHeaderText = header.getText().trim();
        String expectedHeaderText = "New and certified used Mercedes-Benz AMG GLE 63 for sale";
        Assert.assertEquals(actualHeaderText, expectedHeaderText);
        Select bestMatch = new Select(driver.findElement(By.xpath("//select[@id='sort-dropdown']")));
        bestMatch.selectByVisibleText("Highest price");
        Thread.sleep(3000);
        List<WebElement> allTitles= driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement title : allTitles) {
            Assert.assertTrue(title.getText().contains("Mercedes-Benz"));
        }
        Thread.sleep(2000);
        WebElement clickFirst = driver.findElement(By.xpath("//*[@id=\"vehicle-card-83ee7e6a-3b88-4946-ab0d-1354071e1c37\"]/div/div[2]/a"));
        clickFirst.click();







    }
}
