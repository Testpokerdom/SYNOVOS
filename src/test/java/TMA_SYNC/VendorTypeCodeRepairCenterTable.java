package TMA_SYNC;

import TMA_SYNC.Locators.EditPurchaseRequisition;
import TMA_SYNC.Locators.LoginPageLocators;
import TMA_SYNC.Tests.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.sendTextToWebElementFromDropDownList2;

public class VendorTypeCodeRepairCenterTable{

    //public EditPurchaseRequisition editPurchaseRequisition = new EditPurchaseRequisition();


    public void sendTextTOVendorTypeCodeRepeairCenterFileds(WebDriver driver, WebElement fieldVendor, WebElement stringVendorCode, WebElement stringVendor_Synovos, WebElement typeCode, WebElement stringTypeCode, WebElement stringTypeCode_PO, WebElement fieldRepairCenterCode, WebElement stringRepairCenterCode){

        if(fieldVendor.isEnabled() == true){
            sendTextToWebElementFromDropDownList(fieldVendor, stringVendorCode); // Send Vendor Code equals to: 00000023652
        } else {
            waitElementPresence(driver, 5, fieldVendor);
            sendTextToWebElementFromDropDownList(fieldVendor, stringVendorCode);
        }
        waitElementAttributeShouldHaveValue(driver, 5, stringVendor_Synovos, "value", "Synovos");
        sendTextToWebElementFromDropDownList2(typeCode, "PO", stringTypeCode, driver); // Send Type Code equals to: PO
        waitElementAttributeShouldHaveValue(driver, 10, stringTypeCode_PO, "value", "Regular PO");
        sendTextToWebElementFromDropDownList2(fieldRepairCenterCode, "FS", stringRepairCenterCode, driver); // Send Repair Center Code equals to: FS

    }

}
