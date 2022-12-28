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
Feature: Amazon Login
		The potential users should be able to login using valid credentials
		The potential users should not be able to login using invalid credentials

  @amazonValidCredentials
  Scenario: Amazon Login using valid credentials
  Given I am on amazon home page
  Then The sign in button displays
  When I click on the sign in button
  Then I should be directed to the log in page
  
  @amazonValidCredentials @amazonInvalidCredentials
  Scenario: amazonInvalidCredentials
  Given I am on amazon log in page
  When I enter an invalid email "jon.dow@gmail.com"
  And I click the continue button
  Then I should get the error message "We cannot find an account with that email address"
  And I should not be directed to password field.

