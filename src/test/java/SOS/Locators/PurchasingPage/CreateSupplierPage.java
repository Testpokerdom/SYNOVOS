package SOS.Locators.PurchasingPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static SOS.WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButton;

public class CreateSupplierPage extends SearchSuppliersPage {

    public static final Logger logger = LogManager.getLogger(CreateSupplierPage.class);

    public CreateSupplierPage(WebDriver driver){

        super(driver);
    }


    // Create Supplier page
    @FindBy(xpath = "//form[@id='supplierCRUDForm']//div[4]//input[@name='save']")
    public WebElement buttonSave;
    @FindBy(xpath = "//form[@id='supplierCRUDForm']//div[4]//input[@name='approve']") //div[3]//input[2] //form[@id='supplierCRUDForm']//div[4]//input[@name='approve']
    //@FindBy (css = "div:nth-child(2) div:nth-child(5) form:nth-child(1) div:nth-child(16) > input.approveButton:nth-child(2)")
    public WebElement buttonSendForApproval;
    @FindBy(xpath = "//form[@id='command']//div[1]//input[3]")
    public WebElement buttonCancel;

    // Main info user Table
    @FindBy (id = "supplierName")
    public WebElement fieldSupplierName;
    @FindBy (id = "tbdSupplier")
    public WebElement checkBoxTBD;
    @FindBy (id = "primaryContact.name")
    public WebElement fieldContactName;
    @FindBy (id = "primaryContact.phone")
    public WebElement fieldContactPhone;
    @FindBy (id = "primaryContact.email")
    public WebElement fieldContactEmail;
    @FindBy (id = "jdeVendor")
    public WebElement dropdown_listJDE_Vendor;
    @FindBy (id = "ui-id-264")
    public WebElement jdeVendorNumber;
    @FindBy (xpath = "//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']//li[1]")
    public WebElement jdeVendor2;
    @FindBy (id = "supplier.remitTo")
    public WebElement fieldRemitTo;
    @FindBy (id = "supplier.providedW91")
    public WebElement checkBoxProvidedW9;

    // Pop-up confirm/declame user creation
    @FindBy (id= "approvalCommentsHolder")
    public WebElement fieldComments;
    @FindBy (xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-dialog-buttons']//span[contains(text(),'OK')]")
    public WebElement buttonOKpopup;
    @FindBy (id = "emergencyHolder")
    public WebElement checkBoxEmergency;
    @FindBy (xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-dialog-buttons']//span[contains(text(),'Cancel')]")
    public WebElement buttonCancelpopup;

    // Supplier Details page
    @FindBy (xpath = "//div[@id='main']//div[@class='pageHeader']")
    public WebElement textSupplierDetails;


    public static void chooseJDEVendor(WebElement element, String jdeVendor, WebElement jdeVendorNumber){
        sendTextToWebElement(element, jdeVendor);
        clickElement(jdeVendorNumber);

    }

    public void fillUserDataTableAndSendForApproval(String remitTo, String fieldSupplierName, String fieldContactName, String fieldContactPhone, String fieldContactEmail, String filedComment){
        fieldRemitTo.sendKeys(remitTo);
        logger.info("Field Remit To was field by value" + getTextFronWebElement(fieldRemitTo));
        checkBoxProvidedW9.click();
        this.fieldSupplierName.sendKeys(fieldSupplierName + getCurrentTimeUsingCalendar2() + "_"  + randomName2());
        this.fieldContactName.sendKeys(randomName2());
        this.fieldContactPhone.sendKeys(fieldContactPhone);
        this.fieldContactEmail.sendKeys(randomName2() + fieldContactEmail);
        //buttonSendForApproval.click();
        //fieldComments.sendKeys(filedComment);

    }
    public void fillUserDataTableAndSave2(String remitTo, String fieldSupplierName, String fieldContactName, String fieldContactPhone, String fieldContactEmail){
        fieldRemitTo.sendKeys(remitTo);
        logger.info("Field Remit To was field by value" + getTextFronWebElement(fieldRemitTo));
        checkBoxProvidedW9.click();
        this.fieldSupplierName.sendKeys(fieldSupplierName + getCurrentTimeUsingCalendar2() + "_"  + randomName2());
        this.fieldContactName.sendKeys(randomName2());
        this.fieldContactPhone.sendKeys(fieldContactPhone);
        this.fieldContactEmail.sendKeys(randomName2() + fieldContactEmail);
        dropdown_listJDE_Vendor.sendKeys("1045000");
        jdeVendor2.click();
        //clickButton(buttonSendForApproval);
        //fieldComments.sendKeys(filedComment);
        //buttonSave.click();
    }

    public void fillUserDataTableAndSave3_TBD_Supplier(String remitTo, String fieldSupplierName, String fieldContactName, String fieldContactPhone, String fieldContactEmail){
        fieldRemitTo.sendKeys(remitTo);
        logger.info("Field Remit To was field by value" + getTextFronWebElement(fieldRemitTo));
        checkBoxProvidedW9.click();
        this.fieldSupplierName.sendKeys(fieldSupplierName + getCurrentTimeUsingCalendar2() + "_"  + randomName2());
        checkBoxTBD.click();
        System.out.println("Is button send for approval is enable on the Create Supplier page: " + buttonSendForApproval.isEnabled());
        Assert.assertTrue(buttonSendForApproval.isEnabled() == false);
        this.fieldContactName.sendKeys(randomName2());
        this.fieldContactPhone.sendKeys(fieldContactPhone);
        this.fieldContactEmail.sendKeys(randomName2() + fieldContactEmail);
        dropdown_listJDE_Vendor.sendKeys("1045000");
        jdeVendor2.click();
        //clickButton(buttonSendForApproval);
        //fieldComments.sendKeys(filedComment);
        //buttonSave.click();
    }

    public void fillUserDataTableAndSave(String fieldSupplierName, String fieldContactName, String fieldContactPhone, String fieldContactEmail, String filedComment){
        this.fieldSupplierName.sendKeys(fieldSupplierName + getCurrentTimeUsingCalendar2() + "_" + randomName2());
        this.fieldContactName.sendKeys(randomName2());
        this.fieldContactPhone.sendKeys(fieldContactPhone);
        this.fieldContactEmail.sendKeys(randomName2() + fieldContactEmail);

        buttonSave.click();
    }

    public void fillUserDataEmergencySupplier(String remitTo, String fieldSupplierName, String fieldContactPhone, String fieldContactEmail, String filedComment){
        fieldRemitTo.sendKeys(remitTo);
        logger.info("Field Remit To was field by value" + getTextFronWebElement(fieldRemitTo));
        checkBoxProvidedW9.click();
        this.fieldSupplierName.sendKeys(fieldSupplierName + getCurrentTimeUsingCalendar2() + "_"  + randomName2());
        this.fieldContactName.sendKeys(randomName2());
        this.fieldContactPhone.sendKeys(fieldContactPhone);
        this.fieldContactEmail.sendKeys(randomName2() + fieldContactEmail);
        dropdown_listJDE_Vendor.sendKeys("1045000");
        jdeVendor2.click();
        clickButton(buttonSendForApproval);
        fieldComments.sendKeys(filedComment);
        clickElement(checkBoxEmergency);

    }

}
