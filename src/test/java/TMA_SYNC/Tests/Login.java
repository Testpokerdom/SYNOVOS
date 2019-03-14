package TMA_SYNC.Tests;

import TMA_SYNC.Locators.EditPurchaseRequisition;
import TMA_SYNC.Locators.HomePageLocators;
import TMA_SYNC.Locators.LoginPageLocators;
import com.sun.org.glassfish.gmbal.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.waitElementAttributeShouldHaveValue;

public class Login {

    public static WebDriver driver = null;
    public static LoginPageLocators  loginPageLocators= null;
    public static HomePageLocators homePageLocators = null;
    public static EditPurchaseRequisition editPurchaseRequisition = null;

    public static final Logger logger = LogManager.getLogger(Login.class);

    @Before
    public void beforEeach() {
        System.setProperty("webdriver.chrome.driver", "C://Users//viktor.bibik//webdrivers//Chromedriver//chromedriver.exe");
        driver = new ChromeDriver();

        loginPageLocators = new LoginPageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        editPurchaseRequisition = new EditPurchaseRequisition(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        goToUrl(driver,"https://www.webtma.net/loginWithPopUp.aspx");
        logger.info("TMA web site was opened.");
        //sendTextToMultipleWebElements(loginPageLocators.fieldLogin, "VBIBIK18", loginPageLocators.fieldPassword, "deadman18");
        //clickButton(loginPageLocators.buttonLogin);
    }
/*
    @After
    public void afterEach(){

        driver.quit();
    }
*/

    @Test
    @Description("Login as Valid and Existing User")
    //@DisplayName("Login as Valid and Existing User")
    public void test_1_loginValidUser(){
        sendTextToMultipleWebElements(loginPageLocators.fieldLogin, "sss999", loginPageLocators.filedPassword, "tma1", loginPageLocators.filedClient, "Jefferson Test");
        clickButton(loginPageLocators.buttonLogin);

        //Assert.assertEquals("Home  | User:VBIBIK18  | Logout", loginPageLocators.userNickName.getText());
        logger.info("Valid user was logged in - successfully.");
        logger.info("----------------------------------------------------------------");
    }

}
