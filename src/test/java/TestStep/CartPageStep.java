package TestStep;

import Page.CartPage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.And;

public class CartPageStep {
    CartPage cartPage;
    public CartPageStep(){
        cartPage=new CartPage(TestBasePage.getDriver());
    }
    @And("Cart Page:Go to Shipping page")
    public void goToShippingPage(){
                cartPage.clikOnMiniCart();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cartPage.clickOnCheckout();

                }
}
