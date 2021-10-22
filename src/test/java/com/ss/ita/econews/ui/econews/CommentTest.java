package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.data.UserSignInData;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.*;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import com.ss.ita.greencity.ui.pages.news.NewsListCommentComponent;
import com.ss.ita.greencity.ui.pages.news.NewsPage;
import org.testng.annotations.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


import static com.ss.ita.econews.ui.data.UserSignInData.*;
import static org.testng.Assert.*;

public class CommentTest extends TestRuner {

    private NewsPage loginAndCreateNews() {
        CreateNewsPage createNewsPage = new HomePage(driver)
                .getHeader()
                .login(VLAD_DMYTRIV.getEmail(), VLAD_DMYTRIV.getPassword())
                .clickHomePageLink()
                .clickEcoNewsLink()
                .clickCreateNewsButton()
                .clickTagNewsButton();
        createNewsPage.setTitleTextArea(System.currentTimeMillis() + "");
        createNewsPage.setContentArea();
        createNewsPage.clickPublishButton();

        EcoNewsPage ecoNewsPage = createNewsPage
                .getHeader()
                .clickEcoNewsLink();

        NewsPage newsPage = ecoNewsPage
                .getNews()
                .get(0)
                .click();
        return newsPage;
    }

    @Test
    public void verifyCommentPublishingTest() {
        String commentText = "Comment";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        NewsPage newsPage = loginAndCreateNews();
        int commentsNumberBeforePostingComment = newsPage.numbersOfComments();
        newsPage.createAndPublicComment(commentText);
        int commentsNumberAfterPostingComment = newsPage.numbersOfComments();

        assertTrue(commentsNumberAfterPostingComment == commentsNumberBeforePostingComment + 1);
        assertTrue(newsPage.getFirstCommentText().equals(commentText));
    }

    @Test
    public void verifyCommentDeletingWithRepliesTest() {
        String commentText = UUID.randomUUID().toString();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        NewsPage newsPage = loginAndCreateNews();
        int commentsNumberBeforePostingComment = newsPage.numbersOfComments();
        newsPage.createAndPublicComment(commentText);
        int commentsNumberAfterPostingComment = newsPage.numbersOfComments();
        assertTrue(commentsNumberAfterPostingComment == commentsNumberBeforePostingComment + 1);
        assertTrue(newsPage.getFirstCommentText().equals(commentText));
        NewsListCommentComponent comment = newsPage
                .getComment()
                .get(0)
                .clickReplyButton()
                .createAndPublicReply("reply")
                .clearReplyTextArea()
                .createAndPublicReply("REPLY")
                .clickViewReplyButton();
        int repliesNumber = comment.numberOfReplies();
        assertTrue(repliesNumber == 2);
        NewsPage newsPageAfterDeletingComment = comment
                .clickViewReplyButton()
                .deleteFirstComment();
        int commentsNumberAfterDeletingComment = newsPageAfterDeletingComment.numbersOfComments();
        assertTrue(commentsNumberAfterDeletingComment == commentsNumberBeforePostingComment+1);
    }
}