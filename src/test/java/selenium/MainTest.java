package selenium;

import com.company.pages.*;
import com.company.utils.TestHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
    public void checkValidationText() {
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
    public void validateTotalProductPriseChanged() {
        searchResultPage = mainPage.openMainPage().fillSearchingField("Blouse").search();
        searchResultPage.switchItemsToList();
        searchResultPage.clickAddToCartButton();
        shopCartPage = searchResultPage.clickProccedToCheckoutButton();
        shopCartPage.increaseItemCount();
        TestHelper.waitWhileAttributChangeValue(driver, shopCartPage.getItemCounter(), "value", "2", 5);
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
        searchResultPage = mainPage.openMainPage().fillSearchingField("Blouse").search();
        searchResultPage.switchItemsToList();
        searchResultPage.clickAddToCartButton();
        shopCartPage = searchResultPage.clickProccedToCheckoutButton();
        shopCartPage.increaseItemCount();
        TestHelper.waitWhileAttributChangeValue(driver, shopCartPage.getItemCounter(), "value", "2", 5);
        Assert.assertEquals(shopCartPage.getTotalPrice().getText(), "$56.00");
    }

    @Test
    public void validateCorrectTax() {
        searchResultPage = mainPage.openMainPage().fillSearchingField("Blouse").search();
        searchResultPage.switchItemsToList();
        searchResultPage.clickAddToCartButton();
        shopCartPage = searchResultPage.clickProccedToCheckoutButton();
        shopCartPage.increaseItemCount();
        TestHelper.waitWhileAttributChangeValue(driver, shopCartPage.getItemCounter(), "value", "2", 5);
        Assert.assertEquals(shopCartPage.getTax().getText(), "$0.00");
    }

    @Test
    public void validateTotalProductChanged() {
        searchResultPage = mainPage.openMainPage().fillSearchingField("Blouse").search();
        searchResultPage.switchItemsToList();
        searchResultPage.clickAddToCartButton();
        shopCartPage = searchResultPage.clickProccedToCheckoutButton();
        shopCartPage.increaseItemCount();
        TestHelper.waitWhileAttributChangeValue(driver, shopCartPage.getItemCounter(), "value", "2", 5);
        Assert.assertEquals(shopCartPage.getTotalProducts().getText(), "$54.00");
    }

    @Test
    public void validateTotalShippingChanged() {
        searchResultPage = mainPage.openMainPage().fillSearchingField("Blouse").search();
        searchResultPage.switchItemsToList();
        searchResultPage.clickAddToCartButton();
        shopCartPage = searchResultPage.clickProccedToCheckoutButton();
        shopCartPage.increaseItemCount();
        TestHelper.waitWhileAttributChangeValue(driver, shopCartPage.getItemCounter(), "value", "2", 5);
        Assert.assertEquals(shopCartPage.getTotalShipping().getText(), "$2.00");
    }

    @Test
    public void validateTotalPriceWithoutTaxChanged() {
        searchResultPage = mainPage.openMainPage().fillSearchingField("Blouse").search();
        searchResultPage.switchItemsToList();
        searchResultPage.clickAddToCartButton();
        shopCartPage = searchResultPage.clickProccedToCheckoutButton();
        shopCartPage.increaseItemCount();
        TestHelper.waitWhileAttributChangeValue(driver, shopCartPage.getItemCounter(), "value", "2", 5);
        Assert.assertEquals(shopCartPage.getTotalPriceWithoutTax().getText(), "$56.00");
    }

    @AfterMethod
    public void down() {
        driver.manage().deleteAllCookies();
    }
}
