package SOS.Locators.PurchasingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApproveSupplierPage extends SearchSuppliersPage {

    public ApproveSupplierPage (WebDriver driver){
        super(driver);
    }

    //Assert.assertEquel for Header Elements
    @FindBy (xpath = "//div[@id='main']//div[@class='pageHeader']")
    public WebElement textApproveSupplier;

    @FindBy (xpath = "//form[@id='command']//div[1]//input[1]")
    public WebElement buttonSave;
    @FindBy (xpath = "//form[@id='supplierCRUDForm']//div[1]//input[2]")
    public WebElement buttonApprove;
    @FindBy (xpath = "//form[@id='supplierCRUDForm']//div[1]//input[3]")
    public WebElement buttonRejected;
    @FindBy (xpath = "//form[@id='command']//div[1]//input[4]")
    public WebElement buttonCancel;


    //Supplier detailes form
    @FindBy (xpath = "//table[@class='datagrid gradientElement2']/tbody[1]/tr[1]/td[2]")
    public WebElement fieldSupplierNo;
    @FindBy (id = "supplierName")
    public WebElement fieldSupplierName;

    //Confirmation pop-up menu elements - button SAVE
    @FindBy (id = "approvalCommentsHolder")
    public WebElement fieldCommentsAfterButtonSaVE;
    @FindBy (xpath = "//div[@class='ui-dialog-buttonset']//button[1]//span[1]")
    public WebElement buttonOkAfterButtonSaVE;
    @FindBy (xpath = "//div[@class='ui-dialog-buttonset']//button[2]//span[1]")
    public WebElement buttonCancelAfterButtonSaVE;

    //Confirmation pop-up menu elements - button CREATE
    @FindBy (id = "decisionCommentsHolder")
    public WebElement fieldCommentsAfterButtonCREATE;
    @FindBy (xpath = "//span[contains(text(),'OK')]")
    public WebElement buttonOkAfterButtonCREATE_first_stage;
    @FindBy (xpath = "//span[contains(text(),'Cancel')]")
    public WebElement buttonCancelAfterButtonCREATE;

    //Confirmation pop-up elements - button REJECTED
    @FindBy (id = "decisionCommentsHolder")
    public WebElement fieldCommentsAfterButtonREJECTED;
    @FindBy (xpath = "//span[contains(text(),'OK')]")
    public WebElement buttonOkAfterButtonREJECTED;
    @FindBy (xpath = "//div[6]//div[3]//div[1]//button[2]//span[1]")
    public WebElement buttonCancelAfterButtonREJECTED;


    // Second Approval stage
    @FindBy (xpath = "//form[@id='supplierCRUDForm']//div[1]//input[2]")
    public WebElement buttonCREATE_Second_Stage;
    @FindBy (xpath = "//span[contains(text(),'OK')]")
    public WebElement getButtonOkAfterButtonCREATE_second_stage;

    // Text for Assert/assertEquels
    @FindBy (xpath = "//div[@class='pageHeader']")
    public WebElement textInHeaderOnApproveSupplierPage;

    // Requested Payment Terms and check-box - Approved
    @FindBy (id = "paymentTerms")
    public WebElement dropdownListpaymentTerms;
    @FindBy (id = "paymentTermsApproved")
    public WebElement checkBoxApproved;

    @FindBy ()
    public WebElement filedApprovalStatus;

}
