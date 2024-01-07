package Pages;

import Utility.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductScreen {
    private WebDriver driver;
    private final String URL = "https://automationexercise.com/products";
    private final By productList = By.className("features_items");
    private final By firstProduct = By.xpath("a[@href='/product_details/1']/i");
//    /html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a/i
    //<a href="/product_details/1" style="color: brown;"><i class="fa fa-plus-square"></i>View Product</a>
    private final By firstProductName = By.xpath("div[class='product-information']/h2");
    private final By firstProductCategory = By.xpath("div[class='product-information']/p");
    private final By firstProductPrice = By.xpath("div[class='product-information']/span/span");
    private final By firstProductAvailability = By.xpath("div[class='product-information']/p[2]");
    private final By firstProductCondition = By.xpath("div[class='product-information']/p[3]");
    private final By firstProductBrand = By.xpath("div[class='product-information']/p[4]");
    private final By inputSearch = By.tagName("input");
    private final By searchButton = By.tagName("button");
    private final By searchResultProductLabel = By.xpath("div[@class='single-products']/div[1]/p");


    public ProductScreen( WebDriver driver){
        this.driver = driver;
    }

    public boolean checkProductScreenURL(){
        return driver.getCurrentUrl().equals(URL);
    }
    public boolean checkProductListIsVisible(){
        return Utilities.isElementVisible(driver,productList);
    }
    public ProductScreen clickOnFirstProduct(){
        Utilities.scrolling(driver,firstProduct);
        Utilities.clickOnButton(driver,firstProduct);
        return this;
    }
    public boolean checkFirstProductNameIsVisible() {
        return Utilities.isElementVisible(driver, firstProductName);
    }

    public boolean checkFirstProductBrandIsVisible() {
        return Utilities.isElementVisible(driver, firstProductBrand);
    }
    public boolean checkFirstProductConditionIsVisible() {
        return Utilities.isElementVisible(driver, firstProductCondition);
    }
    public boolean checkFirstProductCategoryIsVisible() {
        return Utilities.isElementVisible(driver,firstProductCategory);
    }
    public boolean checkFirstProductAvailabilityIsVisible() {
        return Utilities.isElementVisible(driver, firstProductAvailability);
    }
    public boolean checkFirstProductPriceIsVisible() {
        return Utilities.isElementVisible(driver, firstProductPrice);
    }


    public ProductScreen setSearchData(String data){
        Utilities.setData(driver,inputSearch,data);
        return this;
    }
    public ProductScreen clickOnSearchButton(){
        Utilities.clickOnButton(driver,searchButton);
        return this;
    }
    public boolean checkSearchResult(String data){
        String searchResultLabel = Utilities.getText(driver,searchResultProductLabel);
        return searchResultLabel.contains(data);
    }
}
