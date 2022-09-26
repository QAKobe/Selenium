package com.test.sentrifugo.pages;

import javafx.scene.layout.BackgroundRepeat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //driver.findElement(By.xpath(//div.....))
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(id = "loginsubmit")
    WebElement loginButton;

    @FindBy(id = "usernameerror")
    WebElement usernameError;

    @FindBy(id = "pwderror")
    WebElement passwordError;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String usernameErrorMessage(){
        return BrowserUtils.getText(usernameError);
    }

    public String passwordErrorMessage(){
        return BrowserUtils.getText(passwordError);
    }

    public String usernameErrorColor(){
        return usernameError.getCssValue("color");
    }

    public String passwordErrorColor(){
        return passwordError.getCssValue("color");
    }




}
