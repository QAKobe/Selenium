package com.test.blaze.pages;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sun.security.krb5.internal.PAData;
import utils.BrowserUtils;


public class MacBookProPage {

    public MacBookProPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2")
    WebElement nameOfBrand;

    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement price;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement description;

    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addCartButton;

    @FindBy(xpath = "//a[@id='cartur']")
    WebElement cart;

    public String validationProductName(){
       return BrowserUtils.getText(nameOfBrand);
    }

    public String validationPrice(){
        return BrowserUtils.getText(price);
    }

    public String validationMoreInfo(){
        return BrowserUtils.getText(description);
    }

    public void clickButtonToAdd(){

        addCartButton.click();
    }

    public void clickCart(){
        cart.click();
    }



}

