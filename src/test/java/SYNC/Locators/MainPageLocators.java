package SYNC.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.reporters.jq.Main;

public class MainPageLocators extends LoginPageLocators{
    public MainPageLocators(WebDriver driver){
        super(driver);
    }

    // Main tabs
    @FindBy(id = "Workplace") //div[@id='crmAppNav']//a[@id='Workplace'] //a[@id='Workplace']//nobr[text()='Workplace']
    public WebElement buttonWorkplace;
    @FindBy(id = "area_eam_workorders") //div[@id='crmAppNav']//a[@id='area_eam_workorders']
    public WebElement buttonWorkOrders;
    @FindBy(id = "area_eam_planning") //div[@id='crmAppNav']//a[@id='area_eam_planning']
    public WebElement buttonPlanning;
    @FindBy(id = "area_eam_assets") //div[@id='crmAppNav']//a[@id='area_eam_assets']
    public WebElement buttonAssets;
    @FindBy(id = "area_eam_inventory") //div[@id='crmAppNav']//a[@id='area_eam_inventory']
    public WebElement buttonInventory;
    @FindBy(xpath = "//div[@id='crmAppNav']//a[@title='Purchasing']")
    public WebElement buttonPurchasing;
    @FindBy(xpath = "//div[@id='crmAppNav']//a[@title='Financial']")
    public WebElement buttonFinancial;
    @FindBy(id = "area_eam_resources") //div[@id='crmAppNav']//a[@id='area_eam_resources']
    public WebElement buttonResources;
    @FindBy(id = "Settings") //div[@id='crmAppNav']//a[@id='Workplace']
    public WebElement buttonSettings;
}
