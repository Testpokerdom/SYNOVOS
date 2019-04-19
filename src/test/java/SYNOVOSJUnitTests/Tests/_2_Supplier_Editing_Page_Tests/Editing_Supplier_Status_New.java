package SYNOVOSJUnitTests.Tests._2_Supplier_Editing_Page_Tests;

import SYNOVOSJUnitTests.Locators.LoginPage.LoginPageLocators;
import SYNOVOSJUnitTests.Locators.MainPage.MainPageLocators;
import SYNOVOSJUnitTests.Locators.PurchasingPage.*;
import SYNOVOSJUnitTests.Tests.LoginPage.LoginPageTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SYNOVOSJUnitTests.WebHelpers.WebHelpers.getTextFronWebElement;
import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButtonIfEnable;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Editing_Supplier_Status_New {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static SearchSuppliersPage supplierSearchCreatePage = null;
    public static CreateSupplierPage createSupplierPage = null;
    public static ApprovalProcessSelectionPage approveSupplierListPage = null;
    public static ApproveSupplierPage approveSupplierPage = null;
    public static SupplierDetailPage supplierDetailPage = null;
    public static EditSupplierPage editSupplierPage= null;
    public static final Logger logger = LogManager.getLogger(LoginPageTests.class);
    public static String supplierNumber;

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

        logger.info("------------------------------------------------------");
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
    public void createSupplierWithStatusNew(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "SALES"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataTableAndSave2("asd@ukr.net", "Supplier_status_New_DEMO_SALES_", "","999-999-9999", "@ukr.net");
        clickButtonIfEnable(createSupplierPage.buttonSave);
        supplierNumber = getTextFronWebElement(supplierDetailPage.fieldSupplierNumber);
        System.out.println(supplierNumber);
        logger.info(supplierNumber);
        logger.info("----");
        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());

        clickButtonIfEnable(supplierDetailPage.buttonEdit);
        sendTextToWebElement(editSupplierPage.dropdown_listJDE_Vendor, "8205171");
        clickButtonIfEnable(editSupplierPage.jdeVendor2);
        clickButtonIfEnable(editSupplierPage.buttonSave);
        clickButtonIfEnable(editSupplierPage.buttonOkPopUpWindow);

        Assert.assertEquals("New Supplier - Pending Approval", getTextFronWebElement(supplierDetailPage.fieldApprovalStatus)); // Approval status should be changed from New to New Supplier - Pending Approval
        Assert.assertEquals("04/19/2019 VBIBIKSU: JdeVendor has been changed from '1045000 --- Accu-Systems SALT LAKE CITY UT 84123' to '8205171 --- STEINER MANUFACTURING., INC.''.", getTextFronWebElement(supplierDetailPage.fieldApprovalNotes));
    }
}
