package web;

import com.company.pages.*;
import static com.company.utils.Randomizer.generateRandomMail;
import com.company.utils.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
    public void qwe() {
        mainPage.openMainPage();
        List<WebElement> w = driver.findElements(By.cssSelector("input#search_query_top"));
        Assert.assertEquals(w.size(), 0);
    }

    @Test
    public void checkValidationText() {
        mainPage.openMainPage();
        loginPage = mainPage.clickSignInButton();
        loginPage.enterEmailForRegistration(generateRandomMail(5));
        registrationPage = loginPage.clickCreateAnAccountButton();
        registrationPage.fillRequiredFields("First", "last", "qwe123qwe",
                "Homer", "Simpson", "Navoi Alishera 100", "Herson",
                "+380931002030", "Address alias", "00000");
        registrationPage.clickRegisterButton();
        Assert.assertEquals(registrationPage.getValidationAlertText(), "There are 2 errors");
    }

    @Test
    public void validateTotalProductPriseChanged() {
        increaseItemCountAndWait();
        Assert.assertEquals(shopCartPage.getTotalProductPrice().getText(), "$54.00");
    }

    @Test
    public void deleteGoodFromCart() {
        searchResultPage = mainPage.openMainPage().fillSearchingField("Blouse").search();
        searchResultPage.switchItemsToList();
        searchResultPage.clickAddToCartButton();
        shopCartPage = searchResultPage.clickProccedToCheckoutButton();
        shopCartPage.deleteFromCart();
        TestHelper.waitForElement(driver, shopCartPage.getEmptyCartAllert(), 5);
        Assert.assertTrue(shopCartPage.getEmptyCartAllert().isDisplayed());
    }

    @Test
    public void validateTotalPiceCorrectValue() {
        increaseItemCountAndWait();
        Assert.assertEquals(shopCartPage.getTotalPrice().getText(), "$56.00");
    }

    @Test
    public void validateCorrectTax() {
        increaseItemCountAndWait();
        Assert.assertEquals(shopCartPage.getTax().getText(), "$0.00");
    }

    @Test
    public void validateTotalProductChanged() {
        increaseItemCountAndWait();
        Assert.assertEquals(shopCartPage.getTotalProducts().getText(), "$54.00");
    }

    @Test
    public void validateTotalShippingChanged() {
        increaseItemCountAndWait();
        Assert.assertEquals(shopCartPage.getTotalShipping().getText(), "$2.00");
    }


    @Test
    public void validateTotalPriceWithoutTaxChanged() {
        increaseItemCountAndWait();
        Assert.assertEquals(shopCartPage.getTotalPriceWithoutTax().getText(), "$56.00");
    }

    @AfterMethod
    public void down() {
        driver.manage().deleteAllCookies();
    }

    private void increaseItemCountAndWait() {
        searchResultPage = mainPage.openMainPage().fillSearchingField("Blouse").search();
        searchResultPage.switchItemsToList();
        searchResultPage.clickAddToCartButton();
        shopCartPage = searchResultPage.clickProccedToCheckoutButton();
        shopCartPage.increaseItemCount();
        TestHelper.waitWhileAttributChangeValue(driver, shopCartPage.getItemCounter(), "value", "2", 5);
    }
}
