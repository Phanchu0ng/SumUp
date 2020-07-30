package TestStep;

import Data.Product;
import Data.ReadData;
import Page.AddToWishListPage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class WishListPageStep {
    AddToWishListPage wishListPage;
    Product product1, product2;
    List<Product> listProduct;
    ReadData readData = new ReadData();
    public WishListPageStep(){
        wishListPage = new AddToWishListPage(TestBasePage.getDriver());
    }
    @And("WishList: Verify Product in Wish-List Page")
    public void  verifyProductInWishListPage(DataTable table){
        List <Map<String,String>> mapList = table.asMaps(String.class, String.class);
        for (Map<String, String> map:mapList){
            Product product = readData.getProduct(map.get("product"));
            Assert.assertTrue("Product " + product.getName() + " is not added to wishlist!", wishListPage.checkProductNameDisplayInWishList(product));
            Assert.assertEquals(product.getPrice(), wishListPage.getSummaryProductPriceInWishList(product));
        }

    }
    @When("Wishlist: Go to Wishlist Page when have no product")
    public void GotoWishListWhenHaveNoItems(){
        wishListPage.openWishListPage();
        Assert.assertTrue(wishListPage.checkWishListPageIsEmpty());
    }
    @And("WishList: Click Remove product from wishlist")
    public void removeProductFromWishList(){
        wishListPage.removeProductWishList();
    }
    @Then("WishList: Verify Remove WishList Product Success")
    public void verifyRemoveWishListProduct(){
        Assert.assertTrue(wishListPage.checkMessageAddToWishListSuccess());
    }
    @Given("WishList: Go To WishList Page")
    public void goToWishListPage(){
        wishListPage.openWishListPage();
    }
    @And("WishList:Check that 3 buttons: Update Wish List, Share Wish list, Add All To Cart are  displayed")
    public void btnAreDisplay(){
        Assert.assertTrue(wishListPage.checkBtnUpdateWishListDisplay());
        Assert.assertTrue(wishListPage.checkBtnUpdateWishListDisplay());
        Assert.assertTrue(wishListPage.checkBtnAddAllToCartDisplay());
    }
    @And("WishList:Check that 3 buttons: Update Wish List, Share Wish list, Add All To Cart are not displayed")
    public void checkBtnAreNotDisplay(){
        wishListPage.checkBtnAreNotDiplay();

    }
}
