package util;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class HelperActions extends TestBase {

    public static void enterTextInAnInputFieldUsingActionClass(WebElement element, String inputText)
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(element,inputText).build().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Actual Entered Value in " +element.getAttribute("id")+" is ======>>>>>"+ element.getAttribute("value"));

    }

    public static String uploadFile()
    {
        return new File(System.getProperty("user.dir")+"\\src\\main\\resources\\testpdf.pdf").getAbsolutePath();

    }

}
