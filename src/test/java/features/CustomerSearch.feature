Feature: Search Customers Feature
  As a new user
  I want to be able to search customers
  So that I can filter the results on the page

  Background: Navigate to home page
    Given I go to home page


  Scenario Outline: Successfully Searching for Customers
    When I enter the  phrase '<phrase>' in the input field
    And I select value from the '<searchCriteria>' dropdown
    Then message contains phrase '<phrase>' and criteria '<searchCriteria>' with '<matchCase>'
    And there are elements containing '<phrase>' in field '<searchCriteria>' displayed in the table

    Examples:
      | phrase       | searchCriteria | matchCase |
      | 1            | Id             | matchCase |
      | Bondir       | Name           | matchCase |
      | info@bond.ir | Email          | matchCase |
      | Melbourne    | City           | matchCase |
      | A            | Id             | matchCase |
      | 0            | Name           | matchCase |
      | 676          | Email          | matchCase |
      | 123          | City           | matchCase |

#  Scenario Outline:Unsuccessfully Searching for Customers
#    When the search phrase '<inputField>' is entered in the input field
#    And the value from the dropdown'<SearchByDropdown>' is selected
#    Then proper results are not shown
#    Examples:
#      |inputField   |SearchByDropdown|
#      | A           |Id              |
#      | 0           |Name            |
#      | 676         |Email           |
#      | 123         |City            |