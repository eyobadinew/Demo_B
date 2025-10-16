package Tests;

import Base.BaseTest;
import Pages.IndexPage;
import Pages.SignupPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignupPageTest extends BaseTest {
   IndexPage indexPage;
   SignupPage signupPage;
    @Test(priority =3)
    public void signupValidation(){
        indexPage = new IndexPage(driver,wait);
        indexPage.hitSignupLink();
        signupPage = new SignupPage(driver,wait);
        assertEquals(signupPage.signupPageHeaderText(),"Sign up");
        signupPage.enterUserName();
        signupPage.enterPassword();
        signupPage.hitSignupButton();
        assertEquals(signupPage.signupAlertText(),"Sign up successful.");
        signupPage.acceptSignupAlert();
    }

    @Test(priority=1)
    public void signupWithoutUserNameAndPasswordTest(){
        indexPage = new IndexPage(driver,wait);
        indexPage.hitSignupLink();
        signupPage = new SignupPage(driver,wait);
        assertEquals(signupPage.signupPageHeaderText(),"Sign up");
        signupPage.hitSignupButton();
        assertEquals(signupPage.signupAlertText(),"Please fill out Username and Password.");
        signupPage.acceptSignupAlert();

    }
    @Test(priority =2)
    public void signupWithExistingUserNameAndPasswordTest(){
        indexPage = new IndexPage(driver,wait);
        indexPage.hitSignupLink();
        signupPage = new SignupPage(driver,wait);
        assertEquals(signupPage.signupPageHeaderText(),"Sign up");
        signupPage.enterExistingUserName();
        signupPage.enterExistingPassword();
        signupPage.hitSignupButton();
        assertEquals(signupPage.signupAlertText(),"This user already exist.");
        signupPage.acceptSignupAlert();
    }


}
