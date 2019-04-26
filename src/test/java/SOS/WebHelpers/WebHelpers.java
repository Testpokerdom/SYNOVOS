package SOS.WebHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static SOS.Locators.MainPage.MainClass.driver;

public class WebHelpers {
    public static void goToUrl(WebDriver driver, String url){

        driver.get(url);
    }

    public static void clickButton(WebElement button){

        button.click();
    }

    public static void clickElement(WebElement element){

        element.click();
    }

    public static String getTextFronWebElement(WebElement element){
        String getText = element.getText();
        return getText;
    }

    public static void clearTextField(WebElement textField){

        textField.clear();
    }

    public static void sendTextToWebElement(WebElement field, String text){
        field.clear();
        field.sendKeys(text);
    }

    public static void sendTextToMultipleWebElements(WebElement firstField, String login, WebElement secondField, String password){
        firstField.clear();
        firstField.sendKeys(login);
        secondField.clear();
        secondField.sendKeys(password);
    }

    public static boolean isElementDisplayed(WebElement element){
        boolean elementDisplayed = element.isDisplayed();
        return elementDisplayed;
    }

    public static boolean isElementEnabled(WebElement element){
        boolean elementDisplayed = element.isEnabled();
        return elementDisplayed;
    }

    public static void waitElementPresent(WebDriver driver,long seconds,WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void selectWebElementFromDropDownList(WebElement element, String elementValue){
        Select sel = new Select(element);
        sel.selectByValue(elementValue);
    }

    public static String randomName(){
        Random rand = new Random();
        String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz12345674890";
        Set<String> identifiers = new HashSet<String>();

        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(3)+3;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();

    }

    public static String randomName2(){
        Random rand = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz12345674890";
        String randomstring = "";
        int length = 10;

        char[] text = new char[length];
        for (int i=0; i < length; i++){
            text[i] = characters.charAt(rand.nextInt(characters.length()));
        }

        for (int i = 0; i < text.length; i++){
            randomstring += text[i];
        }

        return randomstring;
    }

    public static String addMaxLengthComment2(){
        Random rand = new Random();
        String characters = "|";
        String randomstring = "";
        int length = 256;

        char[] text = new char[length];
        for (int i=0; i < length; i++){
            text[i] = characters.charAt(rand.nextInt(characters.length()));
        }

        for (int i = 0; i < text.length; i++){
            randomstring += text[i];
        }

        return randomstring;
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
    public static void findLastRawInTableAndClick(){

        List<WebElement> columnOfLastRow= driver.findElements(By.xpath("//table[@id='approvalProcessData']/tbody/tr[last()]/td[last()]"));
        //List<WebElement> columnOfLastRow= driver.findElement(By.xpath(xpath));
        for( WebElement e:columnOfLastRow)
        {
            System.out.println(e.getText());
            //e.click();
        }
        System.out.println("========================================================================");

    }

    public static void findLastRawInTableAndClick2 (WebDriver driver, String xpath){

        List<WebElement> columnOfLastRow= driver.findElements(By.xpath(xpath));
        for( WebElement e:columnOfLastRow)
        {
            System.out.println(e.getText());
            e.click();
        }
        //System.out.println("========================================================================");

    }

    public static String getCurrentTimeUsingCalendar() {
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        String formattedDate=dateFormat.format(date);
        return  formattedDate;
    }

    public static String getCurrentTimeUsingCalendar2() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String formattedDate = dateFormat.format(date);

        return  formattedDate;
    }
}
