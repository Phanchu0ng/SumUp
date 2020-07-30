package TestStep;

import Page.ProductListingPage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ProductListingPageStep {
    public ProductListingPage productListingPage;

    public ProductListingPageStep(){
        productListingPage = new ProductListingPage(TestBasePage.getDriver());
    }

    @Given("go to Product List page")
    public void goToLoginPage() {
        productListingPage.open();
    }

    @And("change layout to list")
    public void changeLayoutToList() {
        productListingPage.changeToList();
    }

    @And("^set sorting product list by (.+?)$")
    public void setSortingProductListByPrice(String option) {
        productListingPage.sortBy(option);
    }

    @Then("the product list is sort correctly")
    public void theProductListIsSortCorrectly() throws Exception {
        Assert.assertTrue("The sort price function work incorrectly", productListingPage.verifySortByPriceCorrect());
    }


}
