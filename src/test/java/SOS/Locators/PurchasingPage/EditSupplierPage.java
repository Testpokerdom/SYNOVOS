package SOS.Locators.PurchasingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSupplierPage  extends SearchSuppliersPage {
    public EditSupplierPage(WebDriver driver){

        super(driver);
    }

    //Main table
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
}
