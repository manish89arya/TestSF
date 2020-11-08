package sftests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SourceFusePage;
import util.SFConstants;

import java.util.concurrent.TimeUnit;

public class SFTest extends TestBase {


    SourceFusePage sourceFusePage;
    SoftAssert softAssert = new SoftAssert();
    /*

Test Case 6: Verify E-mail is triggered or not after submitting the form using assertion on
DB considering an email trigger column as email_sent.

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

    System.out.println("=====>>>>> Test Case 1: Try to submit without filling required fields and Labels of all the required field printed on Console. <<<<======");
    System.out.println("Total Number of required fields is: ===> "+sourceFusePage.getAllRequiredFields());
    sourceFusePage.clickOnSubmit();

}
    @Test
    public void verifyAllInputsUsingSoftAsserstion()
    {
        System.out.println("=====>>>>> Test Case 2: Verify all input fields using Soft assertions <<<<======");
        sourceFusePage.enterFirstName("TestFirstName");
        softAssert.assertEquals("TestFirstName","abc");
        sourceFusePage.enterLastName("TestLastName");
        softAssert.assertEquals("TestLastName","abc");
        sourceFusePage.enterEmail("test@yopmail.com");
        softAssert.assertEquals("test@yopmail.com","abc");
        sourceFusePage.enterCurrentCompany("Test Company");
        softAssert.assertEquals("Test Company","abc");
        sourceFusePage.enterMobileNumber("9000000000");
        softAssert.assertEquals("9000000000","abc");
        sourceFusePage.enterDOB("30/03/1989");
        softAssert.assertEquals("30/03/1989","abc");
        sourceFusePage.enterJobPosition("SDET");
        softAssert.assertEquals("SDET","abc");
        sourceFusePage.enterWebsite("www.google.com");
        softAssert.assertEquals("www.google.com","abc");
        sourceFusePage.enterSalaryRequirements("NA");
        softAssert.assertEquals("NA","abc");
        sourceFusePage.enterStartDate("1 Nov 2020");
        softAssert.assertEquals("1 Nov 2020","abc");
        sourceFusePage.enterAddress("Test Address");
        softAssert.assertEquals("Test Address","abc");
        sourceFusePage.clickOnChooseFile();
        sourceFusePage.chooseYesRadio();
        sourceFusePage.clickOnSubmit();
        softAssert.assertAll();

    }

    @Test
    public void verifyAllInputsUsingHardAssersion()
    {
        System.out.println("=====>>>>> Test Case 3: Verify all input fields using Hard assertions. <<<<======");
        sourceFusePage.enterFirstName("TestFirstName");
        Assert.assertEquals("TestFirstName","abc");
        sourceFusePage.enterLastName("TestLastName");
        Assert.assertEquals("TestLastName","abc");
        sourceFusePage.enterEmail("test@yopmail.com");
        Assert.assertEquals("test@yopmail.com","abc");
        sourceFusePage.enterCurrentCompany("Test Company");
        Assert.assertEquals("Test Company","abc");
        sourceFusePage.enterMobileNumber("9000000000");
        Assert.assertEquals("9000000000","abc");
        sourceFusePage.enterDOB("30/03/1989");
        Assert.assertEquals("30/03/1989","abc");
        sourceFusePage.enterJobPosition("SDET");
        Assert.assertEquals("SDET","abc");
        sourceFusePage.enterWebsite("www.google.com");
        Assert.assertEquals("www.google.com","abc");
        sourceFusePage.enterSalaryRequirements("NA");
        Assert.assertEquals("NA","abc");
        sourceFusePage.enterStartDate("1 Nov 2020");
        Assert.assertEquals("1 Nov 2020","abc");
        sourceFusePage.enterAddress("Test Address");
        Assert.assertEquals("Test Address","abc");
        sourceFusePage.clickOnChooseFile();
        sourceFusePage.chooseYesRadio();
        sourceFusePage.clickOnSubmit();

    }

    @Test
    public void submitFormByUsingXpath()
    {
        System.out.println("=====>>>>> Test Case 4: Submit the form after filling all details properly by using XPath only. <<<<======");
        sourceFusePage.fillEntireForm();
        sourceFusePage.clickOnChooseFile();
        sourceFusePage.chooseYesRadio();
        sourceFusePage.clickOnSubmit();
    }

    @Test
    public void verifyDBEntry()
    {
        System.out.println("====>>>> Test Case 5: Verify DB entry after submitting the form using JDBC connection. <<<<<======");

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
//        TestBase.closeDriver();

    }

}
