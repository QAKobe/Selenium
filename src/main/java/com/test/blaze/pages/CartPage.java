package com.test.blaze.pages;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CartPage {

    public CartPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@id='country']")
    WebElement countryField;

    @FindBy(xpath = "//input[@id='city']")
    WebElement cityField;

    @FindBy(xpath = "//input[@id='card']")
    WebElement cardField;

    @FindBy(xpath = "//input[@id='month']")
    WebElement month;

    @FindBy(xpath = "//input[@id='year']")
    WebElement year;

    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    WebElement verification;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }

    public void enterInformation(String fNameLName, String country, String city, String card, String month, String year){

        nameField.sendKeys(fNameLName);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(card);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        purchaseButton.click();

    }
                                            // if you validate more than 1 element, then do assertion under page class same method.
    public String validatePurchaseMessage(){// if you validate only 1 thing, then do assertion under test class

        return BrowserUtils.getText(verification);
    }

    public void ok(){
        okButton.click();
    }




}
