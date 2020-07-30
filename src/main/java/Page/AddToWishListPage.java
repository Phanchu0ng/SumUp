package Page;

import Data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToWishListPage extends BasePage {
    public AddToWishListPage(WebDriver driver) {
        super(driver);
    }

    String XPATH_EMPTY_WISHLIST_PRODUCT = "//span[text()='You have no items in your wish list.']";
    String XPATH_PRODUCT_WISHLIST = "//div[@class='products-grid wishlist']//li[@class='product-item']";
    String XPATH_MESSAGE_ADD_TO_WISHLIST_SUCCESS = "//div[@data-ui-id='message-success']";
    String XPATH_SUMMARY_PRODUCT_WISHLIST_NAME = "//div[@class='products-grid wishlist']//strong[@class='product-item-name']/a[normalize-space(text())='%s']";
    String XPATH_SUMMARY_PRODUCT_WISHLIST_PRICE = "//div[@class='products-grid wishlist']//li[@class='product-item'][.//a[normalize-space(text())='%s']]//span[@class='price']";
    String XPATH_REMOVE_PRODUCT_FROM_WISHLISH = "//div[@class='products-grid wishlist']//li[@class='product-item']//a[@class='btn-remove action delete']";
    //String XPATH_MESSAGE_REMOVE_SUCCESS="//div[@data-bind='html: message.text']";
    String XPATH_BTN_UPDATE = "//button[@class='action update']";
    String XPATH_BTN_SHARE = "//button[@class='action share']";
    String XPATH_BTN_ADDTOCART = "//button[@class='action tocart']";

    public void openWishListPage() {
        driver.get("https://demo.smartosc.com/wishlist");
    }

    public void removeAllProductInWishList() {
        while (driver.findElements(By.xpath(XPATH_EMPTY_WISHLIST_PRODUCT)).size() == 0) {
//            this.actionHelper.movetoElement(By.xpath(XPATH_PRODUCT_WISHLIST));
            this.actionHelper.clickByJS(By.xpath(XPATH_REMOVE_PRODUCT_FROM_WISHLISH));
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeProductWishList() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.actionHelper.clickByJS(By.xpath(XPATH_REMOVE_PRODUCT_FROM_WISHLISH));

    }

    public boolean checkMessageAddToWishListSuccess() {
        return actionHelper.checkElementDisplay(By.xpath(XPATH_MESSAGE_ADD_TO_WISHLIST_SUCCESS));
    }

    public boolean checkProductNameDisplayInWishList(Product product) {
        return actionHelper.checkElementExist(By.xpath(String.format(XPATH_SUMMARY_PRODUCT_WISHLIST_NAME, product.getName())), 10);
    }

    public boolean checkBtnUpdateWishListDisplay() {
        return actionHelper.checkElementDisplay(By.xpath(XPATH_BTN_UPDATE));
    }

    public boolean checkBtnShareWishListDisplay() {
        return actionHelper.checkElementDisplay(By.xpath(XPATH_BTN_SHARE));
    }

    public boolean checkBtnAddAllToCartDisplay() {
        return actionHelper.checkElementDisplay(By.xpath(XPATH_BTN_ADDTOCART));
    }

    public String getSummaryProductPriceInWishList(Product product) {
        return actionHelper.getText(By.xpath(String.format(XPATH_SUMMARY_PRODUCT_WISHLIST_PRICE, product.getName())));
    }

    public boolean checkWishListPageIsEmpty() {
        return actionHelper.checkElementDisplay(By.xpath(XPATH_EMPTY_WISHLIST_PRODUCT));
    }

    public boolean checkBtnAreNotDiplay(){
        this.actionHelper.checkElementExist(By.xpath(XPATH_BTN_UPDATE),60);
        this.actionHelper.checkElementExist(By.xpath(XPATH_BTN_SHARE),60);
        this.actionHelper.checkElementExist(By.xpath(XPATH_BTN_ADDTOCART),60);
        return false;
    }
}

