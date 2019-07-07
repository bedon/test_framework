package com.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends Page {

    @FindBy(xpath = "//a[@title='List']")
    private WebElement switchToListButton;
    @FindBy(xpath = "//div[@class='right-block-content row']//span[text()='Add to cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='layer_cart_cart col-xs-12 col-md-6']//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage switchItemsToList() {
        switchToListButton.click();
        return this;
    }

    public SearchResultPage clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    public ShopCartPage clickProccedToCheckoutButton() {
        proceedToCheckoutButton.click();
        return new ShopCartPage(driver);
    }
}
