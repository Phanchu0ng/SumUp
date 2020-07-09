package TestStep;

import Data.Customer;
import Page.PaymentPage;
import Page.ShippingPage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.And;
import junit.framework.Test;

public class ShippingPageStep {
    ShippingPage shippingPage;
    Customer customer;
    String shippingFee;
    PaymentPage paymentPage;

    public ShippingPageStep() {
        shippingPage = new ShippingPage(TestBasePage.getDriver());
        paymentPage = new PaymentPage(TestBasePage.getDriver());
    }

    @And("Shipping page: Fill Shipping information")
    public void fillShippingInformation() {
        if (shippingPage.checkShippingAddressFormDisplay()) {
            shippingPage.fillShippingAddress(customer.getFirstName(), customer.getLastName(), customer.getStress_address(), customer.getCity(), customer.getState(), customer.getZip_code(), customer.getCountry(), customer.getPhone_number());
        } else if (shippingPage.checkBtnNewAddressDisplay()) {
        }
    }

    @And("^Shipping page: Choose Shipping method as (.+?)$")
    public void chooseShippingMethod(String shippingMethod) {
        shippingPage.chooseShippingMethod(shippingMethod);
    }

    @And("^Shipping Page: Get Shipping fee of shipping method is (.+?)$")
    public String getShippingFee(String shippingMethod) {
        shippingFee = shippingPage.getShippingFeeInShippingPage(shippingMethod);
        return shippingFee;
    }

    @And("Shipping page: Click On Button Next to go to Payment page and waiting for payment page load")
    public void clickOnNextButton() {
        shippingPage.clickOnNextButton();
        paymentPage.waitloading();
    }
}
