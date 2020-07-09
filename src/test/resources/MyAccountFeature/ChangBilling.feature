@ChangeBilling
Feature: Change Billing Information from My account
  Scenario: Check billing with all information is blank
    Given Open My Account Page
    And My Account: Click Change billing address
    And My Account: Enter Billing Information
    |street|city|zip|country|
    | | | ||
    And My Account: Click on save Address Button
    Then My Account: Verify error message when street blank
    And My Account: Verify error message when city blank
    And My Account: Verify error message when zip blank
    And My Account: Verify error message when country blank

  Scenario: Check billing with all information is valid
    Given Open My Account Page
    And My Account: Click Change billing address
    And My Account: Enter Billing Information
      |street|city|zip|country|
      |Ngo 6 Vinh Phuc |Ha Noi | 100000|Việt Nam|
    And My Account: Click on save Address Button
    Then My Account:Verify Change shipping address is success
      |street|city|zip|country|
      |Ngo 6 Vinh Phuc |Ha Noi | 100000|Việt Nam|