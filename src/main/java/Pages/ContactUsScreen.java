package Pages;

import Utility.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ContactUsScreen
{
    private WebDriver driver;
    private final By getInTouchLabel = By.xpath("//div[@class='contact-form']/h2");
    private final By contactUsButton= By.className("fa-envelope");
    private final By nameInput = By.xpath("//div[@id='form-section']/form/div/input");
    private final By emailInput = By.xpath("//div[@id='form-section']/form/div[2]/input");
    private final By subjectInput = By.xpath("//div[@id='form-section']/form/div[3]/input");
    private final By messageInput = By.id("message");
    private final By submitButton = By.className("btn-primary");
    private final By homeButton = By.className("btn-success");

    private final String URL= "https://automationexercise.com/" ;


    private final By successfulMessageLabel = By.className("alert-success");
    private final By chooseFileButton = By.xpath("//form[@id='contact-us-form']/div[5]/input");



    public ContactUsScreen( WebDriver driver){
        this.driver =driver;
    }
    public boolean checkGetInTouchLabelIsVisible(){
        return Utilities.isElementVisible(driver,getInTouchLabel);
    }
    public ContactUsScreen clickOnContactUsButton(){
        Utilities.clickOnButton(driver,contactUsButton);
        return this;
    }
    public ContactUsScreen setName(String data){
        Utilities.setData(driver,nameInput,data);
        return this;
    }
    public ContactUsScreen setEmail(String data){
        Utilities.setData(driver,emailInput,data);
        return this;
    }
    public ContactUsScreen setSubject(String data){
        Utilities.setData(driver,subjectInput,data);
        return this;
    }
    public ContactUsScreen setMessage(String data){
        Utilities.setData(driver,messageInput,data);
        return this;
    }
    public boolean checkSuccessfulMessageLabelIsVisible(){
        return Utilities.isElementVisible(driver,successfulMessageLabel);
    }
    public HomeScreen clickOnHomeButton(){
        Utilities.clickOnButton(driver,homeButton);
        return new HomeScreen(driver);
    }

    public boolean checkCurrentURL() throws IOException {

        return driver.getCurrentUrl().equals(Utilities.getPropertyValue("URL"));
    }
    public ContactUsScreen uploadFile(){
        Utilities.uploadFile(driver,chooseFileButton);
        return this;
    }

    public ContactUsScreen clickOnOKAlertButton(){
        Utilities.acceptAlerts(driver,submitButton);
        return this;
    }



}
