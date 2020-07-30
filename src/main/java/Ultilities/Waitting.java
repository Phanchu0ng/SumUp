package Ultilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waitting {
    WebDriver driver;
    int WAITING_TIME = 60;
    public Waitting(WebDriver driver) {
        this.driver = driver;
    }
    public void waitUntilExists(By location, long waitingTime){
        WebDriverWait wait =new WebDriverWait(this.driver,waitingTime);
wait.until(ExpectedConditions.presenceOfElementLocated(location));
    }
    public void waitUntilVisibility(By location, int waittingTime){
        WebDriverWait wait = new WebDriverWait(this.driver,(long)waittingTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(location));
    }
    public void waitUntilClickable(By location,int waittingTime){
        WebDriverWait wait = new WebDriverWait(this.driver,(long)waittingTime);
        wait.until(ExpectedConditions.elementToBeClickable(location));
    }
    public void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitForPageLoad() {
        try {
            waitForJQueryLoad();
            waitUntilJSReady();
        } catch (Throwable error) {
        }
    }

    //Wait Until JS Ready
    public void waitUntilJSReady() {
        int counting = 1;
        String pageLoadStatus;
        do {
            sleep(1000);
            pageLoadStatus = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
            counting++;
        } while (!pageLoadStatus.contains("complete") && (counting < WAITING_TIME));
    }

    //Wait for JQuery Load
    public void waitForJQueryLoad() {

        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        int counting = 1;
        final String jQueryActiveScript = "return window.jQuery != undefined && jQuery.active==0";

        //Get JQuery is Ready
        boolean jqueryReady;
        //Wait JQuery until it is Ready!
        do {
            sleep(1000);
            jqueryReady = (Boolean) jsExec.executeScript(jQueryActiveScript);
            counting++;
        } while (!jqueryReady && (counting < WAITING_TIME));

    }



}
