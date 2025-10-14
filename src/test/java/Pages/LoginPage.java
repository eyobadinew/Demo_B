package Pages;

import Utils.ElementUtil;
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

    @FindBy(xpath="//div[@id='logInModal']//button[@type='button'][normalize-space()='Close']")
    private WebElement closeLoginPageButton;

    public String loginPageHeaderText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(loginPageHeader));
        return elementUtil.doGetText(loginPageHeader);

    }

    public void hitCloseLoginPageButton(){
        elementUtil.doClick(closeLoginPageButton);
    }
}
