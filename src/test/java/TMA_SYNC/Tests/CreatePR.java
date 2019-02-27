package TMA_SYNC.Tests;

import TMA_SYNC.Locators.LoginPageLocators;
import TMA_SYNC.PageObjectLocators.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static WebHelpers.WebHelpers.*;

public class CreatePR {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators= null;
    public static MainPage mainPageLocators = null;
    public static MainIFrame_PurchaseRequisitionMain mainIFramePurchaseRequisition = null;
    public static IdentityIFrame_Identity identityIFrameIdentity = null;
    public static PurchReqDialogIFrame_PurchaseRequisitionEntry purchReqDialogIFramePurchaseRequisitionEntry = null;
    public static PurcaseOrderDistributionIFrame_DistributionEntry purchaseOrderDistributionIFrame_DistributionEntry = null;


    public static final Logger logger = LogManager.getLogger(CreatePurchaseRequisition.class);

    @Before
    public void beforEeach() {
        System.setProperty("webdriver.chrome.driver", "C://Users//viktor.bibik//webdrivers//Chromedriver//chromedriver.exe");
        driver = new ChromeDriver();

        loginPageLocators = new LoginPageLocators(driver);
        mainPageLocators = new MainPage(driver);
        mainIFramePurchaseRequisition = new MainIFrame_PurchaseRequisitionMain(driver);
        identityIFrameIdentity = new IdentityIFrame_Identity(driver);
        purchReqDialogIFramePurchaseRequisitionEntry = new PurchReqDialogIFrame_PurchaseRequisitionEntry(driver);
        purchaseOrderDistributionIFrame_DistributionEntry = new PurcaseOrderDistributionIFrame_DistributionEntry(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        logger.info("----------------------------------------------------------------------------------------------------------------------");
        goToUrl(driver,"https://www.webtma.net/login.aspx");
        //logger.info("TMA web site was opened.");
        sendTextToMultipleWebElements(loginPageLocators.fieldLogin, "sss999", loginPageLocators.filedPassword, "tma1", loginPageLocators.filedClient, "Jefferson Test");
        clickButton(loginPageLocators.buttonLogin);
        switchToNewWindow(driver);

    }

    @After
    public void afterEach(){

        driver.quit();
    }

    @Test
    public void Test_1_Create_Valid_PurchaseRequisition(){

        mainPageLocators.switchToMaterialTabAndClickPurchaseRequisitionLink(driver);
        mainIFramePurchaseRequisition.clickButtonAdd(driver);
        identityIFrameIdentity.switchToIFrameIdentityAndFillFieldsVendorTypeCodeAndRepeirCenterCode(driver);
        purchReqDialogIFramePurchaseRequisitionEntry.switchToIFramePurchReqDialogAndFillFieldsAccountPartCodeQuantityAndUnitCost(driver, "100");
        mainIFramePurchaseRequisition.clickButtonsExpandAndAddDistribution(driver);
        purchaseOrderDistributionIFrame_DistributionEntry.switchToIFrameDistributionDialogPOAndFillFields_WorkOrderAndRequiredQty(driver, "100");
        driver.switchTo().defaultContent();
        mainIFramePurchaseRequisition.switchToIFrameMainAndClickButtonSave(driver);
        //identityIFrameIdentity.receivePR_RequisitionNumber(driver);
    }
}
