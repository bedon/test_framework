package selenium;

import com.company.pages.LoginPage;
import com.company.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    private MainPage mainPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setupMainPage() {
        mainPage = new MainPage(driver);
    }

    @Test(dataProvider = "invalidLoginData")
    public void negativeLoginDataTest(String login, String pass, String allertText) throws InterruptedException {
        mainPage.openMainPage();
        loginPage = mainPage.clickSignInButton();
        loginPage.fillLoginEmailField(login).fillpasswordField(pass);
        Thread.sleep(3000);
        loginPage.clickSignInButton();
        Assert.assertEquals(loginPage.getAllertMessage().getText(), allertText);
        Thread.sleep(2000);
    }

    @DataProvider
    public Object[][] invalidLoginData() {
        return new Object[][] {
                {"", "", "An email address required."},
                {"login2", "pass2", "Invalid email address."},
                {"login1@mail.ru", "qweqwe", "Authentication failed."}
        };
    }
}
