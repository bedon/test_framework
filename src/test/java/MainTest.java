import com.company.pages.*;
import com.company.utils.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private SearchResultPage searchResultPage;
    private ShopCartPage shopCartPage;

    @BeforeMethod
    public void setupMainPage() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void checkValidationText() throws InterruptedException {
        mainPage.openMainPage();
        loginPage = mainPage.clickSignInButton();
        loginPage.enterEmailForRegistration("qwe123@mail.ru");
        registrationPage = loginPage.clickCreateAnAccountButton();
        registrationPage.fillRequiredFields("First", "last", "qwe123qwe",
                "Homer", "Simpson", "Navoi Alishera 100", "Herson",
                "+380931002030", "Address alias");
        registrationPage.clickRegisterButton();
        Assert.assertEquals(registrationPage.getValidationAlertText(), "There are 2 errors");
    }

    @Test
    public void deleteGoodsFromCart() throws InterruptedException {
        searchResultPage = mainPage.openMainPage().fillSearchingField("Blouse").search();
        searchResultPage.switchItemsToList();
        searchResultPage.clickAddToCartButton();
        shopCartPage = searchResultPage.clickProccedToCheckoutButton();
        shopCartPage.increaseItemCount();
        /*
        Тут надо нахуярить ассертов
        */
        shopCartPage.deleteFromCart();
        TestHelper.waitForElement(driver, shopCartPage.getEmptyCartAllert(), 5);
        Assert.assertTrue(shopCartPage.getEmptyCartAllert().isDisplayed());
    }
}
