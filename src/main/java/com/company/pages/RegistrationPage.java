package com.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Page {

    @FindBy(css = "input#customer_firstname")
    private WebElement personalFirstNameField;
    @FindBy(css = "input#customer_lastname")
    private WebElement personalLastNameField;
    @FindBy(css = "input#passwd")
    private WebElement passwordField;
    @FindBy(css = "input#firstname")
    private WebElement addressFirstNameField;
    @FindBy(css = "input#lastname")
    private WebElement addressLastNameField;
    @FindBy(css = "input#address1")
    private WebElement address1Field;
    @FindBy(css = "input#city")
    private WebElement cityField;
    @FindBy(css = "input#phone_mobile")
    private WebElement phoneNumberField;
    @FindBy(css = "input#alias")
    private WebElement addressAliasField;
    @FindBy(xpath = "//button[@id='submitAccount']")
    private WebElement registerButton;
    @FindBy(css = "div.alert.alert-danger p")
    private WebElement alertMessage;
    @FindBy(css = "input#postcode")
    private WebElement postCodeField;
    @FindBy(css = "select#id_state")
    private WebElement state;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillRequiredFields(String personalFirstName, String personalLastName, String pass,
                                   String addressFirstName, String addressLastName, String address,
                                   String city, String phone, String addressAlias, String postcode) {
        personalFirstNameField.sendKeys(personalFirstName);
        personalLastNameField.sendKeys(personalLastName);
        passwordField.sendKeys(pass);
        addressFirstNameField.sendKeys(addressFirstName);
        addressLastNameField.sendKeys(addressLastName);
        address1Field.sendKeys(address);
        cityField.sendKeys(city);
        phoneNumberField.sendKeys(phone);
        addressAliasField.clear();
        addressAliasField.sendKeys(addressAlias);
        postCodeField.sendKeys(postcode);
        selectState(1);
    }

    public void selectState(int stateIndex) {
        Select stateSelect = new Select(state);
        stateSelect.selectByIndex(stateIndex);
    }

    public String getValidationAlertText() {
        return alertMessage.getText();
    }
    public AccountPage clickRegisterButton() {
        registerButton.click();
        return new AccountPage(driver);
    }

}
