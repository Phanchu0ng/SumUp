Feature: ProductListingPage

  @sortPrice
  Scenario: Check sort product by price
    Given go to Product List page
    And change layout to list
    And set sorting product list by price
    Then the product list is sort correctly