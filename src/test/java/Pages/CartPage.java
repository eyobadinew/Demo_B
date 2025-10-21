package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
   @FindBy(xpath="//button[normalize-space()='Place Order']")
   private WebElement placeOrderButton;


   @FindBy(css="#name")
   private WebElement nameField;
    @FindBy(css="#country")
    private WebElement countryField;
    @FindBy(css="#city")
    private WebElement cityField;
    @FindBy(css="#card")
    private WebElement creditCardField;
    @FindBy(css="#month")
    private WebElement monthField;
    @FindBy(css="#year")
    private WebElement yearField;
    @FindBy(css="button[onclick='purchaseOrder()']")
    private WebElement purchaseButton;
    @FindBy(xpath="//div[@id='orderModal']//button[@type='button'][normalize-space()='Close']")
    private WebElement closeButton;
    @FindBy(xpath="//h2[normalize-space()='Thank you for your purchase!']")
    private WebElement successfullPurchaseText;



    @FindBy(xpath="//p[contains(@class,'lead text-muted')]")
    private WebElement purchasedItemFeatures;

  @FindBy(xpath="//button[normalize-space()='OK']")
  private WebElement successfulPurchaseOkButton;

    public String cartPageHeaderText(){
        return elementUtil.doGetText(cartPageHeader);

    }

    public void hitPlacePlaceOrderButton(){
        elementUtil.doClick(placeOrderButton);
    }



    public void enterName(String name){
        wait.until(ExpectedConditions.visibilityOfAllElements(nameField));
        elementUtil.doSendKeys(nameField,name);
    }
    public void enterCountry(String country){
       wait.until(ExpectedConditions.visibilityOfAllElements(countryField));
        elementUtil.doSendKeys(countryField,country);
    }
    public void enterCity(String city){
        wait.until(ExpectedConditions.visibilityOfAllElements(cityField));
        elementUtil.doSendKeys(cityField,city);
    }
    public void enterCreditCardNumber(String cardNumber){
        wait.until(ExpectedConditions.visibilityOfAllElements(creditCardField));
        elementUtil.doSendKeys(creditCardField,cardNumber);
    }
    public void enterMonth(String month){
        wait.until(ExpectedConditions.visibilityOfAllElements(monthField));
        elementUtil.doSendKeys(monthField,month);
    }
    public void enterYear(String year){
        wait.until(ExpectedConditions.visibilityOfAllElements(yearField));
        elementUtil.doSendKeys(yearField,year);
    }
    public void hitPurchaseButton(){
        elementUtil.doClick(purchaseButton);
    }
    public void hitCloseButton(){
        elementUtil.doClick(closeButton);
    }
    public String getPurchasedItemInfo(){
         return elementUtil.doGetText(purchasedItemFeatures);
    }

    public WebElement getSuccessfullPurchaseText() {
        return successfullPurchaseText;
    }
    public void hitSuccessfulPurchaseOkButton(){
        elementUtil.doClick(successfulPurchaseOkButton);
    }
}
