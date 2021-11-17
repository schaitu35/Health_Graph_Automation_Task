package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumUtil;

public class ResultsPage {

    private final WebDriver driver;

    private String property= "article:nth-child(%replaceable%)";
    private String propertyViewBtn = " button";


    public ResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public PropertyPage selectProperty(String propertyNumber){
        String num = getNumberFromString(propertyNumber);
        By nThProperty = By.cssSelector(property.replace("%replaceable%", num));
        By nThPropertyBtn = By.cssSelector(property.replace("%replaceable%", num) + propertyViewBtn);
        SeleniumUtil.scrollToElement(driver, nThProperty);
        SeleniumUtil.click(driver, nThPropertyBtn);
        SeleniumUtil.switchToTabs(driver);
        return new PropertyPage(driver);
    }

    // This is Get the Number from Passed String
    private String getNumberFromString(String propertyNumber) {
        if(propertyNumber.contains("th")) return propertyNumber.split("th")[0];
        else if(propertyNumber.contains("nd")) return propertyNumber.split("nd")[0];
        else return propertyNumber.split("st")[0];
    }
}
