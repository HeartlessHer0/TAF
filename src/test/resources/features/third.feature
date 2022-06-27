Feature: Parametrized Tests

  Scenario: Simple parametrized
    Given open browser
    And login page is opened
    When user with email "atrostyanko@gmail.com" and  psw "Americana#1" logged in
    Then add project button is displayed
    And username is "Alex Tros"
    And projects count is 15

  Scenario Outline: Tables
    Given open browser
    And login page is opened
    When user with email "<email>" and  psw "<psw>" logged in
    Then username is "<visibleTest>"
    Examples:
      | email                 | psw         | visibleText |
      | atrostyanko@gmail.com | Americana#1 | Alex Tros    |
      | test@gmail.com        | 124a#1      | 12           |
      | trostyanko@gmail.com | Americana#1 | Alex Tros    |