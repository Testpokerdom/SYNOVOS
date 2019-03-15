package SYNC.Tests.Smoke_Tests;

import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.EnterpriseApplicationLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.FinanceSiteSettingsLocators.FinanceSiteSettingsLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.InvoicStatusTransmitionLocators.InvoicingStatusTransmitionLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.ItemsWithoutManufacturerCreatedIn30DaysLocators.ItemsWithoutManufacturerLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.MRLineDetailsWaitingForAQuoteLocators.MRLineDetailsWaitingForAQuoteLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.MRLineSummaryWaitingForAQuoteClientPrice.MrLineSummaryLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.PGTListPriceRequests.PGTListPriceRequestsLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.PGTManufactureFocusedSourcingLocators.PGTManufactureFocusedSourcingLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.VendorApprovalLocators.VendorApprovalLocators;
import SYNC.Locators.WorkPlaceLocators.WorkPlaceLocators;
import SYNC.Tests.System_Tests.FinanceSiteSettingsPageTests;
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
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static WebHelpers.WebHelpers.*;

public class Smoke_tests_check_page_is_available {
    public WebDriver driver = null;
    public Actions action = null;
    public static WorkPlaceLocators workPlaceLocators = null;
    public static EnterpriseApplicationLocators enterpriseApplicationLocators = null;
    public static FinanceSiteSettingsLocators financeSiteSettings = null;
    public static InvoicingStatusTransmitionLocators invoicingStatusTransmitionLocators = null;
    public static ItemsWithoutManufacturerLocators itemsWithoutManufacturer = null;
    public static MRLineDetailsWaitingForAQuoteLocators mrLineDetailsWaitingForAQuote = null;
    public static MrLineSummaryLocators mrLineSummary = null;
    public static PGTListPriceRequestsLocators pgtListPriceRequestsLocators = null;
    public static PGTManufactureFocusedSourcingLocators pgtManufactureFocusedSourcingLocators = null;
    public static VendorApprovalLocators vendorApprovalLocators = null;
    public static String basePafeTitle;
    public static String newPageTitle;

    public static final Logger logger = LogManager.getLogger(FinanceSiteSettingsPageTests.class);

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
        invoicingStatusTransmitionLocators = new InvoicingStatusTransmitionLocators(driver);
        itemsWithoutManufacturer = new ItemsWithoutManufacturerLocators(driver);
        mrLineDetailsWaitingForAQuote = new MRLineDetailsWaitingForAQuoteLocators(driver);
        mrLineSummary = new MrLineSummaryLocators(driver);
        pgtListPriceRequestsLocators = new PGTListPriceRequestsLocators(driver);
        pgtManufactureFocusedSourcingLocators = new PGTManufactureFocusedSourcingLocators(driver);
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
    public void checkFinanceSiteSettings_PageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkFinanceSiteSettings);
        basePafeTitle = driver.getTitle();
        switchToNewWindow(driver);
        newPageTitle = driver.getTitle();

        Assert.assertNotSame(basePafeTitle, newPageTitle);
        Assert.assertEquals("Finance Site Settings", financeSiteSettings.headerText.getText());
    }

    @Test
    public void checkInvoicingStatusPageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkInvoicingStatusTransmission);
        switchToNewWindow(driver);

        Assert.assertEquals("Invoicing Status/Transmission", invoicingStatusTransmitionLocators.headerText.getText());
    }

    @Test
    public void checkItemsWithoutManufacturer_PageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkItemswithoutManufacturerCreatedin30days);
        switchToNewWindow(driver);

        Assert.assertEquals("Items Without Manufacturer (Created in 30 days)", itemsWithoutManufacturer.headerText.getText());

    }

    @Test
    public void checkMRLineDetailsPageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkMRLineDetailsWaitingforAQuoteClientPrice);
        switchToNewWindow(driver);

        Assert.assertEquals("MR Line Details (Waiting for a Quote/Client Price)", mrLineDetailsWaitingForAQuote.headerText.getText());
    }

    @Test
    public void checkMRLineSummaryPageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkMRLineSummaryWaitingforAQuoteClientPrice);
        switchToNewWindow(driver);

        Assert.assertEquals("MR Line Summary (Waiting for a Quote/Client Price)", mrLineSummary.headerText.getText());
    }

    @Test
    public void checkPGTListPriceRequestsPageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkPGT_ListPriceRequests);
        switchToNewWindow(driver);

        Assert.assertEquals("PGT List Price Requests", pgtListPriceRequestsLocators.headerText.getText());
    }

    @Test
    public void checkPGTManufactureFocusedPageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkPGT_ManufactureFocusedSourcing);
        switchToNewWindow(driver);

        Assert.assertEquals("PGT Manufacture Focused Sourcing", pgtManufactureFocusedSourcingLocators.headerText.getText());
    }

    @Test
    public void checkVendorApprovalPageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkVendorApproval);
        switchToNewWindow(driver);

        Assert.assertEquals("Vendor Approval", vendorApprovalLocators.headerText.getText());
    }
}
