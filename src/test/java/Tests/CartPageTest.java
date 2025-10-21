package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.IndexPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartPageTest extends BaseTest {
    IndexPage indexPage;
    CartPage cartPage;
    @Test
    public void validateCartPage(){
        indexPage = new IndexPage(driver,wait);
        indexPage.hitCartLink();
        cartPage = new CartPage(driver,wait);
        assertEquals(cartPage.cartPageHeaderText(),"Products");
        driver.navigate().back();


    }

    @Test
    public void validatePurchase(){
        indexPage = new IndexPage(driver,wait);
        indexPage.hitCartLink();
        cartPage = new CartPage(driver,wait);
        cartPage.hitPlacePlaceOrderButton();
        cartPage.enterName("Jambalja");
        cartPage.enterCountry("USA");
        cartPage.enterCity("San Francisco");
        cartPage.enterCreditCardNumber("036815243252");
        cartPage.enterMonth("02");
        cartPage.enterYear("2024");
        cartPage.hitPurchaseButton();
        assertTrue(cartPage.getSuccessfullPurchaseText().isDisplayed());
        assertTrue(cartPage.getPurchasedItemInfo().contains("Jambalja"));
        assertTrue(cartPage.getPurchasedItemInfo().contains("036815243252"));
        cartPage.hitSuccessfulPurchaseOkButton();
        cartPage.hitCloseButton();


    }





}
