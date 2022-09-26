package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestNGPractice {

    @Test
    public void validateTitleAndUrl() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        String url = driver.getTitle().trim();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(url, expectedTitle);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demo.opencart.com/admin/";
        Assert.assertEquals(actualUrl.contains(expectedUrl), true);

    }

    @Test
    public void validateProductOption() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(2000);
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(product.isDisplayed());


    }

    @Test
    public void validateBoxes() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));


        for (int i = 1; i < checkBoxes.size(); i++) {
            Assert.assertTrue(checkBoxes.get(i).isDisplayed());
            Thread.sleep(200);
            checkBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            checkBoxes.get(i).click();
            checkBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }

    }

    @Test
    public void validateIsProductAscendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();

        List<WebElement> productNames = driver.findElements(By.xpath("//tr//td[3]")); // indexing--> suggested for tables
        List<String> actualBrands = new ArrayList<>();
        List<String> expectedBrands = new ArrayList<>();

        for (int i = 1; i < productNames.size(); i++) {
            actualBrands.add(productNames.get(i).getText().trim());
            expectedBrands.add(productNames.get(i).getText().trim());
            Collections.sort(expectedBrands);
            Assert.assertEquals(actualBrands, expectedBrands);
        }
        System.out.println(actualBrands);
        System.out.println(expectedBrands);


    }

    @Test
    public void validateDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();

        WebElement productNameButton = driver.findElement(By.xpath("//a[contains(text(), 'Product Name')]"));
        productNameButton.click();
        Thread.sleep(2000);
        List<WebElement> productNames = driver.findElements(By.xpath("//tr/td[3]")); // indexing--> suggested for tables
        List<String> actualBrands = new ArrayList<>();
        List<String> expectedBrands = new ArrayList<>();

        //Whenever you need to do comparison for 2 list with String value. It goes to ASCII TABLE. It means,
        //it is suggested to use either toLowerCase, or UpperCase at the end of GetText().
        for (int i = 1; i < productNames.size(); i++) {
            actualBrands.add(productNames.get(i).getText().toUpperCase().trim());
            expectedBrands.add(productNames.get(i).getText().toUpperCase().trim());
            Collections.sort(expectedBrands);
            Thread.sleep(300);
            Collections.reverse(expectedBrands);
            Assert.assertEquals(actualBrands, expectedBrands);
        }
        System.out.println(actualBrands);
        System.out.println(expectedBrands);


    }


}
