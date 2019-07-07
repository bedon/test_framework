package com.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement createAnAccountButton;

    @FindBy(css = "input#email_create")
    private WebElement registrationEmailField;

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
}
