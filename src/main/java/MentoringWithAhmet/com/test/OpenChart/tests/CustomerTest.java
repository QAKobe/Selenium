package MentoringWithAhmet.com.test.OpenChart.tests;

import MentoringWithAhmet.com.test.OpenChart.Pages.CustomerPage;
import MentoringWithAhmet.com.test.OpenChart.Pages.LoginPage;
import MentoringWithAhmet.com.test.OpenChart.Pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CustomerTest extends TestBase{

    @Parameters({"firstName", "lastName", "email", "telephone"})

    @Test
    public void validateMessage(String name, String lastName, String email, String telephone) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToWebSite();
        MainPage mainPage = new MainPage(driver);
        mainPage.validateInformation();

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.customerInfo(name, lastName, email, telephone);


    }

}
