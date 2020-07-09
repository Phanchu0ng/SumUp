@PlaceOrder
Feature: Check Place Order
  Scenario: Check Place an order success
    Given Add Product to Cart
      |product|
      |product1|
      |product2|
      |product3|
    And Cart Page:Go to Shipping page
    And Shipping page: Fill Shipping information
    And Shipping page: Choose Shipping method as Fixed
    And Shipping Page: Get Shipping fee of shipping method is Fixed
    And Shipping page: Click On Button Next to go to Payment page and waiting for payment page load
    And Payment page: Choose Payment Method is Cash On Delivery
    And Payment page: Click button Place order
    Then Place order successfull