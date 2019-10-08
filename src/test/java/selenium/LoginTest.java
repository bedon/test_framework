package selenium;

import com.company.pages.LoginPage;
import com.company.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class LoginTest extends BaseTest{

    private MainPage mainPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setupMainPage() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void qwe() {
        mainPage.openMainPage();
        List<WebElement> w = driver.findElements(By.cssSelector("input#search_query_top111"));
        if (w.size() != 0) {
            Assert.assertTrue(mainPage.getSearchField().isDisplayed());
        } else {
            throw new NoSuchElementException("Element searchField not found");
        }
    }

    @Test
    public void successLoginTest() {
        mainPage.openMainPage();
        loginPage = mainPage.clickSignInButton();
    }

    @Test(dataProvider = "invalidLoginData")
    public void negativeLoginDataTest(String login, String pass, String allertText) {
        mainPage.openMainPage();
        loginPage = mainPage.clickSignInButton();
        loginPage.fillLoginEmailField(login).fillpasswordField(pass);
        loginPage.clickSignInButton();
        Assert.assertEquals(loginPage.getAllertMessage().getText(), allertText);
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
