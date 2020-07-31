package Ultilities;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionHelper {
    WebDriver driver;
    Actions actions;
    public Waitting waitting;

    public ActionHelper(WebDriver driver) {
        this.driver = driver;
        waitting = new Waitting(driver);
        actions = new Actions(driver);
    }

    public void sendKey(By locator, String data) {
        this.waitting.waitUntilVisibility(locator, 60);
        this.driver.findElement(locator).sendKeys(data);
    }
    public void clearAndSendKey(By locator, String data) {
        this.waitting.waitUntilVisibility(locator, 60);
        this.driver.findElement(locator).clear();
        this.driver.findElement(locator).sendKeys(data);
    }

    public void click(By locator) {
        this.waitting.waitUntilVisibility(locator, 60);
        this.waitting.waitUntilClickable(locator, 60);
        this.driver.findElement(locator).click();
    }

    public void selectItemByVisibleText(By locator, String text) {
        this.waitting.waitUntilVisibility(locator, 60);
        this.waitting.waitUntilClickable(locator, 60);
        Select select = new Select(this.driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    public String getText(By locator) {
        waitting.waitUntilVisibility(locator, 60);
        return driver.findElement(locator).getText();
    }
    public void moveToElement(By locator){
        waitting.waitUntilVisibility(locator,60);
        actions.moveToElement(driver.findElement(locator)).build().perform();
    }

    public String getTextByJS(By locator) {
        this.waitting.waitUntilExists(locator, 60);
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", driver.findElement(locator));
    }

    public void clickByJS(By locator) {
        this.waitting.waitUntilExists(locator, 60);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public boolean checkElementDisplay(By locator) {
        try {
            this.waitting.waitUntilVisibility(locator, 60);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public boolean checkElementDisplay(By locator, int waitingTime) {
        try {
            this.waitting.waitUntilVisibility(locator, waitingTime);
            return true;
        } catch (Exception var4) {
            return false;
        }
    }

    public boolean checkElementExist(By by, long waitingTime) {
        try {
            waitting.waitUntilExists(by, waitingTime);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean checkElementDisplayed(By location){
        return this.driver.findElement(location).isDisplayed();

    }

}
