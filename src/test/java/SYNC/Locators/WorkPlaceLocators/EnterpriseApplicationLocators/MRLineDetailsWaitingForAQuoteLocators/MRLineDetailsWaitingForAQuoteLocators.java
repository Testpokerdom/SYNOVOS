package SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.MRLineDetailsWaitingForAQuoteLocators;

import SYNC.Locators.LoginPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static WebHelpers.WebHelpers.clickButtonIfEnable;
import static WebHelpers.WebHelpers.waitElementPresence;

public class MRLineDetailsWaitingForAQuoteLocators extends LoginPageLocators {
    public MRLineDetailsWaitingForAQuoteLocators(WebDriver driver){

        super(driver);
    }
    @FindBy(xpath = "//h1[text()='MR Line Details (Waiting for a Quote/Client Price)']")
    public WebElement headerText; //+++
    @FindBy (xpath = "//div[@class='jsgrid-grid-header jsgrid-header-scrollbar']//table[@class='jsgrid-table']//a[@id='a_export']")
    public WebElement buttonExportToExcelMRLineDetails; //+++
    @FindBy (xpath = "//select[@onchange='action.methods.changeGridRecordsPerPage(parseInt(this.value,10))']")
    public WebElement dropDownListRecordsPerPage; //+++
    @FindBy (xpath = "//div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']/tbody/tr[last()]/td[2]/div[1]/a[1]") //div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']/tbody/tr[last()]/td[2]
    public WebElement linkNameInLastRow;
    @FindBy (xpath = "//span[@id='form_title_div']//h1[@class='ms-crm-TextAutoEllipsis']")
    public WebElement elementItemName;
    @FindBy (id = "contentIFrame")
    public WebElement iFrameSynovosSync;
    @FindBy (xpath = "//div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']")
    public WebElement tableMRLineDetails;

    //Pagination toolbar elements
    @FindBy (xpath = "//div[@id='jsGridPages']//a[text()='1']")
    public WebElement buttonFirstPage;
    @FindBy (xpath = "//div[@id='jsGridPages']//a[text()='2']")
    public WebElement buttonSecondPage;
    @FindBy (xpath = "//div[@id='jsGridPages']//div[@class='jsgrid-pager']")
    public WebElement toolbarPagination;
    @FindBy (xpath = "//div[@id='jsGridPages']//a[text()='Next']")
    public WebElement buttonNext;
    @FindBy (xpath = "//div[@id='jsGridPages']//a[text()='Last']")
    public WebElement buttonLast;
    @FindBy (xpath = "//div[@id='jsGridPages']//a[text()='Prev']")
    public WebElement buttonPrevious;
    @FindBy (xpath = "//div[@id='jsGridPages']//a[text()='First']")
    public WebElement buttonFirst;

    //Elements for Status column
    @FindBy (xpath = "//div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']/tbody/tr[1]/td[5]")
    public WebElement buttonWaitingForQuote;
    @FindBy (id = "contentIFrame")
    public WebElement iFrameQuotePage;
    @FindBy (xpath = "//table[@id='crmFormHeaderTop']//div[@class='ms-crm-Form-Title-Label autoellipsis']")
    public WebElement textQuotePage;

    public void checkPaginationPanelButtons(WebDriver driver){
        waitElementPresence(driver, 10, buttonNext);
        clickButtonIfEnable(buttonNext);
        waitElementPresence(driver, 10, buttonLast);
        clickButtonIfEnable(buttonLast);
        waitElementPresence(driver, 10, buttonPrevious);
        clickButtonIfEnable(buttonPrevious);
        waitElementPresence(driver, 10, buttonFirst);
        clickButtonIfEnable(buttonFirst);
        waitElementPresence(driver, 10, buttonSecondPage);
        clickButtonIfEnable(buttonSecondPage);
    }
}
