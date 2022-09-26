package PracticeWithSamet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Selectables {

    public Selectables(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[.='News']")
    WebElement newsBox;

    @FindBy(xpath = "//div[.='Feeds']")
    WebElement feedsBox;

    public void switchBoxes(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
       actions.dragAndDrop(newsBox, feedsBox).perform();
    }






}
