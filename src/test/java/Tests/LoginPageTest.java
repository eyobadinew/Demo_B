package Tests;

import Base.BaseTest;
import Pages.IndexPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginPageTest extends BaseTest {
    IndexPage indexPage;
    LoginPage loginPage;

    @Test(priority = 3)
    public void loginTest() {
        indexPage = new IndexPage(driver, wait);
        indexPage.hitLoginLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLoginWithDefaultUser();
        assertTrue(loginPage.getLoginSuccessLink().isDisplayed());
    }


    @Test(priority = 1)
    public void loginWithInvalidUserTest() {
        indexPage = new IndexPage(driver, wait);
        indexPage.hitLoginLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLoginWithInvalidUserNameAndPassword();
        assertEquals(loginPage.loginAlertText(), "User does not exist.");
        loginPage.acceptLoginAlertText();
        driver.navigate().refresh();


    }


    @Test(priority = 2)
    public void loginWithOutUserNameAndPasswordTest() {
        indexPage = new IndexPage(driver, wait);
        indexPage.hitLoginLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLoginWithOutUserNameAndPassword();
        assertEquals(loginPage.loginAlertText(), "Please fill out Username and Password.");
        loginPage.acceptLoginAlertText();
        driver.navigate().refresh();
    }
}