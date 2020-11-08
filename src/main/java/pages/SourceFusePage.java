package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.HelperActions;

import java.util.List;

public class SourceFusePage extends TestBase
{

    @FindBy(xpath = "//div[@id='fnameInput']//input[@type='text']")
    private WebElement txtFldFirstName;

    @FindBy(xpath = "//div[@id='lnameInput']")
    private WebElement txtFldLastName;

    @FindBy(xpath = "//div[@id='emailInput']")
    private WebElement txtFldEmail;

    @FindBy(xpath = "//div[@id='curCompanyInput']")
    private WebElement txtFldCurrentCompany;

    @FindBy(xpath = "//div[@id='mobInput']")
    private WebElement txtFldMobile;

    @FindBy(xpath = "//div[@id='DOBInput']")
    private WebElement txtFldDOB;

    @FindBy(xpath = "//div[@id='positionInput']")
    private WebElement txtFldPosition;

    @FindBy(xpath = "//div[@id='portfolioInput']")
    private WebElement txtFldWebsite;

    @FindBy(xpath = "//div[@id='salaryInput']")
    private WebElement txtFldSalary;

    @FindBy(xpath = "//div[@id='whenStartInput']")
    private WebElement txtFldWhenCanYouStart;

    @FindBy(xpath = "//div[@id='addressInput']")
    private WebElement txtAreaAddress;

    @FindBy(xpath = "//input[@id='resume']")
    private WebElement btnChooseFile;

    @FindBy(xpath = "//input[@type='radio' and @id='yes']")
    private WebElement relocateYes;

    @FindBy(xpath = "//label//span[@class='required']")
    private WebElement allRequiredFieldsInForm;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;


    public SourceFusePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String textInput) {
        HelperActions.enterTextInAnInputFieldUsingActionClass(txtFldFirstName, textInput);
    }

    public void enterLastName(String textInput) {
        HelperActions.enterTextInAnInputFieldUsingActionClass(txtFldLastName, textInput);
    }

    public void enterEmail(String textInput) {
        HelperActions.enterTextInAnInputFieldUsingActionClass(txtFldEmail, textInput);
    }

    public void enterCurrentCompany(String textInput) {
        HelperActions.enterTextInAnInputFieldUsingActionClass(txtFldCurrentCompany, textInput);
    }

    public void enterMobileNumber(String textInput) {
        HelperActions.enterTextInAnInputFieldUsingActionClass(txtFldMobile, textInput);
    }
    public void enterDOB(String textInput) {
        HelperActions.enterTextInAnInputFieldUsingActionClass(txtFldDOB, textInput);
    }

    public void enterJobPosition(String textInput) {
        HelperActions.enterTextInAnInputFieldUsingActionClass(txtFldPosition, textInput);
    }
    public void enterWebsite(String textInput) {
        HelperActions.enterTextInAnInputFieldUsingActionClass(txtFldWebsite, textInput);
    }

    public void enterSalaryRequirements(String textInput) {
        HelperActions.enterTextInAnInputFieldUsingActionClass(txtFldSalary, textInput);
    }

    public void enterStartDate(String textInput) {
        HelperActions.enterTextInAnInputFieldUsingActionClass(txtFldWhenCanYouStart, textInput);
    }
    public void enterAddress(String textInput) {
        HelperActions.enterTextInAnInputFieldUsingActionClass(txtAreaAddress, textInput);
    }

    public void fillEntireForm()
    {
        enterFirstName("Test First Name");
        enterLastName("Test Last Name");
        enterEmail("test@yopmail.com");
        enterCurrentCompany("Test Company");
        enterMobileNumber("9000000000");
        enterDOB("30/03/1989");
        enterJobPosition("SDET");
        enterWebsite("www.google.com");
        enterSalaryRequirements("NA");
        enterStartDate("1 Nov 2020");
        enterAddress("Test Address");
    }

    public void clickOnSubmit()
    {
        System.out.println("Inside ClickOnSubmit button");
        btnSubmit.click();
    }

    public void clickOnChooseFile()
    {
        btnChooseFile.sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\testpdf.pdf");
    }

    public  void chooseYesRadio()
    {
        relocateYes.click();
    }

    public int getAllRequiredFields() {
        List<WebElement> links = driver.findElements(By.xpath("//label//span[@class='required']"));
        return links.size();
    }
}
