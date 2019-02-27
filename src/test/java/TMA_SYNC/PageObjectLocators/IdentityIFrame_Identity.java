package TMA_SYNC.PageObjectLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IdentityIFrame_Identity extends MainPage{

    public IdentityIFrame_Identity(WebDriver driver){
        super(driver);
    }

    // Iframe Identity locator
    @FindBy(id = "frameidentity")
    public WebElement iFramePR_Identity;

    // IFrame Identity elements
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
    public WebElement buttonItems;
}
