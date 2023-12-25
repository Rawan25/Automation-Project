package Utility;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.time.Duration;
import java.util.List;

public class Utilities {
    private static final String testDataPath = "src/main/resources/TestData/";


    public static void clickOnButton(WebDriver driver, By locator){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public static void setData(WebDriver driver, By locator, String data){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }

    public static String getData(WebDriver driver, By locator){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
      return driver.findElement(locator).getText();
    }
    public static List<WebElement> byToWebElementList(WebDriver driver, By locator){
        return (List<WebElement>) driver.findElement(locator);
    }
    public static List<WebElement> byToListWebElement(WebDriver driver, By locator){
        return (List<WebElement>) driver.findElements(locator);
    }
    public static void selectFromDropdown(WebDriver driver, By locator, String option){
        new Select((WebElement) byToListWebElement(driver, locator)).selectByVisibleText(option);
    }
    public static String getJsonData(String filename, String key){
        try {
            FileReader fileReader = new FileReader(testDataPath+filename+".json");
            JsonElement jsonElement =  JsonParser.parseReader(fileReader);
            return jsonElement.getAsJsonObject().get(key).getAsString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }
    public static Boolean isElementVisible(WebDriver driver, By locator){
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }



}
