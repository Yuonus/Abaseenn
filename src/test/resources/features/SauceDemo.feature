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
Feature: Sauce Demo Login criterion
  		The potential user should be able to login to sauce demo using valid credentials
  		The potential user should not be able to login to sauce demo using invalid credentials

  Background: 
    Given I am on the sauce demo home page

  @sauceDemoValidLogin
  Scenario: Login using valid credentials
    When The user enter a user name "standard_user"
    And The user enter a password "secret_sauce"
    When The user click on login button
    Then The user should be able to login with valid credentials
    And The user should see a total of 6 items there

  @sauceDemoInvalidLogin
  Scenario: Sauce Demo invalid login
    When I login with a user name "standard_user" and a password "secret_invalid"
    And I click on the login button
    Then I should not be able to login with invalid password
    And the error message "Epic sadface: Username and password do not match any user in this service" should appear under the password field

  @SaucedemoDDT
  Scenario Outline: User should not be able to login to sauce demo page using invalid credentials
    Given the user is on sauce demo home page
    When the user enter invalid username "<userName>" and password "<password>"
    And the user click on the login button
    Then the user should not be able to login
    And error message "Epic sadface: Username and password do not match any user in this service" should appear under the password field

    Examples: Invalid credentials
      | userName       |  | password       |
      | standard_userr |  | secret_invalid |
      | GULAB          |  | Kareem         |
      | Sam            |  | Samandar       |
      | Sabawoon       |  | Yuonus         |
      | KossShireen    |  | Public         |
