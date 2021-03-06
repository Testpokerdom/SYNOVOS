package SOS.Tests._1_Create_Supplier_New_NewPendingApproval_Emergency_Approved_Reject.Demo_CP_Site_Without_AoutoApproval;

import SOS.Locators.LoginPage.LoginPageLocators;
import SOS.Locators.MainPage.MainPageLocators;
import SOS.Locators.PurchasingPage.*;
import SOS.Tests.LoginPage.LoginPageTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SOS.WebHelpers.WebHelpers.findLastRawInTableAndClick2;
import static SOS.WebHelpers.WebHelpers.getTextFromWebElement;
import static SOS.WebHelpers.WebHelpers.goToUrl;
import static SOS.WebHelpers.WebHelpers.sendTextToWebElement;
import static WebHelpers.GettersAndSetters.getSupplierName;
import static WebHelpers.GettersAndSetters.setSupplierName;
import static WebHelpers.WebHelpers.clickButton;
import static WebHelpers.WebHelpers.clickElement;
import static WebHelpers.WebHelpers.selectWebElementFromDropDownList;
import static WebHelpers.WebHelpers.sendTextToMultipleWebElements;
import static WebHelpers.WebHelpers.*;

//import com.sun.org.glassfish.gmbal.Description;
//import com.sun.org.glassfish.gmbal.Description;
//import org.junit.jupiter.api.DisplayName;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Create_Supplier_Status_Approve_Demo_CP {
        public static WebDriver driver = null;
        public static LoginPageLocators loginPageLocators = null;
        public static MainPageLocators mainPageLocators = null;
        public static SearchSuppliersPage supplierSearchCreatePage = null;
        public static CreateSupplierPage createSupplierPage = null;
        public static ApprovalProcessSelectionPage approveSupplierListPage = null;
        public static ApproveSupplierPage approveSupplierPage = null;
        public static SupplierDetailPage supplierDetailPage = null;
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
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "DEMO"); // 130 - AGRO_FARMA;  SALES - DEMO; DEMO - Demo CP;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataTableAndSave2("asd@ukr.net", "Supplier_status_APPROVED_DEMO_SALES_", "","999-999-9999", "@ukr.net");

        clickButton(createSupplierPage.buttonSendForApproval);
        sendTextToWebElement(createSupplierPage.fieldComments, "Send_for_approval_test_creation");
        clickButtonIfEnable(createSupplierPage.buttonOKpopup);

        setSupplierName(supplierDetailPage.fieldSupplierName);

        System.out.println("Supplier was created, his Number is: " + getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was created, his Number is: " + getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());
    }

    @Test
    //@Description("stage_1_ApproveSupplierWithStatusNewPendingApproval")
    //@DisplayName("stage_1_ApproveSupplierWithStatusNewPendingApproval")
    public void test_2_stage_1_ApproveSupplierWithStatusNewPendingApproval(){
        clickButton(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approveSupplierListPage.dropdownlistSiteName, "DEMO CP SITE"); // AGRO FARMA / DEMO SOS SITE
        findLastRawInTableAndClick2(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]");

        System.out.println("Approved Supplier number is: " + getTextFromWebElement(approveSupplierPage.fieldSupplierNo));
        logger.info("Approved Supplier number is: " + getTextFromWebElement(approveSupplierPage.fieldSupplierNo));

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
    public void test_3_stage_2_ApproveSupplierWithStatusNewPendingApproval(){
        clickButton(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approveSupplierListPage.dropdownlistSiteName, "DEMO CP SITE");
        findLastRawInTableAndClick2(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]");

        System.out.println("Supplier was approved, his number is: " + getTextFromWebElement(approveSupplierPage.fieldSupplierNo));
        logger.info("Supplier was approved, his number is: " + getTextFromWebElement(approveSupplierPage.fieldSupplierNo));

        //selectWebElementFromDropDownList(createSupplierPage.dropdown_listJDE_Vendor, "6040");
        sendTextToWebElement(createSupplierPage.dropdown_listJDE_Vendor, "1045000");
        clickElement(createSupplierPage.jdeVendor2);

        clickButton(approveSupplierPage.buttonCREATE_Second_Stage);
        sendTextToWebElement(approveSupplierPage.fieldCommentsAfterButtonCREATE, "Approved_Supplier_Second_Stage");
        clickButton(approveSupplierPage.getButtonOkAfterButtonCREATE_second_stage);

        System.out.println("Supplier name is : " + getSupplierName());
        logger.info("Supplier successfully passed second approval stage.");
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Approval Process Selection", approveSupplierListPage.textInHeader.getText());
    }

}

