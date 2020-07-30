package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class RegisterPage extends BasePage{

    By ID_FIRSTNAME=By.id("firstname");
    By ID_LASTNAME=By.id("lastname");
    By ID_EMAILADDRESS=By.id("email_address");
    By ID_PASSWORD=By.id("password");
    By ID_PASSCONFIRM=By.id("password-confirmation");
    By  XPATH_BUTTONCREATEACCOUNT=By.xpath("//button[@title='Create an Account']");
    String ID_FIRSTNAME_ERROR="firstname-error";
    String ID_LASTNAME_ERROR="lastname-error";
    String ID_EMAIL_EMPTY_ERROR="email_address-error";
    String ID_PASS_EMPTY_ERROR="password-error";
    String ID_REENTER_PASS_EMPTY_ERROR="password-confirmation-error";
    public RegisterPage(WebDriver driver){
        super(driver);
    }

    public void setFirstName(String firstName){
        this.actionHelper.sendKey(this.ID_FIRSTNAME,firstName);
    }
    public void setLastName(String lastName){
        this.actionHelper.sendKey(ID_LASTNAME,lastName);
    }
    public  void setEmail(String email){
        this.actionHelper.sendKey(ID_EMAILADDRESS,email);
    }
    public  void setPassWord(String pass){
        this.actionHelper.sendKey(ID_PASSWORD,pass);
    }
    public void reSetPassWord(String confirmPass){
        this.actionHelper.sendKey(ID_PASSCONFIRM,confirmPass);
    }
    public void clickBtnSubmit(){
        this.actionHelper.click(XPATH_BUTTONCREATEACCOUNT);
    }
    public void register(String firstName, String lastname, String email, String  pass, String confirmPass){
        this.setFirstName(firstName);
        this.setLastName(lastname);
        this.setEmail(email);
        this.setPassWord(pass);
        this.reSetPassWord(confirmPass);
    }
    public String firstNameEmptyError(){
        this.waitUltility.waitUntilVisibility(id(this.ID_FIRSTNAME_ERROR),60);
        String firstNameErrorMsg =driver.findElement(By.id(this.ID_FIRSTNAME_ERROR)).getText();
        return  firstNameErrorMsg;
    }
    public String lastNameEmptyError(){
        this.waitUltility.waitUntilVisibility(id(this.ID_LASTNAME_ERROR),60);
        String lastNameErrorMsg =driver.findElement(By.id(this.ID_LASTNAME_ERROR)).getText();
        return  lastNameErrorMsg;
    }
    public String emailEmptyError(){
        this.waitUltility.waitUntilVisibility(id(this.ID_EMAIL_EMPTY_ERROR),60);
        String emailErrorMsg =driver.findElement(By.id(this.ID_EMAIL_EMPTY_ERROR)).getText();
        return  emailErrorMsg;
    }
    public String passEmptyError(){
        this.waitUltility.waitUntilVisibility(id(this.ID_PASS_EMPTY_ERROR),60);
        String passErrorMsg =driver.findElement(By.id(this.ID_PASS_EMPTY_ERROR)).getText();
        return  passErrorMsg;
    }
    public String reEnterPassEmptyError(){
        this.waitUltility.waitUntilVisibility(id(this.ID_REENTER_PASS_EMPTY_ERROR),60);
        String reEnterPassErrorMsg =driver.findElement(By.id(this.ID_REENTER_PASS_EMPTY_ERROR)).getText();
        return  reEnterPassErrorMsg;
    }
    public boolean fieldFirstNameDisplay(){
        return this.actionHelper.checkElementExist(ID_FIRSTNAME,60);
    }
    public boolean fieldLastNameDisplay(){
        return this.actionHelper.checkElementExist(ID_LASTNAME,60);
    }
    public boolean fieldEmailDisplay(){
        return this.actionHelper.checkElementExist(ID_EMAILADDRESS,60);
    }
    public boolean fieldPassDisplay(){
        return this.actionHelper.checkElementExist(ID_PASSWORD,60);
    }
    public boolean fieldPassConfirmDisplay(){
        return this.actionHelper.checkElementExist(ID_PASSCONFIRM,60);
    }
    public boolean fieldbuttonCreateUser(){
        return this.actionHelper.checkElementExist(XPATH_BUTTONCREATEACCOUNT,60);
    }
}
