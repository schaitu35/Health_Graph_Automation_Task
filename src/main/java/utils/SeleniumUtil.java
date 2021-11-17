package utils;

import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SeleniumUtil {

    private static WebElement getElement(WebDriver driver, By element){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void click(WebDriver driver, By element){
        getElement(driver, element).click();
    }

    public static boolean isElementDisplayed(WebDriver driver, By element){
        return getElement(driver, element).isDisplayed();
    }

    public static void typeIntoTextBox(WebDriver driver, By element, String text){
        getElement(driver, element).sendKeys(text);
    }

    public static String getElementText(WebDriver driver, By element){
        return getElement(driver,element).getText();
    }

    public static void moveToElement(WebDriver driver, By element){
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(driver, element)).build().perform();
    }

    @SneakyThrows
    public static void scrollToElement(WebDriver driver, By element){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement e = getElement(driver, element);
        je.executeScript("arguments[0].scrollIntoView(true);", e);
        Thread.sleep(2000);
    }

    public static void switchToTabs(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle: windowHandles) {
            if(!Objects.equals(windowHandle, currentWindow)){
                driver.switchTo().window(windowHandle);
            }
        }
    }
}
