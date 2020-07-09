@Register
Feature: Register Test Case
  Scenario: Check Register with empty field
    Given Go to home page
    When Click on Create New account
    And register information
      |firstname|lastname|email|pass|confirmpass|
      | | |                    |    |           |
    Then Verify error Message display under firstname
    And Verify error Message display under lastname
    And Verify error Message display under email
    And Verify error Message display under pass
    And Verify error Message display under pass confirm