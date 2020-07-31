package TestStep;

import Page.ProductListingPage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ProductListingPageStep {
    public ProductListingPage productListingPage;

    public ProductListingPageStep(){
        productListingPage = new ProductListingPage(TestBasePage.getDriver());
    }


    @When("^Go to Product Listing Page (.+?)$")
    public void goToProductListingPage(String url){
        productListingPage.openProductListingPage(url);
    }
    @And("click on list display")
    public void clickOnListDisplay(){
        productListingPage.clickOnListView();
    }
    @And("^click on Sort by (.+?)$")
    public void clickOnSortBy(String value){
        productListingPage.chooserMethodSortBy(value);
    }
    @And ("the product list is sort correctly")
    public void getListPrice(){
        productListingPage.verifySortByPriceCorrect();
    }
    @And("^Click Add product (.+?) to WishList$")
    public void addProductToWishList(String name){
        productListingPage.clickaddproducttowishlist(name);
    }
    @And("^Click Add product (.+?) to Compare list")
    public void addProductToCompare(String name){
        productListingPage.clickaddproducttocomparelist(name);
    }
    @And("^verify product (.+?) add to Compare list on left bar")
    public void verifyProductonCompare(String name){
       Assert.assertTrue(productListingPage.verifyCompareProductOnLeftbar(name));
    }
    @And("^verify product (.+?) add to Wishlist on left bar")
    public void verifyProductonWishList(String name){
        Assert.assertTrue(productListingPage.verifyWishlistProductOnLeftbar(name));
    }


}
