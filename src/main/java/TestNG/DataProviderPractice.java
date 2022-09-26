package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    //it runs the same TEST with a different SET OF DATA

    /*
    Ahmet 123
    Mehmet 312
    Malika 756
    Damla 987
    Ion 966
     */

//    @DataProvider(name = "FullName")
//    public Object[][] getData() {
//
//        return new Object[][]{
//                {"Mehmet", "312","34334"},
//                {"Malika", "789","767676"},
//                {"Damla", "434","45434"},
//                {"Ion", "333","34324"},
//                {"Ahmet", "6767","2342"}
//
//        };
//
//    }

    @Test(dataProvider = "FullName", dataProviderClass = FullNameDataProvider.class)
    public void test(String username, String password, String creditCard) {
        System.out.println(username + password + creditCard);
    }


}
