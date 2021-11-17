package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumUtil;

public class HomePage {

    private final WebDriver driver;

    private By apartmentTypeDropdown = By.xpath("//div[text()='Apartment Type']");
    private By dropDown = By.id("searchCity");
    private By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private By buy = By.xpath("//div[text()='Buy'][1]");
    private By rent = By.xpath("//div[text()='Rent'][1]");
    private By commercial = By.xpath("//div[text()='Commercial'][1]");
    private By searchTextBox = By.cssSelector("#listPageSearchLocality");
    private String city = "//div[text()='%replaceable%']";
    private String suggestionAreas = "//span[contains(normalize-space(),'%replaceable%')]";
    private String apartmentType = "//span[text()='%replaceable%']";

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public HomePage selectCity(String city) {
        SeleniumUtil.click(driver, dropDown);
        SeleniumUtil.click(driver, By.xpath(this.city.replace("%replaceable%", city)));
        return this;
    }

    public HomePage selectAreaFromSuggestion(String area) {
        SeleniumUtil.click(driver, By.xpath(suggestionAreas.replace("%replaceable%", area)));
        return this;
    }

    public HomePage selectPropertyType(String type) {
        switch (type.toUpperCase()) {
            case "BUY":
                SeleniumUtil.click(driver, buy);
                break;
            case "RENT":
                SeleniumUtil.click(driver, rent);
                break;
            case "COMMERCIAL":
                SeleniumUtil.click(driver, commercial);
                break;
            default:
                // TODO
        }
        return this;
    }

    public HomePage enterAreaInSearchBox(String area) {
        SeleniumUtil.typeIntoTextBox(driver, searchTextBox, area);
        return this;
    }

    public HomePage clickOnApartmentType() {
        SeleniumUtil.click(driver, apartmentTypeDropdown);
        return this;
    }

    public HomePage selectApartmentType(String type) {
        SeleniumUtil.click(driver, By.xpath(apartmentType.replace("%replaceable%", type)));
        return this;
    }

    public ResultsPage clickSearchButton() {
        SeleniumUtil.click(driver, searchBtn);
        return new ResultsPage(driver);
    }





}
