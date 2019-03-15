package SYNC.Tests;

import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.EnterpriseApplicationLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.FinanceSiteSettingsLocators.FinanceSiteSettingsLocators;
import SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.MRLineDetailsWaitingForAQuoteLocators.MRLineDetailsWaitingForAQuoteLocators;
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

public class MRLineDetailsWaitingForAQuoteTests {
    public WebDriver driver = null;
    public static WorkPlaceLocators workPlaceLocators = null;
    public static EnterpriseApplicationLocators enterpriseApplicationLocators = null;
    public static FinanceSiteSettingsLocators financeSiteSettings = null;
    public static MRLineDetailsWaitingForAQuoteLocators mrLineDetailsWaitingForAQuote = null;

    public static final Logger logger = LogManager.getLogger(MRLineDetailsWaitingForAQuoteTests.class);

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
        mrLineDetailsWaitingForAQuote = new MRLineDetailsWaitingForAQuoteLocators(driver);

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
    public void checkMRLineDetailsPageIsAvailable(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkMRLineDetailsWaitingforAQuoteClientPrice);
        switchToNewWindow(driver);

        Assert.assertEquals("MR Line Details (Waiting for a Quote/Client Price)", mrLineDetailsWaitingForAQuote.headerText.getText());
    }

    @Test
    public void checkMRLineDetails_DropDownListRecordsPerPageIsEnable_25() throws InterruptedException {
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkMRLineDetailsWaitingforAQuoteClientPrice);
        switchToNewWindow(driver);
        selectWebElementFromDropDownList(mrLineDetailsWaitingForAQuote.dropDownListRecordsPerPage, "25");
        //List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']/tbody/tr"));
        //System.out.println("Table contains rows: " + tableRows.size());

        Assert.assertEquals("25", mrLineDetailsWaitingForAQuote.dropDownListRecordsPerPage.getAttribute("value"));
    }

    @Test
    public void checkMRLineDetails_APagination(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkMRLineDetailsWaitingforAQuoteClientPrice);
        switchToNewWindow(driver);
        mrLineDetailsWaitingForAQuote.checkPaginationPanelButtons(driver);

        Assert.assertEquals(false, mrLineDetailsWaitingForAQuote.buttonSecondPage.isSelected());
    }

    @Test
    public void checkMRLineDetails_ButtonExportToExcelIsEnable_FileIsDownloaded() throws InterruptedException {
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkMRLineDetailsWaitingforAQuoteClientPrice);
        switchToNewWindow(driver);
        Thread.sleep(2000);
        //waitElementToBeClickable(driver, 5, mrLineDetailsWaitingForAQuote.buttonExportToExcelMRLineDetails);
        clickButtonIfEnable(mrLineDetailsWaitingForAQuote.buttonExportToExcelMRLineDetails);
        Thread.sleep(2000);
        isFileDownloaded("C:\\Users\\viktor.bibik\\Downloads\\Tests", "Mr Lines Detail.xlsx");

        Assert.assertEquals(true, mrLineDetailsWaitingForAQuote.buttonExportToExcelMRLineDetails.isEnabled());
    }

    @Test
    public void checkMRLineDetails_DetailedItemPage(){
        clickButtonIfEnable(workPlaceLocators.buttonEnterpriseApplication);
        switchToIFrame(driver, enterpriseApplicationLocators.iFrameEnterpriseApplicationPage);
        clickButtonIfEnable(enterpriseApplicationLocators.linkMRLineDetailsWaitingforAQuoteClientPrice);
        switchToNewWindow(driver);
        clickButtonIfEnable(mrLineDetailsWaitingForAQuote.buttonWaitingForQuote);
        switchToNewWindow(driver);

        Assert.assertEquals("Microsoft Dynamics CRM", driver.getTitle());
    }

}
