@compose_Functionality
Feature: Test the Yahoo Compose mail Functionality
  This will cover the Yahoo Compose mail functionality

  Background:
    Given Launch the browser and navigate to NOBROKER page

  Scenario: Verify search functionality for the multiple locality and description tag for the property.
    Given User at NOBROKER page and select "Buy" option.
    Then Select "Mumbai" city and type "Malad" in the search Box and select the following areas.
          | Malad East, Malkani Estate |
          | Malad west, Sundar Ln      |
    Then Click on the Search button after selecting  following Apartment types.
          | 2 BHK |
          | 3 BHK |
    And  Scroll down on the Property listing page and click on the "4th" property.
    When User inside the property page.
    Then scroll down and check "Description" content must "NOT EMPTY"
