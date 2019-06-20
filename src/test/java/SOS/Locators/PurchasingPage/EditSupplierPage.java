package SOS.Locators.PurchasingPage;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static WebHelpers.GettersAndSetters.getSupplierName;

public class EditSupplierPage  extends SearchSuppliersPage {
    public static final Logger logger = LogManager.getLogger(EditSupplierPage.class);
    public EditSupplierPage(WebDriver driver){

        super(driver);
    }

    //Main table
    @FindBy (xpath = "//table[@class='datagrid gradientElement2']//tr[2]/td[2]")
    public WebElement fieldSupplierName;
    @FindBy (id = "requestedPaymentTerms")
    public WebElement dropDownListRequestedPaymentTerms;
    @FindBy (id = "sendPaymentTermsForApproval")
    public WebElement buttonSendForApprovalPaymentTerms;
    @FindBy (xpath = "//form[@id='supplierCRUDForm']//table[@class='datagrid gradientElement2']//tr[17]//td[2]")
    //@FindBy (id = "supplier.tbdSupplier")
    public WebElement fieldTBDSupplier;
    @FindBy (id = "primaryContact.name")
    public WebElement fieldContactName;
    @FindBy (id = "primaryContact.phone")
    public WebElement fieldContactPhone;
    @FindBy (id = "primaryContact.email")
    public WebElement fieldContactEmail;


    //JDE Vendor elements
    @FindBy(id = "jdeVendor")
    public WebElement dropdown_listJDE_Vendor;
    @FindBy (xpath = "//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']//li[1]")
    public WebElement jdeVendor2;
    @FindBy(xpath = "//form[@id='supplierCRUDForm']//div[4]//input[@name='save']")
    public WebElement buttonSave;

    //Pop-up window
    @FindBy (xpath = "//span[text()='OK']")
    public WebElement buttonOkPopUpWindow;
    @FindBy (id = "approvalCommentsHolder")
    public WebElement fieldCommentsInPopUpWindow;

    //Error messages
    @FindBy (xpath = "//div[@class='error alignCenter']")
    public WebElement headerErorMessage;
    @FindBy (xpath = "//span[@id='supplier.jdeVendor.errors']")
    public WebElement fieldJDEVendorErrorMessage;
    @FindBy (id = "errors")
    public WebElement paymentTermsErrorInHeader;
    @FindBy (id = "supplier.requestedPaymentTerms.errors")
    public WebElement fieldRequestedpaymentTermsErrorMessage;


    public static void supplierNameLogged(){
        System.out.println(getSupplierName());
        logger.info(getSupplierName());
        logger.info("----");
    }

}
