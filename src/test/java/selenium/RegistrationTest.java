package selenium;

import com.company.pages.AccountPage;
import com.company.pages.LoginPage;
import com.company.pages.MainPage;
import com.company.pages.RegistrationPage;
import com.company.utils.Randomizer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    private MainPage mainPage;

    @BeforeMethod
    public void setupMainPage() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void successRegisterNewUser() throws InterruptedException {
        mainPage.openMainPage();
        LoginPage loginPage = mainPage.clickSignInButton();
        loginPage.enterEmailForRegistration(Randomizer.generateRandomMail(7));
        RegistrationPage registrationPage = loginPage.clickCreateAnAccountButton();
        registrationPage.fillRequiredFields("First", "last", "qwe123qwe",
                "Homer", "Simpson", "Navoi Alishera 100", "Herson",
                "+380931002030", "Address alias", "00000");
        AccountPage accountPage = registrationPage.clickRegisterButton();
        Assert.assertEquals(driver.getTitle(), accountPage.getPageTitle());
    }
}
