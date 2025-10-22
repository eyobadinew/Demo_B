package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;
    ElementUtil elementUtil;


    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//h5[@id='logInModalLabel']")
    private WebElement loginPageHeader;

    @FindBy(css="#loginusername")
    private WebElement userNameField;
    @FindBy(css="#loginpassword")
    private WebElement passwordField;
    @FindBy(css="button[onclick='logIn()']")
    private WebElement loginButton;



    @FindBy(css="#nameofuser")
    private WebElement loginSuccessLink;

   @FindBy(xpath="//a[3]")
   private WebElement laptopsLink;

    @FindBy(xpath="//div[@id='logInModal']//button[@type='button'][normalize-space()='Close']")
    private WebElement closeLoginPageButton;

    @FindBy(xpath="//a[@id='logout2']")
    private WebElement logoutLink;

    public String loginPageHeaderText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(loginPageHeader));
        return elementUtil.doGetText(loginPageHeader);

    }

    public void hitCloseLoginPageButton(){
        elementUtil.doClick(closeLoginPageButton);
    }


public void doLoginWithDefaultUser(){
        wait.until(ExpectedConditions.visibilityOfAllElements(loginPageHeader));
        elementUtil.javaScriptExecutorDoSendKeys(userNameField,"jobjobjob");
    elementUtil.javaScriptExecutorDoSendKeys(passwordField,"@1234567890");
    elementUtil.javaScriptExecutorDoClick(loginButton);
}
    public void doLoginWithOutUserNameAndPassword(){
        wait.until(ExpectedConditions.visibilityOfAllElements(loginPageHeader));
        elementUtil.javaScriptExecutorDoSendKeys(userNameField,"");
        elementUtil.javaScriptExecutorDoSendKeys(passwordField,"");
        elementUtil.javaScriptExecutorDoClick(loginButton);
    }

    public void doLoginWithInvalidUserNameAndPassword(){
        wait.until(ExpectedConditions.visibilityOfAllElements(loginPageHeader));
        elementUtil.javaScriptExecutorDoSendKeys(userNameField,"rtrwesceefdrdfd");
        elementUtil.javaScriptExecutorDoSendKeys(passwordField,"pojdhgdtegd");
        elementUtil.javaScriptExecutorDoClick(loginButton);
    }
    public WebElement getLoginSuccessLink() {
        wait.until(ExpectedConditions.visibilityOfAllElements(loginSuccessLink));
        return loginSuccessLink;
    }

    public String loginAlertText(){
        wait.until(ExpectedConditions.alertIsPresent());
       return elementUtil.getAlertText();
    }
    public void acceptLoginAlertText(){
        wait.until(ExpectedConditions.alertIsPresent());
        elementUtil.acceptAlert();
    }

    public void hitLaptopsLink(){
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(laptopsLink)));;
        elementUtil.javaScriptExecutorDoClick(laptopsLink);
    }

    public void doLogout(){
        elementUtil.javaScriptExecutorDoClick(logoutLink);
    }

}


