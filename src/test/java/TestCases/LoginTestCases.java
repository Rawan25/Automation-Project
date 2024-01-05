package TestCases;

import Pages.RegisterScreen;
import Utility.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import Listeners.IInvokedMethodListenerClass;

import static DriverManager.DriverManager.*;


@Listeners(IInvokedMethodListenerClass.class)

public class LoginTestCases {

    @BeforeMethod
    public void setUp() throws IOException {
        setUpDriver("Edge");
        setUpDriver("Edge");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(Utilities.getPropertyValue("URL"));
    }

    @Test(priority = 1, description = "Login User with correct email and password")
    public void successfulLogin(){

        new RegisterScreen(getDriver()).clickOnSignUpLoginButton();
        Assert.assertTrue( new RegisterScreen(getDriver()).checkLoginLabelIsVisible());

        new RegisterScreen(getDriver()).setLoginInput(Utilities.getJsonData("RegisterData", "correct_email"))
                .setPasswordLoginInput(Utilities.getJsonData("RegisterData", "password"))
                .clickOnLoginButton();
        Assert.assertTrue(new RegisterScreen(getDriver()).checkAccountLoggedIn());

        new RegisterScreen(getDriver()).clickOnDeleteAccountButton();
        Assert.assertTrue(new RegisterScreen(getDriver()).checkAccountDeletion());
    }

    @Test(priority = 2, description = "Login User with incorrect email and password")
    public void failLogin(){
        new RegisterScreen(getDriver()).clickOnSignUpLoginButton();
        Assert.assertTrue( new RegisterScreen(getDriver()).checkLoginLabelIsVisible());

        new RegisterScreen(getDriver()).setLoginInput(Utilities.getJsonData("RegisterData", "email"))
                .setPasswordLoginInput(Utilities.getJsonData("RegisterData", "password"))
                .clickOnLoginButton();
        Assert.assertTrue(new RegisterScreen(getDriver()).checkLoginErrorMessageIsVisible());
    }

    @Test(priority = 3, description = "Logout User")
    public void logout() throws IOException {
        new RegisterScreen(getDriver()).clickOnSignUpLoginButton();
        Assert.assertTrue( new RegisterScreen(getDriver()).checkLoginLabelIsVisible());

        new RegisterScreen(getDriver()).setLoginInput(Utilities.getJsonData("RegisterData", "correct_email"))
                .setPasswordLoginInput(Utilities.getJsonData("RegisterData", "password"))
                .clickOnLoginButton();
        Assert.assertTrue(new RegisterScreen(getDriver()).checkAccountLoggedIn());

        new RegisterScreen(getDriver()).clickOnLogoutButton();
        Assert.assertTrue(new RegisterScreen(getDriver()).assertCurrentURL());

    }

    @Test(priority = 4, description = "Register User with existing email")
    public void signupByExistingEmail(){
        new RegisterScreen(getDriver()).clickOnSignUpLoginButton();
        Assert.assertTrue( new RegisterScreen(getDriver()).checkLoginLabelIsVisible());

        new RegisterScreen(getDriver()).setNewUserName(Utilities.getJsonData("RegisterData","username"))
                .setNewUserEmail(Utilities.getJsonData("RegisterData","correct_email"))
                .clickOnSignUpButton();

        Assert.assertTrue(new RegisterScreen(getDriver()).checkSignupErrorMessage());

    }

    @AfterMethod
    public static void quit(){
        quitDriver();
    }


}
