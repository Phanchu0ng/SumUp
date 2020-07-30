package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends BasePage{

        //    String URL="https://demo.smartosc.com/";
        String XPATH_CREATE="//div[@class='panel header']//a[text()='Create an Account']";
        String ID_SEARCH="search";
        String XPATH_EMPTYRESULT_MESSAGE="//div[@class='message notice']";
        String XPATH_LINK_SIGN_IN = "//div[@class='panel header']//li[@class='authorization-link']/a";
        String XPATH_LOGGED_IN = "//div[@class='panel header']//span[@class='logged-in']";
        String XPATH_EXPANDED_MENU="//div[@class='panel header']//button[@class='action switch']";
        String XPATH_BUTTON_SIGN_OUT="//div[@class='panel header']//div[@class='customer-menu']//li[@class='authorization-link']";
       String XPATH_FIRST_MENU="//a[@role='menuitem'][.//span[text()='%s']]";
       String XPATH_SECOND_MENU="//li[@role='presentation'][.//span[text()='%s']]//span[text()='%s']";
       String XPATH_THIRD_MEMU="//li[@role='presentation'][.//span[text()='%s']]//span[text()='%s']";
       String XPATH_BREADCRUMS="//div[@class='breadcrumbs']//a[normalize-space(text())='%s'] ";
       String XPATH_CAT_BREADCRUMS ="//div[@class='breadcrumbs']//strong[normalize-space(text())='%s']";
       String XPATH_PRODUCT="//div[@class='product-item-info']//div[.//a[normalize-space(text())='%s']]";
        public HomePage(WebDriver driver){
            super(driver);
        }
        public HomePage Open(){
            this.driver.get("https://demo.smartosc.com/");
            return this;
        }
        public void clickRegister(){
            this.actionHelper.click(By.xpath(this.XPATH_CREATE));
        }
        public HomePage clickOnSignin(){
            this.actionHelper.click(By.xpath(this.XPATH_LINK_SIGN_IN));
            return this;
        }
        public boolean checkUserLoggedIn(){
            return this.actionHelper.checkElementDisplay(By.xpath(this.XPATH_LOGGED_IN));
        }
        public void clickOnSignOut(){
            this.actionHelper.click(By.xpath(this.XPATH_EXPANDED_MENU));
            this.actionHelper.click(By.xpath(this.XPATH_BUTTON_SIGN_OUT));
        }
        public boolean checkUserLogOut(){
            return this.actionHelper.checkElementExist(By.xpath(this.XPATH_LOGGED_IN),60);
        }
        public String getPageTitle(){
            String registerPageTitle=driver.getTitle();
            return registerPageTitle;
        }
        public void enterSearchValue(String value){
            this.actionHelper.sendKey(By.id(ID_SEARCH),value);
            driver.findElement(By.id(ID_SEARCH)).sendKeys(Keys.ENTER);

        }
        public boolean noResultIsDisplayed(){
            return this.actionHelper.checkElementDisplay(By.xpath(XPATH_EMPTYRESULT_MESSAGE),60);
        }
        public void moveToTopMenu(String firstmenu, String secondmenu, String thirdmenu){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.actionHelper.moveToElement(By.xpath(String.format(XPATH_FIRST_MENU,firstmenu)));
            this.actionHelper.moveToElement(By.xpath(String.format(XPATH_SECOND_MENU,firstmenu,secondmenu)));
            this.actionHelper.click(By.xpath(String.format(XPATH_THIRD_MEMU, firstmenu, thirdmenu)));

        }
        public boolean firstcatDisplayInBreadCrumb(String catname){
           return this.actionHelper.checkElementDisplay(By.xpath(String.format(XPATH_BREADCRUMS,catname)),60);
        }
        public boolean selectedCatNameIsDisplay(String selectedCat){
            return this.actionHelper.checkElementDisplay(By.xpath(String.format(XPATH_CAT_BREADCRUMS,selectedCat)),60);
        }

        public void clickOnProduct(String name){
        this.actionHelper.click(By.xpath(String.format(XPATH_PRODUCT,name)));
        }
        public boolean checkProductIsDisplayInSearchResult(String name){
        return this.actionHelper.checkElementDisplay(By.xpath(String.format(XPATH_PRODUCT,name)));
        }

    }


