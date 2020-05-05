Feature: Search Customers Feature
  As a new user
  I want to be able to search customers
  So that I can filter the results on the page

  Background: Navigate to home page
    Given I go to home page


  Scenario Outline: Successfully Searching for Customers
    When I enter the  phrase '<phrase>' in the input field
    And I select value from the '<searchCriteria>' dropdown
    And I select '<matchCase>' option
    Then message contains phrase '<phrase>' and criteria '<searchCriteria>' with '<matchCase>'
    And message contains proper number of displayed rows
#    And there are elements containing '<phrase>' in field '<searchCriteria>' displayed in the table

    Examples:
      | phrase       | searchCriteria | matchCase          |
      | 1            | Id             | with match case    |
      | Bondir       | Name           | with match case    |
      | info@bond.ir | Email          | with match case    |
      | Melbourne    | City           | with match case    |
      | A            | Id             | with match case    |
      | 0            | Name           | with match case    |
      | 676          | Email          | without match case |
      | 123          | City           | without match case |
      | 2            | Id             | without match case |
      | alabaster    | Name           | without match case |
      | CONATACT     | Email          | without match case |
      | bELFAST      | City           | without match case |
