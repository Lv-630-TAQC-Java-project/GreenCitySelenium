package com.ss.ita.greencity.ui.pages.news;

import com.ss.ita.greencity.ui.elements.TextArea;
import com.ss.ita.greencity.ui.pages.BasePage;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.ss.ita.greencity.ui.locators.NewsLocators.*;

public class NewsPage extends BasePage {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    private TextArea commentInput;
    private NewsListComponent comments;

    public int numbersOfComments() {

        int count = driver.findElements(By.xpath("//p[contains(@class,'comment-text')]")).size();
        return count;
    }

    public String getFirstCommentText() {
        return driver.findElement(FIRST_COMMENT_TEXT.getPath()).getText();
    }

    public NewsPage createAndPublicComment(String commentText) {
        new NewsPage(driver)
                .setCommentText(commentText)
                .clickCommentButton();

        return this;
    }

    public TextArea getCommentInput() {
        if (commentInput == null) {
            commentInput = new TextArea(driver, COMMENT_TEXT_AREA);
        }
        return commentInput;
    }

    public NewsPage setCommentText(String comment) {
        getCommentInput().sendKeysTextArea(comment);
        return this;
    }

    public NewsPage clickCommentButton() {
        driver.findElement(COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public String getCommentsCount() {
        return driver.findElement(COMMENTS_COUNT_LABEL.getPath()).getAttribute("textContent");
    }

    public NewsListCommentComponent getCommentByIndex(int index) {
        NewsListCommentComponent newsListCommentComponent = getComments().get(index);
        return newsListCommentComponent;
    }

    public NewsListComponent getComments() {
        if (comments == null) {
            comments = new NewsListComponent(driver);
        }
        return comments;
    }

    public List<WebElement> getCommentsList() {
        return driver.findElements(COMMENTS_LIST.getPath());
    }
}
