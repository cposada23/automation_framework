package config;

import factory.DriverFactory;
import factory.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class ActionKeywords {
    public static WebDriver driver;
    private static Logger logger = LogFactory.getLogger(ActionKeywords.class);

    public static void openBrowser(){
        logger.info("Opening browser");
        driver = DriverFactory.getDriver("FIREFOX", true, true);
        logger.info("Browser opened");
    }

    public static void navigate(){
        String url = Constants.URL;
        logger.info("Navigating to URL: " + url);
        driver.get(url);
        logger.info("URL opened");
    }

    public static void click_MyAccount(){
        logger.info("Click on my account");
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        logger.info("My account clicked");
    }

    public static void input_Username(){
        driver.findElement(By.id("log")).sendKeys("testuser");
    }

    public static void input_Password(){
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
    }

    public static void click_Login(){
        driver.findElement(By.id("login")).click();
    }

    public static void waitFor() throws Exception{
        Thread.sleep(5000);
    }

    public static void click_Logout(){
        driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
    }

    public static void closeBrowser(){
        driver.quit();
    }
}
