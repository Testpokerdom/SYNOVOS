package SYNOVOSJUnitTests.Tests._3_Supplier_View_Page_Tests;

import SYNOVOSJUnitTests.Locators.LoginPage.LoginPageLocators;
import SYNOVOSJUnitTests.Locators.MainPage.MainPageLocators;
import SYNOVOSJUnitTests.Locators.PurchasingPage.*;
import SYNOVOSJUnitTests.Tests._1_Create_Supplier_New_NewPendingApproval_Emergency_Approved_Reject.Create_Supplier_Status_Reject;
import WebHelpers.WebHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SYNOVOSJUnitTests.WebHelpers.WebHelpers.findLastRawInTableAndClick2;
import static SYNOVOSJUnitTests.WebHelpers.WebHelpers.getCurrentTimeUsingCalendar2;
import static SYNOVOSJUnitTests.WebHelpers.WebHelpers.getTextFronWebElement;
import static SYNOVOSJUnitTests.WebHelpers.WebHelpers.sendTextToWebElement;
import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButtonIfEnable;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class View_Supplier_Status_Approved {
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
/*
    @After
    public void afterEach() {

        driver.quit();
    }

    @Test
    //@Description("createSupplierWithStatusNewPendingApproval")
    //@DisplayName("createSupplierWithStatusNewPendingApproval")
    public void test_1(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "SALES"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataTableAndSave2("asd@ukr.net", "Supplier_status_APPROVED_DEMO_SALES_", "","999-999-9999", "@ukr.net");

        clickButton(createSupplierPage.buttonSendForApproval);
        sendTextToWebElement(createSupplierPage.fieldComments, "Send_for_approval_test_creation");
        clickButtonIfEnable(createSupplierPage.buttonOKpopup);

        System.out.println("Supplier was created, his Number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was created, his Number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());
    }

    @Test
    //@Description("stage_1_ApproveSupplierWithStatusNewPendingApproval")
    //@DisplayName("stage_1_ApproveSupplierWithStatusNewPendingApproval")
    public void test_2(){
        clickButton(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approveSupplierListPage.dropdownlistSiteName, "DEMO SOS SITE"); // AGRO FARMA / DEMO SOS SITE
        findLastRawInTableAndClick2(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]");

        System.out.println("Approved Supplier number is: " + getTextFronWebElement(approveSupplierPage.fieldSupplierNo));
        logger.info("Approved Supplier number is: " + getTextFronWebElement(approveSupplierPage.fieldSupplierNo));

        selectWebElementFromDropDownList(approveSupplierPage.dropdownListpaymentTerms, "10"); //value 10 = "NET 25"
        clickElement(approveSupplierPage.checkBoxApproved);
        clickButton(approveSupplierPage.buttonApprove);
        sendTextToWebElement(approveSupplierPage.fieldCommentsAfterButtonCREATE, "Approved_Supplier_First_Stage");
        clickButton(approveSupplierPage.buttonOkAfterButtonCREATE_first_stage);

        logger.info("Supplier successfully passed first approval stage..");
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Approval Process Selection", approveSupplierListPage.textInHeader.getText());
    }

    @Test
    //@Description ("stage_2_ApproveSupplierWithStatusNewPendingApproval")
    //@DisplayName("stage_2_ApproveSupplierWithStatusNewPendingApproval")
    public void test_3(){
        clickButton(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approveSupplierListPage.dropdownlistSiteName, "DEMO SOS SITE");
        findLastRawInTableAndClick2(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]");

        System.out.println("Supplier was approved, his number is: " + getTextFronWebElement(approveSupplierPage.fieldSupplierNo));
        logger.info("Supplier was approved, his number is: " + getTextFronWebElement(approveSupplierPage.fieldSupplierNo));

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
*/
    @Test
    //@Description ("Change JDE Vendor field value to supplier with status Approved")
    //@DisplayName("Change JDE Vendor field value to supplier with status Approved")
    public void test_4(){
        clickButton(mainPageLocators.linkSupplier);
        sendTextToWebElement(supplierSearchCreatePage.fieldSupplierNameCriterion, getCurrentTimeUsingCalendar2());
        clickButtonIfEnable(supplierSearchCreatePage.buttonSearch);
        clickWebElementIfEnable(matchingSupplierListPage.buttonSupplier);

        findLastRawInTableAndClick2(driver, "//table[@id='supplier']/tbody/tr[last()]/td[last()]");
        System.out.println("Suppliers number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was chosen for Approve, his number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());
        Assert.assertEquals("ASD@UKR.NET", supplierDetailPage.fieldRemitTo.getText());
        Assert.assertEquals("Yes", supplierDetailPage.fieldProvidedW9.getText());
        Assert.assertEquals("Approved", getTextFronWebElement(supplierDetailPage.fieldApprovalStatus)); // Approval status should be Emergency
        Assert.assertFalse(supplierDetailPage.buttonSendForApproval.isEnabled() == true); // Button Send For Approval should be inActive!!!!!
    }
}
