package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ss.ita.greencity.ui.locators.HomePageLocators.HOME_PAGE_TITLE;

public class HomePage extends BasePage {
    private Label mainTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Label getHomePageTitle() {

        if (mainTitle == null) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[text()='Новий спосіб виховати в собі корисні звички']")));
            mainTitle = new Label(driver, HOME_PAGE_TITLE);
        }
        return mainTitle;
    }

}
