package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite Annotation");
        //you can use to set up you Chrome browser properties
        //you can delete cookies
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest Annotation");
        //you can use to launch your browser
        //WebDriver driver=DriverHelper.getDriver()
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass Annotation");
        //You can navigate to website
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod Annotation");
        //driver initialization. WebDriver driver = Driver.getDriver()
        //driver.get(url)
        //You can use to login website
    }

    @Test
    public void test(){//1
        System.out.println("Test1 Annotation");
    }

    @Test void test2(){//1
        System.out.println("Test2 Annotation");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod Annotation");
        //You can tearDown under that(driver.quit)
        //You can take screenshot for failed test annotations
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass Annotation");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest Annotation");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite Annotation");
    }





}
