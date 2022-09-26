package MentoringWithAhmet.com.test.Banking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManagerPage {

    public ManagerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@ng-model='fName']")
    WebElement fNameField;

    @FindBy(xpath = "//input[@ng-model='lName']")
    WebElement lNameField;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement addButton;

    //Open accountButton
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement openAccount;

    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement customers;

    @FindBy(xpath = "//tr[@class='ng-scope'][6]")
    WebElement finalName;
    public void customersButton(){
     customers.click();
    }

    public void openAccountButton(){
        openAccount.click();
    }

    public void addingCustomers(String fNameField, String lNameField, String postCode){
        addCustomerButton.click();
        this.fNameField.sendKeys(fNameField);
        this.lNameField.sendKeys(lNameField);
        this.postCode.sendKeys(postCode);
        addButton.click();
    }

    public void openAccountSelect(WebDriver driver){
        Select select = new Select(driver.findElement(By.xpath("//select[@id='userSelect']")));
        select.selectByVisibleText("Kuba Abdy");
        Select select1 = new Select(driver.findElement(By.xpath("//select[@id='currency']")));
        select1.selectByVisibleText("Dollar");
        processButton.click();

    }

    public String getName(){
        return finalName.getText();
    }








}
