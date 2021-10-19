package com.ss.ita.greencity.ui.pages.econews;

import com.ss.ita.greencity.ui.elements.Label;
import com.ss.ita.greencity.ui.locators.EcoNewsListItemLocators;
import com.ss.ita.greencity.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EcoNewsListItemComponent extends BasePage {

    private WebElement root;
    private Label title;
    private Label content;


    public EcoNewsListItemComponent(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public Label getTitle() {
        if (title == null) {
            title = new Label(driver, root, EcoNewsListItemLocators.TITLE_LABEL);
        }
        return title;
    }

    public Label getContent() {
        if (content == null) {
            content = new Label(driver, root, EcoNewsListItemLocators.TITLE_LABEL);
        }
        return content;
    }

    public NewsPage click(){
        root.click();
        return new NewsPage(driver);
    }

    public String getNewsClass() {
        return this.root.getAttribute("class");
    }

}
