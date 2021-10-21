#Author: david.gutierrez@liferay.com
Feature: My Amazing Fragment
  I want to test My Amazing fragment

  Scenario: Test My Amazing Fragment as Admin
    Given I am logged in Liferay as "ADMINISTRATOR"
    When I navigate to "My Amazing Page"
    Then I can see my name
    And I can see my e-mail

  Scenario: Test My Amazing Fragment as Standard User
    Given I am logged in Liferay as "STANDARD_USER"
    When I navigate to "My Amazing Page"
    Then I can see my name
    And I can see my e-mail