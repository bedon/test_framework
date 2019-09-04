package com.company.pages;

import com.company.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class MainPage extends Page {

    private Properties config = Config.loadProperty("src\\main\\resources\\test.properties");

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;
    @FindBy(css = "input#search_query_top")
    private WebElement searchField;
    @FindBy(css = "button.button-search")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.title = "My Store";
        PageFactory.initElements(driver, this);
    }

    public MainPage openMainPage() {
        driver.get(config.getProperty("baseUrl"));
        return this;
    }

    public SearchResultPage search() {
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public MainPage fillSearchingField(String goodName) {
        searchField.clear();
        searchField.sendKeys(goodName);
        return this;
    }

    public LoginPage clickSignInButton () {
        signInButton.click();
        return new LoginPage(driver);
    }
}
