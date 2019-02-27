package TMA_SYNC.PageObjectLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurcaseOrderDistributionIFrame_DistributionEntry extends MainPage{

    public PurcaseOrderDistributionIFrame_DistributionEntry(WebDriver driver){
        super(driver);
    }

    // IFrame locator
    @FindBy (name = "PurchaseOrderDistributionDialog")
    public WebElement iFrameDistributionDialogPO;

    // IFrame elements
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
}
