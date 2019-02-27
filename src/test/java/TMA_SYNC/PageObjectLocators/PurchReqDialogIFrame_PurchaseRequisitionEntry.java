package TMA_SYNC.PageObjectLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchReqDialogIFrame_PurchaseRequisitionEntry extends MainPage {

    public PurchReqDialogIFrame_PurchaseRequisitionEntry(WebDriver driver){
        super(driver);
    }

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
}
