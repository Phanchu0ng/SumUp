package Ultilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waitting {
    WebDriver driver;

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
    public void waitUntilExist(By xpath) {
    }


}
