package com.ss.ita.pages;

import com.ss.ita.elements.Label;
import org.openqa.selenium.WebDriver;

import static com.ss.ita.locators.EcoNewsLocators.ECO_NEWS_MAIN_HEADER;

public class EcoNewsPage extends BasePage {

    private Label mainHeader;

    public EcoNewsPage(WebDriver driver) {
        super(driver);
    }

    public Label getMainHeader() {
        if (mainHeader == null) {
            mainHeader = new Label(driver, ECO_NEWS_MAIN_HEADER);
        }
        return mainHeader;
    }
}
