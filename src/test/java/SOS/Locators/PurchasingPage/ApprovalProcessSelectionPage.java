package SOS.Locators.PurchasingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApprovalProcessSelectionPage extends SearchSuppliersPage {

    public ApprovalProcessSelectionPage(WebDriver driver){
        super(driver);
    }

    @FindBy (id = "approvalProcessData")
    public WebElement tableSuppliersForApprove;


    // Approval Process Selection table
    @FindBy (xpath = "//th[@id='filterFor_siteCode']//select[@class='filter']")
    public WebElement dropDownListSiteCode;
    @FindBy (xpath = "//th[@id='filterFor_siteName']//select[@class='filter']")
    public WebElement dropdownlistSiteName;
    @FindBy (xpath = "//th[@id='filterFor_supplierName']//select[@class='filter']")
    public WebElement dropDownListSupplierName;
    @FindBy (xpath = "//th[@id='filterFor_approvalProcessLabel']//select[@class='filter']")
    public WebElement dropDownListApprovalType;
    @FindBy (xpath = "//th[@id='filterFor_currentTier']//select[@class='filter']")
    public WebElement dropDownListStage;
    @FindBy (xpath = "//th[@id='filterFor_approvalProcessCreateUser']//select[@class='filter']")
    public WebElement dropDownListCreatedBy;
    @FindBy (xpath = "//th[@id='filterFor_approvalProcessStartDate']//select[@class='filter']")
    public WebElement dropDownListCreatedOn;
    @FindBy (xpath = "//th[@id='filterFor_approvalProcessModifiedUser']//select[@class='filter']")
    public WebElement dropDownListModifiedBy;
    @FindBy (xpath = "filterFor_approvalProcessModifiedDate")
    public WebElement dropDownListModifiedOn;
    @FindBy (xpath = "//div[@id='approvalProcessData_filter']//input[@type='search']")
    public WebElement fieldFilterSearch;
    @FindBy (xpath = "//th[@id='filterFor_supplierName']//select[@class='filter']")
    public WebElement fieldSUpplierNameInTable;



    @FindBy (xpath = "//table[@id='approvalProcessData']/tbody/tr[last()]/td")
    public WebElement getTextFromLastRowInTable;
    @FindBy (xpath = "//table[@id='approvalProcessData']/tbody/tr[last()]/td[4]")
    public WebElement fieldApprovalTypeLastString;
    @FindBy (xpath = "//table[@id='approvalProcessData']/tbody/tr[last()]/td[10]")
    public WebElement fieldCommentsLastString;


    // Text for Asser/assetEqual
    @FindBy (xpath = "//div[@class='pageHeader']")
    public WebElement textInHeader;

}
