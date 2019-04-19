package SYNOVOSJUnitTests.Locators.PurchasingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupplierDetailPage extends CreateSupplierPage {

    public SupplierDetailPage (WebDriver driver){
        super(driver);
    }

    // Header buttons
    @FindBy (name = "backToList")
    public WebElement buttonGoBack;
    @FindBy (name = "newSearch")
    public WebElement buttonSearch;
    @FindBy (name = "delete")
    public WebElement buttonDelete;
    @FindBy (name = "editSupplier")
    public WebElement buttonEdit;



    //Saved User details from the Table
    @FindBy (xpath = "//table[@class='datagrid']/tbody[1]//td[contains(text(),'Supplier No:')]/following-sibling::td[1]")
    public WebElement fieldSupplierNumber;
    @FindBy (xpath = "//form[@id='command']//table//tbody//tr[24]/td[2]")
    public WebElement fieldApprovalStatus;
    @FindBy (xpath = "//form[@id='command']//table//tbody//tr[27]/td[2]")
    public WebElement fieldApprovalNotes;
    @FindBy (xpath = "//form[@id='command']//table//tbody//tr[29]/td[2]")
    public WebElement fieldRemitTo;
    @FindBy (xpath = "//form[@id='command']//table//tbody//tr[30]/td[2]")
    public WebElement fieldProvidedW9;
    @FindBy (xpath = "//form[@id='command']//input[@name='approve']")
    public WebElement buttonSendForApproval;

    //Pop-up window details
    @FindBy (id = "approvalCommentsHolder")
    public WebElement fieldCommnets;
    @FindBy (xpath = "//div[@class='ui-dialog-buttonset']//span[text()='OK']")
    public WebElement buttonOk;
    @FindBy (xpath = "//div[@class='ui-dialog-buttonset']//span[text()='Cancel']")
    public WebElement buttonCancel;

}
