package TMA_SYNC.PageObjectLocators;

import TMA_SYNC.Tests.CreatePurchaseRequisition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButtonIfEnable;

public class PurchReqDialogIFrame_PurchaseRequisitionEntry extends MainPage {

    public PurchReqDialogIFrame_PurchaseRequisitionEntry(WebDriver driver){

        super(driver);
    }

    public static final Logger logger = LogManager.getLogger(PurchReqDialogIFrame_PurchaseRequisitionEntry.class);

    // IFrame locator
    @FindBy(name = "PurchReqDialog")
    public WebElement iFramePurchRequisitionDialog;

    // IFrame elements
    @FindBy (id = "txtAccount_ComboBox_Input")
    public WebElement fieldAccount;
    @FindBy (xpath = "//div[@id='txtAccount_ComboBox_DropDown']//li[text()='030-89000-6902']")
    public WebElement stringSpecificAccount;
    @FindBy (id = "txtPartCode_ComboBox_Input")
    public WebElement dropboxPartCode;
    @FindBy (xpath = "//div[@id='txtPartCode_ComboBox_DropDown']//li[text()='012203']")
    public WebElement stringSpecificPartCode;
    @FindBy (id = "txtQuantity")
    public WebElement filedQuatity;
    @FindBy (id = "txtUnitCost")
    public WebElement fieldCoast;
    @FindBy (id = "btnSave")
    public WebElement buttonSaveAndClose;
    @FindBy (id = "btnCancel")
    public WebElement buttonCancel;

    public void switchToIFramePurchReqDialogAndFillFieldsAccountPartCodeQuantityAndUnitCost(WebDriver driver, String quantity){
        switchToIFrame(driver, iFramePurchRequisitionDialog);
        sendTextToWebElementFromDropDownList(fieldAccount, stringSpecificAccount); //sendTextToWebElement(editPurchaseRequisition.fieldAccount, "030-89000-6902");
        logger.info("Send text to WebElement - Account: \"030-89000-6902\"");
        sendTextToWebElementFromDropDownList(dropboxPartCode,stringSpecificPartCode); //sendTextToWebElement(editPurchaseRequisition.dropboxPartCode, "180017");
        logger.info("Send text to WebElement - Part Code: \"180017\"");
        waitElementPresence(driver, 10, filedQuatity);
        sendTextToWebElement(filedQuatity, quantity);
        waitElement(driver, 10);
        if (fieldCoast.getText() == "8.3400"){
            clickButtonIfEnable(buttonSaveAndClose);
        } else {
            waitElementAttributeShouldHaveValue(driver, 5, fieldCoast, "value", "8.3400");
            clickButtonIfEnable(buttonSaveAndClose);
        }
    }
}
