package Tests;

import Base.BaseTest;
import Pages.AboutUsPage;
import Pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AboutUsPageTest  extends BaseTest {
 IndexPage indexPage;
 AboutUsPage aboutUsPage;

    @Test(priority=1)
    public void displayAboutUsVideoTest(){
        indexPage = new IndexPage(driver, wait);
        indexPage.hitAboutUsLink();
        aboutUsPage=new AboutUsPage(driver,wait);
        aboutUsPage.hitPlayButton();
        assertTrue(aboutUsPage.videoIsDisplayed());
        aboutUsPage.hitCloseButton();

    }

    @Test(priority=2)
    public void closeAboutUsWindowTest(){
        indexPage = new IndexPage(driver, wait);
        indexPage.hitAboutUsLink();
        aboutUsPage=new AboutUsPage(driver,wait);
        aboutUsPage.hitCloseButton();
        assertFalse(aboutUsPage.aboutUsHeaderTextIsDisplayed());

    }



}
