package SOS.Tests._2_Supplier_Editing_Page_Tests;

import SOS.Locators.LoginPage.LoginPageLocators;
import SOS.Locators.MainPage.MainPageLocators;
import SOS.Locators.PurchasingPage.*;
import SOS.Tests.LoginPage.LoginPageTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SOS.WebHelpers.WebHelpers.findLastRawInTableAndClick2;
import static SOS.WebHelpers.WebHelpers.goToUrl;
import static WebHelpers.GettersAndSetters.getSupplierName;
import static WebHelpers.GettersAndSetters.setSupplierName;
import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButton;

public class EditingSupplierAutoApprovedDemoSOS_TBD {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static SearchSuppliersPage supplierSearchCreatePage = null;
    public static CreateSupplierPage createSupplierPage = null;
    public static ApprovalProcessSelectionPage approveSupplierListPage = null;
    public static ApproveSupplierPage approveSupplierPage = null;
    public static SupplierDetailPage supplierDetailPage = null;
    public static MatchingSupplierListPage matchingSupplierListPage = null;
    public static EditSupplierPage editSupplierPage = null;
    public static final Logger logger = LogManager.getLogger(LoginPageTests.class);

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
        matchingSupplierListPage = new MatchingSupplierListPage(driver);
        editSupplierPage = new EditSupplierPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        goToUrl(driver, "http://localhost:8080/sos/splashScreen.sos");
        sendTextToMultipleWebElements(loginPageLocators.fieldLogin, "VBIBIKSU", loginPageLocators.fieldPassword, "deadman11");
        clickButton(loginPageLocators.buttonLogin);
        clickElement(mainPageLocators.tablePurchasing);

    }

    @After
    public void afterEach() {

        driver.quit();
    }

    @Test
    //@Description("createSupplierWithStatusNewPendingApproval")
    //@DisplayName("createSupplierWithStatusNewPendingApproval")
    public void test_1_createSupplierWithStatusNewPendingApproval(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "SALES"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataTableAndSave2("asd@ukr.net", "Supplier_status_APPROVED_DEMO_SOS_", "","999-999-9999", "@ukr.net");
        clickButtonIfEnable(createSupplierPage.checkBoxTBD);

        clickButton(createSupplierPage.buttonSave);
        driver.switchTo().alert().accept();

        setSupplierName(supplierDetailPage.fieldSupplierName);

        System.out.println("Supplier was created, his name is: " + getSupplierName());
        logger.info("Supplier was created, his Number is: " + getSupplierName());
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());
        Assert.assertEquals("Active", supplierDetailPage.fieldStatus.getText());
        Assert.assertEquals("Approved", supplierDetailPage.fieldApprovalStatus.getText());
    }

    @Test
    public void test_2_LeaveRequiredFieldsEmpty(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "SALES"); // 130 - AGRO_FARMA;  SALES - DEMO;
        sendTextToWebElement(supplierSearchCreatePage.fieldSupplierNameCriterion, getSupplierName());
        clickButton(supplierSearchCreatePage.buttonSearch);

        clickButton(matchingSupplierListPage.buttonSupplier);
        findLastRawInTableAndClick2(driver, "//table[@id='supplier']/tbody/tr[last()]/td[last()]/a[@title='Edit Supplier']");
        System.out.println("Supplier was created, his name is: " + getSupplierName());
        logger.info("Supplier was created, his Number is: " + getSupplierName());
        logger.info("------------------------------------------------------");
        clickButton(supplierDetailPage.buttonEdit);

        editSupplierPage.fieldContactName.clear();
        editSupplierPage.fieldContactPhone.clear();
        editSupplierPage.fieldContactEmail.clear();
        editSupplierPage.dropdown_listJDE_Vendor.clear();
        Assert.assertTrue(editSupplierPage.buttonSendForApprovalPaymentTerms.isEnabled() == false); //Button send for approval should be disable
        clickButton(editSupplierPage.buttonSave);

        Assert.assertEquals(" ", supplierDetailPage.fieldPrimaryContactName.getText()); // Name field should be empty
        Assert.assertEquals(" ", supplierDetailPage.fieldPrimaryContactPhone.getText()); // Phone field should be empty
        Assert.assertEquals(" ", supplierDetailPage.fieldPrimaryContactEmail.getText()); // Email field should be empty
        Assert.assertEquals("None", supplierDetailPage.fieldAccounitngInfoJDEVendor.getText()); // JDEVendor field should be empty
    }
}
