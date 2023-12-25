package TestCases;

import Pages.RegisterScreen;
import Utility.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class RegisterUserTestCases {
public static WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver= new EdgeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @Test(priority = 1 ,description = "Verify that home page is visible successfully")
//    public void homeScreenVisibility(){
//        new RegisterScreen(driver).
//
//
//    }

    @Test(priority = 2, description = "Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public void signUpScreen() {
        new RegisterScreen(driver).clickOnSignUpLoginButton()
                .setNewUserName(Utilities.getJsonData("RegisterData", "username"))
                .setNewUserEmail(Utilities.getJsonData("RegisterData", "email"))
                .clickOnSignUpButton();

        Assert.assertTrue(new RegisterScreen(driver).checkEnterAccountLabel());
    }


    @Test (priority = 3, description = "Verify that 'ACCOUNT CREATED!' is visible")
    public void createNewAccount(){
        new RegisterScreen(driver).clickOnSignUpLoginButton()
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
              //  .selectCountry(Utilities.getJsonData("RegisterData","contry"))
                .setState(Utilities.getJsonData("RegisterData","state"))
                .setCity(Utilities.getJsonData("RegisterData","city"))
                .setZipCode(Utilities.getJsonData("RegisterData","zipcode"))
                .setMobileNumber(Utilities.getJsonData("RegisterData","mobile"))
                .clickOnCreateAccountButton();
        Assert.assertTrue(new RegisterScreen(driver).checkAccountCreation());

    }

    @Test(priority = 4,description = "Verify that 'Logged in as username' is visible")
    public void login(){
        new RegisterScreen(driver).clickOnSignUpLoginButton()
                .setNewUserName(Utilities.getJsonData("RegisterData","username"))
                .setNewUserEmail(Utilities.getJsonData("RegisterData","email"))
                .clickOnSignUpButton().clickOnTitleButton()
                .setPassword(Utilities.getJsonData("RegisterData","password"))
//                .clickOnDayDropdown(Utilities.getJsonData("RegisterData","password"))
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

        Assert.assertTrue(new RegisterScreen(driver).assertUserNameIsVisible());

        new RegisterScreen(driver).clickOnDeleteAccountButton();

        Assert.assertTrue(new RegisterScreen(driver).checkAccountDeletion());

    }

    @Test(priority = 5,description = "Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button")
    public void deleteAccount() {
        new RegisterScreen(driver).clickOnSignUpLoginButton()
                .setNewUserName(Utilities.getJsonData("RegisterData", "username"))
                .setNewUserEmail(Utilities.getJsonData("RegisterData", "email"))
                .clickOnSignUpButton().clickOnTitleButton()
                .setPassword(Utilities.getJsonData("RegisterData", "password"))
//                .clickOnDayDropdown(Utilities.getJsonData("RegisterData","password"))
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

        Assert.assertTrue(new RegisterScreen(driver).checkAccountDeletion());

        new RegisterScreen(driver).clickOnContinueButton();
    }

}
