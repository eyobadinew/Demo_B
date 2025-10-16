package Pages;

import Base.BasePage;
import Utils.ElementUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public ElementUtil elementUtil;

    public SignupPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//h5[@id='signInModalLabel']")
    private WebElement signupPageHeader;

    @FindBy(xpath="//input[@id='sign-username']")
    private WebElement userNameField;

    @FindBy(xpath="//input[@id='sign-password']")
    private WebElement passwordField;

    @FindBy(xpath="//button[normalize-space()='Sign up']")
    private WebElement signupButton;




    @FindBy(xpath="//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']")
    private WebElement closeSignupPageButton;

    public String signupPageHeaderText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(signupPageHeader));
        return elementUtil.doGetText(signupPageHeader);
    }
    public void hitCloseSignupPageButton(){
        elementUtil.doClick(closeSignupPageButton);
    }

    public void enterUserName(){
        elementUtil.doSendKeys(userNameField,randomString());
    }
    public void enterPassword(){
        elementUtil.doSendKeys(passwordField,randomAlphaNumeric());
    }

    public void enterExistingUserName(){
        elementUtil.doSendKeys(userNameField,"jobjob");
    }
    public void enterExistingPassword(){
        elementUtil.doSendKeys(passwordField,"@1234567890");
    }


    public void hitSignupButton(){
        elementUtil.doClick(signupButton);
    }
    public String signupAlertText(){
        wait.until(ExpectedConditions.alertIsPresent());
        return elementUtil.getAlertText();
    }

    public void acceptSignupAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        elementUtil.acceptAlert();
    }
}
