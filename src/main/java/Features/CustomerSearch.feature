Feature: Search Customers Feature
  As a new user
  I want to be able to search customers
  So that I can filter the results on the page

  Background: Navigate to home page
    Given go to home page


  Scenario Outline:
    When the search phrase '<inputField>' is entered in the input field
    And the value from the dropdown'<SearchByDropdown>' is selected
    Then results are shown
    Examples:
    |inputField   |SearchByDropdown|
    |             |Id              |
    |             |Name            |
    |             |Email           |
    |             |City            |