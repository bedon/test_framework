package com.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Page {

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.title = "My account - My Store";
        PageFactory.initElements(driver, this);
    }
}
