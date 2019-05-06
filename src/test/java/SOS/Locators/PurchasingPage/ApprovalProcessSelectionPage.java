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
    @FindBy (xpath = "//th[@id='filterFor_siteName']//select[@class='filter']")
    public WebElement dropdownlistSiteName;
    @FindBy (xpath = "//table[@id='approvalProcessData']/tbody/tr[last()]/td")
    public WebElement getTextFromLastRowInTable;
    @FindBy (xpath = "//table[@id='approvalProcessData']/tbody/tr[last()]/td[4]")
    public WebElement fieldApprovalTypeLastString;
    @FindBy (xpath = "//table[@id='approvalProcessData']/tbody/tr[last()]/td[10]")
    public WebElement fielsComments;


    // Text for Asser/assetEqual
    @FindBy (xpath = "//div[@class='pageHeader']")
    public WebElement textInHeader;

}
