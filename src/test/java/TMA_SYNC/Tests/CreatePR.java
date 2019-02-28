package TMA_SYNC.Tests;

import TMA_SYNC.Locators.LoginPageLocators;
import TMA_SYNC.PageObjectLocators.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
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
    public static RoutingWindowIFrame_PurchaseRequisitionAuthorization routingWindowIFrame_purchaseRequisitionAuthorization = null;


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
        routingWindowIFrame_purchaseRequisitionAuthorization = new RoutingWindowIFrame_PurchaseRequisitionAuthorization(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        logger.info("----------------------------------------------------------------------------------------------------------------------");
        goToUrl(driver,"https://www.webtma.net/login.aspx");
        //logger.info("TMA web site was opened.");
        sendTextToMultipleWebElements(loginPageLocators.fieldLogin, "sss999", loginPageLocators.filedPassword, "tma1", loginPageLocators.filedClient, "Jefferson Test");
        clickButton(loginPageLocators.buttonLogin);
        switchToNewWindow(driver);

    }

    /*
    @After
    public void afterEach(){

        driver.quit();
    }
    */
    @Test
    public void _1_PR_SpecifiedQty_100_ReqQty_100(){

        logger.info("Purchase requisition with SpecifiedQty = 100 and ReqQty = 100");
        mainPageLocators.switchToMaterialTabAndClickPurchaseRequisitionLink(driver);
        mainIFramePurchaseRequisition.switchToTheIFrameMainAndclickButtonAdd(driver);
        identityIFrameIdentity.switchToIFrameIdentityAndFillFieldsVendorTypeCodeAndRepeirCenterCode(driver);
        purchReqDialogIFramePurchaseRequisitionEntry.switchToIFramePurchReqDialogAndFillFieldsAccountPartCodeQuantityAndUnitCost(driver, "100");
        mainIFramePurchaseRequisition.clickButtonsExpandAndAddDistribution(driver);
        purchaseOrderDistributionIFrame_DistributionEntry.switchToIFrameDistributionDialogPOAndFillFields_WorkOrderAndRequiredQty(driver, "100");
        driver.switchTo().defaultContent();
        mainIFramePurchaseRequisition.switchToIFrameMainAndClickButtonSave(driver);
        identityIFrameIdentity.receivePR_RequisitionNumber(driver);
        mainPageLocators.switchToDefaultContentAndClickButtonExport(driver);
        driver.switchTo().parentFrame();
        switchToIFrame(driver, mainIFramePurchaseRequisition.iFrameMain);
        routingWindowIFrame_purchaseRequisitionAuthorization.switchToIframePRAutorizationAndClickButtonAutorize(driver);

    }

    /*
    @Test
    public void _2_PR_SpecifiedQty_100_ReqQty_0(){

        logger.info("Purchase requisition with SpecifiedQty = 100 and ReqQty = 0");
        mainPageLocators.switchToMaterialTabAndClickPurchaseRequisitionLink(driver);
        mainIFramePurchaseRequisition.switchToTheIFrameMainAndclickButtonAdd(driver);
        identityIFrameIdentity.switchToIFrameIdentityAndFillFieldsVendorTypeCodeAndRepeirCenterCode(driver);
        purchReqDialogIFramePurchaseRequisitionEntry.switchToIFramePurchReqDialogAndFillFieldsAccountPartCodeQuantityAndUnitCost(driver, "100");
        mainIFramePurchaseRequisition.clickButtonsExpandAndAddDistribution(driver);
        purchaseOrderDistributionIFrame_DistributionEntry.switchToIFrameDistributionDialogPOAndFillFields_WorkOrderAndRequiredQty(driver, "0");
        driver.switchTo().defaultContent();
        mainIFramePurchaseRequisition.switchToIFrameMainAndClickButtonSave(driver);
        identityIFrameIdentity.receivePR_RequisitionNumber(driver);
        mainPageLocators.switchToDefaultContentAndClickButtonExport(driver);
        driver.switchTo().parentFrame();
        switchToIFrame(driver, mainIFramePurchaseRequisition.iFrameMain);
        routingWindowIFrame_purchaseRequisitionAuthorization.switchToIframePRAutorizationAndClickButtonAutorize(driver);
    }

    @Test
    public void _3_PR_SpecifiedQty_100_ReqQty_85_23(){

        logger.info("Purchase requisition with SpecifiedQty = 100 and ReqQty = 85.23");
        mainPageLocators.switchToMaterialTabAndClickPurchaseRequisitionLink(driver);
        mainIFramePurchaseRequisition.switchToTheIFrameMainAndclickButtonAdd(driver);
        identityIFrameIdentity.switchToIFrameIdentityAndFillFieldsVendorTypeCodeAndRepeirCenterCode(driver);
        purchReqDialogIFramePurchaseRequisitionEntry.switchToIFramePurchReqDialogAndFillFieldsAccountPartCodeQuantityAndUnitCost(driver, "100");
        mainIFramePurchaseRequisition.clickButtonsExpandAndAddDistribution(driver);
        purchaseOrderDistributionIFrame_DistributionEntry.switchToIFrameDistributionDialogPOAndFillFields_WorkOrderAndRequiredQty(driver, "85.23");
        driver.switchTo().defaultContent();
        mainIFramePurchaseRequisition.switchToIFrameMainAndClickButtonSave(driver);
        identityIFrameIdentity.receivePR_RequisitionNumber(driver);
        mainPageLocators.switchToDefaultContentAndClickButtonExport(driver);
        driver.switchTo().parentFrame();
        switchToIFrame(driver, mainIFramePurchaseRequisition.iFrameMain);
        routingWindowIFrame_purchaseRequisitionAuthorization.switchToIframePRAutorizationAndClickButtonAutorize(driver);
    }

    @Test
    public void _4_PR_SpecifiedQty_100_ReqQty_minus256(){

        logger.info("Purchase requisition with SpecifiedQty = 100 and ReqQty = -256");
        mainPageLocators.switchToMaterialTabAndClickPurchaseRequisitionLink(driver);
        mainIFramePurchaseRequisition.switchToTheIFrameMainAndclickButtonAdd(driver);
        identityIFrameIdentity.switchToIFrameIdentityAndFillFieldsVendorTypeCodeAndRepeirCenterCode(driver);
        purchReqDialogIFramePurchaseRequisitionEntry.switchToIFramePurchReqDialogAndFillFieldsAccountPartCodeQuantityAndUnitCost(driver, "100");
        mainIFramePurchaseRequisition.clickButtonsExpandAndAddDistribution(driver);
        purchaseOrderDistributionIFrame_DistributionEntry.switchToIFrameDistributionDialogPOAndFillFields_WorkOrderAndRequiredQty(driver, "-256");
        driver.switchTo().defaultContent();
        mainIFramePurchaseRequisition.switchToIFrameMainAndClickButtonSave(driver);
        identityIFrameIdentity.receivePR_RequisitionNumber(driver);
        mainPageLocators.switchToDefaultContentAndClickButtonExport(driver);
        driver.switchTo().parentFrame();
        switchToIFrame(driver, mainIFramePurchaseRequisition.iFrameMain);
        routingWindowIFrame_purchaseRequisitionAuthorization.switchToIframePRAutorizationAndClickButtonAutorize(driver);
    }
    */
}
