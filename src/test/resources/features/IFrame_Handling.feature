@currentTest
Feature: This feature will test iframe handling

  @iframe
  Scenario: Fetch the BSE & NSE exchange rate values from rediff.com
    Given Navigate to the page "https://www.rediff.com/"
    And fetch the current values of NSE & BSE from the page
    And close the browser
