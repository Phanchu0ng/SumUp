package Page;

import Data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PublicKey;

public class PaymentPage extends BasePage{
    String XPATH_PRODUCT_NAME="//div[@class='product-item-name-block']//strong[@class='product-item-name'][normalize-space(text())='%s']";
    String XPATH_PRODUCT_SUBTOTAL="//div[@class='product-item-details']//strong[@class='product-item-name'][normalize-space(text())='%s']//following::span[@class='cart-price']/span";
    String XPATH_BUTTON_PLACE_ORDER="//div[@class='payment-method _active']//button[@class='action primary checkout']";
    String XPATH_BUTTON_EXPAND_CART="//div[@class='title']";
    String XPATH_PRODUCT_NAME_AT_CART_PAGE="//tr[@class='item-info']//strong[@class='product-item-name']/a[text()='%s]";
    String XPATH_SHIPPING_FEE_PAYMENT_PAGE="//tr[@class='totals shipping excl']//span[@class='price']";
    String XPATH_SUMMARY_SUB_TOTAL = "//tr[@class='totals sub']//span[@class='price']";
    String XPATH_SUMMARY_PRODUCT_NAME = "//strong[@class='product-item-name'][text()='%s']";
    String XPATH_SUMMARY_PRODUCT_PRICE = "//li[@class='product-item'][.//strong[text()='%s']]//span[@class='price']";
    String XPATH_SUMMARY_PRODUCT_SIZE = "//li[@class='product-item'][.//strong[text()='%s']]//div[@class='content']//dt[text()='Size']//following-sibling::dd[1]";
    String XPATH_SUMMARY_PRODUCT_COLOR = "//li[@class='product-item'][.//strong[text()='%s']]//div[@class='content']//dt[text()='Color']//following-sibling::dd[1]";
    String XPATH_ADDRESS_SHIP_TO="//div[@class='ship-to'] //div[contains(string(),'%s')]";
    String XPATH_PAYMENT_METHOD="//div[@class='payment-method'][.//span[text()='%s']]//input";
    //    String XPATH_B
    public PaymentPage(WebDriver driver){
        super(driver);
    }
    public void clickBtnPlaceOrder(){
        this.actionHelper.click(By.xpath(this.XPATH_BUTTON_PLACE_ORDER));
    }
    public void waitloading(){
        this.waitLoadingInvisibility();
    }
    public String getProductName(String name){
        return this.actionHelper.getText(By.xpath(String.format(XPATH_PRODUCT_NAME,name)));

    }
    public  String getProductSubTotal(String name){
        String subTotal=this.actionHelper.getText(By.xpath(String.format(XPATH_PRODUCT_SUBTOTAL,name)));
        String subTotalAfter= subTotal.replaceAll("$","");
        return subTotalAfter;
    }
    public String getSummarySubTotal() {
        waitUltility.waitUntilVisibility(By.xpath(XPATH_SUMMARY_SUB_TOTAL),60);
        return actionHelper.getText(By.xpath(XPATH_SUMMARY_SUB_TOTAL));
    }
    public void clickToExpandProduct(){this.actionHelper.click(By.xpath(XPATH_BUTTON_EXPAND_CART));}
    public String getAttributeValue(){
        String AtrValue = driver.findElement(By.xpath(XPATH_BUTTON_EXPAND_CART)).getAttribute("aria-expanded");
        return AtrValue;

    }
    public void choosePaymentMethod(String method){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.actionHelper.click(By.xpath(String.format(XPATH_PAYMENT_METHOD,method)));
    }
    public boolean checkProductNameDisplay(Product product) {
        return actionHelper.checkElementExist(By.xpath(String.format(XPATH_SUMMARY_PRODUCT_NAME, product.getName())), 10);
    }

    public String getSummaryProductPrice(Product product) {
        return actionHelper.getTextByJS(By.xpath(String.format(XPATH_SUMMARY_PRODUCT_PRICE, product.getName()))).replace("\u00A0"," ");
    }

    public String getSummaryProductSize(Product product) {
        return actionHelper.getTextByJS(By.xpath(String.format(XPATH_SUMMARY_PRODUCT_SIZE, product.getName())));
    }

    public String getSummaryProductColor(Product product) {
        return actionHelper.getTextByJS(By.xpath(String.format(XPATH_SUMMARY_PRODUCT_COLOR, product.getName())));
    }
    public String getShippingFeePaymentPage(){
        return actionHelper.getText(By.xpath(XPATH_SHIPPING_FEE_PAYMENT_PAGE));
    }
    public boolean checkShippingInformationDisplay(String Information){
        return actionHelper.checkElementExist(By.xpath(String.format(XPATH_ADDRESS_SHIP_TO,Information)),10);

    }
}
