package Hooks;

import Page.AddToWishListPage;
import Page.CartPage;
import Page.HomePage;
import Page.LoginPage;
import Ultilities.TestBasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;



public class Hooks {

    @Before("@ClearWishList")
    public void openBrowserAndClearWishList() {
        System.out.println("before");
        TestBasePage.openBrowser();
        AddToWishListPage wishListPage=new AddToWishListPage(TestBasePage.getDriver());
        HomePage homepage=new HomePage(TestBasePage.getDriver());
        LoginPage loginPage = new LoginPage(TestBasePage.getDriver());
        homepage.Open().clickOnSignin();
        loginPage.login("chuongpt@maillinator.com","123456a@");
        loginPage.clickBtn();
        wishListPage.openWishListPage();
        wishListPage.removeAllProductInWishList();

    }
    @Before("@PlaceOrder")
    public void openBrowserAndCart() {
        System.out.println("before");
        TestBasePage.openBrowser();
        HomePage homepage=new HomePage(TestBasePage.getDriver());
        LoginPage loginPage = new LoginPage(TestBasePage.getDriver());
        CartPage cartPage= new CartPage(TestBasePage.getDriver());
        homepage.Open().clickOnSignin();
        loginPage.login("chuongpt@maillinator.com","123456a@");
        loginPage.clickBtn();
        cartPage.openCart();
        cartPage.removeAllProductInCart();
    }
    @Before("@Login, @Logout, @Register, @Homepage")
    public void openBrowser() {
        System.out.println("before");
        TestBasePage.openBrowser();
    }
    @Before("@ChangePass,@ChangeBilling,@wishlist")
    public void openBrowserWithLogin() {
        System.out.println("before");
        TestBasePage.openBrowser();
        HomePage homepage = new HomePage(TestBasePage.getDriver());
        LoginPage loginPage = new LoginPage(TestBasePage.getDriver());
        homepage.Open().clickOnSignin();
        loginPage.login("chuongpt@maillinator.com", "123456a@");
        loginPage.clickBtn();
    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TestBasePage.saveScreenshot();
        }
        TestBasePage.getDriver().quit();
    }

}
