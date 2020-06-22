package TestStep;

import Page.HomePage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.Given;


public class HomePageStep {
    public HomePage homepage;

    public HomePageStep(){
        homepage = new HomePage(TestBasePage.getDriver());

    }
    @Given("Go to Login page")
    public void goToLoginPage() {
        homepage.Open().clickOnSignin();
    }

    @Given("Go to home page")
    public void goToHomepage() {
        homepage.Open();
    }
}
