package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumUtil;

public class PropertyPage {
    private final WebDriver driver;

    private By contactButton = By.xpath("//span[text()='Property Details ']");
    private String targetSection = "//div[text()='%replaceable%']";
    private String targetSectionContent = "/../following-sibling::div[1]";

    public PropertyPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isContactButtonDisplayed(){
        return SeleniumUtil.isElementDisplayed(driver, contactButton);
    }

    public boolean gotoSection(String section) {
        SeleniumUtil.scrollToElement(driver, By.xpath(targetSection.replace("%replaceable%", section)));
        return SeleniumUtil.getElementText(driver, By.xpath(targetSection.replace("%replaceable%", section) + targetSectionContent)).isEmpty();
    }


}
