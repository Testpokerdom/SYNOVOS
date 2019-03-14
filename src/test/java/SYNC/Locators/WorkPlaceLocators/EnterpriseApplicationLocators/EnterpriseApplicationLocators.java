package SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators;

import SYNC.Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterpriseApplicationLocators extends LoginPageLocators {
    public EnterpriseApplicationLocators(WebDriver driver){
        super(driver);
    }

    //Iframe "contentIFrame"
    @FindBy (id = "contentIFrame")
    public WebElement iFrameEnterpriseApplicationPage;

    //Enterprise Application page elements
    @FindBy(xpath = "//div[@id='div_result']//a[text()='Finance Site Settings']")
    public WebElement linkFinanceSiteSettings;
    @FindBy(xpath = "//div[@id='div_result']//a[text()='Invoicing Status/Transmission']")
    public WebElement linkInvoicingStatusTransmission;
    @FindBy(xpath = "//div[@id='div_result']//a[text()='Items without Manufacturer (Created in 30 days)']")
    public WebElement linkItemswithoutManufacturerCreatedin30days;
    @FindBy(xpath = "//div[@id='div_result']//a[text()='MR Line Details (Waiting for a Quote/Client Price)']")
    public WebElement linkMRLineDetailsWaitingforAQuoteClientPrice;
    @FindBy(xpath = "//div[@id='div_result']//a[text()='MR Line Summary (Waiting for a Quote/Client Price)']")
    public WebElement linkMRLineSummaryWaitingforAQuoteClientPrice;
    @FindBy(xpath = "//div[@id='div_result']//a[text()='PGT Dashboard']")
    public WebElement linkPGT_Dashboard;
    @FindBy(xpath = "//div[@id='div_result']//a[text()='PGT List Price Requests']")
    public WebElement linkPGT_ListPriceRequests;
    @FindBy(xpath = "PGT Manufacture Focused Sourcing")
    public WebElement linkPGT_ManufactureFocusedSourcing;
    @FindBy(xpath = "//div[@id='div_result']//a[text()='Vendor Approval']")
    public WebElement linkVendorApproval;
}
