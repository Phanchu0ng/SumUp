package Page;

import Ultilities.ActionHelper;
import Ultilities.Waitting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    String XPATH_LOADING = "//div[@class='loading-mask'][@style='display: none;']";
    public WebDriver driver;
    public ActionHelper actionHelper;
    public Waitting waitUltility;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actionHelper = new ActionHelper(driver);
        this.waitUltility = new Waitting(driver);
    }

    public void waitLoadingInvisibility() {
        this.waitUltility.waitUntilExist(By.xpath(this.XPATH_LOADING));
    }
}


