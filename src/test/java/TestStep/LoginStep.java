package TestStep;

import Page.HomePage;
import Page.LoginPage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.Map;

public class LoginStep {
    public LoginPage login;
    public HomePage homepage;
    public LoginStep(){
        homepage = new HomePage(TestBasePage.getDriver());
        login = new LoginPage(TestBasePage.getDriver());
    }
    @And("^input Email as (.+?)$")
    public void inputEmailAs(String email) {
        login.enterEmail(email);
    }

    @And("^input Password as (.+?)$")
    public void inputPassAs(String pass) {
        login.enterPass(pass);
    }

    @And("click on SignIn button")
    public void clickOnSignInButton() {
        login.clickBtn();
    }

    @Then("verify user is logged in successfully")
    public void verifyUserIsLoggedInSuccessfully() {
        // check user log in successfully
        Assert.assertTrue("Login Successfully successfull",homepage.checkUserLoggedIn());
    }
    @And("Login to website with username and password")
    public void Login(DataTable table) {
//        while (homepage.checkUserLoggedIn() != true) {
            System.out.println("adhsdg");
            Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);
            login.enterEmail(map.get("email"));
            login.enterPass(map.get("pass"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            login.clickBtn();
//        }
    }
    @Then("Check message display under email is correctlly")
    public void messageDisplayUnderemail(){
        Assert.assertEquals("This is a required field.",login.getMessageEmailerror());
    }
    @And("Check message display under Pass is correctlly")
    public void messageDisplayUnderPass(){
        Assert.assertEquals("This is a required field.",login.getMessagePassError());
    }
    @Then("Verify when email invalid format")
    public void messageDisplayUnderInvalidEmailFormat(){
        Assert.assertEquals("Please enter a valid email address (Ex: johndoe@domain.com).",login.getMessageEmailerror());
    }
    @Then("Verify When login with invalid account")
    public void messageDisplayWhenInvalidAccount(){
        Assert.assertEquals("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.",login.getMessage());
    }
}
