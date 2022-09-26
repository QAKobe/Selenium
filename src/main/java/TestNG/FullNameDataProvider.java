package TestNG;

import org.testng.annotations.DataProvider;

public class FullNameDataProvider {

    @DataProvider(name = "FullName")
    public Object[][] getData() {

        return new Object[][]{
                {"Mehmet", "312","34334"},
                {"Malika", "789","767676"},
                {"Damla", "434","45434"},
                {"Ion", "333","34324"},
                {"Ahmet", "6767","2342"}

        };

    }

}
