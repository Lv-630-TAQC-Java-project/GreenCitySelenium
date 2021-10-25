package com.ss.ita.greencity.ui.pages.news;

import com.ss.ita.greencity.ui.elements.TextArea;
import com.ss.ita.greencity.ui.pages.BasePage;
import okio.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Timer;

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

    private void waitForCommentAction(Integer timeout) {
        // Current comments count
        int count_before = numbersOfComments();

        int loops_count = 0;
        while(true) {
            loops_count += 1;

            //Actual comments count
            int actual_count = numbersOfComments();

            // ASAP comment's count was changed - break out from while loop
            if(count_before != actual_count) { break; }

            // Throw exception if comment's number wasn't changed during timeout period
            if (loops_count == timeout) {
                throw new TimeoutException("Comment count wasn't changed after " + loops_count + " seconds!");
            }

            // Wait 1 second per iteration
            try  { Thread.sleep(1000); }
            catch(InterruptedException ex)
            { Thread.currentThread().interrupt(); }
        }
    }

    public NewsPage clickCommentButton() {
        driver.findElement(COMMENT_BUTTON.getPath()).click();
        new NewsPage(driver).waitForCommentAction(10);
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
        new NewsPage(driver).waitForCommentAction( 10);
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
