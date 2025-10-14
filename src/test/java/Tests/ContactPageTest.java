package Tests;

import Base.BaseTest;
import Pages.ContactPage;
import Pages.IndexPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContactPageTest extends BaseTest {

    @Test(priority=1)
    public void sendContactMessageTest() {
        IndexPage indexPage = new IndexPage(driver, wait);
        indexPage.hitContactsLink();
        ContactPage contactPage = new ContactPage(driver, wait);
        contactPage.enterContactEmail("test@tesers.com");
        contactPage.enterContactName("jobjoba");
        contactPage.enterContactMessage("We have issues with the following product. Please get us back as soon as possible");
        contactPage.hitSendMessageButton();
        assertEquals(contactPage.getContactAlertMessage(),"Thanks for the message!!");
        contactPage.acceptContactAlert();
    }
       @Test(priority=2)
    public void closeContactMessageWindowTest()  {
        IndexPage indexPage = new IndexPage(driver, wait);
        indexPage.hitContactsLink();
        ContactPage contactPage = new ContactPage(driver, wait);
        contactPage.enterContactEmail("test@tesers.com");
        contactPage.enterContactName("jobjoba");
        contactPage.enterContactMessage("We have issues with the following product. Please get us back as soon as possible");
        contactPage.hitCloseContactMessage();
        assertFalse(contactPage.getSendMessageButton().isDisplayed());

    }

    @Test(priority=3)
    public void cancelContactMessageWindowTest()  {
        IndexPage indexPage = new IndexPage(driver, wait);
        indexPage.hitContactsLink();
        ContactPage contactPage = new ContactPage(driver, wait);
        contactPage.enterContactEmail("test@tesers.com");
        contactPage.enterContactName("jobjoba");
        contactPage.enterContactMessage("We have issues with the following product. Please get us back as soon as possible");
        contactPage.hitCancelContactMessage();
        assertFalse(contactPage.getSendMessageButton().isDisplayed());

    }


}