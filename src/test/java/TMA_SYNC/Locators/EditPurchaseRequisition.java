package TMA_SYNC.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static WebHelpers.WebHelpers.*;

public class EditPurchaseRequisition extends LoginPageLocators {

    public EditPurchaseRequisition (WebDriver driver){
        super(driver);
    }

    // Upper toolbar elements

    @FindBy (linkText = "Add")
    public WebElement buttonAdd2;
    @FindBy (xpath = "//div[@id='UserToolbar']//a[@title='Add']") //  //a[@title='Add']//img[@class='rtbIcon'] //div[@id='UserToolbar']//a[@title='Add']//span[text()='Add'] //div[@id='UserToolbar']//span[text()='Add']
    public WebElement buttonAdd;
    @FindBy (xpath = "//span[contains(text(),'Edit')]")
    public WebElement buttonEdit;
    @FindBy (xpath = "//span[contains(text(),'Prev')]")
    public WebElement buttonPrev;
    @FindBy (xpath = "//a[@title='Next']//img[@class='rtbIcon']")
    public WebElement buttonNext;
    @FindBy (xpath = "//div[@id='UserToolbar']//img[@alt='Save']")
    public WebElement buttonSaveMain;
    @FindBy (id = "txtFastFind")
    public WebElement fieldSearch;
    @FindBy (id = "btnFastFind")
    public WebElement buttonSearch;

    // Different Iframes add/edit/save
    @FindBy (id = "RadWindowWrapper_BookmarkEntry")
    public WebElement iframeBookmarkEntry;
    @FindBy (id ="dynIFrame")
    public WebElement iframeGeneralForToolbarElements;
    @FindBy (id = "mainFrame")
    public WebElement iFrameMain;
    @FindBy (id = "frameidentity")
    public WebElement iFramePR_Identity;
    @FindBy (name = "PurchReqDialog")
    public WebElement iFramePurchRequisitionDialog;
    @FindBy (name = "alert1550146698615")
    public  WebElement iFrameWarningMassege;
    @FindBy (name = "PurchaseOrderDistributionDialog")
    public WebElement iFrameDistributionDialogPO;
    @FindBy (name = "RoutingWindow")
    public WebElement iFramePurchaseRequisitionAuthorization;
    @FindBy (name = "confirm1550751353006")
    public WebElement iFrameExportPR;

    @FindBy (id = "btnSave")
    public WebElement buttonSaveInBookmarkEntry;

    // Iframe Purchase requisition elements
    @FindBy (id = "txtVendorCode_ComboBox_Input") // txtVendorCode_ComboBox
    public WebElement inputFieldVendor;
    @FindBy (xpath = "//div[@id='txtVendorCode_ComboBox_DropDown']//li[text()='00000023652']")
    public WebElement stringSpecificVendorCode;
    @FindBy (xpath = "//div[@id='RadMultiPage1']//input[@name='txtVendorName']")
    public WebElement textFieldVendor_Synovos;
    @FindBy (id = "txtVendorCode_ComboBox_DropDown")
    public WebElement drop_down_list_Vendor;
    @FindBy (id ="txtType_ComboBox_Input")
    public WebElement inputFieldTypeCode;
    @FindBy (xpath = "//div[@id='txtType_ComboBox_DropDown']//li[5]")  //div[@id='txtType_ComboBox_DropDown']//li[text()='PO']  ||  //div[@id='txtType_ComboBox_DropDown']//li[5]
    public WebElement stringSpecificTypeCode;
    @FindBy (xpath = "//div[@id='txtType_ComboBox_DropDown']//li[text()='PO']")
    public WebElement stringSpecificTypeCode2;
    @FindBy (xpath = "//div[@id='RadMultiPage1']//input[@name='txtTypeDesc']")
    public WebElement textFieldTypeCode_RegularPO;
    @FindBy (id ="txtRepairCenter_ComboBox_Input")
    public WebElement inputFieldRepairCenterCode;
    @FindBy (xpath = "//div[@id='txtRepairCenter_ComboBox_DropDown']//li[3]")
    public WebElement stringSpecificCenterCode;
    @FindBy (xpath = "//div[@id='txtRepairCenter_ComboBox_DropDown']//li[text()='FS']")
    public WebElement stringSpecificCenterCode2;
    @FindBy (id = "txtRequisition")
    public WebElement purchaseRequisitionNumber;
    @FindBy (id = "grdPR_ctl00_ctl02_ctl00_lblAddItem")
    public WebElement buttonAddItems;

