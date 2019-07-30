package com.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement createAnAccountButton;

    @FindBy(xpath = "//form[@id='login_form']//div/input[@id='email']")
    private WebElement loginEmailField;

    @FindBy(xpath = "//form[@id='login_form']//span/input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(css = "input#email_create")
    private WebElement registrationEmailField;

    @FindBy(css = "button#SubmitLogin")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    private WebElement allertMessage;

    public WebElement getAllertMessage() {
        return allertMessage;
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.title = "Login - My Store";
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterEmailForRegistration(String email) {
        registrationEmailField.clear();
        registrationEmailField.sendKeys(email);
        return this;
    }

    public RegistrationPage clickCreateAnAccountButton() {
        createAnAccountButton.click();
        return new RegistrationPage(driver);
    }

    public LoginPage fillLoginEmailField(String login) {
        loginEmailField.sendKeys(login);
        return this;
    }

    public LoginPage fillpasswordField(String pass) {
        passwordField.sendKeys(pass);
        return this;
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
