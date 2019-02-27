package TMA_SYNC.PageObjectLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static WebHelpers.WebHelpers.*;

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

    public void switchToIFrameDistributionDialogPOAndFillFields_WorkOrderAndRequiredQty(WebDriver driver, String requiredQuantity){
        switchToIFrame(driver, iFrameDistributionDialogPO);
        sendTextToWebElementFromDropDownList(fieldWorkOrder, stringWorkOrderElement);
        if (fieldTask.getText() == "FLS05-General Fire/Life Safety"){
            sendTextToWebElement(fieldRequiredQty, requiredQuantity);
        } else {
            waitElementAttributeShouldHaveValue(driver, 10, fieldTask, "value", "1728");
            sendTextToWebElement(fieldRequiredQty, requiredQuantity);
        }
        clickButtonIfEnable(buttonSaveAndCloseDistributionEntry);
    }
}
