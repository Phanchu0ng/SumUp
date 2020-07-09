@Login
   Feature: Login Test Case
  Scenario: Check Login with empty email and password
    Given Go to home page
    When Go to Login page
    And Login to website with username and password
    |email|pass|
    | | |
    Then Check message display under email is correctlly
    And Check message display under Pass is correctlly

     Scenario Outline:  CheckLogin With Email wrong format
      Given Go to home page
      When Go to Login page
      And input Email as <email>
      And input Password as <pass>
      And click on SignIn button
      Then Verify when email invalid format
      Examples:
        | email                  | pass   |
        | hihihahahehe@gmail..com | Test123456 |
        | abc@@gmail.com          | Test123456 |
        |fdsfdsf                  |Test123456  |

     Scenario: Check Login with invalid account
       Given Go to home page
       When Go to Login page
       And Login to website with username and password
         |email|pass|
         | chuongpt@maillinator.com|123 |
       Then Verify When login with invalid account


     Scenario: Check Login successfully
       Given Go to home page
       When Go to Login page
       And Login to website with username and password
         |email|pass|
         |chuongpt@maillinator.com | 123456a@|
       Then verify user is logged in successfully
