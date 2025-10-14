package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {
    public WebDriver driver;
    public WebDriverWait wait;
    ElementUtil elementUtil;


    public IndexPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//a[normalize-space()='Contact']")
    private WebElement contactLink;
    @FindBy(xpath="//a[normalize-space()='About us']")
    private WebElement aboutUsLink;
    @FindBy(xpath="//a[@id='cartur']")
    private WebElement cartLink;
    @FindBy(xpath="//a[@id='login2']")
    private WebElement loginLink;
    @FindBy(xpath="//a[@id='signin2']")
    private WebElement signupLink;
    @FindBy(xpath="//div[@id='videoModal']//span[@aria-hidden='true'][normalize-space()='×']")
    private WebElement cancelAboutUsLink;
    @FindBy(xpath="//h5[@id='videoModalLabel']")
    private WebElement aboutUsHeader;

   @FindBy(xpath="//h2[normalize-space()='Samsung galaxy s6']")
   private WebElement samsungPhonePageHeader;






    public void hitContactsLink(){
        elementUtil.doClick(contactLink);
    }
    public void hitAboutUsLink(){
        elementUtil.doClick(aboutUsLink);
    }
    public void hitCartLink(){
        elementUtil.doClick(cartLink);
    }
    public void hitLoginLink(){
        elementUtil.doClick(loginLink);
    }
    public void hitSignupLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(signupLink));
        elementUtil.javaScriptExecutorDoClick(signupLink);
    }
    public void hitCancelAboutUsLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(cancelAboutUsLink));
        elementUtil.doClick(cancelAboutUsLink);
    }
    public String aboutUsHeaderText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(aboutUsHeader));
        return elementUtil.doGetText(aboutUsHeader);
    }
    public void hitProductCategory(String category){
        driver.findElement(By.xpath("//a[@id='itemc' and normalize-space(text()) = '"+category+"']")).click();
    }

    public void hitProductSubCategory(String subCategory){

   driver.findElement(By.xpath("//a[normalize-space()='"+subCategory+"']")).click();
    }

    public String getSubCategoryPageHeaderText(String text){
      return  driver.findElement(By.xpath("//h2[normalize-space()='"+text+"']")).getText();
    }
    public void navigateBrowserBack(){
        elementUtil.doBrowserNavigateBack();
    }



}
