package Pages;

import Utility.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class RegisterScreen {
    private WebDriver driver;
    private final By signUpLoginButton = By.className("fa-lock");
    private final By newUserName = By.xpath("//div[@class='row']/div[3]/div/form/input[2]");
    private final By newUserEmail = By.xpath("//div[@class='row']/div[3]/div/form/input[3]");
    private final By signupErrorMessage = By.xpath("//div[@class='row']/div[3]/div/form/p");
    private final By signUpButton = By.xpath("//div[@class='row']/div[3]/div/form/button");
    private final By enterAccountLabel = By.tagName("b");
    private final By genderTitle = By.id("uniform-id_gender2");
    private final By passwordInput = By.id("password");
    private final By daysList = By.id("days");
    private final By monthsList = By.id("months");
    private final By yearsList = By.id("years");
    private final By signUpCheckBox = By.id("newsletter");
    private final By receiveSpecialOffersCheckBox = By.id("optin");
    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");
    private final By companyInput = By.id("company");
    private final By addressInput = By.id("address1");
    private final By address2Input = By.id("address2");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipCode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");
    private final By createAccountButton = By.className("btn-default");
    private final By accountCreatedText = By.tagName("b");
    private final By continueButton = By.className("btn-primary");
    private final By loggedInUser = By.tagName("b");
    private final By deleteAccountButton = By.className("fa-trash-o");
    private final By accountDeletedText = By.tagName("b");
    private final By loginLabel= By.xpath("//div[@class='login-form']//h2");

    private final By loginEmailInput = By.xpath("//form[@action='/login']//input[2]");
    private final By loginPasswordInput = By.xpath("//form[@action='/login']//input[3]");
    private final By loginButton = By.xpath("//form[@action='/login']//button");
    private final By loginErrorMessage = By.xpath("//form[@action='/login']//button");
    private final By loginUserName = By.className("fa-user");
    private final By logoutButton = By.className("fa-lock");
    private final String url = "https://automationexercise.com/login";




    public RegisterScreen(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterScreen clickOnSignUpLoginButton() {
        Utilities.clickOnButton(driver, signUpLoginButton);
        return this;
    }

    public RegisterScreen setNewUserName(String data) {
        Utilities.setData(driver, newUserName, data);
        return this;
    }

    public RegisterScreen setNewUserEmail(String data) {
        Utilities.setData(driver, newUserEmail, data);
        return this;
    }

    public RegisterScreen clickOnSignUpButton() {
        Utilities.clickOnButton(driver, signUpButton);
        return this;
    }
    public boolean checkEnterAccountLabel(){
        return Utilities.isElementVisible(driver,enterAccountLabel);
    }

    public RegisterScreen clickOnTitleButton() {
        Utilities.clickOnButton(driver, genderTitle);
        return this;
    }

    public RegisterScreen setPassword(String data) {
        Utilities.setData(driver, passwordInput, data);
        return this;
    }

    public RegisterScreen clickOnDayDropdown(String day) {
        Utilities.selectFromDropdown(driver, daysList,day);
        return this;
    }

    public RegisterScreen selectMonthOFBirth(String month) {
        Utilities.selectFromDropdown(driver, monthsList, month);
        return this;
    }

    public RegisterScreen selectYearOFBirth(String year) {
        Utilities.selectFromDropdown(driver, yearsList, year);
        return this;
    }

    public RegisterScreen clickOnSignUpCheckBox() {
        Utilities.clickOnButton(driver, signUpCheckBox);
        return this;
    }

    public RegisterScreen clickOnReceiveSpecialOffersCheckBox() {
        Utilities.clickOnButton(driver, receiveSpecialOffersCheckBox);
        return this;
    }

    public RegisterScreen setFirstName(String data) {
        Utilities.setData(driver, firstNameInput, data);
        return this;
    }

    public RegisterScreen setLastName(String data) {
        Utilities.setData(driver, lastNameInput, data);
        return this;
    }

    public RegisterScreen setCompany(String data) {
        Utilities.setData(driver, companyInput, data);
        return this;
    }

    public RegisterScreen setAddressOne(String data) {
        Utilities.setData(driver, addressInput, data);
        return this;
    }

    public RegisterScreen setAddressTwo(String data) {
        Utilities.setData(driver, address2Input, data);
        return this;
    }

    public RegisterScreen selectCountry(String option) {
        Utilities.selectFromDropdown(driver, country, option);
        return this;
    }

    public RegisterScreen setState(String data) {
        Utilities.setData(driver, state, data);
        return this;
    }

    public RegisterScreen setCity(String data) {
        Utilities.setData(driver, city, data);
        return this;
    }

    public RegisterScreen setZipCode(String data) {
        Utilities.setData(driver, zipCode, data);
        return this;
    }

    public RegisterScreen setMobileNumber(String data) {
        Utilities.setData(driver, mobileNumber, data);
        return this;
    }

    public RegisterScreen clickOnCreateAccountButton() {
        Utilities.clickOnButton(driver, createAccountButton);
        return this;
    }

    public boolean checkAccountCreation() {
        return Utilities.isElementVisible(driver, accountCreatedText);
    }

    public RegisterScreen clickOnContinueButton() {
        Utilities.clickOnButton(driver, continueButton);
        return this;
    }

    public boolean assertUserNameIsVisible() {
        return Utilities.isElementVisible(driver, loggedInUser);
    }

    public RegisterScreen clickOnDeleteAccountButton() {
        Utilities.clickOnButton(driver, deleteAccountButton);
        return this;
    }

    public boolean checkAccountDeletion() {
        return Utilities.isElementVisible(driver, accountDeletedText);
    }
    public boolean checkLoginLabelIsVisible(){
        return Utilities.isElementVisible(driver,loginLabel);
    }

    public RegisterScreen setLoginInput(String data) {
        Utilities.setData(driver, loginEmailInput, data);
        return this;
    }

    public RegisterScreen setPasswordLoginInput(String data){
        Utilities.setData(driver,loginPasswordInput,data);
        return this;
    }

    public RegisterScreen clickOnLoginButton(){
        Utilities.clickOnButton(driver,loginButton);
        return this;
    }
    public boolean checkAccountLoggedIn() {
        return Utilities.isElementVisible(driver, loginUserName);
    }
    public boolean checkLoginErrorMessageIsVisible(){
        return Utilities.isElementVisible(driver,loginErrorMessage);
    }
    public RegisterScreen clickOnLogoutButton(){
        Utilities.clickOnButton(driver,logoutButton);
        return this;
    }
    public Boolean assertCurrentURL() throws IOException {
        return driver.getCurrentUrl().equals(Utilities.getPropertyValue("Login_Screen"));
    }
    public boolean checkSignupErrorMessage(){
        return Utilities.isElementVisible(driver,signupErrorMessage);
    }
}

