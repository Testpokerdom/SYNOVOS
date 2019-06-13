package SOS.Tests._12_PaymentTermsApprovalinitiation;

import SOS.Locators.LoginPage.LoginPageLocators;
import SOS.Locators.MainPage.MainPageLocators;
import SOS.Locators.PurchasingPage.*;
import SOS.Tests.LoginPage.LoginPageTests;
import SOS.WebHelpers.WebHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SOS.Locators.PurchasingPage.EditSupplierPage.supplierNameLogged;
import static SOS.WebHelpers.WebHelpers.findLastRawInTableAndClick2;
import static SOS.WebHelpers.WebHelpers.sendTextToWebElement;
import static WebHelpers.GettersAndSetters.getSupplierName;
import static WebHelpers.GettersAndSetters.setSupplierName;
import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickWebElementIfEnable;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_6_ApprovePaymentTermsPreviouslyValidated {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static SearchSuppliersPage supplierSearchCreatePage = null;
    public static CreateSupplierPage createSupplierPage = null;
    public static ApprovalProcessSelectionPage approveSupplierListPage = null;
    public static ApproveSupplierPage approveSupplierPage = null;
    public static SupplierDetailPage supplierDetailPage = null;
    public static EditSupplierPage editSupplierPage= null;
    public static MatchingSupplierListPage matchingSupplierListPage = null;
    public static final Logger logger = LogManager.getLogger(Test_6_ApprovePaymentTermsPreviouslyValidated.class);

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
        matchingSupplierListPage = new MatchingSupplierListPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        logger.info("------------------------------------------------------");
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
*/
    @Test
    public void test_1_createSupplierWithStatusNew(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "130"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataTableAndSave2("asd@ukr.net", "Supplier_status_New_DEMO_SALES_", "","999-999-9999", "@ukr.net");
        clickButtonIfEnable(createSupplierPage.buttonSave);
        setSupplierName(supplierDetailPage.fieldSupplierName);

        supplierNameLogged();
        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());

        clickButtonIfEnable(supplierDetailPage.buttonEdit);
        Assert.assertTrue(editSupplierPage.buttonSendForApprovalPaymentTerms.isEnabled() == true);

        clickButtonIfEnable(editSupplierPage.buttonSendForApprovalPaymentTerms);
        sendTextToWebElement(editSupplierPage.fieldCommentsInPopUpWindow, "Requested Payment Terms Approval");
        clickButtonIfEnable(editSupplierPage.buttonOkPopUpWindow);

        clickElement(mainPageLocators.tablePurchasing);
        clickWebElementIfEnable(mainPageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approveSupplierListPage.dropdownlistSiteName, "AGRO FARMA"); // AGRO FARMA / DEMO SOS SITE
        selectWebElementFromDropDownList(approveSupplierListPage.fieldSUpplierNameInTable, getSupplierName());
        Assert.assertEquals("Supplier Payment Terms Approval Process", approveSupplierListPage.fieldApprovalTypeLastString.getText());
        Assert.assertTrue(WebHelpers.getTextFromWebElement(approveSupplierListPage.fieldCommentsLastString).contains("(PT)"));

        approveSupplierPage.approveRequestedPaymentTermForSupplierWithStatusNEW(driver);

    }

    @Test
    public void test_2_sendForPaymentApprovalSupplierWithApprovedPreviouslyPaymentTerm(){
        clickWebElementIfEnable(mainPageLocators.tablePurchasing);
        clickWebElementIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "130"); // 130 - AGRO_FARMA;  SALES - DEMO;
        sendTextToWebElement(supplierSearchCreatePage.fieldSupplierNameCriterion, getSupplierName());
        clickButtonIfEnable(supplierSearchCreatePage.buttonSearch);

        supplierNameLogged();

        //clickButtonIfEnable(matchingSupplierListPage.buttonSupplier);
        findLastRawInTableAndClick2(driver, "//table[@id='supplier']/tbody/tr[last()]/td[last()]/a[@title='Edit Supplier']");
        clickButtonIfEnable(supplierDetailPage.buttonEdit);
        selectWebElementFromDropDownList(editSupplierPage.dropDownListRequestedPaymentTerms, "10"); //value 10 = "NET 25"
        clickButtonIfEnable(editSupplierPage.buttonSendForApprovalPaymentTerms);

        sendTextToWebElement(editSupplierPage.fieldCommentsInPopUpWindow, "The same required value was added");
        clickButtonIfEnable(editSupplierPage.buttonOkPopUpWindow);

        Assert.assertEquals("Current requested payment terms are already approved.", editSupplierPage.paymentTermsErrorInHeader.getText());
        Assert.assertEquals("Current requested payment terms are already approved.", editSupplierPage.fieldRequestedpaymentTermsErrorMessage.getText());
    }

}
