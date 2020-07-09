@AddProductToWishList
Feature: Add Product To Wish List Test Case
  @ClearWishList
  Scenario: Add Product To Wish List Successful
    Given click add product to wishlist
      |product|
      |product1|
      |product2|
    Then WishList: Verify Product in Wish-List Page
      |product|
      |product1|
      |product2|

  @wishlist
  Scenario: Add Product To Wish List Successful
    Given WishList: Go To WishList Page
    And WishList: Click Remove product from wishlist
    Then WishList: Verify Remove WishList Product Success
