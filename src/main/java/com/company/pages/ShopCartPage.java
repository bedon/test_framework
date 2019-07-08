package com.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopCartPage extends Page {

    @FindBy(xpath = "//i[@class='icon-plus']")
    private WebElement increaseItemCountButton;
    @FindBy(css = "span#total_product_price_2_7_0")
    private WebElement totalProductPrice;
    @FindBy(xpath = "//table[@id='cart_summary']//td[@id='total_product']")
    private WebElement totalProducts;
    @FindBy(xpath = "//table[@id='cart_summary']//td[@id='total_shipping']")
    private WebElement totalShipping;
    @FindBy(xpath = "//table[@id='cart_summary']//td[@id='total_price_without_tax']")
    private WebElement totalPriceWithoutTax;
    @FindBy(xpath = "//table[@id='cart_summary']//td[@id='total_tax']")
    private WebElement tax;
    @FindBy(xpath = "//table[@id='cart_summary']//td[@id='total_price_container']")
    private WebElement totalPrice;
    @FindBy(css = "i.icon-trash")
    private WebElement deleteItemButton;
    @FindBy(css = "p.alert.alert-warning")
    private WebElement emptyCartAllert;
    @FindBy(xpath = "//input[@name='quantity_2_7_0_0_hidden' and @value='2']")
    private WebElement itemCounter;

    public WebElement getItemCounter() {
        return itemCounter;
    }

    public WebElement getTotalProductPrice() {
        return totalProductPrice;
    }

    public WebElement getTotalProducts() {
        return totalProducts;
    }

    public WebElement getTotalShipping() {
        return totalShipping;
    }

    public WebElement getTotalPriceWithoutTax() {
        return totalPriceWithoutTax;
    }

    public WebElement getTax() {
        return tax;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public ShopCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ShopCartPage deleteFromCart() {
        deleteItemButton.click();
        return this;
    }

    public WebElement getEmptyCartAllert() {
        return emptyCartAllert;
    }

    public ShopCartPage increaseItemCount() {
        increaseItemCountButton.click();
        return this;
    }
}
