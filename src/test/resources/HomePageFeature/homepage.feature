@Homepage
Feature: Check Action at Homepage
  Scenario: Check that after entering an invalid title (Ex: abcdef) in the search input then search
    Given Go to home page
    When Enter search value as hjhjkk
    Then No result return

  Scenario: Check that after entering a valid title (Ex: Hero Hoodie) in the search input then search, results are returned
    Given Go to Login page
    When Enter search value as Hero Hoodie
    Then Product Hero Hoodie is existing in Search result

  Scenario: Check go to Login Page when click on sign in
    Given Go to home page
    When Go to Login page
    Then Verify Check Title of page is Customer Login
    And Login Page: Verify Textbox Email is display
    And Login Page: Verify Textbox Pass is display
    And Login Page: Verify Button Login is display

  Scenario: Check go to Create New Customer Account Page when click on create new account
    Given Go to home page
    When Click on Create New account
    Then Verify Check Title of page is Create New Customer Account
    And RegisterPage: Verify First Name field is display
    And RegisterPage: Verify Last Name field is display
    And RegisterPage: Verify Email field is display
    And RegisterPage: Verify PassWord field is display
    And RegisterPage: Verify Confirm PassWord field is display
    And RegisterPage: Verify Button create user is display


  Scenario: Check that user can open a category from dropdownlist on header bar (Men >Tops >Tees)
    Given Go to home page
    When Open category from dropdown of header bar
      |firstmenu|secondmenu|thirdmenu|
      |Men|Tops|Tees|
    Then Check Catname Display On BreadCrumbs as Men
    And Check Catname Display On BreadCrumbs as Tops
    And Check Selected catname display in breadcrumbs as Tees

  Scenario: Check Go to product detail page when click on product
    Given Go to home page
    When Click on product Breathe-Easy Tank
    Then Go to Product detail page with product name Breathe-Easy Tank

