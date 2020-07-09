@ChangePass
Feature: Change Pass Word
  Scenario: Check Chang pass Word when Confirm Pass is incorrect
    Given Open My Account Page
    And My Account: Click On Link text Chang Password
    And My Account: Input current pass as 123456a@
    And My Account: Input new pass as 1234567aB@
    And My Account: Input new pass confirm as 1234567aC@
    And My Account: Click on Save change button
    Then My Account:Verify error message when confirm pass is incorrect

  Scenario: Check Chang pass Word when current Pass is incorrect
    Given Open My Account Page
    And My Account: Click On Link text Chang Password
    And My Account: Input current pass as 123456@
    And My Account: Input new pass as 1234567aB@
    And My Account: Input new pass confirm as 1234567aB@
    And My Account: Click on Save change button
    Then My Account:Verify error message when current pass is incorrect
