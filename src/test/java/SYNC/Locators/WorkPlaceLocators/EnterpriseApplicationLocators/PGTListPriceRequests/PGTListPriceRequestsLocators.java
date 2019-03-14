package SYNC.Locators.WorkPlaceLocators.EnterpriseApplicationLocators.PGTListPriceRequests;

import SYNC.Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PGTListPriceRequestsLocators extends LoginPageLocators {
    public PGTListPriceRequestsLocators(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='PGT List Price Requests']")
    public WebElement headerText; //+++
    @FindBy (xpath = "//div[@class='jsgrid-grid-header jsgrid-header-scrollbar']//table[@class='jsgrid-table']//a[@id='a_export']")
    public WebElement buttonExportToExcelMRLineDetails; //+++
    @FindBy (xpath = "//select[@onchange='action.methods.changeGridRecordsPerPage(parseInt(this.value,10))']")
    public WebElement dropDownListRecordsPerPage; //+++
    @FindBy (xpath = "//div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']/tbody/tr[last()]/td[9]/div[1]/a[1]") //div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']/tbody/tr[last()]/td[2]
    public WebElement linkStatusInLastRowRGTListPriceRequests;
    @FindBy (id = "i_selectall")
    public WebElement checkboxSelectAll;
    @FindBy (xpath = "//div[@class='jsgrid-grid-body']//table[@class='jsgrid-table']//tr[1]//td[1]//input[1]")
    public  WebElement checkBoxFirstitem;

}
