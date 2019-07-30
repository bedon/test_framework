package selenium;

import com.company.webdriver.factory.DriverType;
import com.company.webdriver.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver(DriverType.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
