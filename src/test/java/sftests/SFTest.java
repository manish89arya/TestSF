package sftests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SourceFusePage;
import util.SFConstants;

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class SFTest extends TestBase {

    String FirstName = null;
    String LastName = null;
    String Email= null;
    String CurrentCompany= null;
    String MobileNumber=null;
    String DOB=null;
    String JobPosition=null;
    String Website=null;
    String SalaryRequirements=null;
    String StartDate=null;
    String Address=null;
    SourceFusePage sourceFusePage;
    SoftAssert softAssert = new SoftAssert();

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
    public void verifyDBEntry() throws ClassNotFoundException, SQLException {
        System.out.println("====>>>> Test Case 5: Verify DB entry after submitting the form using JDBC connection. <<<<<======");

        sourceFusePage.enterFirstName("Test First Name");
        sourceFusePage.enterLastName("Test Last Name");
        sourceFusePage.enterEmail("test@yopmail.com");
        sourceFusePage.enterCurrentCompany("Test Company");
        sourceFusePage.enterMobileNumber("9000000000");
        sourceFusePage.enterDOB("30/03/1989");
        sourceFusePage.enterJobPosition("SDET");
        sourceFusePage.enterWebsite("www.google.com");
        sourceFusePage.enterSalaryRequirements("NA");
        sourceFusePage.enterStartDate("1 Nov 2020");
        sourceFusePage.enterAddress("Test Address");

        //Below code will verify Db once above details are filled.
        Class.forName(SFConstants.JDBC_DRIVER);

        //Create Connection to DB
        Connection con = DriverManager.getConnection(SFConstants.DB_URL,SFConstants.DB_USERNAME,SFConstants.DB_PASSWORD);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(SFConstants.DB_QUERY);

        // While Loop to iterate through all data and print results
        while (rs.next()){
             FirstName= rs.getString("FirstName");
             LastName=rs.getString("LastName");
             Email= rs.getString("Email");
             CurrentCompany= rs.getString("Test Company");
             MobileNumber= rs.getString("MobileNumber");
            DOB= rs.getString("DOB");
            JobPosition= rs.getString("JobPosition");
            Website= rs.getString("Website");
            SalaryRequirements= rs.getString("SalaryRequirements");
            StartDate= rs.getString("StartDate");
            Address= rs.getString("Address");

            System.out.println(FirstName+"\t"+LastName+"\t"+Email+"\t"+CurrentCompany+"\t"+MobileNumber
                    +DOB+"\t"+JobPosition+"\t"+Website+"\t"+SalaryRequirements+"\t"+StartDate+"\t"+Address);
        }
        // closing DB Connection
        con.close();

        softAssert.assertEquals(FirstName,"Test First Name");
        softAssert.assertEquals(LastName,"Test First Name");
        softAssert.assertEquals(Email,"test@yopmail.com");
        softAssert.assertEquals(CurrentCompany,"Test Company");
        softAssert.assertEquals(MobileNumber,"9000000000");
        softAssert.assertEquals(DOB,"30/03/1989");
        softAssert.assertEquals(JobPosition,"SDET");
        softAssert.assertEquals(Website,"www.google.com");
        softAssert.assertEquals(SalaryRequirements,"NA");
        softAssert.assertEquals(StartDate,"1 Nov 2020");
        softAssert.assertEquals(Address,"Test Address");
        softAssert.assertAll();
    }

    @Test
    public void verifyEmailIsTriggered() throws ClassNotFoundException, SQLException {
        System.out.println("=====>>>>> Test Case 6: Verify E-mail is triggered or not after submitting the form using assertion on DB considering an email trigger column as email_sent. <<<<======");
        String email_sent = null;
        sourceFusePage.enterFirstName("Test First Name");
        sourceFusePage.enterLastName("Test Last Name");
        sourceFusePage.enterEmail("test@yopmail.com");
        sourceFusePage.enterCurrentCompany("Test Company");
        sourceFusePage.enterMobileNumber("9000000000");
        sourceFusePage.enterDOB("30/03/1989");
        sourceFusePage.enterJobPosition("SDET");
        sourceFusePage.enterWebsite("www.google.com");
        sourceFusePage.enterSalaryRequirements("NA");
        sourceFusePage.enterStartDate("1 Nov 2020");
        sourceFusePage.enterAddress("Test Address");

        //Below code will verify Db once above details are filled.
        Class.forName(SFConstants.JDBC_DRIVER);

        //Create Connection to DB
        Connection con = DriverManager.getConnection(SFConstants.DB_URL,SFConstants.DB_USERNAME,SFConstants.DB_PASSWORD);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(SFConstants.DB_QUERY);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            email_sent= rs.getString("email_sent");
            System.out.println(email_sent);
        }
        // closing DB Connection
        con.close();

        Assert.assertEquals(email_sent, "yes"); // assuming if email is sent then value of email_sent is stored as yes


    }

    @AfterMethod
    public void tearDown()
    {
        System.out.println("inside teardown");
        TestBase.closeDriver();

    }

}
