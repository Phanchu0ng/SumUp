package TestStep;

import Data.Product;
import Data.ReadData;
import Page.AddToWishListPage;
import Page.ProductDeatailPage;
import Ultilities.TestBasePage;
import cucumber.api.java.en.And;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class ProductDetailPageStep {
    ProductDeatailPage productDetailPage;
    AddToWishListPage wishListPage;
    ReadData readProductdata = new ReadData();
    public ProductDetailPageStep(){
        productDetailPage = new ProductDeatailPage(TestBasePage.getDriver());
        wishListPage = new AddToWishListPage(TestBasePage.getDriver());
    }
    @And("click add product to wishlist")
    public void addProductToWishList(DataTable dataTable){
        List<Map<String,String>> mapList= dataTable.asMaps(String.class,String.class);
        for(Map<String,String> map:mapList){
            Product product=readProductdata.getProduct(map.get("product"));
            productDetailPage.addListOfProductToWishList(product);
            Assert.assertTrue("add product"+product.getName()+ "sucessfully",wishListPage.checkMessageAddToWishListSuccess());
        }

    }

    @And("Add Product to Cart")
    public void addProductToCart(DataTable dataTable){
        System.out.println("fhdsjfhs");
        List<Map<String,String>> mapList= dataTable.asMaps(String.class,String.class);
        for(Map<String,String> map:mapList){
            Product product=readProductdata.getProduct(map.get("product"));
            productDetailPage.addProductToCart(product);
            Assert.assertTrue("add product"+product.getName()+ "sucessfully",productDetailPage.messageSuccessDisplay());
        }

    }
    @And("^Go to Product detail page with product name (.+?)$")
    public void checkGotoProductDetaiPage(String name){
        productDetailPage.productNameDisplay(name);
    }
}
