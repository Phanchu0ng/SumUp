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
    @When("Login to website with username and password")
    public void Login(DataTable table) {
        while (homepage.checkUserLoggedIn() == false) {
            Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);
            login.enterEmail(map.get("email"));
            login.enterPass(map.get("pass"));
            login.clickBtn();
        }
    }
}
