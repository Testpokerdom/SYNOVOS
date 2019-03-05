package SYNC.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class LoginPageLocators {

    public  LoginPageLocators(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


}
