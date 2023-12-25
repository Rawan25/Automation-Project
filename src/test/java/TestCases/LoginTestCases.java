package TestCases;

import Pages.RegisterScreen;
import Utility.Utilities;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestCases {
    public static WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver= new EdgeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1, description = "Login User with correct email and password")
    public void successfulLogin(){

        new RegisterScreen(driver).clickOnSignUpLoginButton();
        Assert.assertTrue( new RegisterScreen(driver).checkLoginLabelIsVisible());

        new RegisterScreen(driver).setLoginInput(Utilities.getJsonData("RegisterData", "correct_email"))
                .setPasswordLoginInput(Utilities.getJsonData("RegisterData", "password"))
                .clickOnLoginButton();
        Assert.assertTrue(new RegisterScreen(driver).checkAccountLoggedIn());

        new RegisterScreen(driver).clickOnDeleteAccountButton();
        Assert.assertTrue(new RegisterScreen(driver).checkAccountDeletion());
    }

    @Test(priority = 2, description = "Login User with incorrect email and password")
    public void failLogin(){
        new RegisterScreen(driver).clickOnSignUpLoginButton();
        Assert.assertTrue( new RegisterScreen(driver).checkLoginLabelIsVisible());

        new RegisterScreen(driver).setLoginInput(Utilities.getJsonData("RegisterData", "email"))
                .setPasswordLoginInput(Utilities.getJsonData("RegisterData", "password"))
                .clickOnLoginButton();
        Assert.assertTrue(new RegisterScreen(driver).checkLoginErrorMessageIsVisible());
    }

    @Test(priority = 3, description = "Logout User")
    public void logout(){
        new RegisterScreen(driver).clickOnSignUpLoginButton();
        Assert.assertTrue( new RegisterScreen(driver).checkLoginLabelIsVisible());

        new RegisterScreen(driver).setLoginInput(Utilities.getJsonData("RegisterData", "correct_email"))
                .setPasswordLoginInput(Utilities.getJsonData("RegisterData", "password"))
                .clickOnLoginButton();
        Assert.assertTrue(new RegisterScreen(driver).checkAccountLoggedIn());

        new RegisterScreen(driver).clickOnLogoutButton();
        Assert.assertTrue(new RegisterScreen(driver).assertCurrentURL());

    }

    @Test(priority = 4, description = "Register User with existing email")
    public void signupByExistingEmail(){
        new RegisterScreen(driver).clickOnSignUpLoginButton();
        Assert.assertTrue( new RegisterScreen(driver).checkLoginLabelIsVisible());

        new RegisterScreen(driver).setNewUserName(Utilities.getJsonData("RegisterData","username"))
                .setNewUserEmail(Utilities.getJsonData("RegisterData","correct_email"))
                .clickOnSignUpButton();

        Assert.assertTrue(new RegisterScreen(driver).checkSignupErrorMessage());

    }






}
