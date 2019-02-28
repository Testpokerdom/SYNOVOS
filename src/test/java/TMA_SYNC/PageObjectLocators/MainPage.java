package TMA_SYNC.PageObjectLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButtonIfEnable;

public class MainPage {
    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    // Left toolbar elements
    @FindBy(xpath = "//span[contains(text(),'Action Menu')]")
    public WebElement tabActionMenu;
    @FindBy (xpath = "//span[contains(text(),'Favorites')]")
    public WebElement tabFavorites;
    @FindBy (xpath = "//span[@class='rpOut']//span[@class='rpText'][contains(text(),'Material')]") //     //a[@class='rpLink rpExpandable  rpSelected rpExpanded']//span[@class='rpText']
    public WebElement tabMaterial;
    @FindBy (xpath = "//span[contains(text(),'Accounting')]")
    public WebElement tabAccounting;
    @FindBy (xpath = "//span[contains(text(),'Tutorials')]")
    public WebElement tabTuturials;

    // "Action Menu" elements:
    @FindBy (xpath = "//div[@id='RadPanelbar1']//span[text()='Authorize']")
    public WebElement buttonAuthorize;
    @FindBy (xpath = "//div[@id='RadPanelbar1']//span[text()='Export']")
    public WebElement buttonExport;

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

    public void switchToMaterialTabAndClickPurchaseRequisitionLink(WebDriver driver){
        clickWebElementIfEnable(tabMaterial);
        waitElementPresence(driver, 5, linkPurchaseRequisitionOnMaterialTab);
        clickButtonIfEnable(linkPurchaseRequisitionOnMaterialTab);
    }

    public void switchToDefaultContentAndClickButtonExport(WebDriver driver){
        driver.switchTo().defaultContent();
        clickButtonIfEnable(buttonAuthorize);
    }
}
