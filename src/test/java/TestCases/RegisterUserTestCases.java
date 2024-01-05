package TestCases;

import Pages.RegisterScreen;
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

public class RegisterUserTestCases {
    @BeforeMethod
    public void setUp() throws IOException {
        setUpDriver("Edge");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(Utilities.getPropertyValue("URL"));
    }

    @Test(priority = 1, description = "Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public void signUpScreen() {
        new RegisterScreen(getDriver()).clickOnSignUpLoginButton()
                .setNewUserName(Utilities.getJsonData("RegisterData", "username"))
                .setNewUserEmail(Utilities.getJsonData("RegisterData", "email"))
                .clickOnSignUpButton();

        Assert.assertTrue(new RegisterScreen(getDriver()).checkEnterAccountLabel());
    }

    @Test (priority = 2, description = "Verify that 'ACCOUNT CREATED!' is visible")
    public void createNewAccount(){
        new RegisterScreen(getDriver()).clickOnSignUpLoginButton()
                .setNewUserName(Utilities.getJsonData("RegisterData","username"))
                .setNewUserEmail(Utilities.getJsonData("RegisterData","email"))
                .clickOnSignUpButton().clickOnTitleButton()
                .setPassword(Utilities.getJsonData("RegisterData","password"))
//                .clickOnDayDropdown(Utilities.getJsonData("RegisterData","day"))
//                .selectMonthOFBirth(Utilities.getJsonData("RegisterData","month"))
//                .selectYearOFBirth(Utilities.getJsonData("RegisterData","year"))
                .clickOnSignUpCheckBox().clickOnReceiveSpecialOffersCheckBox()
                .setFirstName(Utilities.getJsonData("RegisterData","username"))
                .setLastName(Utilities.getJsonData("RegisterData","lastname"))
                .setCompany(Utilities.getJsonData("RegisterData","company"))
                .setAddressOne(Utilities.getJsonData("RegisterData","address1"))
                .setAddressTwo(Utilities.getJsonData("RegisterData","address2"))
//                .selectCountry(Utilities.getJsonData("RegisterData","contry"))
                .setState(Utilities.getJsonData("RegisterData","state"))
                .setCity(Utilities.getJsonData("RegisterData","city"))
                .setZipCode(Utilities.getJsonData("RegisterData","zipcode"))
                .setMobileNumber(Utilities.getJsonData("RegisterData","mobile"))
                .clickOnCreateAccountButton();
        Assert.assertTrue(new RegisterScreen(getDriver()).checkAccountCreation());

    }

    @Test(priority = 3,description = "Verify that 'Logged in as username' is visible")
    public void login(){
        new RegisterScreen(getDriver()).clickOnSignUpLoginButton()
                .setNewUserName(Utilities.getJsonData("RegisterData","username"))
                .setNewUserEmail(Utilities.getJsonData("RegisterData","email"))
                .clickOnSignUpButton().clickOnTitleButton()
                .setPassword(Utilities.getJsonData("RegisterData","password"))
//                .clickOnDayDropdown(Utilities.getJsonData("RegisterData","day"))
//                .selectMonthOFBirth(Utilities.getJsonData("RegisterData","month"))
//                .selectYearOFBirth(Utilities.getJsonData("RegisterData","year"))
                .clickOnSignUpCheckBox().clickOnReceiveSpecialOffersCheckBox()
                .setFirstName(Utilities.getJsonData("RegisterData","username"))
                .setLastName(Utilities.getJsonData("RegisterData","lastname"))
                .setCompany(Utilities.getJsonData("RegisterData","company"))
                .setAddressOne(Utilities.getJsonData("RegisterData","address1"))
                .setAddressTwo(Utilities.getJsonData("RegisterData","address2"))
//                .selectCountry(Utilities.getJsonData("RegisterData","company"))
                .setState(Utilities.getJsonData("RegisterData","state"))
                .setCity(Utilities.getJsonData("RegisterData","city"))
                .setZipCode(Utilities.getJsonData("RegisterData","zipcode"))
                .setMobileNumber(Utilities.getJsonData("RegisterData","mobile"))
                .clickOnCreateAccountButton().clickOnContinueButton();

        Assert.assertTrue(new RegisterScreen(getDriver()).assertUserNameIsVisible());

        new RegisterScreen(getDriver()).clickOnDeleteAccountButton();

        Assert.assertTrue(new RegisterScreen(getDriver()).checkAccountDeletion());
    }

    @Test(priority = 4,description = "Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button")
    public void deleteAccount() {
        new RegisterScreen(getDriver()).clickOnSignUpLoginButton()
                .setNewUserName(Utilities.getJsonData("RegisterData", "username"))
                .setNewUserEmail(Utilities.getJsonData("RegisterData", "email"))
                .clickOnSignUpButton().clickOnTitleButton()
                .setPassword(Utilities.getJsonData("RegisterData", "password"))
//                .clickOnDayDropdown(Utilities.getJsonData("RegisterData","day"))
//                .selectMonthOFBirth(Utilities.getJsonData("RegisterData", "month"))
//                .selectYearOFBirth(Utilities.getJsonData("RegisterData", "year"))
                .clickOnSignUpCheckBox().clickOnReceiveSpecialOffersCheckBox()
                .setFirstName(Utilities.getJsonData("RegisterData", "username"))
                .setLastName(Utilities.getJsonData("RegisterData", "lastname"))
                .setCompany(Utilities.getJsonData("RegisterData", "company"))
                .setAddressOne(Utilities.getJsonData("RegisterData", "address1"))
                .setAddressTwo(Utilities.getJsonData("RegisterData", "address2"))
//                .selectCountry(Utilities.getJsonData("RegisterData", "company"))
                .setState(Utilities.getJsonData("RegisterData", "state"))
                .setCity(Utilities.getJsonData("RegisterData", "city"))
                .setZipCode(Utilities.getJsonData("RegisterData", "zipcode"))
                .setMobileNumber(Utilities.getJsonData("RegisterData", "mobile"))
                .clickOnCreateAccountButton().clickOnContinueButton().clickOnDeleteAccountButton();

        Assert.assertTrue(new RegisterScreen(getDriver()).checkAccountDeletion());

        new RegisterScreen(getDriver()).clickOnContinueButton();
    }
    @AfterMethod
    public static void quit(){
        quitDriver();
    }

}
