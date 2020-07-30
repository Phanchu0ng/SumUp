@AddProductToWishList
Feature: Add Product To Wish List Test Case
  @ClearWishList
  Scenario: Add Product To Wish List Successful
    Given click add product to wishlist
      |product|
      |Juno Jacket|
      |Portia Capri|
    Then WishList: Verify Product in Wish-List Page
      |product|
      |Juno Jacket|
      |Portia Capri|

  @wishlist
  Scenario: Add Product To Wish List Successful
    Given WishList: Go To WishList Page
    And WishList: Click Remove product from wishlist
    Then WishList: Verify Remove WishList Product Success
   @ClearWishList
   Scenario: Check that 3 buttons: Update Wish List, Share Wish list, Add All To Cart are displayed when wishlist has items and vice versa
     Given Wishlist: Go to Wishlist Page when have no product
     Then WishList:Check that 3 buttons: Update Wish List, Share Wish list, Add All To Cart are not displayed
     And click add product to wishlist
       |product|
       |Portia Capri|
     And WishList: Go To WishList Page
     And WishList:Check that 3 buttons: Update Wish List, Share Wish list, Add All To Cart are  displayed