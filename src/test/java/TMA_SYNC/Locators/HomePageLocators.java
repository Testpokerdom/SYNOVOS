package TMA_SYNC.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators extends LoginPageLocators {

    public HomePageLocators(WebDriver driver){
        super(driver);
    }

    // Left toolbar elements
    @FindBy (xpath = "//span[contains(text(),'Action Menu')]")
    public WebElement tabActionMenu;
    @FindBy (xpath = "//span[contains(text(),'Favorites')]")
    public WebElement tabFavorites;
    @FindBy (xpath = "//span[@class='rpOut']//span[@class='rpText'][contains(text(),'Material')]") //     //a[@class='rpLink rpExpandable  rpSelected rpExpanded']//span[@class='rpText']
    public WebElement tabMaterial;
    @FindBy (xpath = "//span[contains(text(),'Accounting')]")
    public WebElement tabAccounting;
    @FindBy (xpath = "//span[contains(text(),'Tutorials')]")
    public WebElement tabTuturials;

    // Home and Logout links
    @FindBy ()
    public WebElement buttonHome;
    @FindBy ()
    public WebElement buttonLogout;

    // Material tab elements

    @FindBy (xpath = "//ul[@class='rpGroup rpLevel1 ']//li[@class='rpItem']//span[@class='rpText'][contains(text(),'Requisitions')]")
    public WebElement linkPurchaseRequisitionOnMaterialTab;
    @FindBy (xpath = "//span[@class='rpText'][text()='Purchase Orders']")
    public WebElement linkMaterialTabPurchaseOrder;

}
