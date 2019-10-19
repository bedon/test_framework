package mobile;

import com.company.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MobileTest {
    public WebDriver driver;
    private Properties properties = Config.loadProperty("src\\main\\resources\\test.properties");

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverPath"));
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "iPhone 6/7/8");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void mobTest() throws InterruptedException {
        driver.get(properties.getProperty("baseUrl"));
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDowm () {
        driver.quit();
    }
}
