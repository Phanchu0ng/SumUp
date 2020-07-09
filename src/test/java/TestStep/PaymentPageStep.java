package TestStep;

import Page.PaymentPage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.And;

public class PaymentPageStep {
    PaymentPage paymentPage;
    public PaymentPageStep(){
        paymentPage=new PaymentPage(TestBasePage.getDriver());
    }
    @And("^Payment page: Choose Payment Method is (.+?)$")
    public void choosePaymentMethod(String PaymentMethod){
        paymentPage.choosePaymentMethod(PaymentMethod);
    }
    @And("Payment page: Click button Place order")
    public void clickBtnPlaceOrder(){
        paymentPage.clickBtnPlaceOrder();
    }
}
