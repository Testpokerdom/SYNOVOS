package SYNC.Tests.System_Tests;

import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.EnterpriseApplicationLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.FinanceSiteSettingsLocators.FinanceSiteSettingsLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.InvoicStatusTransmitionLocators.InvoicingStatusTransmitionLocators;
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

public class InvoicingStatusTransmissionPageTests {
    public WebDriver driver = null;
    public static WorkPlaceLocators workPlaceLocators = null;
    public static EnterpriseApplicationLocators enterpriseApplicationLocators = null;
    public static FinanceSiteSettingsLocators financeSiteSettings = null;
    public static InvoicingStatusTransmitionLocators invoicingStatusTransmitionLocators = null;

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
        invoicingStatusTransmitionLocators = new InvoicingStatusTransmitionLocators(driver);


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
    public void checkInvoicingStatusPageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkInvoicingStatusTransmission);
        switchToNewWindow(driver);

        Assert.assertEquals("Invoicing Status/Transmission", invoicingStatusTransmitionLocators.headerText.getText());

    }

    @Test
    public void checkInvoicingStatus_DropDownListRecordsPerPageIsEnable_25(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkInvoicingStatusTransmission);
        switchToNewWindow(driver);
        selectWebElementFromDropDownList(invoicingStatusTransmitionLocators.dropDownListRecordsPerPage, "25");

        Assert.assertEquals("25", invoicingStatusTransmitionLocators.dropDownListRecordsPerPage.getAttribute("value"));
    }

    @Test
    public void checkInvoicingStatus_ButtonExportToExcelIsEnable() throws InterruptedException {
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkInvoicingStatusTransmission);
        switchToNewWindow(driver);
        clickButtonIfEnable(invoicingStatusTransmitionLocators.buttonExportToExcel);
        Thread.sleep(2000);
        isFileDownloaded("C:\\Users\\viktor.bibik\\Downloads\\Tests", "Invoicing Status.xlsx");

        Assert.assertEquals(true, invoicingStatusTransmitionLocators.buttonExportToExcel.isEnabled());
    }

    @Test
    public void checkInvoicingStatus_DetailedItemPage(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkInvoicingStatusTransmission);
        switchToNewWindow(driver);

        clickButtonIfEnable(invoicingStatusTransmitionLocators.linkNameInLastRowInvoicingStatusTransmition);
        switchToIFrame(driver, invoicingStatusTransmitionLocators.iFrameTransmitInvoice);

        Assert.assertEquals("Transmit Invoices", invoicingStatusTransmitionLocators.textTransmitInvoices.getText());

    }

}
