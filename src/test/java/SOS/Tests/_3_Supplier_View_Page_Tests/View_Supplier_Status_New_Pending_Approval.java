package SOS.Tests._3_Supplier_View_Page_Tests;

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

import static SOS.WebHelpers.WebHelpers.getTextFronWebElement;
import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButtonIfEnable;

public class View_Supplier_Status_New_Pending_Approval {
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
    //@Description("Create Supplier")
    //@DisplayName("Create Supplier")
    public void createSupplierWithStatusNewSupplierPendingApproval(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "SALES"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataTableAndSave2("asd@ukr.net", "Supplier_status_APPROVED_DEMO_SALES_", "","999-999-9999", "@ukr.net");
        clickButtonIfEnable(createSupplierPage.buttonSendForApproval);
        sendTextToWebElement(createSupplierPage.fieldComments, "Supplier was created and sent for approval with status New Supplier - Pending Approval");
        clickButtonIfEnable(createSupplierPage.buttonOKpopup);

        System.out.println("Supplier was created, his Number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was created, his Number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("------------------------------------------------------");
        System.out.println("Is button Send For Approval available: " + supplierDetailPage.buttonSendForApproval.isEnabled());

        Assert.assertEquals("Supplier Detail", supplierDetailPage.textSupplierDetails.getText());
        Assert.assertEquals("ASD@UKR.NET", supplierDetailPage.fieldRemitTo.getText());
        Assert.assertEquals("Yes", supplierDetailPage.fieldProvidedW9.getText());
        Assert.assertEquals("New Supplier - Pending Approval", getTextFronWebElement(supplierDetailPage.fieldApprovalStatus)); // Approval status should be New Supplier - Pending Approval
        Assert.assertFalse(supplierDetailPage.buttonSendForApproval.isEnabled() == true);  // Button Send For Approval should be inActive!!!!!
        //Assert.assertEquals("false", supplierDetailPage.buttonSendForApproval.isEnabled());
    }
}
