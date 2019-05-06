package SOS.Tests._12_PaymentTermsApprovalinitiation;

import SOS.Locators.LoginPage.LoginPageLocators;
import SOS.Locators.MainPage.MainPageLocators;
import SOS.Locators.PurchasingPage.*;
import SOS.Tests._1_Create_Supplier_New_NewPendingApproval_Emergency_Approved_Reject.Create_Supplier_Status_Reject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SOS.WebHelpers.WebHelpers.findLastRawInTableAndClick2;
import static SOS.WebHelpers.WebHelpers.getCurrentTimeUsingCalendar2;
import static SOS.WebHelpers.WebHelpers.sendTextToWebElement;
import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButtonIfEnable;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_2_ApprovePaymentTermForSupplierStatusApproved {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static SearchSuppliersPage supplierSearchCreatePage = null;
    public static CreateSupplierPage createSupplierPage = null;
    public static ApprovalProcessSelectionPage approvalProcessSelection = null;
    public static ApproveSupplierPage approveSupplierPage = null;
    public static SupplierDetailPage supplierDetailPage = null;
    public static EditSupplierPage editSupplierPage= null;
    public static ApprovalProcessSelectionPage approveSupplierListPage = null;
    public static MatchingSupplierListPage matchingSupplierListPage = null;
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
        editSupplierPage = new EditSupplierPage(driver);
        approveSupplierListPage = new ApprovalProcessSelectionPage(driver);
        matchingSupplierListPage = new MatchingSupplierListPage(driver);

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
    public void test_1_createSupplierWithStatusNewPendingApproval(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "SALES"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataTableAndSave2("asd@ukr.net", "Supplier_status_APPROVED_DEMO_SALES_", "","999-999-9999", "@ukr.net");

        clickButton(createSupplierPage.buttonSendForApproval);
        sendTextToWebElement(createSupplierPage.fieldComments, "Send_for_approval_test_creation");
        clickButtonIfEnable(createSupplierPage.buttonOKpopup);

        System.out.println("Supplier was created, his Number is: " + SOS.WebHelpers.WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was created, his Number is: " + SOS.WebHelpers.WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());
    }

    @Test
    public void test_2_stage_1_ApproveSupplierWithStatusNewPendingApproval(){
        clickButton(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approveSupplierListPage.dropdownlistSiteName, "DEMO SOS SITE"); // AGRO FARMA / DEMO SOS SITE
        findLastRawInTableAndClick2(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]");

        System.out.println("Approved Supplier number is: " + SOS.WebHelpers.WebHelpers.getTextFromWebElement(approveSupplierPage.fieldSupplierNo));
        logger.info("Approved Supplier number is: " + SOS.WebHelpers.WebHelpers.getTextFromWebElement(approveSupplierPage.fieldSupplierNo));

        approveSupplierPage.choosePaymentTermsForSupplier("10", "Approved_Supplier_First_Stage");

        logger.info("Supplier successfully passed first approval stage..");
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Approval Process Selection", approveSupplierListPage.textInHeader.getText());
    }

    @Test
    public void test_3_stage_2_ApproveSupplierWithStatusNewPendingApproval(){
        clickButton(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approveSupplierListPage.dropdownlistSiteName, "DEMO SOS SITE");
        findLastRawInTableAndClick2(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]");

        System.out.println("Supplier was approved, his number is: " + SOS.WebHelpers.WebHelpers.getTextFromWebElement(approveSupplierPage.fieldSupplierNo));
        logger.info("Supplier was approved, his number is: " + SOS.WebHelpers.WebHelpers.getTextFromWebElement(approveSupplierPage.fieldSupplierNo));

        //selectWebElementFromDropDownList(createSupplierPage.dropdown_listJDE_Vendor, "6040");
        sendTextToWebElement(createSupplierPage.dropdown_listJDE_Vendor, "1045000");
        clickElement(createSupplierPage.jdeVendor2);

        clickButton(approveSupplierPage.buttonCREATE_Second_Stage);
        sendTextToWebElement(approveSupplierPage.fieldCommentsAfterButtonCREATE, "Approved_Supplier_Second_Stage");
        clickButton(approveSupplierPage.getButtonOkAfterButtonCREATE_second_stage);
        logger.info("Supplier successfully passed second approval stage.");
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Approval Process Selection", approveSupplierListPage.textInHeader.getText());
    }

    @Test
    public void test_4_sendRequiredPaymentTermForApproveAndApprovePaymentTerm(){
        clickButton(mainPageLocators.linkSupplier);
        sendTextToWebElement(supplierSearchCreatePage.fieldSupplierNameCriterion, getCurrentTimeUsingCalendar2());
        clickButtonIfEnable(supplierSearchCreatePage.buttonSearch);
        clickWebElementIfEnable(matchingSupplierListPage.buttonSupplier);

        findLastRawInTableAndClick2(driver, "//table[@id='supplier']/tbody/tr[last()]/td[last()]");
        System.out.println("Suppliers number is: " + SOS.WebHelpers.WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was chosen for Approve, his number is: " + SOS.WebHelpers.WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));

        clickButtonIfEnable(supplierDetailPage.buttonEdit);

        Assert.assertTrue(editSupplierPage.buttonSendForApprovalPaymentTerms.isEnabled() == true);

        clickButtonIfEnable(editSupplierPage.buttonSendForApprovalPaymentTerms);
        sendTextToWebElement(editSupplierPage.fieldCommentsInPopUpWindow, "Requested Payment Terms Approval");
        clickButtonIfEnable(editSupplierPage.buttonOkPopUpWindow);

        clickElement(mainPageLocators.tablePurchasing);
        clickWebElementIfEnable(mainPageLocators.linkApproveSupplier);
        Assert.assertEquals("Supplier Payment Terms Approval Process", approveSupplierListPage.fieldApprovalTypeLastString.getText());
        Assert.assertTrue(SOS.WebHelpers.WebHelpers.getTextFromWebElement(approveSupplierListPage.fielsComments).contains("(PT)"));

        approveSupplierPage.approveRequestedPaymentTerm(driver);
    }
}
