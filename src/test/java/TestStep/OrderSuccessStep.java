package TestStep;

import Page.OrderSuccessPage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

public class OrderSuccessStep {
    OrderSuccessPage orderSuccessPage;
    public OrderSuccessStep(){
        orderSuccessPage = new OrderSuccessPage(TestBasePage.getDriver());

        }
    @Then("Place order successfull")
    public void verifyPlaceorderSuccess(){
        Assert.assertTrue(orderSuccessPage.checkOrderNumberDisplay());
    }
}
