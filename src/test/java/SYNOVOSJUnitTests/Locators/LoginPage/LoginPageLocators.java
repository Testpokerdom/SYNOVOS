package SYNOVOSJUnitTests.Locators.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLocators {
    public LoginPageLocators(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    // Main page loginWithPopUp/password web elements
    @FindBy (xpath = "//table[@class='logintable']//input[@name='userName']")
    public WebElement fieldLogin;
    @FindBy (name = "password")
    public WebElement fieldPassword;
    @FindBy (name = "loginWithPopUp")
    public WebElement buttonLogin;
    @FindBy (xpath = "//table[@class='logintable']//a[@title='Click to reset your password.']")
    public WebElement linkForgotPassword;
    @FindBy (xpath = "//table[@class='logintable']//a[@href='resetPassword.htm']")
    public WebElement linkSynovosWebPage;
    @FindBy (css = "table.logintable:nth-child(4) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) font:nth-child(1) > b:nth-child(1)")
    public WebElement messageIncorrectLoginOrPassword;

    // main page after Login
    @FindBy (xpath = "//div[@id='menu_bar']//div[@id='topRightItems']")
    public WebElement userNickName;


}
