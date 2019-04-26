package SOS.Locators.MainPage;

import SOS.Locators.LoginPage.LoginPageLocators;
import SOS.Locators.PurchasingPage.ApprovalProcessSelectionPage;
import SOS.Locators.PurchasingPage.CreateSupplierPage;
import SOS.Locators.PurchasingPage.SearchSuppliersPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static SOS.WebHelpers.WebHelpers.*;

public class MainClass {

    public static WebDriver driver = null;
    public static LoginPageLocators loginPageLocators = null;
    public static MainPageLocators mainPageLocators = null;
    public static SearchSuppliersPage supplierSearchCreatePage = null;
    public static CreateSupplierPage createSupplierPage = null;
    public static ApprovalProcessSelectionPage approveSupplierPage = null;
    public static final Logger logger = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Users//viktor.bibik//webdrivers//Chromedriver//chromedriver.exe");
        driver = new ChromeDriver();

        loginPageLocators = new LoginPageLocators(driver);
        mainPageLocators = new MainPageLocators(driver);
        supplierSearchCreatePage = new SearchSuppliersPage(driver);
        createSupplierPage = new CreateSupplierPage(driver);
        approveSupplierPage = new ApprovalProcessSelectionPage(driver);


        goToUrl(driver, "http://localhost:8080/sos/splashScreen.sos");
        sendTextToMultipleWebElements(loginPageLocators.fieldLogin, "VBIBIK18", loginPageLocators.fieldPassword, "deadman18");
        logger.info("dddddddddddddddddddddddddddddddddddddddddd");
        clickButton(loginPageLocators.buttonLogin);
        logger.info("dddddddddddddddddddddddddddddddddddddddddd");
        /*
        clickElement(homePageLocators.tablePurchasing);
        clickButton(homePageLocators.linkApproveSupplier);
        selectWebElementFromDropDownList(approveSupplierPage.dropdownlistSiteName, "AEROJET PROPULSION");
        //findLastRawInTableAndClick();
        findLastRawInTableAndClick2(driver,"//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]");
        */
    }
    public static String addMaxLengthComment(){
        String characters = "|";
        int length = 255;
        char[] text = new char[length];


        for (int i = 0; i < text.length; i++){
            System.out.print(characters);
        }
        return characters;
    }
/*
    public static String findLastTableRaw(){
        ApprovalProcessSelectionPage approveSupplierPage = new ApprovalProcessSelectionPage(driver);

        List columnOfLastRow = approveSupplierPage.tableSuppliersForApprove.last();
        for(WebElement e:columnOfLastRow)
        {
            System.out.println(e.getText());
        }
        System.out.println("========================================================================");
    }
*/

}
