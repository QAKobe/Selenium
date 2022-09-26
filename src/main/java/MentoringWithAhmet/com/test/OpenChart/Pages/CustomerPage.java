package MentoringWithAhmet.com.test.OpenChart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {

    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addNewButton;

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephone;

    public void customerInfo(String name, String lastName, String email, String telephone){

        addNewButton.click();
        firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.telephone.sendKeys(telephone);

    }


}
