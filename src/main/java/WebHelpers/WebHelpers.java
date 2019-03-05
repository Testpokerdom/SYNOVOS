package WebHelpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class WebHelpers {

    public static final Logger logger = LogManager.getLogger(WebHelpers.class);

    public static void goToUrl(WebDriver driver, String url){

        driver.get(url);
        logger.info("Open URL: " + url);
    }

    public void login(WebDriver driver, String uname, String pwd){
        String TEST_ENVIRONMENT = "us01.dynamicseam.com";
        String URL = "https://" + uname + ":" + pwd + "@" + TEST_ENVIRONMENT;
        driver.get(URL);
    }

    public static void clickButton(WebElement button){
        String buttonValue = button.getAttribute("value");
        button.click();

        logger.info("Click Button \""  + buttonValue +  "\"");
    }

    public static void clickButtonIfEnable(WebElement button){
        String buttonValue = button.getAttribute("value");
        String buttonText = button.getText();
        String buttonId = button.getAttribute("id");
        if(button.isEnabled() == true){
            button.click();
            logger.info("Click Button  with value - \""  + buttonValue +  "\" - " + buttonText + " - " + buttonId);
        } else {
            System.out.println("Element is not enable");
            logger.info("Button" + buttonValue + "is not available");
        }
    }

    public static void clickElement(WebElement element){

        element.click();
        logger.info("Click WebElement \""  + element.getText() +  " \"");
    }

    public static String getTextFromWebElement(WebElement element){
        String getText = element.getText();
        System.out.println(getText);
        logger.info("WebElement text \""  + getText +  "\" was received: ");
        return getText;
    }

    public static String getTextFromWebElementAttribute(WebElement element){
        String attributeText = element.getAttribute("value");
        System.out.println("WebElement text \"" + attributeText +  "\"");
        logger.info("WebElement text \""  + attributeText +  "\" was received: ");
        return  attributeText;
    }

    public static String getAttibuteWebElement(WebElement element){
        String getAttribute = element.getAttribute("value");
        System.out.println(getAttribute);
        logger.info("Receive weelement attribute: \""  + getAttribute +  "\"");
        return  getAttribute;

    }

    public static void clearTextField(WebElement textField){

        textField.clear();
    }

    public static void sendTextToWebElement(WebElement field, String text){
        field.clear();
        field.sendKeys(text);
        logger.info("Send text to WebElement: \""  + field +  "\". Text: " + "\" " + text + "\"");
    }

    public static void sendTextToMultipleWebElements(WebElement firstField, String login, WebElement secondField, String password, WebElement thirdField, String client){
        firstField.clear();
        firstField.sendKeys(login);
        logger.info("Send text to WebElement Login: " + "\"" + login + "\"");
        secondField.clear();
        secondField.sendKeys(password);
        logger.info("Send text to WebElement Password: " + "\"" + password + "\"");
        thirdField.clear();
        thirdField.sendKeys(client);
        logger.info("Send text to WebElement Client: " + "\"" + client + "\"");
    }
    public static void sendTextToWebElementFromDropDownList(WebElement field, WebElement requiredString){
        field.click();
        field.clear();
        requiredString.click();
    }

    public static void sendTextToWebElementFromDropDownList2(WebElement field, String text, WebElement requiredString, WebDriver driver){
        field.click();
        field.clear();
        field.sendKeys(text);
        String requiredText = requiredString.getText();
        waitElementPresence(driver, 5, requiredString);
        requiredString.click();
        logger.info("Send text: " + requiredText + " - to the WebElement - " + field);

    }

    public static boolean isElementDisplayed(WebElement element){
        boolean elementDisplayed = element.isDisplayed();
        return elementDisplayed;
    }

    public static boolean isElementEnabled(WebElement element){
        boolean elementEnabled = element.isEnabled();
        if(element.isEnabled() == true){
            System.out.println("Element value is: " + element.getTagName()+ "." + " Is element enabled - " + elementEnabled);
            logger.info("WebElement is enabled. Webelement name is " + element.getTagName());
        } else {
            System.out.println("Element with value - " + element.getTagName() + " - is not enable");
            logger.info("WebElement is enabled. Webelement name is " + element.getTagName());
        }
        return elementEnabled;
    }

    public static void clickWebElementIfEnable(WebElement element){
        if (element.isEnabled() == true){
            element.click();
            logger.info("Click WebElement: \""  + element.getText() +  " \"");
        } else {
            System.out.println("Element is not enable");
            logger.info("Web element is not enabled. WebElement is: \""  + element.getText() +  " \"");
        }
    }

    public static void waitElementPresence(WebDriver driver, long seconds, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("Wait web element presence: \"" + element.getText() + "\" for seconds - " + seconds);
    }

    public static void waitElementAttributeShouldHaveValue(WebDriver driver, long seconds, WebElement element, String attribute, String value){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public static void waitElement(WebDriver driver,long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        logger.info("Just wait for some web element.");
    }

    public static void selectWebElementFromDropDownList (WebElement element, String elementValue){
        Select sel = new Select(element);
        sel.selectByVisibleText(elementValue);

        List<WebElement> options = sel.getOptions();
        int size = options.size();

        for (int i=0; i<size; i++){
            String value = options.get(i).getText();
            System.out.println(value);
        }
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
    public static void findLastRawInTableAndClick(WebDriver driver){

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

    public static void switchToNewWindow(WebDriver driver){

        String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                driver.switchTo().window(windowHandle);
                //driver.manage().window().maximize();
                String pagetitle = driver.getTitle();
                logger.info("Switch to the new window: " + pagetitle);
            }
        }
    }

    public static void switchToIFrame (WebDriver driver, WebElement iframe){
        driver.switchTo().frame(iframe);
        System.out.println("Iframe was found by locator with value - " + iframe);
        logger.info("Switch to IFrame: " + iframe);
    }

    public static void listOfWebElementsFindSpecificOne(WebDriver driver, WebElement element){

        boolean isChecked = false;
		List<WebElement> elementFormList = driver.findElements(
				By.xpath("//div[@id='txtType_ComboBox_DropDown']//li[5]"));
		int size = elementFormList.size();
		System.out.println("Size of the list: " + size);
		for (int i=0; i<size; i++) {
			isChecked = elementFormList.get(i).isSelected();

			if (!isChecked) {
                elementFormList.get(i).click();
			}
		}

        /*
        WebElement ul = element;
        List<WebElement> options = ul.findElements(By.tagName("li"));
        for(WebElement sample: options)
        {
            if(sample.getText().equals("PO")){
                sample.click();
                break;
            }
        }
        */
    }

}
