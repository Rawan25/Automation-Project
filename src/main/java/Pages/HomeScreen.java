package Pages;

import Utility.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomeScreen {
    private WebDriver driver;
    private final By testCasesButton = By.xpath("//div[@class='col-sm-8']/div/ul/li[5]/a");
    //*[@id="header"]/div/div/div/div[2]/div/ul/li[5]/a
    private final  String testCasesScreenURL = "https://automationexercise.com/test_cases";
    private final By productButton = By.xpath("//div[@class='col-sm-8']/div/ul/li[2]/a");
    //*[@id="header"]/div/div/div/div[2]/div/ul/li[2]/a

    private final By footer = By.id("footer");
    private final By subscriptionLabel = By.xpath("//div[@class='footer-widget']/div/div/div[2]/div/h2");
    private final By subscriptionEmailInput = By.id("susbscribe_email");
    private final By submitButton = By.id("subscribe");
    private final By successfulMessage = By.xpath("//div[@class='form-row']/div/div");

    public HomeScreen( WebDriver driver){
        this.driver = driver;
    }

    public HomeScreen clickOnTestCaseButton(){
        Utilities.clickOnButton(driver,testCasesButton);
        return this;
    }
    public boolean checkTestCasesScreenURL() throws IOException {
        return driver.getCurrentUrl().equals(Utilities.getPropertyValue("HomePageUrl"));
    }
    public ProductScreen clickOnProductButton(){
        Utilities.clickOnButton(driver,productButton);
        return new ProductScreen(driver);
    }

    public HomeScreen navigateToFooter(){
        Utilities.scrolling(driver,footer);
        return this;
    }
    public boolean checkVisibilityOfSubscriptionLabel(){
        return Utilities.isElementVisible(driver,subscriptionLabel);
    }
    public HomeScreen insertSubscriptionEmail(String data){
        Utilities.setData(driver,subscriptionEmailInput,data);
        return this;
    }
    public HomeScreen clickOnSubmitButton(){
        Utilities.clickOnButton(driver,submitButton);
        return this;
    }
    public boolean checkSuccessfulMessageIsVisible(){
        return Utilities.isElementVisible(driver,successfulMessage);
    }

}
