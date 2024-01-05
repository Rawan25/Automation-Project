package Utility;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Utilities {
    private static final String testDataPath = "src/main/resources/TestData/";
    private static final String screenshotPath = "src\\main\\resources\\ScreenShots\\";
    private static final String environmentPath = "src\\main\\resources\\environment.proprties";
    private static final String uploadFilePath = "C:\\Users\\ASUS\\Desktop\\UploadFileTest.txt";


    public static void clickOnButton(WebDriver driver, By locator){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public static void setData(WebDriver driver, By locator, String data){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }
    public static WebElement byToWebElement(WebDriver driver, By locator){
        return  driver.findElement(locator);
    }


    public static String getText(WebDriver driver, By locator){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
      return driver.findElement(locator).getText();
    }

    public static void selectFromDropdown(WebDriver driver, By locator, String option){
        new Select( byToWebElement(driver, locator)).selectByVisibleText(option);
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
    public static void scrolling(WebDriver driver, By locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",byToWebElement(driver,locator));
    }
    public static String  getTimeStamp(){

        return new SimpleDateFormat("YYYY-MM-dd_h-m-ss a").format(new Date());
    }
    public static void takeScreenShot(WebDriver driver, String name) throws IOException {
        Screenshot shot = new AShot().takeScreenshot(driver);
        File finalScreenShot = new File(screenshotPath + name + getTimeStamp() + ".png");
        ImageIO.write(shot.getImage(),"png",finalScreenShot);
        Allure.addAttachment(name, Files.newInputStream(Path.of(finalScreenShot.getPath())));
    }

    public static String getPropertyValue(String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(environmentPath));
        return properties.getProperty(key);
    }
    public static void WaitForAlerts(WebDriver driver)
    {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.
                        alertIsPresent());
    }
    public static void acceptAlerts(WebDriver driver,By locator)
    {
        clickOnButton(driver, locator);
        new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public static void uploadFile(WebDriver driver, By locator)
    {
        driver.findElement(locator).sendKeys(uploadFilePath);
    }


}
