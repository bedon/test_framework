package selenium;

import com.company.pages.MainPage;
import org.testng.annotations.BeforeMethod;

public class RegistrationTest extends BaseTest{
    private MainPage mainPage;

    @BeforeMethod
    public void setupMainPage() {
        mainPage = new MainPage(driver);
    }
}
