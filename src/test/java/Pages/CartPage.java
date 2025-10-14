package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    public WebDriver driver;
    public WebDriverWait wait;
    ElementUtil elementUtil;


    public CartPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath=" //h2[normalize-space()='Products']")
    private WebElement cartPageHeader;

    public String cartPageHeaderText(){
        return elementUtil.doGetText(cartPageHeader);

    }


}
