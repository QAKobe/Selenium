package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Kubanych/Downloads/Techtorialhtml.html");

        //ID Locator

        WebElement header = driver.findElement(By.id("techtorial1")); // it will find the elements with
        String actualHeader = header.getText(); // getText method-> gets the text and return String
        String expectedHeader = "Techtorial Academy";
        if (actualHeader.equals(expectedHeader)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        WebElement paragraph = driver.findElement(By.id("details2")); // we found with by id
        System.out.println(paragraph.getText());


        //Name locator
        WebElement firstNameBox = driver.findElement(By.name("firstName"));
        System.out.println(firstNameBox);
        firstNameBox.sendKeys("Kuba");// sendKeys method sends data that you want.

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Abdy");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("1234354");

        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("@techtorial");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("Chitown");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Chicago");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("Illinois");

        WebElement zipCode = driver.findElement(By.name("postalCode"));
        zipCode.sendKeys("60656");

        WebElement country = driver.findElement(By.name("country"));
        country.click();
        Select s = new Select(driver.findElement(By.name("country")));
        s.selectByVisibleText("KYRGYZSTAN ");


        //Class Locator

        WebElement allTool = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTool.getText());

        //isDisplayed and isSelected Method?
        WebElement javaBox = driver.findElement(By.id("cond1")); // i have box now
        System.out.println(javaBox.isDisplayed());// true

        if (javaBox.isDisplayed()) {
            javaBox.click();
            System.out.println(javaBox.isSelected()); // true
        } else {
            System.out.println("box is not there");
        }

        WebElement javaBoxTestNg = driver.findElement(By.id("cond3"));
        System.out.println(javaBoxTestNg.isDisplayed());
        if (javaBoxTestNg.isDisplayed()){
            javaBoxTestNg.click();
            System.out.println(javaBoxTestNg.isSelected());
        }else {
            System.out.println("Not there");
        }

        WebElement cucumber = driver.findElement(By.id("cond4"));
        System.out.println(cucumber.isDisplayed());
        if (cucumber.isDisplayed()){
            cucumber.click();
            System.out.println(cucumber.isSelected());
        }


        Thread.sleep(3000);
        driver.close();

    }
}
