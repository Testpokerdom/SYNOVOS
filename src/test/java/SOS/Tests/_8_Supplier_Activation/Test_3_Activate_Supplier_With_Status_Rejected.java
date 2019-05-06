package SOS.Tests._8_Supplier_Activation;

import SOS.Locators.LoginPage.LoginPageLocators;
import SOS.Locators.MainPage.MainPageLocators;
import SOS.Locators.PurchasingPage.*;
import SOS.Tests._1_Create_Supplier_New_NewPendingApproval_Emergency_Approved_Reject.Create_Supplier_Status_Reject;
import SOS.WebHelpers.WebHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SOS.WebHelpers.WebHelpers.findLastRawInTableAndClick2;
import static SOS.WebHelpers.WebHelpers.getCurrentTimeUsingCalendar2;
import static SOS.WebHelpers.WebHelpers.goToUrl;
import static SOS.WebHelpers.WebHelpers.sendTextToWebElement;
import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButton;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_3_Activate_Supplier_With_Status_Rejected {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static SearchSuppliersPage supplierSearchCreatePage = null;
    public static CreateSupplierPage createSupplierPage = null;
    public static ApprovalProcessSelectionPage approvalProcessSelection = null;
    public static ApproveSupplierPage approveSupplierPage = null;
    public static SupplierDetailPage supplierDetailPage = null;
    public static MatchingSupplierListPage matchingSupplierListPage = null;
    public static ApprovalProcessSelectionPage approveSupplierListPage = null;
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
        matchingSupplierListPage = new MatchingSupplierListPage(driver);
        approveSupplierListPage = new ApprovalProcessSelectionPage(driver);

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
        System.out.println("Supplier was created, his Number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was created, his Number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
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
        System.out.println("Suppliers number for rejecting is: " + WebHelpers.getTextFromWebElement(approveSupplierPage.fieldSupplierNo));
        logger.info("Supplier was chosen for Rejecting, his number is: " + WebHelpers.getTextFromWebElement(approveSupplierPage.fieldSupplierNo));
        clickButton(approveSupplierPage.buttonRejected);
        sendTextToWebElement(approveSupplierPage.fieldCommentsAfterButtonREJECTED, "Supplier_was_rejected");
        clickButton(approveSupplierPage.buttonOkAfterButtonREJECTED);
        logger.info("Supplier was Rejected");
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Approval Process Selection", approvalProcessSelection.textInHeader.getText());
    }

    @Test
    //@Description ("changeNameAndJDEVendorForRejectedSupplier")
    //@DisplayName("changeNameAndJDEVendorForRejectedSupplier")
    public void test_3_clickButtonActivateForRejectedSupplier(){
        clickButton(mainPageLocators.linkSupplier);
        sendTextToWebElement(supplierSearchCreatePage.fieldSupplierNameCriterion, getCurrentTimeUsingCalendar2());
        clickWebElementIfEnable(supplierSearchCreatePage.radiobuttonInActiveStatus);
        clickButtonIfEnable(supplierSearchCreatePage.buttonSearch);
        clickButtonIfEnable(matchingSupplierListPage.buttonSupplier);
        findLastRawInTableAndClick2(driver, "//table[@id='supplier']/tbody/tr[last()]/td[last()]");

        System.out.println("Suppliers number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was chosen for Rejecting, his number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));

        clickButtonIfEnable(supplierDetailPage.buttonActivate);
        sendTextToWebElement(supplierDetailPage.fieldCommnets, "Rejected supplier will be Activated");
        clickButtonIfEnable(supplierDetailPage.buttonOk);

        Assert.assertEquals("Inactive", WebHelpers.getTextFromWebElement(supplierDetailPage.fieldStatus));
        Assert.assertEquals("New Supplier - Pending Approval", WebHelpers.getTextFromWebElement(supplierDetailPage.fieldApprovalStatus));
    }

    @Test
    public void test_4_stage_1_ApproveSupplierWithStatusNewPendingApproval(){
        clickButton(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approveSupplierListPage.dropdownlistSiteName, "DEMO SOS SITE"); // AGRO FARMA / DEMO SOS SITE
        findLastRawInTableAndClick2(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]");

        System.out.println("Approved Supplier number is: " + WebHelpers.getTextFromWebElement(approveSupplierPage.fieldSupplierNo));
        logger.info("Approved Supplier number is: " + WebHelpers.getTextFromWebElement(approveSupplierPage.fieldSupplierNo));

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
    public void test_5_stage_2_ApproveSupplierWithStatusNewPendingApproval(){
        clickButton(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approveSupplierListPage.dropdownlistSiteName, "DEMO SOS SITE");
        findLastRawInTableAndClick2(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]");

        System.out.println("Supplier was approved, his number is: " + WebHelpers.getTextFromWebElement(approveSupplierPage.fieldSupplierNo));
        logger.info("Supplier was approved, his number is: " + WebHelpers.getTextFromWebElement(approveSupplierPage.fieldSupplierNo));

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
    public void test_6_findApprovedSupplierAndCheckStatusAndApprovalStatus(){
        clickButton(mainPageLocators.linkSupplier);
        //selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "DEMO SOS SITE");
        sendTextToWebElement(supplierSearchCreatePage.fieldSupplierNameCriterion, getCurrentTimeUsingCalendar2());
        //clickButtonIfEnable(supplierDetailPage.radiobuttonInActiveStatus);
        clickButtonIfEnable(supplierSearchCreatePage.buttonSearch);
        clickButtonIfEnable(matchingSupplierListPage.buttonSupplier);
        findLastRawInTableAndClick2(driver, "//table[@id='supplier']/tbody/tr[last()]/td[last()]");

        System.out.println("Supplier was approved, his number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was approved, his number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));

        Assert.assertEquals("Active", supplierDetailPage.fieldStatus.getText());
        Assert.assertEquals("Approved", supplierDetailPage.fieldApprovalStatus.getText());

    }
}
