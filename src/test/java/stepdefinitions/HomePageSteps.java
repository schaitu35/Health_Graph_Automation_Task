package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.junit.Assert;
import pages.HomePage;
import pages.PropertyPage;
import pages.ResultsPage;

import java.util.List;

public class HomePageSteps {

    private HomePage homePage;
    private ResultsPage resultsPage;
    private PropertyPage propertyPage;

    @Given("^Launch the browser and navigate to NOBROKER page$")
    public void launch_the_browser_and_navigate_to_NOBROKER_page() {
        homePage = new HomePage(DriverFactory.getDriver());
    }


    @Given("User at NOBROKER page and select {string} option.")
    public void userAtNOBROKERPageAndSelectOption(String arg0) {
        homePage.selectPropertyType(arg0);
    }


    @And("Scroll down on the Property listing page and click on the {string} property.")
    public void scrollDownOnThePropertyListingPageAndClickOnTheProperty(String arg0) {
        propertyPage = resultsPage.selectProperty(arg0);
    }

    @When("User inside the property page.")
    public void userInsideThePropertyPage() {
        Assert.assertTrue(propertyPage.isContactButtonDisplayed());
    }


    @SneakyThrows
    @Then("Select {string} city and type {string} in the search Box and select the following areas.")
    public void selectCityAndTypeInTheSearchBoxAndSelectTheFollowingAreas(String city, String subArea, DataTable table) {
        homePage.selectCity(city);
        List<String> areas = table.asList();
        for (String area: areas) {
            homePage.enterAreaInSearchBox(subArea);
            homePage.selectAreaFromSuggestion(area);
            Thread.sleep(2000);
        }

    }

    @SneakyThrows
    @Then("Click on the Search button after selecting  following Apartment types.")
    public void clickOnTheSearchButtonAfterSelectingFollowingApartmentTypes(DataTable table) {
        List<String> types = table.asList();
        homePage.clickOnApartmentType();
        for (String apartmentType : types) {
            homePage.selectApartmentType(apartmentType);
            Thread.sleep(2000);
        }
       resultsPage = homePage.clickSearchButton();

    }

    @Then("scroll down and check {string} content must {string}")
    public void scrollDownAndCheckContentMust(String arg0, String arg1) {
        switch (arg1.toUpperCase()) {
            case "NOT EMPTY":
                Assert.assertFalse(propertyPage.gotoSection(arg0));
                break;
            case "EMPTY":
                Assert.assertTrue(propertyPage.gotoSection(arg0));
                break;
            default:
                // TODO
        }
    }
}
