package MentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //TASK1
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");

        WebElement seleniumTestPage = driver.findElement(By.xpath("//h1[@class='title']"));
        System.out.println(seleniumTestPage.getText());

        WebElement paragraph = driver.findElement(By.xpath("//strong[contains(text(), 'test')]"));
        System.out.println(paragraph.getText());

        WebElement seleniumBox = driver.findElement(By.id("seleniumbox"));


        if (seleniumBox.isDisplayed()&&!seleniumBox.isSelected()) {
            seleniumBox.click();
            System.out.println("Selenium Box is checked now");
        }else {
            System.out.println("Selenium is already checked");
        }

        WebElement radioButton = driver.findElement(By.xpath("//input[@id='java1']"));
        radioButton.click();

        WebElement save = driver.findElement(By.xpath("//button[@type='button']"));
        save.click();

       /*
TASK 2:HyperLink Task:
1-Click the Test Dairy link with linktext
2-print out the header,title and currentUrl of Test Dairy from opening page
3-Navigate back to main page
4-Click Test Diary Selenium learning with PartialLinkText
5-print out the header,title and currentUrl of Test Dairy from opening page
 */

        WebElement testDiary = driver.findElement(By.linkText("Test Diary"));
        testDiary.click();
        System.out.println(driver.getTitle().trim());

        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println(header.getText().trim());
        System.out.println(driver.getCurrentUrl().trim());
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement tDSeleniumLearning = driver.findElement(By.partialLinkText("Learning"));
        tDSeleniumLearning.click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());
        driver.navigate().back();

        //Task3
        WebElement firstName = driver.findElement(By.xpath("//input[@name='your-name']"));
        firstName.sendKeys("Kuba");

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("kubanin@yahoo.com");

        WebElement object1 = driver.findElement(By.xpath("//input[@name='your-subject']"));
        object1.sendKeys("Selenium Research");

        WebElement message = driver.findElement(By.xpath("//textarea[@name='your-message']"));
        message.sendKeys("Dear sir/Madam, I would like to get more information about Selenium");

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();

        WebElement result = driver.findElement(By.xpath("//div[contains(text(), 'sent')]"));

        if (result.isDisplayed()){
            System.out.println("data went through");
        }else {
            System.out.println("data did not go through");
        }




    }
}
