package TestStep;

import Page.HomePage;
import Page.RegisterPage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.Map;

public class RegisterPageStep {
    public HomePage homePage;
    public RegisterPage registerPage;
    public RegisterPageStep(){
        homePage= new HomePage(TestBasePage.getDriver());
        registerPage = new RegisterPage(TestBasePage.getDriver());
    }
     @Then("Verify error Message display under firstname")
     public void messageDisplayUnderFirstName(){
         Assert.assertEquals("This is a required field.",registerPage.firstNameEmptyError());
     }
    @Then("Verify error Message display under lastname")
    public void messageDisplayUnderLastName(){
        Assert.assertEquals("This is a required field.",registerPage.lastNameEmptyError());
    }
    @Then("Verify error Message display under email")
    public void messageDisplayUnderEmail(){
        Assert.assertEquals("This is a required field.",registerPage.emailEmptyError());
    }
    @Then("Verify error Message display under pass")
    public void messageDisplayUnderPass(){
        Assert.assertEquals("This is a required field.",registerPage.passEmptyError());
    }
    @Then("Verify error Message display under pass confirm")
    public void messageDisplayUnderPassConfirm(){
        Assert.assertEquals("This is a required field.",registerPage.reEnterPassEmptyError());
    }
    @And("register information")
    public void registerAccount(DataTable table) {
        System.out.println("adhsdg");
        Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);
        registerPage.register(map.get("firstname"),map.get("lastname"),map.get("email"),map.get("pass"),map.get("confirmpass"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        registerPage.clickBtnSubmit();
//        }
    }
}
