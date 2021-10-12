package com.ss.ita.econews;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ss.ita.data.DataProviderImpl;

public class TestRuner extends DataProviderImpl {
    protected static WebDriver driver;
    PropertiesProvider propertiesProvider = new PropertiesProvider();

    @BeforeClass
    protected void getDriver() {
        switch (propertiesProvider.getBrowser()) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", propertiesProvider.getChromeBrowser());
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                System.setProperty("webdriver.gecko.driver", propertiesProvider.getFirefoxBrowser());
                driver = new FirefoxDriver();
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid browser");
            }
        }
        driver.manage().window().maximize();
        driver.get(propertiesProvider.getBaseUrl());
    }

    @AfterClass
    protected void quitDriver() {
        if (driver != null) driver.quit();
    }

}
