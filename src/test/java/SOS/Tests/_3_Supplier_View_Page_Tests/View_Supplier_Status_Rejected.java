package SOS.Tests._3_Supplier_View_Page_Tests;

import SOS.Locators.LoginPage.LoginPageLocators;
import SOS.Locators.MainPage.MainPageLocators;
import SOS.Locators.PurchasingPage.*;
import SOS.Tests._1_Create_Supplier_New_NewPendingApproval_Emergency_Approved_Reject.Create_Supplier_Status_Reject;
import SOS.WebHelpers.WebHelpers;
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
import static SOS.WebHelpers.WebHelpers.getCurrentTimeUsingCalendar2;
import static SOS.WebHelpers.WebHelpers.goToUrl;
import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButton;

public class View_Supplier_Status_Rejected {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static SearchSuppliersPage supplierSearchCreatePage = null;
    public static CreateSupplierPage createSupplierPage = null;
    public static ApprovalProcessSelectionPage approvalProcessSelection = null;
    public static ApproveSupplierPage approveSupplierPage = null;
    public static SupplierDetailPage supplierDetailPage = null;
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
    //@Description("_createSupplierWithStatusNewPendingApprova")
    //@DisplayName("_createSupplierWithStatusNewPendingApprova")
    public void test_1(){
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
    //@Description ("_rejectSupplierWithStatusNewPendingApproval")
    //@DisplayName("_rejectSupplierWithStatusNewPendingApproval")
    public void test_2(){
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
    //@Description ("_sendRejectedSupplierForApprovalFromSupplierDetailPage")
    //@DisplayName("_sendRejectedSupplierForApprovalFromSupplierDetailPage")
    public void test_3(){

        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "SALES"); // 130 - AGRO_FARMA;  SALES - DEMO;
        sendTextToWebElement(supplierSearchCreatePage.fieldSupplierNameCriterion, getCurrentTimeUsingCalendar2());
        clickWebElementIfEnable(supplierSearchCreatePage.radiobuttonInActiveStatus);
        clickButtonIfEnable(supplierSearchCreatePage.buttonSearch);

        clickButtonIfEnable(matchingSupplierListPage.buttonSupplier);
        findLastRawInTableAndClick2(driver, "//table[@id='supplier']/tbody/tr[last()]/td[last()]");
        System.out.println("Suppliers number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was chosen for Approve, his number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));

        Assert.assertEquals("Rejected", supplierDetailPage.fieldApprovalStatus.getText());
        Assert.assertEquals("ASD@UKR.NET", supplierDetailPage.fieldRemitTo.getText());
        Assert.assertEquals("Yes", supplierDetailPage.fieldProvidedW9.getText());

        clickButtonIfEnable(supplierDetailPage.buttonSendForApproval);
        sendTextToWebElement(supplierDetailPage.fieldCommnets, "Supplier with status New Supplier - pending Approval was send for approve from Supplier Detail page");
        clickButtonIfEnable(supplierDetailPage.buttonOk);


        Assert.assertEquals("New Supplier - Pending Approval", supplierDetailPage.fieldApprovalStatus.getText());
        Assert.assertTrue(WebHelpers.getTextFromWebElement(supplierDetailPage.fieldApprovalNotes).contains("04/22/2019 VBIBIKSU: Supplier with status New Supplier - pending Approval was send for approve from Supplier Detail page"));

    }
}
