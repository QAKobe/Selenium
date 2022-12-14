package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentPage {

    public DepartmentPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@title='Add']")
    WebElement addButton;

    @FindBy(xpath = "//input[@id='deptname']")
    WebElement departmentNameField;

    @FindBy(id = "s2id_unitid")
    WebElement businessUnit;

    @FindBy(xpath = "//input[@id='deptcode']")
    WebElement departmentCode;

    @FindBy(xpath = "//div[@id='s2id_depthead']")
    WebElement departmentHead;

    @FindBy(id = "s2id_city")
    WebElement city;

    @FindBy(xpath = "//input[@id='submitbutton']")
    WebElement saveButton;

    @FindBy(xpath = "//tbody//tr[contains(@onclick,'selectrow(departments,this);')][1]//td")
    List<WebElement> information;


    public void addDepartment(String departmentName, String businessUnit, String departmentCode, String departmentHead, String city){
        addButton.click();
        this.departmentNameField.sendKeys(departmentName);
        this.businessUnit.sendKeys(businessUnit);
        this.departmentCode.sendKeys(departmentCode);
        this.departmentHead.sendKeys(departmentHead);
        this.city.sendKeys(city);
        saveButton.click();
    }
    public void validateInformation(){
        List<String> expectedInformation = Arrays.asList("Information Technology","IT","01/05/2001","Thomas E","America/New_York [EDT]","Orange Blossom");

        List<String>actualInformation = new ArrayList<>();
        for (int i = 1; i < information.size(); i++) {
            actualInformation.add(information.get(i).getText().trim());
        }

        for (int i = 0; i < actualInformation.size(); i++) {
            Assert.assertEquals(actualInformation.get(i), expectedInformation.get(i));
        }

        //Assert.assertEquals(actualInformation, expectedInformation);

    }


}
