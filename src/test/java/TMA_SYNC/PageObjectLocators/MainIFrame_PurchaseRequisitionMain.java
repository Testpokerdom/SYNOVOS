package TMA_SYNC.PageObjectLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static WebHelpers.WebHelpers.*;

public class MainIFrame_PurchaseRequisitionMain extends MainPage {

    public MainIFrame_PurchaseRequisitionMain(WebDriver driver)
    {
        super(driver);
    }

    // Main Iframe locator
    @FindBy (id = "mainFrame")
    public WebElement iFrameMain;

    // Upper toolbar elements
    @FindBy(linkText = "Add")
    public WebElement buttonAdd2;
    @FindBy (xpath = "//div[@id='UserToolbar']//a[@title='Add']") //  //a[@title='Add']//img[@class='rtbIcon'] //div[@id='UserToolbar']//a[@title='Add']//span[text()='Add'] //div[@id='UserToolbar']//span[text()='Add']
    public WebElement buttonAdd;
    @FindBy (xpath = "//span[contains(text(),'Edit')]")
    public WebElement buttonEdit;
    @FindBy (xpath = "//span[contains(text(),'Prev')]")
    public WebElement buttonPrev;
    @FindBy (xpath = "//a[@title='Next']//img[@class='rtbIcon']")
    public WebElement buttonNext;
    @FindBy (xpath = "//div[@id='UserToolbar']//img[@alt='Save']")
    public WebElement buttonSaveMain;
    @FindBy (id = "txtFastFind")
    public WebElement fieldSearch;
    @FindBy (id = "btnFastFind")
    public WebElement buttonSearch;

    // Buttons Expend and Add Distributions
    @FindBy (id = "grdPR_ctl00_ctl04_GECBtnExpandColumn")
    public WebElement buttonExpendIntoItemsTable;
    @FindBy (id = "grdPR_ctl00_ctl05_Detail10_ctl02_ctl00_lblAddDistribution")
    public WebElement buttonAddDistribution;

    //Export Purchase Requisition pop-up elements
    @FindBy (xpath = "//div[@class='rwDialogPopup radconfirm']//span[text()='OK']")  //div[@id='confirm1550751353006_content']//span[text()='OK']
    public WebElement buttonOkExportPurchaseRequsition;
    @FindBy (xpath = "//div[@id='confirm1550751353006_content']//span[text()='Cancel']")
    public WebElement buttonCancelExportPurchaseRequsition;

    public void clickButtonAdd(WebDriver driver){
        switchToIFrame(driver, iFrameMain);
        clickButtonIfEnable(buttonAdd);
    }

    public void clickButtonsExpandAndAddDistribution(WebDriver driver){
        driver.switchTo().parentFrame();
        clickButtonIfEnable(buttonExpendIntoItemsTable);
        clickButtonIfEnable(buttonAddDistribution);
    }

    public void switchToIFrameMainAndClickButtonSave(WebDriver driver){
        switchToIFrame(driver, iFrameMain);
        clickWebElementIfEnable(buttonSaveMain);
    }
}
