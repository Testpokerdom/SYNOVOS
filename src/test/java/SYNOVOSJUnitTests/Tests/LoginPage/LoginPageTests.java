package SYNOVOSJUnitTests.Tests.LoginPage;

import SYNOVOSJUnitTests.Locators.LoginPage.LoginPageLocators;
import SYNOVOSJUnitTests.Locators.MainPage.MainPageLocators;
//import com.sun.org.glassfish.gmbal.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SYNOVOSJUnitTests.WebHelpers.WebHelpers.*;

public class LoginPageTests {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static final Logger logger = LogManager.getLogger(LoginPageTests.class);

    @Before
    public void beforEeach() {
        System.setProperty("webdriver.chrome.driver", "C://Users//viktor.bibik//webdrivers//Chromedriver//chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C://Users//viktor.bibik//webdrivers//Firefoxdriver//geckodriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        loginPageLocators = new LoginPageLocators(driver);
        mainPageLocators = new MainPageLocators(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        goToUrl(driver, "http://localhost:8080/sos/splashScreen.sos");
        logger.info("SYNOVOS web site was opened.");
        //sendTextToMultipleWebElements(loginPageLocators.fieldLogin, "VBIBIK18", loginPageLocators.fieldPassword, "deadman18");
        //clickButton(loginPageLocators.buttonLogin);
    }

    @After
    public void afterEach(){

        driver.quit();
    }

    @Test
    //@Description("Login as Valid and Existing User")
    //@DisplayName("Login as Valid and Existing User")
    public void test_1_loginValidUser(){
        sendTextToMultipleWebElements(loginPageLocators.fieldLogin, "VBIBIK18", loginPageLocators.fieldPassword, "deadman18");
        clickButton(loginPageLocators.buttonLogin);
        waitElementPresent(driver, 4, loginPageLocators.userNickName);

        Assert.assertEquals("Home  | User:VBIBIK18  | Logout", loginPageLocators.userNickName.getText());
        logger.info("Valid user was logged in - successfully.");
        logger.info("----------------------------------------------------------------");
    }


    @Test
    //@Description("Login as InValid and UnExisting User")
    //@DisplayName("Login as InValid and UnExisting User")
    public void test_2_loginInValidUser(){
        sendTextToMultipleWebElements(loginPageLocators.fieldLogin, "InValidUser", loginPageLocators.fieldPassword, "unExistPass");
        clickButton(loginPageLocators.buttonLogin);

        Assert.assertEquals( "User Name/Password combination incorrect.\n" + "Please try again.", loginPageLocators.messageIncorrectLoginOrPassword.getText());
        logger.info("InValid user was not logged into the system");
        logger.info("----------------------------------------------------------------");
    }

}

