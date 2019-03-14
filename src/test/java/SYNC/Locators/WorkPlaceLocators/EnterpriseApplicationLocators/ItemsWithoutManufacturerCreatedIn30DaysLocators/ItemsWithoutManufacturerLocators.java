package SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.ItemsWithoutManufacturerCreatedIn30DaysLocators;

import SYNC.Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsWithoutManufacturerLocators extends LoginPageLocators {
    public ItemsWithoutManufacturerLocators(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Items Without Manufacturer (Created in 30 days)']")
    public WebElement headerText;
    @FindBy (xpath = "//div[@class='jsgrid-grid-header jsgrid-header-scrollbar']//a[@id='a_export']")
    public WebElement buttonExportToExcelItemsWithoutManufacturePage;
    @FindBy (xpath = "//select[@onchange='action.methods.changeGridRecordsPerPage(parseInt(this.value,10))']")
    public WebElement dropDownListRecordsPerPage;
    @FindBy (xpath = "//div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']/tbody/tr[last()]/td[2]/div[1]/a[1]") //div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']/tbody/tr[last()]/td[2]
    public WebElement linkNameInLastRow;
    @FindBy (xpath = "//span[@id='form_title_div']//h1[@class='ms-crm-TextAutoEllipsis']")
    public WebElement elementItemName;
    @FindBy (id = "contentIFrame")
    public WebElement iFrameSynovosSync;
}
