@Login
Feature: Login Test Case
  Scenario: Check Login with empty email and password
    Given Go to home page
    When Go to Login page
    And Login to website with username and password
    |email|pass|
    | | |