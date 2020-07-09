package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    String XPATH_MINICART="//div[@class='minicart-wrapper']";
    String ID_BTN_CHECKOUT="top-cart-btn-checkout";
    String XPATH_GO_TO_CART="//a[@class='action viewcart']";
    String XPATH_BUTTON_REMOVE_PRODUCT_CART = "//form//a[@title='Remove item']";
    String XPATH_EMPTY_CART = "//div[@class='cart-empty']";
    public CartPage (WebDriver driver){
        super(driver);
    }
    public void openCart() {
        driver.get("https://demo.smartosc.com/checkout/cart");
    }

    public void clikOnMiniCart(){
        this.actionHelper.click(By.xpath(this.XPATH_MINICART));
    }
    public  void  clickOnCheckout(){
        this.actionHelper.click(By.id(this.ID_BTN_CHECKOUT));
    }
    public void removeAllProductInCart() {
        while (driver.findElements(By.xpath(XPATH_EMPTY_CART)).size() == 0) {
            driver.findElement(By.xpath(XPATH_BUTTON_REMOVE_PRODUCT_CART)).click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
