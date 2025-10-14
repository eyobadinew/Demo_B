package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {


        public WebDriver driver;
        public WebDriverWait wait;
        ElementUtil elementUtil;


        public ContactPage(WebDriver driver, WebDriverWait wait){
            this.driver = driver;
            this.wait = wait;
            elementUtil = new ElementUtil(driver);
            PageFactory.initElements(driver,this);

        }

        @FindBy(xpath="//h5[@id='exampleModalLabel']")
        private WebElement contactPageHeader;
        @FindBy(xpath="//input[@id='recipient-email']")
        private WebElement contactEmailField;
    @FindBy(xpath="//input[@id='recipient-name']")
    private WebElement contactNameField;



    @FindBy(xpath="//textarea[@id='message-text']")
    private WebElement contactMessageField;
    @FindBy(xpath="//button[normalize-space()='Send message']")
    private WebElement sendMessageButton;
    @FindBy(xpath="//div[@id='exampleModal']//button[@type='button'][normalize-space()='Close']")
    private WebElement clothButton;
    @FindBy(xpath="//div[@id='exampleModal']//span[@aria-hidden='true'][normalize-space()='×']")
    private WebElement cancelXButton;



        public String contactPageHeaderText(){
            wait.until(ExpectedConditions.visibilityOfAllElements(contactPageHeader));
           return elementUtil.doGetText(contactPageHeader);
        }

        public void enterContactEmail(String email){
            wait.until(ExpectedConditions.visibilityOfAllElements(sendMessageButton));
            elementUtil.doSendKeys(contactEmailField,email);
        }

    public void enterContactName(String name){
        wait.until(ExpectedConditions.visibilityOfAllElements(sendMessageButton));
        elementUtil.doSendKeys(contactNameField,name);
    }
    public void enterContactMessage(String message){
        wait.until(ExpectedConditions.visibilityOfAllElements(sendMessageButton));
        elementUtil.doSendKeys(contactMessageField,message);
    }
    public void hitSendMessageButton(){
        wait.until(ExpectedConditions.visibilityOfAllElements(sendMessageButton));
elementUtil.doClick(sendMessageButton);
    }

   public String getContactAlertMessage(){
          return  elementUtil.getAlertText();
   }
   public void acceptContactAlert(){
            elementUtil.acceptAlert();
   }

   public void hitCloseContactMessage(){
            elementUtil.doClick(clothButton);
            wait.until(ExpectedConditions.invisibilityOf(sendMessageButton));
   }
    public void hitCancelContactMessage(){
        elementUtil.doClick(cancelXButton);
        wait.until(ExpectedConditions.invisibilityOf(cancelXButton));
    }

    public WebElement getSendMessageButton() {
        return sendMessageButton;
    }
}
