package SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.MRLineSummaryWaitingForAQuoteClientPrice;

import SYNC.Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MrLineSummaryLocators extends LoginPageLocators {

    public MrLineSummaryLocators(WebDriver driver){

        super(driver);
    }

    @FindBy(xpath = "//h1[text()='MR Line Summary (Waiting for a Quote/Client Price)']")
    public WebElement headerText; //+++
    @FindBy (xpath = "//div[@class='jsgrid-grid-header jsgrid-header-scrollbar']//table[@class='jsgrid-table']//a[@id='a_export']")
    public WebElement buttonExportToExcelMRLineDetails; //+++
    @FindBy (xpath = "//select[@onchange='action.methods.changeGridRecordsPerPage(parseInt(this.value,10))']")
    public WebElement dropDownListRecordsPerPage; //+++

}
