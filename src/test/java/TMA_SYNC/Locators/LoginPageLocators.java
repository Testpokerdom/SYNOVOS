package TMA_SYNC.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLocators {
    public LoginPageLocators(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    // Main page loginWithPopUp/password web elements
    @FindBy (name = "txtLogin")
    public WebElement fieldLogin;
    @FindBy (name = "txtPassword")
    public WebElement filedPassword;
    @FindBy (name = "txtClient")
    public WebElement filedClient;
    @FindBy (id = "Button1")
    public WebElement buttonLogin;
    @FindBy (id = "Button2")
    public WebElement buttonReset;
    @FindBy (id = "chkRememberMe")
    public WebElement checkboxRememeberMe;
    @FindBy (xpath = "//div[@id='forgotPasswordHolder']//a[@id='lblForgotPassword']")
    public WebElement linkIForgotMyPassword;


}
