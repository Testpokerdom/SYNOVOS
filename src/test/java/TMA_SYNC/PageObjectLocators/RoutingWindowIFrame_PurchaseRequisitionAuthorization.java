package TMA_SYNC.PageObjectLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static WebHelpers.WebHelpers.*;

public class RoutingWindowIFrame_PurchaseRequisitionAuthorization extends MainPage{

    public RoutingWindowIFrame_PurchaseRequisitionAuthorization(WebDriver driver){
        super(driver);
    }

    // IFrame locator
    @FindBy(name = "RoutingWindow")
    public WebElement iFramePurchaseRequisitionAuthorization;

    //IFrame elements
    @FindBy (id = "btnAuthorize")
    public WebElement buttonAuthorizePurchaseRequisitionAuthorization;
    @FindBy (id = "btnRejectRouting")
    public WebElement buttonRejectPurchaseRequisitionAuthorization;
    @FindBy (id = "btnIgnore")
    public WebElement buttonIgnorePurchaseRequisitionAuthorization;

    public void switchToIframePRAutorizationAndClickButtonAutorize(WebDriver driver){
        switchToIFrame(driver, iFramePurchaseRequisitionAuthorization);
        if(buttonAuthorizePurchaseRequisitionAuthorization.isEnabled() != true){
            waitElementPresence(driver,5, buttonAuthorizePurchaseRequisitionAuthorization);
            clickButtonIfEnable(buttonAuthorizePurchaseRequisitionAuthorization);
        } else {
            clickButtonIfEnable(buttonAuthorizePurchaseRequisitionAuthorization);
        }
    }
}
