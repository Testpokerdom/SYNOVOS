package SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.InvoicStatusTransmitionLocators;

import SYNC.Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoicingStatusTransmitionLocators extends LoginPageLocators {
    public InvoicingStatusTransmitionLocators(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Invoicing Status/Transmission']")
    public WebElement headerText;
    @FindBy (id = "a_export")
    public WebElement buttonExportToExcel;
    @FindBy (xpath = "//select[@onchange='action.methods.changeGridRecordsPerPage(parseInt(this.value,10))']")
    //@FindBy (css = "body:nth-child(2) div:nth-child(7) div:nth-child(1) > select:nth-child(2)")
    public WebElement dropDownListRecordsPerPage;
    @FindBy (xpath = "//div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']/tbody/tr[last()]/td[2]/div[1]/a[1]") //div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']/tbody/tr[last()]/td[2]
    public WebElement linkNameInLastRowInvoicingStatusTransmition;
    @FindBy (id = "EAM_DIALOG_1_IFRAME")
    public WebElement iFrameTransmitInvoice;
    //@FindBy (id = "tdDialogHeader")
    @FindBy (xpath = "//div[@id='tdDialogHeader']/div[1]")
    public WebElement textTransmitInvoices;
}
