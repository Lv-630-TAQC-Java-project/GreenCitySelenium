package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.*;
import com.ss.ita.greencity.ui.pages.news.NewsListCommentComponent;
import com.ss.ita.greencity.ui.pages.news.NewsPage;
import org.testng.annotations.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


import static com.ss.ita.econews.ui.data.UserSignInData.*;
import static org.testng.Assert.*;

public class CommentTest extends TestRuner {

    private NewsPage loginAndGoToNews(int indexOfNews) {
       NewsPage newsPage = new HomePage(driver)
                .getHeader()
                .login(VLAD_DMYTRIV.getEmail(), VLAD_DMYTRIV.getPassword())
                .getHeader()
                .clickEcoNewsLink()
                .getNewsByIndex(indexOfNews)
                .click();
        return newsPage;
    }

    @Test
    public void verifyCommentPublishingTest() {
        String commentText = UUID.randomUUID().toString();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        NewsPage newsPage = loginAndGoToNews(0);
        int commentsNumberBeforePostingComment = newsPage.numbersOfComments();
        newsPage.createAndPublicComment(commentText);
        int commentsNumberAfterPostingComment = newsPage.numbersOfComments();

        assertTrue(commentsNumberAfterPostingComment == commentsNumberBeforePostingComment + 1);
        assertTrue(newsPage.getCommentByIndex(0).getContent().equals(commentText));
    }

    @Test
    public void verifyCommentDeletingWithRepliesTest() {
        String commentText = UUID.randomUUID().toString();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        NewsPage newsPage = loginAndGoToNews(0);
        int commentsNumberBeforePostingComment = newsPage.numbersOfComments();
        newsPage.createAndPublicComment(commentText);
        int commentsNumberAfterPostingComment = newsPage.numbersOfComments();

        assertTrue(commentsNumberAfterPostingComment == commentsNumberBeforePostingComment + 1);
        assertTrue(newsPage.getCommentByIndex(0).getContent().equals(commentText));

        NewsListCommentComponent comment = newsPage
                .getCommentByIndex(0)
                .createOneReplyToComment("reply")
                .createAnotherReply("REPLY")
                .clickViewReplyButton();
        int repliesNumber = comment.numberOfReplies();

        assertTrue(repliesNumber == 2);

        NewsPage newsPageAfterDeletingComment = comment
                .clickViewReplyButton()
                .deleteFirstComment();
        int commentsNumberAfterDeletingComment = newsPageAfterDeletingComment.numbersOfComments();

        assertTrue(commentsNumberAfterDeletingComment == commentsNumberBeforePostingComment);
    }

    @Test
    public void verifyReviewRepliesTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}

