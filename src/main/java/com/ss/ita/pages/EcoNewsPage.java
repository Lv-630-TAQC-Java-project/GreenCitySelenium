package com.ss.ita.pages;

import com.ss.ita.elements.Label;
import org.openqa.selenium.WebDriver;

import static com.ss.ita.locators.EcoNewsLocators.ECO_NEWS_MAIN_HEADER;
import static com.ss.ita.locators.EcoNewsLocators.TEST_NEWS_TITLE;


public class EcoNewsPage extends BasePage {

    private Label mainHeader;
    private Label newsTitle;

    public EcoNewsPage(WebDriver driver) {
        super(driver);
    }

    public Label getMainHeader() {
        if (mainHeader == null) {
            mainHeader = new Label(driver, ECO_NEWS_MAIN_HEADER);
        }
        return mainHeader;
    }

    public Label getNewsTitle(){
        if (newsTitle == null) {
            newsTitle = new Label(driver, TEST_NEWS_TITLE);
        }
        return newsTitle;
    }
}
