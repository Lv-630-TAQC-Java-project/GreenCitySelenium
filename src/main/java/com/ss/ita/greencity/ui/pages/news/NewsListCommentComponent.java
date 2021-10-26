package com.ss.ita.greencity.ui.pages.news;

import com.ss.ita.greencity.ui.elements.*;
import com.ss.ita.greencity.ui.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ss.ita.greencity.ui.locators.NewsListCommentsLocators.*;
import static com.ss.ita.greencity.ui.locators.NewsLocators.COMMENTS_LIST;

public class NewsListCommentComponent extends BasePage {

    private WebElement root;
    private Label content;
    private TextArea replyInput;
    private Button postReply;
    private TextArea editCommentField;

    public NewsListCommentComponent(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public NewsListCommentComponent createOneReplyToComment(String replyText) {
        return clickReplyButton()
                .createAnotherReply(replyText)
                .clearReplyTextArea();
    }

    public NewsListCommentComponent clearReplyTextArea() {
        getReplyInput().clickTextArea();
        getReplyInput().clearTextArea();
        return this;
    }

    public int numberOfReplies() {
        int count = driver.findElements(By.xpath("//div[contains(@class,'comment-body-wrapper wrapper-reply')]")).size();
        return count;
    }

    public NewsListCommentComponent clickViewReplyButton() {
        driver.findElement(VIEW_REPLY_BUTTON.getPath()).click();
        return this;
    }

    public NewsListCommentComponent clickReplyButton() {
        driver.findElement(REPLY_FIRST_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public NewsListCommentComponent createAnotherReply(String replyText) {
        new NewsListCommentComponent(driver, root)
                .setReplyText(replyText)
                .clickPublishReplyButton();
        return this;
    }

    public NewsListCommentComponent setReplyText(String replyText) {
        getReplyInput().clickTextArea();
        getReplyInput().sendKeysTextArea(replyText);
        return this;
    }

    public TextArea getReplyInput() {
        if (replyInput == null) {
            replyInput = new TextArea(driver, REPLY_TEXT_AREA);
        }
        return replyInput;
    }

    public NewsListCommentComponent clickPublishReplyButton() {
        driver.findElement(PUBLISH_REPLY_BUTTON.getPath()).click();
        return this;
    }

    public int numbersOfComments() {

        int count = driver.findElements(By.xpath("//p[contains(@class,'comment-text')]")).size();
        return count;
    }

    public void waitForCommentAction(Integer timeout) {
        // Current comments count
        int count_before = numbersOfComments();

        int loops_count = 0;
        while (true) {
            loops_count += 1;

            //Actual comments count
            int actual_count = numbersOfComments();

            // ASAP comment's count was changed - break out from while loop
            if (count_before != actual_count) {
                break;
            }

            // Throw exception if comment's number wasn't changed during timeout period
            if (loops_count == timeout) {
                throw new TimeoutException("Comment count wasn't changed after " + loops_count + " seconds!");
            }

            // Wait 1 second per iteration
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }



    public NewsPage deleteFirstComment() {
        clickDeleteCommentButton().clickApproveDeletingCommentButton().waitForCommentAction(10);
        return new NewsPage(driver);
    }

    public NewsListCommentComponent clickDeleteCommentButton() {
        driver.findElement(DELETE_FIRST_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public NewsListCommentComponent clickApproveDeletingCommentButton() {
        driver.findElement(APPROVE_DELETING_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public Button getPublishReplyButton() {
        if (postReply == null) {
            postReply = new Button(driver, PUBLISH_REPLY_BUTTON);
        }
        return postReply;
    }

    // Edit methods

    public NewsListCommentComponent clickEditComment() {
        new Button(driver, EDIT_COMMENT_BUTTON).clickButton();
        return this;
    }

    public NewsListCommentComponent setEditFieldText(String text) {
        editCommentField = new TextArea(driver, EDIT_COMMENT_FIELD);
        editCommentField.sendKeysTextArea(text);
        return this;
    }

    public NewsListCommentComponent clickSaveChangesButton() {
        new Button(driver, EDIT_SAVE_COMMENT_BUTTON).clickButton();
        return this;
    }

    // general method
    public NewsListCommentComponent editComment(String newText) {
        return clickEditComment()
                .setEditFieldText(newText)
                .clickSaveChangesButton();
    }

    public Label getContent() {
        return new Label(root.findElement(COMMENT_TEXT.getPath()));
    }
}
