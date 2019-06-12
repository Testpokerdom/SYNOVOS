package SOS.Tests._13_ApproveSupplierPage;

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

import static SOS.WebHelpers.WebHelpers.getTextFromWebElement;
import static SOS.WebHelpers.WebHelpers.goToUrl;
import static WebHelpers.GettersAndSetters.*;
import static WebHelpers.WebHelpers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_1_CheckMainPageElements {
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
    public void test_1_createSupplierWithStatusNewSupplierPendingApproval(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "130"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataTableAndSave2("asd@ukr.net", "Supplier_status_APPROVED_DEMO_SALES_", "","999-999-9999", "@ukr.net");
        clickButtonIfEnable(createSupplierPage.buttonSendForApproval);
        sendTextToWebElement(createSupplierPage.fieldComments, "Supplier was created and sent for approval with status New Supplier - Pending Approval");
        clickButtonIfEnable(createSupplierPage.buttonOKpopup);

        setSupplierNumber(supplierDetailPage.fieldSupplierNumber);
        setSupplierName(supplierDetailPage.fieldSupplierName);

        System.out.println("Supplier was created, his Number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was created, his Number is: " + WebHelpers.getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());
    }

    @Test
    public void test_2_createSupplierEmergency(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "130"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataEmergencySupplier("asd@ukr.net","Supplier_Emergency_DEMO_SALES_", "123-123-1234", "@ukr.net", "Emergency supplier was created");
        clickButtonIfEnable(createSupplierPage.buttonOKpopup);
        System.out.println("Emergency Supplier was created, his number is: " + getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Emergency Supplier was created, his number is: " + getTextFromWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());
    }

    @Test
    public void test_3_checkSiteCodeDropDownList(){
        clickButtonIfEnable(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approvalProcessSelection.dropDownListSiteCode, "130");
        //findLastRawInTableAndGetValue(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[1]");
        setWebElementText(findLastRawInTableAndGetValue(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[1]"));

        Assert.assertEquals("130", getWebElementValue(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[1]"));
    }

    @Test
    public  void test_4(){
        clickButtonIfEnable(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approvalProcessSelection.dropDownListSiteCode, "130");
        System.out.println("site code is: " + getWebElementValue(driver, "//table[@id='approvalProcessData']/tbody/tr[last()]/td[1]"));
        System.out.println("Supplier number is: " + getSupplierNumber());
        System.out.println("Supplier name is: " + getSupplierName());
    }
}
