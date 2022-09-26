package MentoringWithAhmet.com.test.OpenChart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn-close") ////button[@class='btn-close']
    WebElement xButton;

    @FindBy(xpath = "//h2[@class='float-end']")
    List<WebElement> dashBoardValues;

    @FindBy(xpath = "//li[@id='menu-customer']")
    WebElement mainCustomer;

    @FindBy(xpath = "//a[.='Customers']")
    WebElement subCustomer;

    public void validateInformation() throws InterruptedException {

        Thread.sleep(2000);
        xButton.click();
        List<String> expectedValues = Arrays.asList("196", "48.6M", "4.4K", "78");

        for (int i = 0; i < dashBoardValues.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(dashBoardValues.get(i)), expectedValues.get(i));
        }

        mainCustomer.click();
        subCustomer.click();
    }


}
