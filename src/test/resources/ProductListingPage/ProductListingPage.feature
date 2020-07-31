
Feature: ProductListingPage
  @sortprice
  Scenario: Check sort product by price
    Given Go to Product Listing Page https://demo.smartosc.com/men/tops-men/jackets-men.html
    And click on list display
    And click on Sort by price
    Then the product list is sort correctly
  @ClearWishList
  Scenario: Check User able to add product to wishlist
    Given Go to Product Listing Page https://demo.smartosc.com/men/tops-men/jackets-men.html
    And Click Add product Montana Wind Jacket to WishList
    And Go to Product Listing Page https://demo.smartosc.com/men/tops-men/jackets-men.html
    Then verify product Montana Wind Jacket add to Wishlist on left bar

  @ClearCompareList
  Scenario: Check User able to add product to wishlist
    Given Go to Product Listing Page https://demo.smartosc.com/men/tops-men/jackets-men.html
    And Click Add product Montana Wind Jacket to Compare list
    Then verify product Montana Wind Jacket add to Compare list on left bar