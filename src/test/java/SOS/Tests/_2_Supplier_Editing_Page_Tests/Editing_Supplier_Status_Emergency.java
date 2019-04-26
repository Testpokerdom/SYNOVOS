package SOS.Tests._2_Supplier_Editing_Page_Tests;

import SOS.Locators.LoginPage.LoginPageLocators;
import SOS.Locators.MainPage.MainPageLocators;
import SOS.Locators.PurchasingPage.*;
import SOS.Tests._1_Create_Supplier_New_NewPendingApproval_Emergency_Approved_Reject.Create_Supplier_Status_Emergancy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SOS.WebHelpers.WebHelpers.getTextFronWebElement;
import static SOS.WebHelpers.WebHelpers.goToUrl;
import static WebHelpers.WebHelpers.*;

public class Editing_Supplier_Status_Emergency {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static SearchSuppliersPage supplierSearchCreatePage = null;
    public static CreateSupplierPage createSupplierPage = null;
    public static ApprovalProcessSelectionPage approveSupplierListPage = null;
    public static ApproveSupplierPage approveSupplierPage = null;
    public static SupplierDetailPage supplierDetailPage = null;
    public static EditSupplierPage editSupplierPage= null;
    public static Logger logger = LogManager.getLogger(Create_Supplier_Status_Emergancy.class);

    @Before
    public void beforEeach() {
        System.setProperty("webdriver.chrome.driver", "C://Users//viktor.bibik//webdrivers//Chromedriver//chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C://Users//viktor.bibik//webdrivers//Firefoxdriver//geckodriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();

        loginPageLocators = new LoginPageLocators(driver);
        mainPageLocators = new MainPageLocators(driver);
        supplierSearchCreatePage = new SearchSuppliersPage(driver);
        createSupplierPage = new CreateSupplierPage(driver);
        approveSupplierListPage = new ApprovalProcessSelectionPage(driver);
        approveSupplierPage = new ApproveSupplierPage(driver);
        supplierDetailPage = new SupplierDetailPage(driver);
        editSupplierPage = new EditSupplierPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        goToUrl(driver, "http://localhost:8080/sos/splashScreen.sos");
        sendTextToMultipleWebElements(loginPageLocators.fieldLogin, "VBIBIKSU", loginPageLocators.fieldPassword, "deadman11");
        clickButtonIfEnable(loginPageLocators.buttonLogin);
        clickButtonIfEnable(mainPageLocators.tablePurchasing);

    }
/*
    @After
    public void afterEach() {

        driver.quit();
    }
*/
    @Test
    public void createSupplierEmergency(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "SALES"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataEmergencySupplier("asd@ukr.net","Supplier_Emergency_DEMO_SALES_", "123-123-1234", "@ukr.net", "Emergency supplier was created");
        clickButtonIfEnable(createSupplierPage.buttonOKpopup);
        System.out.println("Emergency Supplier was created, his number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Emergency Supplier was created, his number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());

        clickButtonIfEnable(supplierDetailPage.buttonEdit);
        sendTextToWebElement(editSupplierPage.dropdown_listJDE_Vendor, "8205171");
        clickButtonIfEnable(editSupplierPage.jdeVendor2);
        clickButtonIfEnable(editSupplierPage.buttonSave);

        Assert.assertEquals("Emergency", getTextFronWebElement(supplierDetailPage.fieldApprovalStatus)); // Approval status should be Emergency
        Assert.assertTrue(getTextFronWebElement(supplierDetailPage.fieldApprovalNotes).contains("/2019 VBIBIKSU: JdeVendor has been changed from '1045000 --- Accu-Systems SALT LAKE CITY UT 84123'" +
                " to '8205171 --- STEINER MANUFACTURING., INC.''."));
    }
}
