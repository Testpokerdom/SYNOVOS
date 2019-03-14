package SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.FinanceSiteSettingsLocators;

import SYNC.Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinanceSiteSettingsLocators extends LoginPageLocators {
    public FinanceSiteSettingsLocators(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath = "//h1[text()='Finance Site Settings']")
    public WebElement headerText;
    @FindBy (id = "a_export")
    public WebElement buttonExportToExcel;
    @FindBy (id = "a_export1")
    public WebElement buttonTransmissionSummary_last_3_months;
    @FindBy (css = "body:nth-child(2) div:nth-child(5) div:nth-child(1) > select:nth-child(2)")
    public WebElement dropDownListRecordsPerPage;
}
