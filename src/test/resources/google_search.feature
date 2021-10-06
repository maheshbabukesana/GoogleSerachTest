Feature: Google Search

  Background:
    Given User navigate to the Google page
    Then Accept the cookies



  Scenario: Verify Google search parameter
    Given The search field should be displayed
    When  I type {search} on search
    Then I see predictive categories
    And  I press enter
    Then I can see all the related links to search keyword

  Scenario: Verify Google invalid search parameter
    Given The search field should be displayed
    When  I type {invalid search} on search
    Then I see  page not found message



