package sftests;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SourceFusePage;

public class SFTest extends TestBase {


    SourceFusePage sourceFusePage;
    SoftAssert softAssert = new SoftAssert();
    /*
Test Case 1: Try to submit without filling required fields and "Labels" of all the required field printed on Console.

Test Case 2: Verify all input fields using Soft assertions.

Test Case 3: Verify all input fields using Hard assertions.

Test Case 4: Submit the form after filling all details properly by using XPath only.

Test Case 5: Verify DB entry after submitting the form using JDBC connection.

Test Case 6: Verify E-mail is triggered or not after submitting the form using assertion on DB considering an email trigger column as email_sent.

     */

@BeforeMethod
public void setup()
{
    System.out.println("inside setup");
    TestBase.browserSetUp();
    sourceFusePage = new SourceFusePage();
    TestBase.authenticationPopUpLogin();
}

    @Test
public void submitWithoutFillingAllDetails()
{

    System.out.println("Inside First Test");
    System.out.println("Total Number of required fields is: ===> "+sourceFusePage.getAllRequiredFields());
    sourceFusePage.clickOnSubmit();

}
    @Test
    public void verifyAllInputsUsingSoftAsserstion()
    {
        System.out.println("Inside First Test2");

    }

    @Test
    public void verifyAllInputsUsingHardAssersion()
    {
        System.out.println("inside test2");
    }

    @Test
    public void submitFormUsingXpath()
    {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sourceFusePage.fillEntireForm();
        sourceFusePage.clickOnChooseFile();
    }

    @Test
    public void verifyDBEntry()
    {
        System.out.println("inside test4");
    }

    @Test
    public void verifyEmailIsTriggered()
    {
        System.out.println("inside test5");
    }

    @AfterMethod
    public void tearDown()
    {
        System.out.println("inside teardown");
        TestBase.closeDriver();

    }

}
