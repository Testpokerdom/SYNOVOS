package SYNOVOSJUnitTests.Locators.PurchasingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupplierDetailPage extends CreateSupplierPage {

    public SupplierDetailPage (WebDriver driver){
        super(driver);
    }

    // Header buttons
    @FindBy (name = "backToList")
    public WebElement buttonGoBack;
    @FindBy (name = "newSearch")
    public WebElement buttonSearch;
    @FindBy (name = "delete")
    public WebElement buttonDelete;

    //Saved User details from the Table
    @FindBy (xpath = "//table[@class='datagrid']/tbody[1]//td[contains(text(),'Supplier No:')]/following-sibling::td[1]")
    public WebElement fieldSupplierNumber;
}
