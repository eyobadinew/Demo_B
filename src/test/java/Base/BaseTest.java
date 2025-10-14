package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public BasePage basePage;
    public Properties prop;
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        basePage = new BasePage();
        prop = basePage.init_properties();
        driver = basePage.init_driver();
        driver.get(prop.getProperty("url"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}
