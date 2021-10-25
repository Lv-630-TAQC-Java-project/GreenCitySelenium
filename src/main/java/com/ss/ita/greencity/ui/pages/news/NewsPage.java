package com.ss.ita.greencity.ui.pages.news;

import com.ss.ita.greencity.ui.elements.TextArea;
import com.ss.ita.greencity.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ss.ita.greencity.ui.locators.NewsListCommentsLocators.*;
import static com.ss.ita.greencity.ui.locators.NewsLocators.*;
import static java.lang.String.format;

public class NewsPage extends BasePage {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    private TextArea commentInput;
    private TextArea replyInput;
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
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(format(IS_COMMENT_POSTED.getPath().toString(), commentText))));
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

    public NewsListComponent getComment() {
        if (comments == null) {
            comments = new NewsListComponent(driver);
        }
        return comments;
    }

    public NewsPage deleteFirstComment() {
        new NewsPage(driver)
                .clickDeleteCommentButton()
                .clickApproveDeletingCommentButton();
        return this;
    }

    public NewsPage clickDeleteCommentButton() {
        driver.findElement(DELETE_FIRST_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public NewsPage clickApproveDeletingCommentButton() {
        driver.findElement(APPROVE_DELETING_COMMENT_BUTTON.getPath()).click();
        return this;
    }
}