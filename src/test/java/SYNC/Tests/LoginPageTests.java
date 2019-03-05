package SYNC.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;

import java.util.concurrent.TimeUnit;

import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.switchToNewWindow;
import static sun.security.jgss.GSSUtil.login;

public class LoginPageTests {
    public WebDriver driver = null;
    public Actions action = null;
    public static final Logger logger = LogManager.getLogger(LoginPageTests.class);

    @Before
    public void beforEeach() {
        System.setProperty("webdriver.chrome.driver", "C://Users//viktor.bibik//webdrivers//Chromedriver//chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        logger.info("----------------------------------------------------------------------------------------------------------------------");



    }
/*
    @After
    public void afterEach(){

        driver.quit();
    }
*/
    @Test
    public void loginTest(){

        goToUrl(driver,"https://us01.dynamicseam.com");

        /*
        driver.switchTo().defaultContent();
        System.out.println("title is: " + driver.getTitle());
        */
        /*
        Alert promptPopUp = driver.switchTo().alert();
        promptPopUp.sendKeys("eam01\\rmishyn");
        promptPopUp.sendKeys("!123456789");
        promptPopUp.accept();
        */

        driver.switchTo().alert().sendKeys("eam01\\\\rmishyn");
        driver.switchTo().alert().accept();
    }

}
