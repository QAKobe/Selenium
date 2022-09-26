package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Laptops')]")
    WebElement laptopsButton;

    public void clickLaptop(){
        laptopsButton.click();
    }

    public void goBack(WebDriver driver) throws InterruptedException {
       driver.navigate().refresh();
    }


}
