package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class LoginPage extends BasePage {
    String ID_EMAIL="email";
    String ID_PASS="pass";
    String XPATH_BTNSUBMITLOGIN="//div[@class='primary']//button[@class='action login primary']";
    String XPATH_MESSAGE_WHEN_LOGIN_FAILED="//div[@class='page messages']//div[@class='messages']//div[@data-bind='html: message.text']";
    String XPATH_MESSAGE_EMAIL_ERROR="//div[@id='email-error']";
    String XPATH_MESSAGE_PASS_ERROR="//div[@id='pass-error']";
    String ID_CAPTCHA_EMAIL_LOGIN="captcha_user_login";
    String ID_CAPTCHA_USER_LOGIN_ERROR ="captcha_user_login-error";
    public  LoginPage(WebDriver driver){
        super(driver);
    }
    public void login(String email, String pass){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.actionHelper.sendKey(By.id(this.ID_EMAIL),email);
        this.actionHelper.sendKey(By.id(this.ID_PASS),pass);

    }
    public void enterEmail(String email){
        this.actionHelper.sendKey(By.id(ID_EMAIL),email);
    }
    public void enterPass(String pass){
        this.actionHelper.sendKey(By.id(ID_PASS),pass);
    }
    public void clickBtn(){
        this.actionHelper.click(xpath(this.XPATH_BTNSUBMITLOGIN));
    }
    public String getMessage(){
        this.waitUltility.waitUntilVisibility(By.xpath(XPATH_MESSAGE_WHEN_LOGIN_FAILED),120);
        String loginInErrorMsg = driver.findElement(By.xpath(XPATH_MESSAGE_WHEN_LOGIN_FAILED)).getText();
        return loginInErrorMsg;
    }
    public String getMessageEmailerror() {
        this.waitUltility.waitUntilVisibility(xpath(XPATH_MESSAGE_EMAIL_ERROR),60);
        String emailErrorMsg =driver.findElement(By.xpath(XPATH_MESSAGE_EMAIL_ERROR)).getText();
        return  emailErrorMsg;
    }
    public  String getMessagePassError() {
        this.waitUltility.waitUntilVisibility(xpath(XPATH_MESSAGE_PASS_ERROR),60);
        String passErrorMsg =driver.findElement(By.xpath(XPATH_MESSAGE_PASS_ERROR)).getText();
        return passErrorMsg;
    }
    public boolean checkCaptchaEmailLoginDisplay(){
        return this.actionHelper.checkElementDisplay(By.xpath(ID_CAPTCHA_USER_LOGIN_ERROR));
    }
    public  String getMessageCaptchaError() {
        this.waitUltility.waitUntilVisibility(xpath(ID_CAPTCHA_EMAIL_LOGIN),60);
        String captchaErrorMsg =driver.findElement(By.id(ID_CAPTCHA_EMAIL_LOGIN)).getText();
        return captchaErrorMsg;
    }
}
