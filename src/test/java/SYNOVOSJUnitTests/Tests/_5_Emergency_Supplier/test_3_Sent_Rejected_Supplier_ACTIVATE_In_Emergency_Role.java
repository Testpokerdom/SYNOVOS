package SYNOVOSJUnitTests.Tests._5_Emergency_Supplier;

import SYNOVOSJUnitTests.Locators.LoginPage.LoginPageLocators;
import SYNOVOSJUnitTests.Locators.MainPage.MainPageLocators;
import SYNOVOSJUnitTests.Locators.PurchasingPage.*;
import SYNOVOSJUnitTests.Tests._1_Create_Supplier_New_NewPendingApproval_Emergency_Approved_Reject.Create_Supplier_Status_Reject;
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
import static SYNOVOSJUnitTests.WebHelpers.WebHelpers.goToUrl;
import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButtonIfEnable;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class test_3_Sent_Rejected_Supplier_ACTIVATE_In_Emergency_Role {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static SearchSuppliersPage supplierSearchCreatePage = null;
    public static CreateSupplierPage createSupplierPage = null;
    public static ApprovalProcessSelectionPage approvalProcessSelection = null;
    public static ApproveSupplierPage approveSupplierPage = null;
    public static SupplierDetailPage supplierDetailPage = null;
    public static EditSupplierPage editSupplierPage= null;
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
    public void test_1_reateSupplierWithStatusNewPendingApproval(){
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

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());
    }

    @Test
    //@Description ("rejectSupplierWithStatusNewPendingApproval")
    //@DisplayName("rejectSupplierWithStatusNewPendingApproval")
    public void test_2_rejectSupplierWithStatusNewPendingApproval(){
        clickButton(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approvalProcessSelection.dropdownlistSiteName, "DEMO SOS SITE"); // DEMO SOS SITE -- AGRO FARMA
        findLastRawInTableAndClick2(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]");
        System.out.println("Suppliers number for rejecting is: " + getTextFronWebElement(approveSupplierPage.fieldSupplierNo));
        logger.info("Supplier was chosen for Rejecting, his number is: " + getTextFronWebElement(approveSupplierPage.fieldSupplierNo));
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
    public void test_3_Sent_Rejected_Supplier_For_Approval_In_Emergency_Role(){
        clickButton(mainPageLocators.linkSupplier);
        sendTextToWebElement(supplierSearchCreatePage.fieldSupplierNameCriterion, getCurrentTimeUsingCalendar2());
        clickWebElementIfEnable(supplierSearchCreatePage.radiobuttonInActiveStatus);
        clickButtonIfEnable(supplierSearchCreatePage.buttonSearch);
        findLastRawInTableAndClick2(driver, "//table[@id='supplier']/tbody/tr[1]/td[last()]");
        System.out.println("Suppliers number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was chosen for Rejecting, his number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));

        clickButtonIfEnable(supplierDetailPage.buttonActivate);
        sendTextToWebElement(supplierDetailPage.fieldCommnets, "Some text");
        clickButtonIfEnable(supplierDetailPage.checkBoxEmergencyOrederSupplier);
        clickButtonIfEnable(supplierDetailPage.buttonOk);

        Assert.assertEquals("Supplier in current state cannot be set as an Emergency supplier.", supplierDetailPage.errorMessage.getText());
        Assert.assertEquals("Inactive", getTextFronWebElement(supplierDetailPage.fieldStatus));
        Assert.assertEquals("Rejected", getTextFronWebElement(supplierDetailPage.fieldApprovalStatus));
    }

}
