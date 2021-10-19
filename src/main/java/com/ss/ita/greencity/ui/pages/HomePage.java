package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ss.ita.greencity.ui.locators.HomePageLocators.HOME_PAGE_TITLE_UKR;

public class HomePage extends BasePage {
    private Label mainTitleUkr;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Label getHomePageTitleUkr() {

        if (mainTitleUkr == null) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[text()='Новий спосіб виховати в собі корисні звички']")));
            mainTitleUkr = new Label(driver, HOME_PAGE_TITLE_UKR);
        }
        return mainTitleUkr;
    }

}
