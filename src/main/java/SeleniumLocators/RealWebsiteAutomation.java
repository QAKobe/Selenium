package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RealWebsiteAutomation {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul
5-Click apply for hospital admission box
6-Healhcare program 'Medicaid'
7-Visit date should be provided
8-Put your command for this box
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Print out the headers and values(only values) on your console.
11)Click go to homepage and print out url
12)Driver.quit or close.

 */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com");
        WebElement appointment = driver.findElement(By.xpath("//a[@class='btn btn-dark btn-lg']"));
        appointment.click();
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Select select = new Select(driver.findElement(By.id("combo_facility")));
        select.selectByVisibleText("Hongkong CURA Healthcare Center");
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        WebElement medicare = driver.findElement(By.xpath("//input[@value='Medicaid']"));
        medicare.click();
        WebElement table = driver.findElement(By.xpath("//input[@name='visit_date']"));
        table.sendKeys("15/04/2022");
        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("Please book me hotel in Honkong and it should be 5 stars Penninsula or something like that");
        Thread.sleep(3000);
        WebElement book = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        book.click();
        WebElement values = driver.findElement(By.xpath("//h1[contains(text(),'CURA Healthcare Service')]"));
        System.out.println(values.getText());
        WebElement values2 = driver.findElement(By.xpath("//h3[contains(text(),'We Care About Your Health')]"));
        System.out.println(values2.getText());
        Thread.sleep(3000);
        WebElement validateConfirmation = driver.findElement(By.tagName("h2"));
        System.out.println(validateConfirmation.getText());
        WebElement validateFacility = driver.findElement(By.xpath("//label[@for='facility']"));
        WebElement validateHospital = driver.findElement(By.xpath("//p[@id='facility']"));
        System.out.println(validateFacility.getText() + " = " + validateHospital.getText());
        WebElement validateApply = driver.findElement(By.xpath("//label[contains(text(), 'Apply')]"));
        WebElement validateNo = driver.findElement(By.xpath("//p[@id ='hospital_readmission']"));
        System.out.println(validateApply.getText() + " -- " + validateNo.getText());
        WebElement validateHealthCare = driver.findElement(By.xpath("//label[contains(text(), 'Healthcare')]"));
        WebElement validateMedicare = driver.findElement(By.xpath("//p[contains(text(), 'Medicaid')]"));
        System.out.println(validateHealthCare.getText() + "--" + validateMedicare.getText());
        WebElement validateVisit = driver.findElement(By.xpath("//label[contains(text(), 'Visit Date')]"));
        WebElement validateDate = driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(validateVisit.getText() + "--" + validateDate.getText());
        WebElement comment1 = driver.findElement(By.xpath("//label[contains(text(), 'Comment')]"));
        WebElement textMessage = driver.findElement(By.xpath("//p[contains(text(), 'like that')]"));
        System.out.println(comment1.getText() + "--" + textMessage.getText());
        WebElement homePage = driver.findElement(By.xpath("//a[@href='https://katalon-demo-cura.herokuapp.com/']"));
        homePage.click();
        Thread.sleep(3000);
        driver.close();


    }
}
