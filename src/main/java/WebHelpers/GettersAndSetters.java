package WebHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GettersAndSetters {

    private static String webElementText;
    private static String supplierNumber;
    private static String supplierName;


    public static String getSupplierNumber() {
        return supplierNumber;
    }

    public static void setSupplierNumber(WebElement suppNumber) {
        supplierNumber = suppNumber.getText();
    }

    public static String getSupplierName() {

        return supplierName;
    }

    public static void setSupplierName(WebElement suppName) {
        supplierName = suppName.getText();
    }



    public static String getWebElementValue(WebDriver driver, String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        webElementText = element.getText();
        return webElementText;
    }

    public static void setWebElementText(String webElementText) {
        GettersAndSetters.webElementText = webElementText;
    }
}
