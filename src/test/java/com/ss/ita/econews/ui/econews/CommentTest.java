package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


import static org.testng.Assert.*;

public class CommentTest extends TestRuner {

   public NewsPage goToFffNews() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        NewsPage newsPage = new HomePage(driver)
                .getHeader()
                .clickEcoNewsLink()
                .clickFffNewsButton();

        return newsPage;
    }

    private NewsPage setComment() {
        String commentText = "comment";
        return goToFffNews()
                .setComment(commentText)
                .clickCommentButton();
    }

    @Test
    public void comment() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        int commentNumber = new NewsPage(driver).CommentNumber();

        int secondCommentNumber = new NewsPage(driver).CommentNumber();
        assertTrue(secondCommentNumber == commentNumber + 1);
        assertTrue(newsPage.getFirstCommentText().equals(commentText));
    }
}
