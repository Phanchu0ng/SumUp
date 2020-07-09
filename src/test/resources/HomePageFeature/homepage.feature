@Homepage
Feature: Check Action at Homepage
  Scenario: Check that after entering an invalid title (Ex: abcdef) in the search input then search
    Given Go to home page
    When Enter search value as hjhjkk
    Then No result return

  Scenario: Check go to Login Page when click on sign in
    Given Go to home page
    When Go to Login page
    Then Verify Check Title of page is Customer Login

  Scenario: Check go to Create New Customer Account Page when click on create new account
    Given Go to home page
    When Click on Create New account
    Then Verify Check Title of page is Create New Customer Account


  Scenario: Check that user can open a category from dropdownlist on header bar (Men >Tops >Tees)
    Given Go to home page
    When Open category from dropdown of header bar
      |firstmenu|secondmenu|thirdmenu|
      |Men|Tops|Tees|
    Then Check Catname Display On BreadCrumbs as Men
    And Check Catname Display On BreadCrumbs as Tops
    And Check Selected catname display in breadcrumbs as Tees

