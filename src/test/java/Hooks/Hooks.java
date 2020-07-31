package Hooks;

import Page.*;
import Ultilities.TestBasePage;
import Ultilities.Waitting;
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
    @Before("@ClearCompareList")
    public void openBrowserAndClearCompareList() {
        System.out.println("before");
        TestBasePage.openBrowser();
        ComparePage comparePage=new ComparePage(TestBasePage.getDriver());
        HomePage homepage=new HomePage(TestBasePage.getDriver());
        LoginPage loginPage = new LoginPage(TestBasePage.getDriver());
        homepage.Open().clickOnSignin();
        loginPage.login("chuongpt@maillinator.com","123456a@");
        loginPage.clickBtn();
        comparePage.openComparePage();
        comparePage.removeAllProductFromCompareList();

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
    @Before("@ChangePass, @ChangeBilling, @wishlist,@sortprice")
    public void openBrowserWithLogin() {
        System.out.println("before");
        TestBasePage.openBrowser();
        HomePage homepage = new HomePage(TestBasePage.getDriver());
        LoginPage loginPage = new LoginPage(TestBasePage.getDriver());
        homepage.Open().clickOnSignin();
        loginPage.login("chuongpt@maillinator.com", "123456a@");
        loginPage.clickBtn();
        Waitting waitting = new Waitting(TestBasePage.getDriver());
        waitting.waitForPageLoad();
    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TestBasePage.saveScreenshot();
        }
        TestBasePage.getDriver().quit();
    }

}
