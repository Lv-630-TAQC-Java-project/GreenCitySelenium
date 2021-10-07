package com.ss.ita.pages;

import com.ss.ita.elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.ss.ita.locators.CreateNewsLocators.*;

import static com.ss.ita.locators.HeaderLocators.*;

public class Header extends BasePage {
    private Link ecoNewsLink;
    private Link CreateNewsButton;

    public Header(WebDriver driver) {
        super(driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Link getEcoNewsLink() {
        if (ecoNewsLink == null) {
            ecoNewsLink = new Link(driver, ECO_NEWS_LINK);
        }
        return ecoNewsLink;
    }

    public EcoNewsPage clickEcoNewsLink() {
        getEcoNewsLink().click();
        return new EcoNewsPage(driver);
    }

    public Link CreateNewsButton() {
        if (CreateNewsButton == null) {
            CreateNewsButton = new Link(driver, CREATE_NEWS_BUTTON);
        }
        return CreateNewsButton;
    }
    public CreateNewsPage clickCreateButton() {
        CreateNewsButton().click();
        return new CreateNewsPage(driver);
    }

    public void login() {
        driver.findElement(SIGN_IN.getPath()).click();
        driver.findElement(EMAIL.getPath()).sendKeys("greencity.test.user@gmail.com");
        driver.findElement(PASSWORD.getPath()).sendKeys("LeVq3ucLZRVPJuA!");
        driver.findElement(SIGN_IN_IN_WINDOW.getPath()).click();
    }
}
