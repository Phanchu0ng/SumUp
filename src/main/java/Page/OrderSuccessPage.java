package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSuccessPage extends BasePage {
        String XPATH_ORDER_NUMBER = "//a[@class='order-number']";

    public OrderSuccessPage(WebDriver driver) {
            super(driver);
        }

        public boolean checkOrderNumberDisplay() {
            return this.actionHelper.checkElementDisplay(By.xpath(this.XPATH_ORDER_NUMBER));
        }
}
