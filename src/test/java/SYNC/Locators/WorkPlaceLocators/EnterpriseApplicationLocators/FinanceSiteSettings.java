package SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators;

import SYNC.Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinanceSiteSettings extends LoginPageLocators {
    public FinanceSiteSettings(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath = "//h1[text()='Finance Site Settings']")
    public WebElement headerText;
    @FindBy (id = "a_export")
    public WebElement buttonExportToExel;
    @FindBy (id = "a_export1")
    public WebElement buttonTransmissionSummary_last_3_months;
}
