package SOS.Tests._1_Create_Supplier_New_NewPendingApproval_Emergency_Approved_Reject;

import SOS.Locators.LoginPage.LoginPageLocators;
import SOS.Locators.MainPage.MainPageLocators;
import SOS.Locators.PurchasingPage.*;
//import com.sun.org.glassfish.gmbal.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
//import org.junit.jupiter.api.DisplayName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SOS.WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButton;
import static WebHelpers.WebHelpers.clickButtonIfEnable;
import static WebHelpers.WebHelpers.clickElement;
import static WebHelpers.WebHelpers.selectWebElementFromDropDownList;
import static WebHelpers.WebHelpers.sendTextToMultipleWebElements;
import static WebHelpers.WebHelpers.sendTextToWebElement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Create_Supplier_Status_Reject {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static SearchSuppliersPage supplierSearchCreatePage = null;
    public static CreateSupplierPage createSupplierPage = null;
    public static ApprovalProcessSelectionPage approvalProcessSelection = null;
    public static ApproveSupplierPage approveSupplierPage = null;
    public static SupplierDetailPage supplierDetailPage = null;
    public static final Logger logger = LogManager.getLogger(Create_Supplier_Status_Reject.class);

    @Before
    public void beforEeach() {
        System.setProperty("webdriver.chrome.driver", "C://Users//viktor.bibik//webdrivers//Chromedriver//chromedriver.exe");
        driver = new ChromeDriver();

        loginPageLocators = new LoginPageLocators(driver);
        mainPageLocators = new MainPageLocators(driver);
        supplierSearchCreatePage = new SearchSuppliersPage(driver);
        createSupplierPage = new CreateSupplierPage(driver);
        approvalProcessSelection = new ApprovalProcessSelectionPage(driver);
        approveSupplierPage = new ApproveSupplierPage(driver);
        supplierDetailPage = new SupplierDetailPage(driver);

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
    //@Description("Create Supplier")
    //@DisplayName("Create Supplier")
    public void test_1_createSupplierWithStatusNewPendingApproval(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "SALES"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataTableAndSave2("asd@ukr.net", "Supplier_status_APPROVED_DEMO_SALES_", "","999-999-9999", "@ukr.net");
        clickButtonIfEnable(createSupplierPage.buttonSendForApproval);
        sendTextToWebElement(createSupplierPage.fieldComments, "Supplier was created and sent for approval with status New Supplier - Pending Approval");
        clickButtonIfEnable(createSupplierPage.buttonOKpopup);
        System.out.println("Supplier was created, his Number is: " + getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was created, his Number is: " + getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());
    }

    @Test
    //@Description ("Find last Created Supplier (from \"test_1\") and Reject them")
    //@DisplayName("Find last Created Supplier (from \"test_1\") and Reject them")
    public void test_2_rejectSupplierWithStatusNewPendingApproval(){
        clickButton(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approvalProcessSelection.dropdownlistSiteName, "DEMO SOS SITE"); // DEMO SOS SITE -- AGRO FARMA
        findLastRawInTableAndClick2(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]");
        System.out.println("Suppliers number for rejecting is: " + getTextFromWebElement(approveSupplierPage.fieldSupplierNo));
        logger.info("Supplier was chosen for Rejecting, his number is: " + getTextFromWebElement(approveSupplierPage.fieldSupplierNo));
        clickButton(approveSupplierPage.buttonRejected);
        sendTextToWebElement(approveSupplierPage.fieldCommentsAfterButtonREJECTED, "Supplier_was_rejected");
        clickButton(approveSupplierPage.buttonOkAfterButtonREJECTED);
        logger.info("Supplier was Rejected");
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Approval Process Selection", approvalProcessSelection.textInHeader.getText());
    }

}
