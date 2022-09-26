package MentoringWithAhmet.com.test.OpenChart.tests;

import MentoringWithAhmet.com.test.OpenChart.Pages.LoginPage;
import MentoringWithAhmet.com.test.OpenChart.Pages.MainPage;
import org.testng.annotations.Test;

public class MainTest extends TestBase{

    @Test
    public void validateData() throws InterruptedException {

        LoginPage loginPage  = new LoginPage(driver);
        loginPage.loginToWebSite();
        MainPage mainPage = new MainPage(driver);
        mainPage.validateInformation();
    }

}
