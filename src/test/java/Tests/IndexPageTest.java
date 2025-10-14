package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IndexPageTest extends BaseTest {

    @Test(priority  =1)
    public void navigateToContactPageTest(){
        IndexPage indexPage = new IndexPage(driver,wait);
        indexPage.hitContactsLink();
        ContactPage contactPage = new ContactPage(driver,wait);
        assertEquals(contactPage.contactPageHeaderText(),"New message");
        contactPage.hitCancelContactMessage();
    }
    @Test(priority  =2)
    public void navigateToAboutUsWindowTest(){
        IndexPage indexPage = new IndexPage(driver,wait);
        indexPage.hitAboutUsLink();
        indexPage.hitCancelAboutUsLink();
        assertEquals(indexPage.aboutUsHeaderText(),"About us");
        indexPage.hitCancelAboutUsLink();
    }

    @Test(priority = 3)
    public void navigateToCartPageTest(){
        IndexPage indexPage = new IndexPage(driver,wait);
        indexPage.hitCartLink();
        CartPage cartPage = new CartPage(driver,wait);
        assertEquals(cartPage.cartPageHeaderText(),"Products");
        indexPage.navigateBrowserBack();
    }

    @Test(priority = 4)
    public void navigateToLoginPageTest(){
        IndexPage indexPage = new IndexPage(driver,wait);
        indexPage.hitLoginLink();
        LoginPage loginPage = new LoginPage(driver,wait);
        assertEquals(loginPage.loginPageHeaderText(),"Log in");
        loginPage.hitCloseLoginPageButton();
    }

    @Test(priority = 5)
    public void navigateToSignupPageTest(){
        IndexPage indexPage = new IndexPage(driver,wait);
        indexPage.hitSignupLink();
        SignupPage signupPage = new SignupPage(driver,wait);
        assertEquals(signupPage.signupPageHeaderText(),"Sign up");
        signupPage.hitCloseSignupPageButton();
    }
    @Test(priority = 6)
    public void choosePhoneCategoryTest(){
        IndexPage indexPage = new IndexPage(driver,wait);
        indexPage.hitProductCategory("Phones");
        indexPage.hitProductSubCategory("Samsung galaxy s6");
       assertEquals(indexPage.getSubCategoryPageHeaderText("Samsung galaxy s6"),"Samsung galaxy s6");
        indexPage.navigateBrowserBack();
    }
    @Test(priority = 7)
    public void chooseLaptopsCategoryTest(){
        IndexPage indexPage = new IndexPage(driver,wait);
        indexPage.hitProductCategory("Laptops");
        indexPage.hitProductSubCategory("MacBook air");
        assertEquals(indexPage.getSubCategoryPageHeaderText("MacBook air"),"MacBook air");
        indexPage.navigateBrowserBack();
    }
    @Test(priority = 8)
    public void chooseMonitorsCategoryTest(){
        IndexPage indexPage = new IndexPage(driver,wait);
        indexPage.hitProductCategory("Monitors");
        indexPage.hitProductSubCategory("Apple monitor 24");
        assertEquals(indexPage.getSubCategoryPageHeaderText("Apple monitor 24"),"Apple monitor 24");
        indexPage.navigateBrowserBack();
    }


}
