package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.Label;
import org.openqa.selenium.WebDriver;

import static com.ss.ita.greencity.ui.locators.HeaderLocators.LANGUAGE_SWITCHER;
import static com.ss.ita.greencity.ui.locators.HeaderLocators.UKRAINE_LANGUAGE_BUTTON;

public class LanguageBar extends BasePage {
    private Label langBar;
    private Label ukrLang;

    public LanguageBar(WebDriver driver) {
        super(driver);
    }

    public Label getLanguageSwitcher() {
        if (langBar == null) {
            langBar = new Label(driver, LANGUAGE_SWITCHER);
        }
        return langBar;
    }

    public Label getUkrainianBar() {

        if (ukrLang == null) {
            ukrLang = new Label(driver, UKRAINE_LANGUAGE_BUTTON);
        }
        return ukrLang;
    }

    public LanguageBar clickOnLanguageSwitcher() {
        getLanguageSwitcher().click();
        return new LanguageBar(driver);
    }

    public HomePage clickOnUkrLanguage() {
        getUkrainianBar().click();
        return new HomePage(driver);
    }
}
