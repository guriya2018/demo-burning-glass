@currentTest
Feature: This feature will do the registration and upload the file

  @iframe
  Scenario: Register on naukri.com and upload the cv
    Given Navigate to the page "https://www.naukri.com/"
    And upload the candidate cv
    And close the browser
    
