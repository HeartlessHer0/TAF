Feature: Beginner test for Cucumber

  Scenario: Simple test without body

  Scenario: Simple test with Given
    Given open browser

  Scenario: Simple test with Given and When
    Given open browser
    When login page is opened

  Scenario: Simple test with all keywords
    Given open browser
    When login page is opened
    Then username field is displayed

  Scenario: Using AND in Given
      Given open browser
      And login page is opened

  Scenario: Using AND in Given
      Given open browser
      And login page is opened
      Then username field is displayed

