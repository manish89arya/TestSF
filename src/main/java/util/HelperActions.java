package util;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HelperActions extends TestBase {

    public static void enterTextInAnInputFieldUsingActionClass(WebElement element, String inputText)
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(element,inputText).build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Actual Entered Value in " +element.getAttribute("id")+" is ======>>>>>"+ element.getAttribute("value"));
    }

    public static void uploadFile()
    {

    }

}
