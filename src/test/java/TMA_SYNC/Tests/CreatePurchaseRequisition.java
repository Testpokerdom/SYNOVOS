package TMA_SYNC.Tests;

import TMA_SYNC.Locators.EditPurchaseRequisition;
import TMA_SYNC.Locators.HomePageLocators;
import TMA_SYNC.Locators.LoginPageLocators;
import com.sun.org.glassfish.gmbal.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickWebElementIfEnable;

public class CreatePurchaseRequisition {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators= null;
    public static HomePageLocators homePageLocators = null;
    public static EditPurchaseRequisition editPurchaseRequisition = null;
    //public static VendorTypeCodeRepairCenterTable vendorTypeCodeRepairCenterTable = null;

    public static final Logger logger = LogManager.getLogger(CreatePurchaseRequisition.class);

    @Before
    public void beforEeach() {
        System.setProperty("webdriver.chrome.driver", "C://Users//viktor.bibik//webdrivers//Chromedriver//chromedriver.exe");
        driver = new ChromeDriver();

        loginPageLocators = new LoginPageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        editPurchaseRequisition = new EditPurchaseRequisition(driver);
        //vendorTypeCodeRepairCenterTable = new VendorTypeCodeRepairCenterTable();

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
    @Description("Create PR with valid items parameters")
    //@DisplayName("Login as Valid and Existing User")
    public void test_1_Click() throws InterruptedException {

        // Left menu elements: click button "Material", click button "Purchase Requisition"
        clickWebElementIfEnable(homePageLocators.tabMaterial);
        waitElementPresence(driver, 5, homePageLocators.linkPurchaseRequisitionOnMaterialTab);
        clickButtonIfEnable(homePageLocators.linkPurchaseRequisitionOnMaterialTab);

        // Switch to Iframe "mainFrame" + click button "ADD"
        switchToIFrame(driver, editPurchaseRequisition.iFrameMain);
        clickButtonIfEnable(editPurchaseRequisition.buttonAdd);
        // Switch to Iframe "frameidentity" + feel the fields "Vendor", "Type Code", "Repair Center Code"
        switchToIFrame(driver, editPurchaseRequisition.iFramePR_Identity);
        /*
        vendorTypeCodeRepairCenterTable.sendTextTOVendorTypeCodeRepeairCenterFileds(driver, editPurchaseRequisition.inputFieldVendor, editPurchaseRequisition.stringSpecificVendorCode,
                editPurchaseRequisition.textFieldVendor_Synovos, editPurchaseRequisition.inputFieldTypeCode, editPurchaseRequisition.stringSpecificTypeCode2,
                editPurchaseRequisition.textFieldTypeCode_RegularPO, editPurchaseRequisition.inputFieldRepairCenterCode, editPurchaseRequisition.stringSpecificCenterCode2);
                */
        if(editPurchaseRequisition.inputFieldVendor.isEnabled() == true){
            sendTextToWebElementFromDropDownList(editPurchaseRequisition.inputFieldVendor, editPurchaseRequisition.stringSpecificVendorCode); // Send Vendor Code equals to: 00000023652
        } else {
            waitElementPresence(driver, 5, editPurchaseRequisition.inputFieldVendor);
            sendTextToWebElementFromDropDownList(editPurchaseRequisition.inputFieldVendor, editPurchaseRequisition.stringSpecificVendorCode);
        }
        waitElementAttributeShouldHaveValue(driver, 5, editPurchaseRequisition.textFieldVendor_Synovos, "value", "Synovos");
        sendTextToWebElementFromDropDownList2(editPurchaseRequisition.inputFieldTypeCode, "PO", editPurchaseRequisition.stringSpecificTypeCode2, driver); // Send Type Code equals to: PO
        waitElementAttributeShouldHaveValue(driver, 10, editPurchaseRequisition.textFieldTypeCode_RegularPO, "value", "Regular PO");
        sendTextToWebElementFromDropDownList2(editPurchaseRequisition.inputFieldRepairCenterCode, "FS", editPurchaseRequisition.stringSpecificCenterCode2, driver); // Send Repair Center Code equals to: FS


        // Click button "Items" + switch to Purchase Requisition Entry pop-up + feel the fields "Account", "Part Code", "Quantity", "Unit Coast"
        clickWebElementIfEnable(editPurchaseRequisition.buttonAddItems);
        switchToIFrame(driver, editPurchaseRequisition.iFramePurchRequisitionDialog);
        sendTextToWebElementFromDropDownList(editPurchaseRequisition.fieldAccount, editPurchaseRequisition.stringSpecificAccount); //sendTextToWebElement(editPurchaseRequisition.fieldAccount, "030-89000-6902");
        logger.info("Send text to WebElement - Account: \"030-89000-6902\"");
        sendTextToWebElementFromDropDownList(editPurchaseRequisition.dropboxPartCode,editPurchaseRequisition.stringSpecificPartCode); //sendTextToWebElement(editPurchaseRequisition.dropboxPartCode, "180017");
        logger.info("Send text to WebElement - Part Code: \"180017\"");
        waitElementPresence(driver, 10, editPurchaseRequisition.filedQuatity);
        sendTextToWebElement(editPurchaseRequisition.filedQuatity, "100");
        waitElement(driver, 10);
        if (editPurchaseRequisition.fieldCoast.getText() == "8.3400"){
            clickButtonIfEnable(editPurchaseRequisition.buttonSaveAndClose);
        } else {
            waitElementAttributeShouldHaveValue(driver, 5, editPurchaseRequisition.fieldCoast, "value", "8.3400");
            clickButtonIfEnable(editPurchaseRequisition.buttonSaveAndClose);
        }

        // Click button "Expand" after that click button "Add Distribution" - ADD DISTRIBUTION
        driver.switchTo().parentFrame();
        clickButtonIfEnable(editPurchaseRequisition.buttonExpendIntoItemsTable);
        clickButtonIfEnable(editPurchaseRequisition.buttonAddDistribution);

        // Send text ot the fields: "Work Order", "Task", "Required Qty"
        switchToIFrame(driver, editPurchaseRequisition.iFrameDistributionDialogPO);
        sendTextToWebElementFromDropDownList(editPurchaseRequisition.fieldWorkOrder, editPurchaseRequisition.stringWorkOrderElement);
        if (editPurchaseRequisition.fieldTask.getText() == "FLS05-General Fire/Life Safety"){
            sendTextToWebElement(editPurchaseRequisition.fieldRequiredQty, "100");
        } else {
            waitElementAttributeShouldHaveValue(driver, 10, editPurchaseRequisition.fieldTask, "value", "1728");
            sendTextToWebElement(editPurchaseRequisition.fieldRequiredQty, "100");
        }
        clickButtonIfEnable(editPurchaseRequisition.buttonSaveAndCloseDistributionEntry);

        //
        driver.switchTo().defaultContent();
        switchToIFrame(driver, editPurchaseRequisition.iFrameMain);
        clickWebElementIfEnable(editPurchaseRequisition.buttonSaveMain);
        switchToIFrame(driver, editPurchaseRequisition.iFramePR_Identity);
        String a = getTextFromWebElementAttribute(editPurchaseRequisition.purchaseRequisitionNumber);
        //System.out.println("Purchase requisition numder is: " + editPurchaseRequisition.purchaseRequisitionNumber.getAttribute("value"));  //getTextFromWebElement(editPurchaseRequisition.purchaseRequisitionNumber));
        logger.info("++++++++++++++" + " Purchase requisition numder is: " + editPurchaseRequisition.purchaseRequisitionNumber.getAttribute("value") + "++++++++++++++");

        driver.switchTo().defaultContent();
        clickButtonIfEnable(editPurchaseRequisition.buttonAuthorize);
        driver.switchTo().parentFrame();
        switchToIFrame(driver, editPurchaseRequisition.iFrameMain);
        switchToIFrame(driver, editPurchaseRequisition.iFramePurchaseRequisitionAuthorization);
        clickButtonIfEnable(editPurchaseRequisition.buttonAuthorizePurchaseRequisitionAuthorization);

        driver.switchTo().defaultContent();
        editPurchaseRequisition.fieldSearch.sendKeys(a);
        clickButtonIfEnable(editPurchaseRequisition.buttonSearch);
        if (editPurchaseRequisition.buttonExport.isEnabled() != true){
            waitElementPresence(driver, 5, editPurchaseRequisition.buttonExport);
            clickButtonIfEnable(editPurchaseRequisition.buttonExport);
        } else {
            clickButtonIfEnable(editPurchaseRequisition.buttonExport);
        }


        switchToIFrame(driver, editPurchaseRequisition.iFrameMain);
        clickButtonIfEnable(editPurchaseRequisition.buttonOkExportPurchaseRequsition);
        //System.out.println("Text is: " + driver.switchTo().activeElement().getText());

        logger.info("The Requisition was successfully created and scheduled to be exported.");
        logger.info("----------------------------------------------------------------------------------------------------------------------");
        //Assert.assertEquals("Home  | User:VBIBIK18  | Logout", loginPageLocators.userNickName.getText());

    }
}
