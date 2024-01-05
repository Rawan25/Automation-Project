package TestCases;

import Pages.HomeScreen;
import Pages.ProductScreen;
import Utility.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Listeners.IInvokedMethodListenerClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.time.Duration;

import static DriverManager.DriverManager.*;
import static DriverManager.DriverManager.getDriver;

@Listeners(IInvokedMethodListenerClass.class)

public class ProductTestCase {
    public SoftAssert softAssert;


    @BeforeMethod
    public void setUp() throws IOException {
        setUpDriver("Edge");
        setUpDriver("Edge");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(Utilities.getPropertyValue("URL"));
    }

    @Test(priority = 1,description = "Verify all the products related to search are visible")
    public void searchAboutProduct(){
        new HomeScreen(getDriver()).clickOnProductButton()
                .setSearchData(Utilities.getJsonData("SearchData" ,"product")).clickOnSearchButton()
                .clickOnSearchButton();

        Assert.assertTrue(new ProductScreen(getDriver())
                .checkSearchResult(Utilities.getJsonData("SearchData" ,"product")));
    }
    @Test (priority = 2, description = "Verify user is navigated to ALL PRODUCTS page successfully")
    public void navigateToProductScreen(){
        new HomeScreen(getDriver()).clickOnProductButton();

        Assert.assertTrue(new ProductScreen(getDriver()).checkProductScreenURL());
    }

    @Test(priority = 3, description = "Verify The products list is visible")
    public void productListIsVisible(){
        new HomeScreen(getDriver()).clickOnProductButton();

        Assert.assertTrue(new ProductScreen(getDriver()).checkProductListIsVisible());
    }

    @Test(priority = 4, description = "Verify that detail detail is visible: product name, category, price," +
            " availability, condition, brand")

    public void checkFirstProductDetails(){
        new HomeScreen(getDriver()).clickOnProductButton().clickOnFirstProduct();

        softAssert.assertTrue(new ProductScreen(getDriver()).checkFirstProductConditionIsVisible());
        softAssert.assertTrue(new ProductScreen(getDriver()).checkFirstProductAvailabilityIsVisible());
        softAssert.assertTrue(new ProductScreen(getDriver()).checkFirstProductBrandIsVisible());
        softAssert.assertTrue(new ProductScreen(getDriver()).checkFirstProductCategoryIsVisible());
        softAssert.assertTrue(new ProductScreen(getDriver()).checkFirstProductNameIsVisible());
        softAssert.assertTrue(new ProductScreen(getDriver()).checkFirstProductPriceIsVisible());
        softAssert.assertAll();

    }
    @AfterMethod
    public static void quit(){
        quitDriver();
    }}
