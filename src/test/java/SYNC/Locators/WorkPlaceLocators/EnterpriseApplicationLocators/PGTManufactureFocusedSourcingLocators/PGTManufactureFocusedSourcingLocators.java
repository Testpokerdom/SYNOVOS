package SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.PGTManufactureFocusedSourcingLocators;

import SYNC.Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PGTManufactureFocusedSourcingLocators extends LoginPageLocators {
    public PGTManufactureFocusedSourcingLocators(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='PGT Manufacture Focused Sourcing']")
    public WebElement headerText; //+++
    @FindBy (xpath = "//div[@class='jsgrid-grid-header jsgrid-header-scrollbar']//table[@class='jsgrid-table']//a[@id='a_export']")
    public WebElement buttonExportToExcelPGTManufactureFocused; //+++
    @FindBy (xpath = "//select[@onchange='action.methods.changeGridRecordsPerPage(parseInt(this.value,10))']")
    public WebElement dropDownListRecordsPerPage; //+++
}
