package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class MyAccountPage extends BasePage {
    String XPATH_ACTION_CHANGEPASSWORD="//a[@class='action change-password']";
    String ID_CURRENT_PASSWORD="current-password";
    String ID_NEW_PASSWORD="password";
    String ID_NEW_PASSWORD_CONFIRM="password-confirmation";
    String XPATH_BTN_SAVE="//button[@title='Save']";
    String ID_CONFIRMPASS_ERR="password-confirmation-error";
    String XPATH_CURRENT_PASS_ERROR="//div[@data-bind='html: message.text']";

    String XPATH_EDIT_SHIPPING_ADDRESS="//div[@class='box box-shipping-address']//a[@class='action edit']";
    String XPATH_EDIT_BILLING="//div[@class='box box-billing-address']//a[@class='action edit']";
    String ID_STREET_ADDRESS="street_1";
    String ID_CITY="city";
    String ID_ZIP="zip";
    String NAME_INPUT_COUNTRY = "country_id";
    String XPATH_SAVE_ADDRESS_BTN="//button[@title='Save Address']";
    String ID_STREET_ASSRESS_ERROR="street_1-error";
    String ID_CITY_ERROR="city-error";
    String ID_ZIP_ERROR="zip-error";
    String ID_COUNTRY_ERROR="country-error";
    String XPATH_BILLING_ADDRESS="//div[@class='box box-address-billing']//div[contains(string(),'%s')]";
    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    public MyAccountPage Open(){
        this.driver.get("https://demo.smartosc.com/customer/account/");
        return this;
    }
    public void clickChangPass(){
        this.actionHelper.click(By.xpath(XPATH_ACTION_CHANGEPASSWORD));
    }
    public void inputcurrentPassword(String currentPassword){
        this.actionHelper.sendKey(By.id(ID_CURRENT_PASSWORD),currentPassword);
    }
    public void inputnewPassword(String newPassword){
        this.actionHelper.sendKey(By.id(ID_NEW_PASSWORD),newPassword);
    }
    public void inputnewPasswordConfirm(String newPasswordConfirm){
        this.actionHelper.sendKey(By.id(ID_NEW_PASSWORD_CONFIRM),newPasswordConfirm);
    }
    public void clickSaveChangePass(){
        this.actionHelper.click(By.xpath(XPATH_BTN_SAVE));
    }
    public void clickEditBillAddress(){
        this.actionHelper.click(By.xpath(XPATH_EDIT_BILLING));
    }
    public void fillBillingAddress(String street, String city, String zip, String country){
    this.actionHelper.clearAndSendKey(By.id(this.ID_STREET_ADDRESS),street);
        this.actionHelper.clearAndSendKey(By.id(this.ID_CITY),city);
        this.actionHelper.clearAndSendKey(By.id(this.ID_ZIP),zip);
        this.actionHelper.selectItemByVisibleText(By.name(this.NAME_INPUT_COUNTRY), country);
    }
    public void clickOnSaveAddressBtn(){
        this.actionHelper.click(By.xpath(XPATH_SAVE_ADDRESS_BTN));
    }
    public String errStreetBlank(){
        this.waitUltility.waitUntilVisibility(id(this.ID_STREET_ASSRESS_ERROR),60);
        String errStreetBlank =driver.findElement(By.id(this.ID_STREET_ASSRESS_ERROR)).getText();
        return  errStreetBlank;
    }
    public String errCityBlank(){
        this.waitUltility.waitUntilVisibility(id(this.ID_CITY_ERROR),60);
        String errCityBlank =driver.findElement(By.id(this.ID_CITY_ERROR)).getText();
        return  errCityBlank;
    }
    public String errzipBlank(){
        this.waitUltility.waitUntilVisibility(id(this.ID_ZIP_ERROR),60);
        String errzipBlank =driver.findElement(By.id(this.ID_ZIP_ERROR)).getText();
        return  errzipBlank;
    }
    public String errCountryBlank(){
        this.waitUltility.waitUntilVisibility(id(this.ID_COUNTRY_ERROR),60);
        String errCountryBlank =driver.findElement(By.id(this.ID_COUNTRY_ERROR)).getText();
        return  errCountryBlank;
    }
    public String errorConfirmPass(){
        this.waitUltility.waitUntilVisibility(id(this.ID_CONFIRMPASS_ERR),60);
        String errorConfirmPass =driver.findElement(By.id(this.ID_CONFIRMPASS_ERR)).getText();
        return  errorConfirmPass;
    }
    public String errorCurrentPass(){
        this.waitUltility.waitUntilVisibility(xpath(this.XPATH_CURRENT_PASS_ERROR),60);
        String errorCurrentPass =driver.findElement(By.xpath(this.XPATH_CURRENT_PASS_ERROR)).getText();
        return  errorCurrentPass;
    }
    public boolean checkBillingInformation(String information){
        return actionHelper.checkElementExist(By.xpath(String.format(XPATH_BILLING_ADDRESS,information)),10);

    }
}
