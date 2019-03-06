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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static WebHelpers.WebHelpers.*;

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
        ChromeOptions options = new ChromeOptions();

        String downloadFilepath = "C:\\Users\\viktor.bibik\\Downloads\\Tests";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        //chromePrefs.put("download.default_directory", folder.getAbsolutePath());
        chromePrefs.put("download.default_directory", downloadFilepath);

        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        //cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        //driver = new ChromeDriver(cap);

        driver = new ChromeDriver(options);


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
    public void checkFinanceSiteSettings_PageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkFinanceSiteSettings);
        switchToNewWindow(driver);

        Assert.assertEquals("Finance Site Settings", financeSiteSettings.headerText.getText());
    }

    @Test
    public void checkFinanceSiteSettingsPage_ButtonExportToExcelIsEnable() throws InterruptedException {
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkFinanceSiteSettings);
        switchToNewWindow(driver);
        clickButtonIfEnable(financeSiteSettings.buttonExportToExcel);
        Thread.sleep(2000);
        isFileDownloaded("C:\\Users\\viktor.bibik\\Downloads\\Tests", "Finance Site Settings.xlsx");

        Assert.assertEquals(true, financeSiteSettings.buttonExportToExcel.isEnabled());
    }

    @Test
    public void checkFinanceSiteSettingsPage_ButtonTransmissionSummaryIsEnable() throws InterruptedException {
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkFinanceSiteSettings);
        switchToNewWindow(driver);
        clickButtonIfEnable(financeSiteSettings.buttonTransmissionSummary_last_3_months);
        //
        Thread.sleep(2000);
        isFileDownloaded("C:\\Users\\viktor.bibik\\Downloads\\Tests", "Transmitted Invoices.xlsm");

        Assert.assertEquals(true, financeSiteSettings.buttonTransmissionSummary_last_3_months.isEnabled());
    }

    @Test
    public void checkFinanceSiteSettingsPage_DropDownListRecordsPerPageIsEnable_25(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkFinanceSiteSettings);
        switchToNewWindow(driver);
        selectWebElementFromDropDownList(financeSiteSettings.dropDownListRecordsPerPage, "25");

        Assert.assertEquals("25", financeSiteSettings.dropDownListRecordsPerPage.getAttribute("value"));
    }

}
