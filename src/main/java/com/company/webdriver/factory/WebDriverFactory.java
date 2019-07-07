package com.company.webdriver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public final class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver getDriver(DriverType driverType) {

        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FF:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            default:
                throw new IllegalArgumentException("No implementation for provided driver type");
        }
    }
}
