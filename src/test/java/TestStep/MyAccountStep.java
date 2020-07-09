package TestStep;

import Page.MyAccountPage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en_scouse.An;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.Map;

public class MyAccountStep {
    public MyAccountPage myAccountPage;

    public MyAccountStep(){
        myAccountPage = new MyAccountPage(TestBasePage.getDriver());
    }
    @Given("Open My Account Page")
    public void openMyAccountPage(){
        myAccountPage.Open();
    }
    @And("My Account: Click On Link text Chang Password")
    public void clickChangPassWord(){
        myAccountPage.clickChangPass();
    }
    @And("^My Account: Input current pass as (.+?)$")
    public void inputCurrentPass(String currentPass){
        myAccountPage.inputcurrentPassword(currentPass);
    }
    @And("^My Account: Input new pass as (.+?)$")
    public void inputNewPass(String newPass){
        myAccountPage.inputnewPassword(newPass);
    }
    @And("^My Account: Input new pass confirm as (.+?)$")
    public void inputNewPassConfirm(String newPassConfirm){
        myAccountPage.inputnewPasswordConfirm(newPassConfirm);
    }
    @And("My Account: Click on Save change button")
    public void clickonSaveChangebtn(){
        myAccountPage.clickSaveChangePass();
    }
    @Given("My Account: Click Change billing address")
    public void clickChangeBillingAddress(){
        myAccountPage.clickEditBillAddress();
    }
    @And("My Account: Enter Billing Information")
    public void enterBillingInformation(DataTable table){
        Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);
        myAccountPage.fillBillingAddress(map.get("street"), map.get("city"), map.get("zip"), map.get("country"));
    }
    @And("My Account: Click on save Address Button")
    public void clickOnSaveAddress(){
        myAccountPage.clickOnSaveAddressBtn();
    }
    @And("My Account: Verify error message when street blank")
    public void verifyErrorStreetBlank(){
        Assert.assertEquals("This is a required field.",myAccountPage.errStreetBlank());
    }
    @And("My Account: Verify error message when city blank")
    public void verifyErrorCityBlank(){
        Assert.assertEquals("This is a required field.",myAccountPage.errCityBlank());
    }
    @And("My Account: Verify error message when zip blank")
    public void verifyErrorZipBlank(){
        Assert.assertEquals("This is a required field.",myAccountPage.errzipBlank());
    }
    @And("My Account: Verify error message when country blank")
    public void verifyErrorCountryBlank(){
        Assert.assertEquals("Please select an option.",myAccountPage.errCountryBlank());
    }
    @And("My Account:Verify error message when confirm pass is incorrect")
    public void verifyErrorConfirmPassNotMatch(){
        System.out.println(myAccountPage.errorConfirmPass());
        Assert.assertEquals("Please enter the same value again.",myAccountPage.errorConfirmPass());
    }
    @And("My Account:Verify error message when current pass is incorrect")
    public void verifyErrorCurrentPassIncorrect(){
        System.out.println(myAccountPage.errorCurrentPass());
        Assert.assertEquals("The password doesn't match this account. Verify the password and try again.",myAccountPage.errorCurrentPass());
    }
    @And("My Account:Verify Change shipping address is success")
    public void verifyAfterChangeSuccess(DataTable table){
        Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);
            Assert.assertTrue(myAccountPage.checkBillingInformation(map.get("street")));
        Assert.assertTrue(myAccountPage.checkBillingInformation(map.get("city")));
        Assert.assertTrue(myAccountPage.checkBillingInformation(map.get("zip")));
        Assert.assertTrue(myAccountPage.checkBillingInformation(map.get("country")));
    }
}
