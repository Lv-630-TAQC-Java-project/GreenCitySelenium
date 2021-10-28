package com.ss.ita.greencity.ui.pages.econews;

import com.ss.ita.greencity.ui.elements.Label;
import com.ss.ita.greencity.ui.locators.EcoNewsListItemLocators;
import com.ss.ita.greencity.ui.pages.BasePage;
import com.ss.ita.greencity.ui.pages.news.NewsPage;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class EcoNewsListItemComponent extends BasePage {

    private WebElement root;
    private Label title;
    private Label content;
    private Label image;
    private Label tag;
    private Label data;
    private Label author;


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
            content = new Label(driver, root, EcoNewsListItemLocators.CONTENT_LABEL);
        }
        return content;
    }

    public Label getImage() {
        if (image == null) {
            image = new Label(driver, root, EcoNewsListItemLocators.IMAGE_LABEL);
        }
        return image;
    }

    public Label getTag() {
        if (tag == null) {
            tag = new Label(driver, root, EcoNewsListItemLocators.TAG_LABEL);
        }
        return tag;
    }

    public Label getData() {
        if (data == null) {
            data = new Label(driver, root, EcoNewsListItemLocators.DATA_LABEL);
        }
        return data;
    }

    public Label getAuthor() {
        if (author == null) {
            author = new Label(driver, root, EcoNewsListItemLocators.AUTHOR_LABEL);
        }
        return author;
    }

    public NewsPage click(){
        root.click();
        return new NewsPage(driver);
    }

    public String getNewsClass() {
        return this.root.getAttribute("class");
    }

}
