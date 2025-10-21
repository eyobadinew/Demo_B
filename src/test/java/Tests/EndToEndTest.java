package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.IndexPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EndToEndTest extends BaseTest {
    IndexPage indexPage;
    LoginPage loginPage;

    CartPage cartPage;


    @Test
    public void doEndToEndTest(){
        indexPage = new IndexPage(driver,wait);
        indexPage.hitProductCategory("Laptops");
        indexPage.hitProductSubCategory("MacBook Pro");
        indexPage.hitAddToCartButton();
        assertEquals(indexPage.getAlertText(),"Product added");
        indexPage.acceptAlertText();
        indexPage.hitCartLink();
        cartPage = new CartPage(driver,wait);
        cartPage.hitPlacePlaceOrderButton();
        cartPage.enterName("Jobaye");
        cartPage.enterCountry("USA");
        cartPage.enterCity("San Francisco");
        cartPage.enterCreditCardNumber("89253432425");
        cartPage.enterMonth("June");
        cartPage.enterYear("2025");
        cartPage.hitPurchaseButton();
        assertTrue(cartPage.getSuccessfullPurchaseText().isDisplayed());
        assertTrue(cartPage.getPurchasedItemInfo().contains("Jobaye"));
        assertTrue(cartPage.getPurchasedItemInfo().contains("89253432425"));







    }





}
