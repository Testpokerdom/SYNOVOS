package SYNC.Tests;

import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.EnterpriseApplicationLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.FinanceSiteSettingsLocators.FinanceSiteSettingsLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.PGTManufactureFocusedSourcingLocators.PGTManufactureFocusedSourcingLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.VendorApprovalLocators.VendorApprovalLocators;
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
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.isFileDownloaded;

public class VendorApprovalTests{
    public WebDriver driver = null;
    public static WorkPlaceLocators workPlaceLocators = null;
    public static EnterpriseApplicationLocators enterpriseApplicationLocators = null;
    public static FinanceSiteSettingsLocators financeSiteSettings = null;
    public static VendorApprovalLocators vendorApprovalLocators = null;

    public static final Logger logger = LogManager.getLogger(InvoicingStatusTransmissionPageTests.class);

    @Before
    public void beforEeach() {
        System.setProperty("webdriver.chrome.driver", "C://Users//viktor.bibik//webdrivers//Chromedriver//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        String downloadFilepath = "C:\\Users\\viktor.bibik\\Downloads\\Tests";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);

        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(options);


        workPlaceLocators = new WorkPlaceLocators(driver);
        enterpriseApplicationLocators = new EnterpriseApplicationLocators(driver);
        financeSiteSettings = new FinanceSiteSettingsLocators(driver);
        vendorApprovalLocators = new VendorApprovalLocators(driver);

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
    public void checkPGTListPriceRequestsPageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkVendorApproval);
        switchToNewWindow(driver);

        Assert.assertEquals("Vendor Approval", vendorApprovalLocators.headerText.getText());
    }

    @Test
    public void checkPGTListPriceRequests_DropDownListRecordsPerPageIsEnable_25(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkVendorApproval);
        switchToNewWindow(driver);
        selectWebElementFromDropDownList(vendorApprovalLocators.dropDownListRecordsPerPage, "25");

        Assert.assertEquals("25", vendorApprovalLocators.dropDownListRecordsPerPage.getAttribute("value"));
    }

    @Test
    public void checkPGTListPriceRequests_ButtonExportToExcelIsEnable_FileIsDownloaded() throws InterruptedException {
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkVendorApproval);
        switchToNewWindow(driver);
        clickButtonIfEnable(vendorApprovalLocators.buttonExportToExcelPGTManufactureFocused);
        Thread.sleep(2000);
        isFileDownloaded("C:\\Users\\viktor.bibik\\Downloads\\Tests", "Vendor Approval_.xlsx");

        Assert.assertEquals(true, vendorApprovalLocators.buttonExportToExcelPGTManufactureFocused.isEnabled());
    }
}
