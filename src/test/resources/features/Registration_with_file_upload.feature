@currentTest
Feature: This feature will do the registration and upload the file

  @iframe
  Scenario Outline: Register on naukri.com and upload the cv
    Given Navigate to the page "https://www.naukri.com/"
    And upload the candidate cv
    Then User will filled the details as "<Name>",  email, "<Mobile>"
    And close the browser

    Examples: 
      | Name      | Mobile     |
      | Test User | 0777668899 |
