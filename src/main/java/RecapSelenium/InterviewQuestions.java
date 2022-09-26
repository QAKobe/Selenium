package RecapSelenium;

import WaitTimes.ExplicitWait;

public class InterviewQuestions {
    /*
    1-What are the advantages and disadvantages of Selenium?

    Advantage: -Free Source
               -It supports multiple languages(Java, Python, C++, C#)
               -Big community
               -It supports multiple browsers(Chrome, Safari, FireFox...)

    Disadvantage: -You cannot automate "CAPTCHA, PICTURE, MOBILE APPLICATIONS....."
                  -There is no direct call for the error report(Support center/customer center)
                  -It only automates Web applications.
                  -It does not have any system to generate report, so we integrate reports from-->
                        TestNG report, Cucumber Report.

    2-What type of testing can you automate with Selenium?

        -Smoke Testing                   Regression Testing                     Functional Testing(positive/negative)

    3-What are the test types can you not automate with Selenium?

        -Performance Testing
        -Manual Testing(captcha, pictures, Adhoc testing)
        -Non-functional testing(performance, stress testing, load testing)

    4-What is locator and what are the locator type? *******

       -->Locator is a way to find the elements from DOM(Development tool/page)
       -->ID             -->className               -->Name                       -->TagName
       -->LinkText       -->PartialLinkText         -->CSS                        -->XPATH

    5-How do you handle the Dynamic Elements(CVS) ************

        In my project I faced many dynamic elements, and I used different ways to handle with:

        -->I use parent/child relationship to locate elements.
        -->I use different attributes which are not dynamic(Changes)
        SHOW OFF--> I use special xpath types-->
                        --Following-siblings
                        -->preceding-siblings
                        -->contains
                        -->.=
                        -->and condition
                        just say what is important don't go deep and do go too simple

   6-What is the difference between driver.get() and driver.navigate() ***********

        NavigateTo()--> It does not wait webElements(page) to be loaded totally.
                    --> have some methods --> refresh, back, forward,to

        get()--> it will wait all WebElements(page) to be loaded.
             --> get does not have methods.

   7-What is difference between driver.close() and driver.quit()*****

        Close()--> it specifically closes the window where the driver is currently working on.

        quit()--> it closes all the opened pages from automation.


   8-What is Xpath?  ******
        Xpath--> is used to find location of element on a webPage by using html structure
                 Xpath is one of the ways to locate webElements.

        And can you tell me about types of Xpath?
        There are 2 types of Xpath

                  Absolute Xpath--> it goes all the way from parent to child step by step(html/body/div/h1/button)
                                 -->it starts with single slash(/)

              ****Relative Xpath--> It directly focuses on the child(location of the element)(button) or parent-child(h1/button)

        Which Xpath do you use in your project?
        --> in my project, I use mostly relative xpath because it directly focuses on child which I need to locate
            it saves a lot of time to not check all the parent of the child
            Element is in Relative Xpath way shorter than Absolute Xpath

   9-What is the difference between Relative and Absolute Xpath?
         Absolute Xpath:
         It goes from parent to child
         It has single slash(/) for the path
         Syntax is different

         Relative Xpath:
         It goes from parent to child or to the child directly
         It has double slash(//) for the path
         Syntax is different

    10-How do you handle (static) drop down menu or dropDowns?
        In my project I was handling static dropDown different ways:
        *I would definitely check the tag of the location
        *If the tag name is "Select" --> then I'd use Select select = new Select(Location of the WebElement)
        *If the tag name is not "Select" --> I use locators to locate my elements and sendKeys.
        *If it is not working then I'd go with Actions class and click or HoverOver the element(Actions actions = new Actions(driver))
        -->actions.moveToElement(WebElement).perform

    11-Can you tell me some methods you use for select class? *
        In my project, I use select class to handle dropDowns
        --> Select class is really useful to locate and find the elements and to be able to use select class this element
        must have select tagName
        -->SelectByVisibleText()
        -->SelectByIndex()
        -->SelectByValue()

    12-What kind of Exceptions did you face in selenium during automations?****
        -->NoSuchElementException
        -->StaleElementReferenceException
        -->NullPointerException(driver, pages)
        -->ElementIsNotInterceptedException--> Element might not be visible on the page(scrollDown)
        -->ElementIsNotIntractableException--> Element might not be visible on the page(scrollDown)
        -->TimeOutException-->Explicit and Fluent wait
        -->NoSuchFrameException
        -->NoSuchWindowException
        -->UnHandledAlertException

        13-In what condition do you get StaleElementReference Exception ? How do you handle it ? *****
      -->There are couple reasons of getting this exception:
         ** -->The element is not on DOM(development structure/tool)
         * -->The element is not updated YET.
          -->The element needs to be refreshed
     -->How do you handle it ?
        -->First of all, As a tester one of the tough exception i face and struggle to handle is StaleElementReference.
        With my research I found these three ways that are really effective.
        ***** -->I reinitialize the WebElement-->reassign the webelement
          exp:WebElement element = driver.findElement(By.id("ahmet"));
        //  element.click;//stale element reference exception
          element=driver.findElement(By.id("ahmet"));
          element.click;
        **-->Thread.sleep because some elements take little time to be updated,so we can wait with Thread.sleep
        *-->driver.navigate.refresh();
      14-How do you handle alerts?
      There are different types of alerts I faced in my framework? Can you tell me which one you are asking specifically?
      do you want me talk all of them ?
      --->*OS alerts/pop-ups -->Operation System alers which we cannot handle with Selenium.As much as I know there is
      a Robot class which handles it,but tbh(to be honest) I never used before.
      --->HTML alerts/pop-ups -->As you know sir/madam, with Selenium you can go and find the element then take any actions
      you want. Like click OK, Cancel, X button ....etc
      -->JAVASCRIPT pop-up-->Alert interface--> Mostly I face with this Alert pop-ups which comes from JAVASCRIPT
      .To be able to handle these pop-ups. I create an object from Alert interface and call the methods:
         Alert alert = driver.switchTo().alert()
      -->alert.accept-->It clicks "OK" button
      -->alert.dismiss-->it clicks "CANCEL" button
      -->alert.sendKeys()-->it sends the key(text...) to the JS pop-up
      -->alert.getText()-->it gets the Text
      15)What do you know about Iframe?Can you tell me the type that you used before and how do you handle the iframe
      in Selenium?
      **Iframe is a way to protect the data like advertisements,videos,documents ...etc.
     *** We cannot directly access the inside of iframe because "Iframe is html inside of HTML"
     -->To be able to understand the data is under the iframe:
        *I automate my element and getting NoSuchElement exception.(If you believe everything is good with this element like xpath)
        *I go to the website and search for //frame or //iframe
        *Then I look up my element whether it is under this iframe or not
     There different types of iframe that I can handle:
       -->You have to switch your iframe to be able to access the data:
          driver.switchTo().frame(Name or ID)-->MOST COMMON(%99)
          driver.switchTo().frame(WebElement)-->driver.findElement(By.Xpath(//frame[@id='frame-1'])
          driver.switchTo().frame(index) -->not suggested since index numbers are changing a lot.
      -->SHOW OFF :
        -->If you want I can you more details about other methods for iframes LIKE:
         -->driver.switchTo.ParentFrame()-->which goes to the parent of the frame
         -->DRIVER.SWITCHTO.DEFAULTCONTENT()-->which goes directly to the Main HTML.(all the way to the top(main))
                                            -->which goes directly to the out of all frames(until main html)
       16-What do you know Actions class?
       -->Actions class is really useful for my framework since with actions class I use Keyboard and mouse actions
          -->Actions actions =new Action(driver);
       -->actions .
             --> MoveByOffSet(x,y) -->it is going to find the element based on x and y locations
             --> DoubleClick --> it double-clicks the element
             --> SendKeys() -->It sends the Keys to the element , Keys.ENTER***
             --> ConTextClick()-->it right clicks the element
             --> ClickAndHold()-->it clicks and holds the element
             --> release()-->it releases the element is already clicked and hold
             --> DragAndDrop -->it drags and drops the element
   **        --> MoveToElement --> It hovers over the element
             --> Click()-->it clicks the element
             -->ScrollByAmount(x,y) -->i scrolls the page based on the x and y.
   *****     --> Perform()-->it performs the actions methods.(WITHOUT THIS IT WILL NOT WORK)

            KEYBOARD ACTIONS:

             -->Keys.ENTER/RETURN-->it enters after sending the keys
             -->Keys.Arrow-up / down / right/ left  -->  it goes different directions on the page.(Sliders and scrollPage)
        17-What is the difference between Find Element and Find Elements? ***

        Find element:                                                       Find Elements:
     *   driver.findElement(By.)   <---       synthax is different   <---    * driver.findElements(By.)
     *  returns the single WebElement  <--    Return type is different <--   * returns the List Of WebElement
     *  Once it fails,
        it throws NoSuchELement exception   <--- ExceptionType  <---        *It throws the empty list. No exception

        18-Can you tell me some driver and WebElement Element methods?

-->  Driver Methods:                                                   -->  WebElement Methods:
  *get()-->goes to the website                                         *sendKeys()-->it sends the keys
  *navigate().to()-->goes to the website no waiting                    *click()-->it clicks the element
  *getTitle()-->gets the title                                         *getText()-->it gets the text
  *findElement/s()-->find the elements from webpage                    *clear()-->it clears the box
  *getCurrentUrl()-->it gets the url of the page                       *isDisplayed()-->it checks the element is visible
  *getPageSource()-->it gets the source of page(HTML)                  *isSelected()-->it checks the box/radio button is selected
  *manage().window().maximize()-->it maximize your web Browser         *submit()-->it clicks the submit button
  *manage().wait().implicitlyWait()-->it creates wait times            *getAttribute()-->it gets the value of any attribute
  *getWindowHandle/s-->it gets the id of the webpage                   *getCSSValue()-->it gets the CSS value of element(color)
  *switchTo().window-->it switches the window
  *switchTo().alert()-->it switches the alert
  *switchTo().frame()-->it switches the frame
  *quit()-->it closes the "ALL PAGES"
  *close()-->it closes the current page.

  19-What is the difference between check box and radio box?
        CheckBox = you can click multiple boxes
        RadioButton = you can choose only one

    20-Difference between isDisplayed, isSelected and isEnabled?
        isDisplayed : displayed the element is visible on the page or not.
        isSelected : it checks the element is selected or not. (Check-mark inside the box)
        isEnabled : it checks the element is enabled or not(some elements are faded(meaning is not clickable))

    21-How do you switch multiple windows?
        I can use driver.window(driver.getWindowHandle)
        I have utils package which has methods for this.

        driver.switchTo().window(driver.getWindowHandle)
        BrowserUtils.switchByTitle()
        BrowserUtils.switchById()

   22-How do you scroll down to the page from Web browser?
        First I definitely use JS scrollIntoView script
        Actions class (scrollByAmount(x,y))
        SHOW OFF: (Point Class00> getX, getY--> and y location.)
        Point point = WebElement.getLocation();
        int xCord = point.getX();
        int yCord = point.getY();
        js.executeScript("window.scrollTo("+xCord+","+yCord+")");

   23-How do you Upload file in Selenium?
        Find the element that triggers upload window(choose button)
        Find the path of the file you want to upload ex: C://Users/Kubanych/pic.png etc...
        driver.findElement(choose button).sendKeys(location of file)

   24-What is the difference between Assert and SoftAssert?
        TBH they have similar logic in terms of validation but there are couple differences as much as I know.

        Assert is a class that have some methods to validate the actual and expected data
        with the methods like Assert.assertEquals, AssertTrue, AssertFalse, AssertFail()
        *It will throw an exception and stop the execution no matter what when it fails.

        SoftAssert is a class that have some methods to validate actual and expected data with methods like
        softAssert.assertEquals, AssertTrue, AssertFalse, AssertFail
        *When softAssert fails, it will not throw an exception and stop the execution.
        *You need to create an object to be able to use SoftAssert methods.
        *To be able to activate softAssert --> at the end you need to put AssertAll method.
        SoftAssert softAssert = new SoftAssert();

  25-Can you tell me about Singleton? Can you make your Constructor private?
        First of all, I appreciate for this question, I love Singleton a lot. In the past, one of the failures
        I was struggling to solve was NullPointerException, and with the help of SPD I was able to make my driver more useful
        protected, and safe which is centralized into the framework.

        Encapsulation:
            private WebDriver
            private Constructor
            public method getDriver()

   26-Can you tell me about TestNG annotations? What do you know about @Parameters and @DataProviders?
        *@Test
        *@BeforeMethod
        *@AfterMethod
        @BeforeClass
        @AfterClass
        @BeforeTest
        @AfterTest
        @BeforeSuite
        @AfterSuite
        @Parameters
        @DataProvider

        @Parameters: is a way to parameterize the data in TestNG
            I use parameter Keyword inside of xml file
            I need to provide parameters form xml which is written from class.

        @DataProvider: it is a way to execute the same test with different set of data
            I use @DataProvider annotation to link test cases and method

            @DataProvider(name="test")
            public Object[][]data(){
            return new Object[][]{
            "Ahmet", "Mehmet","Ayse", "Fatma"
            "Kutman","Myktybek", "Amina", "Ali"
            }
            }
            @Test(dataProvider="test")
            it will run 2 times with same test case. If you are storing your data provider in different class.
            Then you need to do one more implementation.

            @Test(DataProvider ="Test",dataProviderClass=nameOfFetchtedClass.class)
            *-->It returns Object[][]multidimensional array.

    27-What do you know about wait times? Can you tell me the difference between implicit and explicit wait?
        To be honest, this is one of my favorite concepts since it handles a lot wait time issues. To be able to do that:
            -->Implicit wait: => it is one of wait times that handles wait issues for specific elements to locate.
            *when the element is not found in certain amount of time, then it throws NoSuchElement exception
            *driver.manage.timeouts.implicit(Duration.ofSeconds(10))

            -->Explicit wait: is one of the wait times that handles wait issues for specific element to locate with
            "Specific Condition". --> visibleOf, clickable,..etc (NOTE: Look for more methods inside this explicit wait class)
            *WebDriver wait = new WebDriverWait(Duration.ofSeconds(10));
            wait.until.(ExpectedCondition.visibleOf(WebElement))**
            *When it does not find the element, it throws TimeOutsException

            -->Fluent wait: is one of wait times that handles wait issues for specific element to locate with
            check the element "periodically"

      28-What is the difference between Verification and Validation?****
            Verification: it is way to verify data. It does not need execution of the code or Assertion. We just read and verify the code.
            ex. I completed my homework and sending it to Ion. Ion is reading my implementation and verifying that my code is good.

            Validation: It is a way to validate data. "It requires execution and Assertion of the code".
            ex. I start doing my project and I do all the execution and assertion to "VALIDATE" my code is good. Meaning Assertion is a MUST IN AUTOMATION.

            CONGRATULATIONS:
























     */


}
