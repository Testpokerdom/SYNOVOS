package SOS.Locators.MainPage;

import SOS.Locators.LoginPage.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageLocators extends LoginPageLocators {

    public MainPageLocators(WebDriver driver) {

        super(driver);

    }

    // Web elements header - Tabels
    @FindBy(xpath = "//a[@class='drop'][contains(text(),'Home')]")
    public WebElement tableHome;
    @FindBy (xpath = "//a[contains(text(),'Utilities')]")
    public WebElement tableUtilities;
    @FindBy(xpath = "//a[@class='drop'][contains(text(),'Requisition')]")
    public WebElement tableRequisition;
    @FindBy (xpath = "//a[contains(text(),'Purchasing')]")
    public WebElement tablePurchasing;
    @FindBy(xpath = "//a[contains(text(),'Receiving')]")
    public WebElement tableReceiving;
    @FindBy (xpath = "//a[@class='drop'][contains(text(),'Inventory')]")
    public WebElement tableInventory;
    @FindBy(xpath = "//a[@class='drop'][contains(text(),'Issues')]")
    public WebElement tableIssues;
    @FindBy (xpath = "//a[contains(text(),'Invoicing')]")
    public WebElement tableInvoicing;
    @FindBy(xpath = "//a[contains(text(),'Reports')]")
    public WebElement tableReports;
    @FindBy (xpath = "//a[contains(text(),'Info')]")
    public WebElement tableInfo;

    // Purchase table elements
    @FindBy (xpath = "//li[@id='topmenu']//a[@href='/sos/supplier.htm']")
    public WebElement linkSupplier;
    @FindBy (xpath = "//li[@id='topmenu']//a[@href='/sos/purchasing/searchPO.sos?mode=edit']")
    public WebElement linkSavedPOs;
    @FindBy (xpath = "//div[@class='pageHeader']")
    public WebElement textShouldBeInHeader;
    @FindBy (xpath = "//div[@id='header']//a[@href='/sos/approval/approveSupplierListForm.htm']")
    public WebElement linkApproveSupplier;

}
