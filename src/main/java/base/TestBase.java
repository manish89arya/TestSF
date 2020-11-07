package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.SFConstants;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {

    public static WebDriver driver;


    public static void browserSetUp() {
        if(SFConstants.BROWSER_NAME.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        {
            System.out.println("Please set your browser property!");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(SFConstants.URL);
        driver.manage().timeouts().pageLoadTimeout(SFConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(SFConstants.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }

    public static void closeDriver()
    {
        driver.quit();
    }

    public static void authenticationPopUpLogin()
    {
        driver.get("http://sfwebhtml:t63KUfxL5vUyFLG4eqZNUcuRQ@sfwebhtml.sourcefuse.com/automation-form-demo-for-interview/");
    }
}
