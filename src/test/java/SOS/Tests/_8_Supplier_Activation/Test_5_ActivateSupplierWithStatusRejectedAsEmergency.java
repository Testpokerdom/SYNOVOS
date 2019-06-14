package SOS.Tests._8_Supplier_Activation;

import SOS.Locators.LoginPage.LoginPageLocators;
import SOS.Locators.MainPage.MainPageLocators;
import SOS.Locators.PurchasingPage.*;
import SOS.Tests._1_Create_Supplier_New_NewPendingApproval_Emergency_Approved_Reject.Demo_Agro_Farma_Site_Without_AutoApproval.Create_Supplier_Status_Reject;
import SOS.WebHelpers.WebHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SOS.WebHelpers.WebHelpers.findLastRawInTableAndClick2;
import static SOS.WebHelpers.WebHelpers.sendTextToWebElement;
import static WebHelpers.GettersAndSetters.getSupplierName;
import static WebHelpers.GettersAndSetters.setSupplierName;
import static WebHelpers.WebHelpers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_5_ActivateSupplierWithStatusRejectedAsEmergency {
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
    public void test_1_createSupplierWithStatusNewPendingApproval(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "130"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButtonIfEnable(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataTableAndSave2("asd@ukr.net", "Supplier_status_APPROVED_DEMO_SALES_", "","999-999-9999", "@ukr.net");
        clickButtonIfEnable(createSupplierPage.buttonSendForApproval);
        sendTextToWebElement(createSupplierPage.fieldComments, "Supplier was created and sent for approval with status New Supplier - Pending Approval");
        clickButtonIfEnable(createSupplierPage.buttonOKpopup);
        setSupplierName(supplierDetailPage.fieldSupplierName);

        System.out.println("Supplier was created, his Number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was created, his Number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());
    }

    @Test
    public void test_2_rejectSupplierWithStatusNewPendingApproval(){
        clickButton(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approveSupplierListPage.dropdownlistSiteName, "AGRO FARMA"); // AGRO FARMA / DEMO SOS SITE
        selectWebElementFromDropDownList(approveSupplierListPage.fieldSUpplierNameInTable, getSupplierName());
        findLastRawInTableAndClick2(driver, "//table[@id='approvalProcessData']/tbody/tr[1]/td[last()]"); // //table[@id='approvalProcessData']/tbody/tr[1]/td[last()] //table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]

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
    public void test_3_activateRejectedSupplierAsEmergency(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "130"); // 130 - AGRO_FARMA;  SALES - DEMO;
        sendTextToWebElement(supplierSearchCreatePage.fieldSupplierNameCriterion, getSupplierName());
        clickButtonIfEnable(supplierSearchCreatePage.radiobuttonInActiveStatus);
        clickButtonIfEnable(supplierSearchCreatePage.buttonSearch);
        clickButtonIfEnable(matchingSupplierListPage.buttonSupplier);
        findLastRawInTableAndClick2(driver, "//table[@id='supplier']/tbody/tr[last()]/td[last()]/a[@title='Edit Supplier']");

        System.out.println("Supplier was created, his Number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was created, his Number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));

        Assert.assertEquals("Inactive", supplierDetailPage.fieldStatus.getText());
        Assert.assertEquals("Rejected", supplierDetailPage.fieldApprovalStatus.getText());

        clickButtonIfEnable(supplierDetailPage.buttonActivate);
        clickButtonIfEnable(supplierDetailPage.checkBoxEmergencyOrederSupplier);
        clickButtonIfEnable(supplierDetailPage.buttonOk);

        Assert.assertEquals("Supplier in current state cannot be set as an Emergency supplier.", supplierDetailPage.errorMessageSupplierIncurrentStateCannotBeSetAsEmergency.getText());
        Assert.assertEquals("Inactive", supplierDetailPage.fieldStatus.getText());
        Assert.assertEquals("Rejected", supplierDetailPage.fieldApprovalStatus.getText());
        Assert.assertTrue(supplierDetailPage.buttonActivate.isEnabled() == true);
    }
}
