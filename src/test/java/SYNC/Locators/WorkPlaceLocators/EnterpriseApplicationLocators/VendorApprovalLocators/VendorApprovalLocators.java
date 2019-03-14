package SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.VendorApprovalLocators;

import SYNC.Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VendorApprovalLocators extends LoginPageLocators {
    public VendorApprovalLocators(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Vendor Approval']")
    public WebElement headerText; //+++
    @FindBy (xpath = "//div[@class='jsgrid-grid-header jsgrid-header-scrollbar']//table[@class='jsgrid-table']//a[@id='a_export']")
    public WebElement buttonExportToExcelPGTManufactureFocused; //+++
    @FindBy (xpath = "//select[@onchange='action.methods.changeGridRecordsPerPage(parseInt(this.value,10))']")
    public WebElement dropDownListRecordsPerPage; //+++
    @FindBy (xpath = "//div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']/tbody//tr[last()]/td[3]/div[1]/a[1]")
    public WebElement lastClickableElementInTable;
}
