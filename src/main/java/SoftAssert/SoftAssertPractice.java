package SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SoftAssertPractice {


    public int sum(int num1, int num2){
        return num1+num2;
    }

    @Test
    public void practice(){
        Assert.assertEquals(sum(2,6), 8);
        System.out.println("Nazgul");
        Assert.assertEquals(sum(3,8), 12);//should fail
        System.out.println("Ion");
        Assert.assertEquals(sum(0,0), 0);
        System.out.println("Mustafa");


    }

    @Test
    public void test(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(sum(2,6), 8);
        System.out.println("Akyn");
        softAssert.assertEquals(sum(3,8),12);// should fail
        System.out.println("Ayana");
        softAssert.assertEquals(sum(0,0), 0);
        System.out.println("Tunde");
        softAssert.assertAll();
    }


}
