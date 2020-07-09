package TestStep;

import Page.HomePage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.Map;


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
    @And("Click on Sign Out")
    public void clickOnSigOut(){
        homepage.clickOnSignOut();
    }
    @Then("Verify Log out success")
    public void verifyLogOutSuccess(){
        Assert.assertTrue(homepage.checkUserLogOut());
    }
    @Given("Click on Create New account")
    public void clickOnCreateNewaccount(){
        homepage.clickRegister();
    }
    @Given("^Enter search value as (.+?)$")
    public void enterSearchvalue(String value){
        homepage.enterSearchValue(value);
    }
    @Then("No result return")
    public void verifyNoresultReturn(){
        Assert.assertTrue(homepage.noResultIsDisplayed());
    }
    @Then("^Verify Check Title of page is (.+?)$")
    public void verifyTitelOfPage(String tittle){
        System.out.println(homepage.getPageTitle());
        Assert.assertEquals(tittle,homepage.getPageTitle());

    }
    @Given("Open category from dropdown of header bar")
    public void OpenCatgory(DataTable table){
        Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);
        homepage.moveToTopMenu(map.get("firstmenu"), map.get("secondmenu"), map.get("thirdmenu"));
    }
    @Then("^Check Catname Display On BreadCrumbs as (.+?)$")
        public void verifyCatNameDisplayInBreadCrumbs(String catname){
        Assert.assertTrue(homepage.firstcatDisplayInBreadCrumb(catname));
    }
    @And("^Check Selected catname display in breadcrumbs as (.+?)$")
    public  void verifySelectedCatNameDisplayInBreadCrumbs(String selectedCat){
        Assert.assertTrue(homepage.selectedCatNameIsDisplay(selectedCat));
    }
}
