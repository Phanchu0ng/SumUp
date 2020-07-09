@Logout
Feature: LogOut Test Case
  Scenario: Check Log-Out Successful
    Given Go to home page
    When Go to Login page
    And Login to website with username and password
      |email|pass|
      |chuongpt@maillinator.com | 123456a@|
    And Click on Sign Out
    Then Verify Log out success