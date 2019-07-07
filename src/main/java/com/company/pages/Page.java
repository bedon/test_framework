package com.company.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver driver;
    protected String title;

    public String getPageTitle() {
        return this.title;
    }
}