    // Button Items elements inside Purchase Requisition Iframe
    @FindBy (id = "grdPR_ctl00_ctl04_GECBtnExpandColumn")
    public WebElement buttonExpendIntoItemsTable;
    @FindBy (id = "grdPR_ctl00_ctl05_Detail10_ctl02_ctl00_lblAddDistribution")
    public WebElement buttonAddDistribution;

    // IFrame Purchase Requisition entry elements
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

    // IFrame Distribution (Dialog) Entry elements
    @FindBy(id = "txtWONumber_ComboBox_Input")
    public WebElement fieldWorkOrder;
    @FindBy(xpath = "//div[@id='txtWONumber_ComboBox_DropDown']//li[text()='FS-10625']")
    public WebElement stringWorkOrderElement;
    @FindBy (id = "DDLTask")
    public WebElement fieldTask;
    @FindBy(id = "txtRequiredQty")
    public WebElement fieldRequiredQty;
    @FindBy(id = "txtOrderQty")
    public WebElement fieldOrderedQuentity;
    @FindBy (id = "btnSave")
    public WebElement buttonSaveAndCloseDistributionEntry;
    @FindBy (id = "btnCancel")
    public WebElement buttonCancelDistributionEntry;

    // IFrame Purchase Requisition Authorization elements:
    @FindBy (id = "btnAuthorize")
    public WebElement buttonAuthorizePurchaseRequisitionAuthorization;
    @FindBy (id = "btnRejectRouting")
    public WebElement buttonRejectPurchaseRequisitionAuthorization;
    @FindBy (id = "btnIgnore")
    public WebElement buttonIgnorePurchaseRequisitionAuthorization;

    // "Action Menu" elements:
    @FindBy (xpath = "//div[@id='RadPanelbar1']//span[text()='Authorize']")
    public WebElement buttonAuthorize;
    @FindBy (xpath = "//div[@id='RadPanelbar1']//span[text()='Export']")
    public WebElement buttonExport;

    //Export Purchase Requisition pop-up elements
    @FindBy (xpath = "//div[@class='rwDialogPopup radconfirm']//span[text()='OK']")  //div[@id='confirm1550751353006_content']//span[text()='OK']
    public WebElement buttonOkExportPurchaseRequsition;
    @FindBy (xpath = "//div[@id='confirm1550751353006_content']//span[text()='Cancel']")
    public WebElement buttonCancelExportPurchaseRequsition;


    // Warning pop-up for IFrame Purchase Requisition entry elements
    @FindBy (id = "RadWindowWrapper_alert1550146698615")
    public WebElement pop_up_Warning;
    @FindBy (xpath = "//div[@id='alert1550146698615_content']//span[@class='rwInnerSpan']")
    public WebElement buttonOKInWarningPopUp;


    public void clickOnTheWebElementIfPresents(){

        if (isElementEnabled(iframeBookmarkEntry) == true){
            if (isElementEnabled(buttonSaveInBookmarkEntry)){
            clickElement(buttonSaveInBookmarkEntry);
            }
        } else {
            buttonAdd.click();
        }
    }

    public void waitElementAttributeShouldHaveValue(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.attributeContains(fieldCoast, "value", "8.3400"));
    }

    public void sendTextToTheFiledRequiredQtyReceivedFromTheFiledOrdered(){
        String fieldordered = fieldOrderedQuentity.getText();
        System.out.println(fieldordered);
        fieldRequiredQty.sendKeys(fieldordered);
    }

}
