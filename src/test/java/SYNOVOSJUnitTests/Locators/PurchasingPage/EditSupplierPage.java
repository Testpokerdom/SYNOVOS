package SYNOVOSJUnitTests.Locators.PurchasingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSupplierPage  extends SearchSuppliersPage {
    public EditSupplierPage(WebDriver driver){

        super(driver);
    }

    @FindBy(id = "jdeVendor")
    public WebElement dropdown_listJDE_Vendor;
    @FindBy (xpath = "//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']//li[1]")
    public WebElement jdeVendor2;
    @FindBy(xpath = "//form[@id='supplierCRUDForm']//div[4]//input[@name='save']")
    public WebElement buttonSave;

    //Pop-up window
    @FindBy (xpath = "//span[text()='OK']")
    public WebElement buttonOkPopUpWindow;
}
