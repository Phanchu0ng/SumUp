package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductListingPage extends BasePage{
    String ID_LIST_VIEW = "mode-list";
    String XPATH_LIST_VIEW = "//div[@class='toolbar toolbar-products'][1]//a[@id='mode-list']";
    String XPATH_SORT_BY = "(//div[@class='toolbar-sorter sorter']//select[@class='sorter-options'])[1]";
    String XPATH_PRODUCT_PRICES = "//li[@class='item product product-item']//span[@class='price']";
    String XPATH_BUTTON_NEXT = "(//ul[@class='items pages-items']//a[@class='action  next'])[2]";
    String XPATH_PRODUCT_PRICE = "(//li[@class='item product product-item']//span[@class='price'])[%s]";
    String XPATH_CLICK_ON_COLOR="//div[@class='filter-options-title'][normalize-space(text())='Color']";
    String XPATH_CHOOSE_FILTER_COLOR ="//div[@class='filter-options-content']//div[@attribute-id='93']//a[@aria-label='%s']";
    String XPATH_COLOR_LIST_PRODUCT="//div[@class='product-item-info']//div[@class='swatch-attribute color']//div[@option-label='%s']";
    String XPATH_PRODUCT_COLOR="(//div[@class='product-item-info']//div[@class='swatch-attribute color']//div[@option-label='%s'])[%s]";
    String XPATH_ADD_PRODUCT_TO_COMPARE="//ol[@class='products list items product-items']//div[@class='product details product-item-details'][.//a[normalize-space(text())='%s'] ]//a[@class='action tocompare']";
    String XPATH_ADD_TO_WISHLIST="//ol[@class='products list items product-items']//div[@class='product details product-item-details'][.//a[normalize-space(text())='%s'] ]//a[@class='action towishlist']";
    String XPATH_PRODUCT_IN_COMPARE_LIST="//div[@class='block block-compare']//a[text()='%s']";
    String XPATH_PRODUCT_IN_WISHLIST="//div[@class='block block-wishlist']//span[text()='Proteus Fitness Jackshirt']";
    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    public void openProductListingPage(String url) {
        this.driver.get(url);
    }
    public void clickaddproducttowishlist(String name){
        this.actionHelper.clickByJS(By.xpath(String.format(XPATH_ADD_TO_WISHLIST,name)));
    }
    public void clickaddproducttocomparelist(String name){
        this.actionHelper.clickByJS(By.xpath(String.format(XPATH_ADD_PRODUCT_TO_COMPARE,name)));
    }
    public boolean verifyCompareProductOnLeftbar(String name){
        return this.actionHelper.checkElementDisplay(By.xpath(String.format(XPATH_PRODUCT_IN_COMPARE_LIST,name)));
    }
    public boolean verifyWishlistProductOnLeftbar(String name){
        return this.actionHelper.checkElementDisplay(By.xpath(String.format(XPATH_PRODUCT_IN_WISHLIST,name)));
    }
    public void clickOnListView() {
        while (this.actionHelper.checkElementDisplay(By.xpath(XPATH_LIST_VIEW)) == false) {
            this.actionHelper.click(By.xpath(XPATH_LIST_VIEW));
        }
    }

    public void chooserMethodSortBy(String value) {
        Select drpMethodSortBy = new Select(driver.findElement(By.xpath(XPATH_SORT_BY)));
        drpMethodSortBy.selectByValue(value);

    }

    public boolean checkButtonNextDisplay() {
        return actionHelper.checkElementDisplay(By.xpath(XPATH_BUTTON_NEXT));
    }

    public void verifySortByPriceCorrect() {
        String url =driver.getCurrentUrl();
        List<String> priceList = new LinkedList<>();
        for (int i = 1; i <= driver.findElements(By.xpath(XPATH_PRODUCT_PRICES)).size(); i++) {
            priceList.add((driver.findElement(By.xpath(String.format(XPATH_PRODUCT_PRICE, i))).getText().replace("US$", "").replace(",", ".")));
        }
        while (checkButtonNextDisplay() == true) {
            System.out.println("abc");
            actionHelper.click(By.xpath(XPATH_BUTTON_NEXT));
            String currentUrl=driver.getCurrentUrl();
            if(currentUrl!=url){
                for (int i = 1; i <= driver.findElements(By.xpath(XPATH_PRODUCT_PRICES)).size(); i++) {
                    priceList.add((driver.findElement(By.xpath(String.format(XPATH_PRODUCT_PRICE, i))).getText().replace("US$", "").replace(",", ".")));
                }
                url=currentUrl;
            }
        }
        System.out.println(priceList);
        if (this.actionHelper.checkElementDisplay(By.xpath("//a[@title='Set Ascending Direction']")) == true) {
            for (int i = 0; i < priceList.size()-1; i++) {
                if (Float.parseFloat(priceList.get(i)) >= Float.parseFloat(priceList.get(i+1))) {

                } else {
                    Assert.assertFalse(true);
                }
            }
        } else {
            for (int i = 0; i < priceList.size()-1; i++) {
                if (Float.parseFloat(priceList.get(i)) <= Float.parseFloat(priceList.get(i+1))) {
                } else {
                    Assert.assertFalse(true);
                }
            }
            System.out.println(priceList);
        }
    }
    public void clickOnColor(){
        String atr=driver.findElement(By.xpath(XPATH_CLICK_ON_COLOR)).getAttribute("aria-expanded");
        if(atr.equals(false)){
            this.actionHelper.click(By.xpath(XPATH_CLICK_ON_COLOR));
        }

    }
    public void chooseColorToFilter(String color){
        this.actionHelper.click(By.xpath(String.format(XPATH_CHOOSE_FILTER_COLOR,color)));
    }
    public void verifyListResultFilter(String color){
        List<String> listProductColor = new ArrayList<String>();
        for(int i=1;i <=driver.findElements(By.xpath(XPATH_COLOR_LIST_PRODUCT)).size();i++){
            this.actionHelper.checkElementDisplay(By.xpath(String.format(XPATH_PRODUCT_COLOR,color,i)));
            String valueStr=driver.findElement(By.xpath(String.format(XPATH_PRODUCT_COLOR,color,i))).getAttribute("aria-checked");
            if(valueStr.equals("true")){

            }else {
                Assert.assertFalse(true);
            }
        }

    }
}
