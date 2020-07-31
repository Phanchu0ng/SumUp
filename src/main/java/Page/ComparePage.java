package Page;

import Data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparePage  extends BasePage{

    public ComparePage(WebDriver driver){
        super(driver);
    }
    String XPATH_EMPTY_COMPARELIST="//div[@class='message info empty']";
    String XPATH_REMOVE_PRODUCT="//div[@class='table-wrapper comparison']//a[@class='action delete']";
    String XPATH_BUTTON_OK="//footer[@class='modal-footer']//button[@class='action-primary action-accept']";
    String XPATH_PRODUCT_NAME="//tr//td[@class='cell product info'][.//a[normalize-space(text())='%s']]";
    String XPATH_PRODUCT_PRICE="//tr//td[@class='cell product info'][.//a[normalize-space(text())='%s']]//span[@class='price']";
    public void openComparePage(){
        driver.get("https://demo.smartosc.com/catalog/product_compare/index/");
    }
    public void removeAllProductFromCompareList(){
        while(driver.findElements(By.xpath(XPATH_EMPTY_COMPARELIST)).size() == 0){
            driver.findElement(By.xpath(XPATH_REMOVE_PRODUCT)).click();
//            WebElement iframeElement = driver.findElement();
            String winDownHandle= driver.getWindowHandle();
            driver.switchTo().window(winDownHandle);
            waitUltility.waitUntilClickable(By.xpath(XPATH_BUTTON_OK),60);
            driver.findElement(By.xpath(XPATH_BUTTON_OK)).click();
            driver.switchTo().window(winDownHandle);
        }
    }
    public boolean checkProductNameExistInCompareList(Product product){
        return actionHelper.checkElementDisplay(By.xpath(String.format(XPATH_PRODUCT_NAME,product.getName())),60);
    }
    public String getProductPrice(Product product){
        return actionHelper.getText(By.xpath(String.format(XPATH_PRODUCT_PRICE,product.getName())));
    }
}
