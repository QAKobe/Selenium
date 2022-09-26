package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class PracticeSelectAndLocators {

    @Test
    public void validateTests(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Kuan");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Abdy");

        WebElement gender = driver.findElement(By.xpath("//input[@id='sex-0']"));
        gender.click();

        WebElement yearOfExperience = driver.findElement(By.xpath("//input[@id='exp-6']"));
        yearOfExperience.click();

        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.sendKeys("09/21/2022");

        WebElement professionType = driver.findElement(By.xpath("//input[@id='profession-1']"));
        professionType.click();

        WebElement tool = driver.findElement(By.xpath("//input[@id='tool-2']"));
        tool.click();

        WebElement continents = driver.findElement(By.id("continents"));
        BrowserUtils.selectBy(continents, "North America", "text");


        WebElement commands = driver.findElement(By.id("selenium_commands"));
        BrowserUtils.selectBy(commands, "Browser Commands", "text");
        BrowserUtils.selectBy(commands, "Switch Commands", "text");
        WebElement submitButton=driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();



    }

    @Test
    public void createAccount(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Kuan");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Abdy");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("kuan@yahoo.com");

        WebElement telephone = driver.findElement(By.xpath("//input[@name='telephone']"));
        telephone.sendKeys("432432432");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("abdyvasiev");

        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@name='confirm']"));
        passwordConfirm.sendKeys("abdyvasiev");

        WebElement newsLetter = driver.findElement(By.xpath("//label[@class='radio-inline']//input[@value='1']"));
        newsLetter.click();

        WebElement agree = driver.findElement(By.xpath("//input[@name='agree']"));
        agree.click();

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();

        WebElement message = driver.findElement(By.xpath("//div[@id='content']//h1"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals(actualMessage, expectedMessage);




    }


    }

