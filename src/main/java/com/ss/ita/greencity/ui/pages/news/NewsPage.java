package com.ss.ita.greencity.ui.pages.news;

import com.ss.ita.greencity.ui.elements.Button;
import com.ss.ita.greencity.ui.elements.Input;
import com.ss.ita.greencity.ui.elements.Label;
import com.ss.ita.greencity.ui.elements.TextArea;
import com.ss.ita.greencity.ui.pages.BasePage;

import org.openqa.selenium.By;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ss.ita.greencity.ui.locators.NewsLocators.*;
import static com.ss.ita.greencity.ui.locators.NewsLocators.REPLY_BUTTON;

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

    public NewsPage createAndPublicComment(String commentText) {
        new NewsPage(driver)
                .setCommentText(commentText)
                .clickCommentButton()
                .waitForCommentAction(10);
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

    public int getCommentsCountFromLabel() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until((ExpectedCondition<Boolean>) driver -> getCommentsCountLabel().matches("\\s*\\d\\s*\\w+\\s*"));

        return Integer.parseInt(getCommentsCountLabel().replaceAll("\\D", ""));
    }

    public String getCommentsCountLabel(){
        return driver.findElement(COMMENTS_COUNT_LABEL.getPath()).getAttribute("textContent");
    }

    public NewsListCommentComponent getCommentByIndex(int index) {
            comments = new NewsListComponent(driver);

        return comments.get(index);
    }
}
