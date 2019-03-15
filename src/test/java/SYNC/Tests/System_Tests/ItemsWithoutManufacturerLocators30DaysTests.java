package SYNC.Tests.System_Tests;

import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.EnterpriseApplicationLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.FinanceSiteSettingsLocators.FinanceSiteSettingsLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.ItemsWithoutManufacturerCreatedIn30DaysLocators.ItemsWithoutManufacturerLocators;
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

public class ItemsWithoutManufacturerLocators30DaysTests {
    public WebDriver driver = null;
    public static WorkPlaceLocators workPlaceLocators = null;
    public static EnterpriseApplicationLocators enterpriseApplicationLocators = null;
    public static FinanceSiteSettingsLocators financeSiteSettings = null;
    public static ItemsWithoutManufacturerLocators itemsWithoutManufacturer = null;

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
        itemsWithoutManufacturer = new ItemsWithoutManufacturerLocators(driver);

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
    public void checkItemsWithoutManufacturer_PageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkItemswithoutManufacturerCreatedin30days);
        switchToNewWindow(driver);

        Assert.assertEquals("Items Without Manufacturer (Created in 30 days)", itemsWithoutManufacturer.headerText.getText());

    }

    @Test
    public void checkItemsWithoutManufacturer_DetailedItemPage(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkItemswithoutManufacturerCreatedin30days);
        switchToNewWindow(driver);
        clickWebElementIfEnable(itemsWithoutManufacturer.linkNameInLastRow);
        switchToNewWindow(driver);

        Assert.assertEquals("Microsoft Dynamics CRM", driver.getTitle());

    }

    @Test
    public void checkItemsWithoutManufacturer_DropDownListRecordsPerPageIsEnable_25(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkItemswithoutManufacturerCreatedin30days);
        switchToNewWindow(driver);
        selectWebElementFromDropDownList(itemsWithoutManufacturer.dropDownListRecordsPerPage, "25");

        Assert.assertEquals("25", itemsWithoutManufacturer.dropDownListRecordsPerPage.getAttribute("value"));
    }

    @Test
    public void checkItemsWithoutManufacturer_ButtonExportToExcelIsEnable_FileIsDownloaded() throws InterruptedException {
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkItemswithoutManufacturerCreatedin30days);
        switchToNewWindow(driver);
        clickButtonIfEnable(itemsWithoutManufacturer.buttonExportToExcelItemsWithoutManufacturePage);
        Thread.sleep(2000);
        isFileDownloaded("C:\\Users\\viktor.bibik\\Downloads\\Tests", "Items Without Manufacturer.xlsx");

        Assert.assertEquals(true, itemsWithoutManufacturer.buttonExportToExcelItemsWithoutManufacturePage.isEnabled());
    }
}
