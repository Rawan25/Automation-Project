package TestCases;

import Pages.ContactUsScreen;
import Utility.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Listeners.IInvokedMethodListenerClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import static DriverManager.DriverManager.*;
import static DriverManager.DriverManager.getDriver;

@Listeners(IInvokedMethodListenerClass.class)

public final class ContactUsTestCase {


    @BeforeMethod
    public void setUp() throws IOException {
        setUpDriver("Edge");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(Utilities.getPropertyValue("URL"));
    }

    @Test(priority = 1, description = "Verify 'GET IN TOUCH' is visible")
    public void getInTouch(){
        new ContactUsScreen(getDriver()).clickOnContactUsButton();
        Assert.assertTrue(new ContactUsScreen(getDriver()).checkGetInTouchLabelIsVisible());
    }

    @Test(priority = 2,description = "Verify success message 'Success! Your details have been submitted " +
            "successfully.' is visible")
    public void sendEmail(){
        new ContactUsScreen(getDriver()).clickOnContactUsButton()
                .setName(Utilities.getJsonData("ContactUsData","username"))
                .setEmail(Utilities.getJsonData("ContactUsData", "email"))
                .setSubject(Utilities.getJsonData("ContactUsData", "subject"))
                .setMessage(Utilities.getJsonData("ContactUsData", "message"))
                .uploadFile().clickOnOKAlertButton();

        Assert.assertTrue(new ContactUsScreen(getDriver()).checkSuccessfulMessageLabelIsVisible());
    }

    @Test(priority = 3, description = "Verify that landed to home page successfully")

    public void navigateToHome() throws IOException {
        new ContactUsScreen(getDriver()).clickOnContactUsButton()
                .setName(Utilities.getJsonData("ContactUsData", "username"))
                .setEmail(Utilities.getJsonData("ContactUsData", "email"))
                .setSubject(Utilities.getJsonData("ContactUsData", "subject"))
                .setMessage(Utilities.getJsonData("ContactUsData", "message"))
                .uploadFile().clickOnOKAlertButton().clickOnHomeButton();

        Assert.assertTrue(new ContactUsScreen(getDriver()).checkCurrentURL());
    }

    @AfterMethod
    public static void quit(){
        quitDriver();
    }

}
