#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Amazon Search items
  As a user I should be able to search different items

  @amazonSearch
  Scenario Outline: Searching for merchandises
    Given I am on the amazon home page
    Then I should be directed to Amazon homepage
    When I search "<items>"
    And I click the search button
    Then Searched item "<items>" should be displayed in the search bar

    Examples: items
      | items             |
      | Coffee mug        |
      | Pretty Coffee mug |
      | Cool Coffee mug   |
      | Cute Coffee mug   |
      | Ugly Coffee mug   |
