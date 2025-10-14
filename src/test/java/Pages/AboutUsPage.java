package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutUsPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public ElementUtil elementUtil;

    public AboutUsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//h5[@id='videoModalLabel']")
    private WebElement aboutUsHeader;
  @FindBy(xpath="//button[@title='Play']//span[@class='vjs-icon-placeholder']")
    private WebElement playButton;

    @FindBy(xpath="//div[@id='videoModal']//button[@type='button'][normalize-space()='Close']")
    private WebElement clothButton;
    @FindBy(xpath="//div[@id='videoModal']//span[@aria-hidden='true'][normalize-space()='×']")
    private WebElement cancelButton;

    @FindBy(xpath="//video[@id='example-video_html5_api']")
    private WebElement videoDisplay;

   public void hitPlayButton(){
       elementUtil.javaScriptExecutorDoClick(playButton);
   }

   public boolean videoIsDisplayed(){
       wait.until(ExpectedConditions.visibilityOfAllElements(videoDisplay));
      return elementUtil.doIsDisplayed(videoDisplay);
   }

   public void hitCloseButton(){
       wait.until(ExpectedConditions.visibilityOfAllElements(clothButton));
       elementUtil.javaScriptExecutorDoClick(clothButton);
       wait.until(ExpectedConditions.invisibilityOfAllElements(clothButton));

   }
   public boolean aboutUsHeaderTextIsDisplayed(){
       return elementUtil.doIsDisplayed(aboutUsHeader);
   }

}
