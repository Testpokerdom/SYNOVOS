package SYNC.Locators.WorkPlaceLocators;

import SYNC.Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkPlaceLocators extends LoginPageLocators {
    public WorkPlaceLocators(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath = "//a[@class='ms-crm-NavBar-Group-Heading']//nobr[text()='My Work']")
    public WebElement buttonMyWork;
    @FindBy (xpath = "//a[@class='ms-crm-NavBar-Group-Heading']//nobr[text()='Reports']")
    public WebElement buttonReports;

    // My Work elements
    @FindBy (xpath = "//a[@id='nav_dashboards']//nobr[text()='Dashboards']")
    public WebElement buttonDashboards;
    @FindBy (xpath = "//a[@id='nav_activities']//nobr[text()='Activities']")
    public WebElement buttonActivities;
    @FindBy (xpath = "//a[@id='nav_calendar']//nobr[text()='Calendar']")
    public WebElement buttonCalendar;
    @FindBy (xpath = "//a[@id='eam_release_notes']//nobr[text()='Release Notes']")
    public WebElement buttonReleaseNotes;
    @FindBy (xpath = "//a[@id='eam_service_request']//nobr[text()='Service Requests']")
    public WebElement buttonServiceRequest;
    @FindBy (xpath = "//a[@id='eam_work_assignment']//nobr[text()='My Work Schedule']")
    public WebElement buttonMyWorkSchedule;
    @FindBy (xpath = "//a[@id='eam_estore']//nobr[text()='e-Catalog']")
    public WebElement buttonE_Catalog;
    @FindBy (xpath = "//a[@id='eam_glsearch']//nobr[text()='Global Search']")
    public WebElement buttonGlobalSearch;
    @FindBy (xpath = "//a[@id='eam_customeriq']//nobr[text()='Customer IQ']")
    public WebElement buttonCustomerIQ;
    @FindBy (xpath = "//a[@id='eam_availabledeployments']//nobr[text()='Deployments']")
    public WebElement buttonDeployments;
    @FindBy (xpath = "//a[@id='eam_microservices']//nobr[text()='Enterprise Applications']")
    public WebElement buttonEnterpriseApplication;

    //Reports elements
    @FindBy (xpath = "//a[@id='nav_reports']//nobr[text()='Standard']")
    public WebElement buttonStandart;
    @FindBy (xpath = "//a[@id='eam_consolidated_reports']//nobr[text()='Consolidated']")
    public WebElement buttonConsolidate;
    @FindBy (xpath = "//a[@id='eam_reportsexport']//nobr[text()='Scheduled']")
    public WebElement buttonScheduled;

}
