package SOS.Locators.PurchasingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MatchingSupplierListPage extends SearchSuppliersPage {
    public MatchingSupplierListPage(WebDriver driver){
        super(driver);
    }

    //Table header elements
    @FindBy (xpath = "//table[@id='supplier']//tr[1]/th[1]")
    public WebElement buttonSupplier;
    @FindBy (xpath = "//div[@class='pageHeader']")
    public WebElement headerTextMatching; // Matching Supplier List
}
