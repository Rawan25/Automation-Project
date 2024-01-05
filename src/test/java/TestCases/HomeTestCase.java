package TestCases;

import Pages.HomeScreen;
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

@Listeners(IInvokedMethodListenerClass.class)

public class HomeTestCase {


    @BeforeMethod
    public void setUp() throws IOException {
        setUpDriver("Edge");
        setUpDriver("Edge");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(Utilities.getPropertyValue("URL"));
    }

    @Test (priority = 1, description = "Verify user is navigated to test cases page successfully")
    public void navigateToTestCase() throws IOException {
        new HomeScreen(getDriver()).clickOnTestCaseButton();

        Assert.assertTrue(new HomeScreen(getDriver()).checkTestCasesScreenURL());
    }
    @Test(priority = 2,description = "Verify text 'SUBSCRIPTION' is visible")
    public void navigateToFooter(){
        new HomeScreen(getDriver()).navigateToFooter();
        Assert.assertTrue(new HomeScreen(getDriver()).checkVisibilityOfSubscriptionLabel());
    }

    @Test(priority = 3,description = "Verify success message 'You have been successfully subscribed!' is visible")
    public void VerifySubscriptionMessage(){
        new HomeScreen(getDriver()).navigateToFooter()
                .insertSubscriptionEmail(Utilities.getJsonData("RegisterData", "email"))
                .clickOnSubmitButton();
        Assert.assertTrue(new HomeScreen(getDriver()).checkSuccessfulMessageIsVisible());

    }

    @AfterMethod
    public static void quit(){
        quitDriver();
    }
}
