package util;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperActions extends TestBase {

    public static void enterTextInAnInputField(WebElement element, String inputText)
    {
        HelperActions.waitForVisibility(element);
        element.sendKeys(inputText);
    }

    public static void waitForVisibility(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
//        JavascriptExecutor jse = (JavascriptExec+utor)driver;
//        jse.executeScript("document.getElementById('fnameInput').setAttribute('disabled', 'false')");
    }


}
