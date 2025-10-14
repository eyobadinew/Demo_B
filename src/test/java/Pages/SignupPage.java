package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
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

    @FindBy(xpath="//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']")
    private WebElement closeSignupPageButton;

    public String signupPageHeaderText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(signupPageHeader));
        return elementUtil.doGetText(signupPageHeader);
    }
    public void hitCloseSignupPageButton(){
        elementUtil.doClick(closeSignupPageButton);
    }






}
