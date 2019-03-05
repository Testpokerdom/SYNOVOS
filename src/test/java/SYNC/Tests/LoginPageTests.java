package SYNC.Tests;

import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.EnterpriseApplicationLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.FinanceSiteSettings;
import SYNC.Locators.WorkPlaceLocators.WorkPlaceLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.SourceType;

import java.util.concurrent.TimeUnit;

import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.switchToNewWindow;
import static sun.security.jgss.GSSUtil.login;

public class LoginPageTests {
    public WebDriver driver = null;
    public Actions action = null;
    public static WorkPlaceLocators workPlaceLocators = null;
    public static EnterpriseApplicationLocators enterpriseApplicationLocators = null;
    public static FinanceSiteSettings financeSiteSettings = null;

    public static final Logger logger = LogManager.getLogger(LoginPageTests.class);

    @Before
    public void beforEeach() {
        System.setProperty("webdriver.chrome.driver", "C://Users//viktor.bibik//webdrivers//Chromedriver//chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        workPlaceLocators = new WorkPlaceLocators(driver);
        enterpriseApplicationLocators = new EnterpriseApplicationLocators(driver);
        financeSiteSettings = new FinanceSiteSettings(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        logger.info("----------------------------------------------------------------------------------------------------------------------");
        loginWithPopUp(driver, "rmishyn", "!123456789", "us01.dynamicseam.com");

    }

    @After
    public void afterEach(){

        driver.quit();
    }

    @Test
    public void checkFinanceSiteSettingsPageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkFinanceSiteSettings);
        switchToNewWindow(driver);

        Assert.assertEquals("Finance Site Settings", financeSiteSettings.headerText.getText());
    }

    @Test
    public void checkFinanceSiteSettingsPageButtonsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkFinanceSiteSettings);
        switchToNewWindow(driver);
        clickButtonIfEnable(financeSiteSettings.buttonExportToExel);
        clickButtonIfEnable(financeSiteSettings.buttonTransmissionSummary_last_3_months);

        Assert.assertTrue("false", financeSiteSettings.buttonExportToExel.isEnabled());
        Assert.assertTrue("true", financeSiteSettings.buttonTransmissionSummary_last_3_months.isEnabled());
    }

}
