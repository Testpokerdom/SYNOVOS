package SYNOVOSJUnitTests.Locators.PurchasingPage;

import SYNOVOSJUnitTests.Locators.LoginPage.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchSuppliersPage extends LoginPageLocators {

    public SearchSuppliersPage(WebDriver driver){
        super(driver);
    }

    // "Search Suppliers" page elements
    @FindBy (xpath = "//form[@id='supplierSearchCriteria']//div[2]//input[1]")
    public WebElement buttonSearch;
    @FindBy (xpath = "//form[@id='supplierSearchCriteria']//div[2]//input[2]")
    public WebElement buttonCancel;
    @FindBy (xpath = "//form[@id='supplierSearchCriteria']//div[2]//input[3]")
    public WebElement buttonCreate;

    //Fill elements for Supplier search
    @FindBy (id = "siteCode")
    public WebElement dropdownListSiteCode;
    @FindBy (id = "number")
    public WebElement fieldNumber;
    @FindBy (id = "supplierNameCriterion")
    public WebElement fieldSupplierNameCriterion;
    @FindBy (id = "notes")
    public WebElement fieldNotes;
    @FindBy (id = "jdeVendor")
    public WebElement fieldJdeVendor;
    @FindBy (id = "activeOption1")
    public WebElement radiobuttonActiveStatus;
    @FindBy (id = "activeOption2")
    public WebElement radiobuttonInActiveStatus;
    @FindBy (id = "activeOption3")
    public WebElement radiobuttonAllStatus;





}
