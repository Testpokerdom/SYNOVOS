package SYNOVOSJUnitTests.Tests._6_TBD_Supplier;

import SYNOVOSJUnitTests.Locators.LoginPage.LoginPageLocators;
import SYNOVOSJUnitTests.Locators.MainPage.MainPageLocators;
import SYNOVOSJUnitTests.Locators.PurchasingPage.*;
import SYNOVOSJUnitTests.Tests.LoginPage.LoginPageTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static SYNOVOSJUnitTests.WebHelpers.WebHelpers.getTextFronWebElement;
import static WebHelpers.WebHelpers.*;
import static WebHelpers.WebHelpers.clickButtonIfEnable;

public class Create_TBD_Supplier {
    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static SearchSuppliersPage supplierSearchCreatePage = null;
    public static CreateSupplierPage createSupplierPage = null;
    public static ApprovalProcessSelectionPage approveSupplierListPage = null;
    public static ApproveSupplierPage approveSupplierPage = null;
    public static SupplierDetailPage supplierDetailPage = null;
    public static EditSupplierPage editSupplierPage = null;
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
        editSupplierPage = new EditSupplierPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        logger.info("------------------------------------------------------");
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
    public void createSupplierWithStatusNew(){
        clickButtonIfEnable(mainPageLocators.linkSupplier);
        selectWebElementFromDropDownList(supplierSearchCreatePage.dropdownListSiteCode, "SALES"); // 130 - AGRO_FARMA;  SALES - DEMO;
        clickButton(supplierSearchCreatePage.buttonCreate);
        createSupplierPage.fillUserDataTableAndSave3_TBD_Supplier("asd@ukr.net", "Supplier_status_APPROVED_DEMO_SALES_", "","999-999-9999", "@ukr.net");
        clickButtonIfEnable(createSupplierPage.buttonSave);

        //Allert popup window elements
        //System.out.println("Allert window text is: " + driver.switchTo().alert().getText());
        Assert.assertEquals("Saving the supplier as TBD supplier will make it approved rightaway. After that TBD status cannot be changed.", driver.switchTo().alert().getText()); // Current pop-up should contain text body specified in Assert
        driver.switchTo().alert().accept(); // click button Ok in Allert popup window

        System.out.println("Supplier was created, his Number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("Supplier was created, his Number is: " + getTextFronWebElement(supplierDetailPage.fieldSupplierNumber));
        logger.info("------------------------------------------------------");

        Assert.assertEquals("Supplier Detail", createSupplierPage.textSupplierDetails.getText());
        Assert.assertEquals("Active", supplierDetailPage.fieldStatus.getText());
        Assert.assertEquals("Approved", supplierDetailPage.fieldApprovalStatus.getText());
        System.out.println("Is button Send for Approval enable on the Supplier Detail Page: " + supplierDetailPage.buttonSendForApproval.isEnabled());
        Assert.assertTrue(supplierDetailPage.buttonSendForApproval.isEnabled() == false); // Button Send for Approval on the Supplier Detail page should be UNAVAILABLE

        clickButtonIfEnable(supplierDetailPage.buttonEdit);
        //System.out.println("Field To-Be-Determined Supplier get text: " + editSupplierPage.fieldTBDSupplier.getText());
        Assert.assertEquals("Yes", editSupplierPage.fieldTBDSupplier.getText()); //Checkbox To-Be-Determined Supplier should be unavailable. Instead of that should de text "Yes".
    }
}
