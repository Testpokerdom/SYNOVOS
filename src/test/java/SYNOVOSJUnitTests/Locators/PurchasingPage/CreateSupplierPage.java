package SYNOVOSJUnitTests.Locators.PurchasingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static SYNOVOSJUnitTests.WebHelpers.WebHelpers.*;

public class CreateSupplierPage extends SearchSuppliersPage {

    public CreateSupplierPage(WebDriver driver){

        super(driver);
    }


    // Create Supplier page
    @FindBy(xpath = "//form[@id='command']//div[1]//input[1]")
    public WebElement buttonSave;
    @FindBy(xpath = "//form[@id='command']//div[1]//input[2]")
    public WebElement buttonSandForApproval;
    @FindBy(xpath = "//form[@id='command']//div[1]//input[3]")
    public WebElement buttonCancel;

    // Main info user Table
    @FindBy (id = "supplierName")
    public WebElement fieldSupplierName;
    @FindBy (id = "supplier.toBeSetAsEmergencyOrderSupplier1")
    public WebElement checkboxEmergency;
    @FindBy (id = "primaryContact.name")
    public WebElement fieldContactName;
    @FindBy (id = "primaryContact.phone")
    public WebElement fieldContactPhone;
    @FindBy (id = "primaryContact.email")
    public WebElement fieldContactEmail;
    @FindBy (id = "jdeVendor")
    public WebElement dropdown_listJDE_Vendor;

    // Pop-up confirm/declame user creation
    @FindBy (id= "approvalCommentsHolder")
    public WebElement fieldComments;
    @FindBy (xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-dialog-buttons']//span[contains(text(),'OK')]")
    public WebElement buttonOKpopup;
    @FindBy (xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-dialog-buttons']//span[contains(text(),'Cancel')]")
    public WebElement buttonCancelpopup;

    // Supplier Details page
    @FindBy (xpath = "//div[@id='main']//div[@class='pageHeader']")
    public WebElement textSupplierDetails;

    public void fillUserDataTableAndSendForApproval(String fieldSupplierName, String fieldContactName, String fieldContactPhone, String fieldContactEmail, String filedComment){
        this.fieldSupplierName.sendKeys(fieldSupplierName + getCurrentTimeUsingCalendar2() + "_"  + randomName2());
        this.fieldContactName.sendKeys(randomName2());
        this.fieldContactPhone.sendKeys(fieldContactPhone);
        this.fieldContactEmail.sendKeys(randomName2() + fieldContactEmail);
        buttonSandForApproval.click();
        fieldComments.sendKeys(filedComment);

    }

    public void fillUserDataTableAndSave(String fieldSupplierName, String fieldContactName, String fieldContactPhone, String fieldContactEmail, String filedComment){
        this.fieldSupplierName.sendKeys(fieldSupplierName + getCurrentTimeUsingCalendar2() + "_" + randomName2());
        this.fieldContactName.sendKeys(randomName2());
        this.fieldContactPhone.sendKeys(fieldContactPhone);
        this.fieldContactEmail.sendKeys(randomName2() + fieldContactEmail);

        buttonSave.click();
    }

    public void fillUserDataEmergencySupplier(String fieldSupplierName, String fieldContactPhone, String fieldContactEmail, String filedComment){
        this.fieldSupplierName.sendKeys(fieldSupplierName + getCurrentTimeUsingCalendar2() + "_"  + randomName2());
        checkboxEmergency.click();
        this.fieldContactName.sendKeys(randomName2());
        this.fieldContactPhone.sendKeys(fieldContactPhone);
        this.fieldContactEmail.sendKeys(randomName2() + fieldContactEmail);
        buttonSandForApproval.click();
        fieldComments.sendKeys(filedComment);
    }
}
