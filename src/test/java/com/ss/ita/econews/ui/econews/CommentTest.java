package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.*;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import com.ss.ita.greencity.ui.pages.news.NewsListCommentComponent;
import com.ss.ita.greencity.ui.pages.news.NewsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;

import static com.ss.ita.econews.ui.data.UserSignInData.*;
import static org.testng.Assert.*;

public class CommentTest extends TestRuner {

    @BeforeMethod
    private NewsPage loginAndGoToCreateNews() {
        CreateNewsPage createNewsPage = new HomePage(driver)
                .getHeader()
                .login(VLAD_DMYTRIV.getEmail(), VLAD_DMYTRIV.getPassword())
                .getHeader()
                .clickEcoNewsLink()
                .clickCreateNewsButton()
                .clickTagNewsButton();
        createNewsPage.setTitleTextArea(System.currentTimeMillis() + "");
        createNewsPage.setContentArea();
        createNewsPage.clickPublishButton();
        NewsPage newsPage = new EcoNewsPage(driver)
                .getNewsByIndex(0)
                .click();
        return newsPage;
    }

    @Test
    public void verifyCommentPublishingTest() {
        String commentText = UUID.randomUUID().toString();
        NewsPage newsPage = loginAndGoToCreateNews();
        int commentsNumberBeforePostingComment = newsPage.numbersOfComments();
        newsPage.createAndPublicComment(commentText);
        int commentsNumberAfterPostingComment = newsPage.numbersOfComments();

        assertTrue(commentsNumberAfterPostingComment == commentsNumberBeforePostingComment + 1);
        assertTrue(newsPage.getCommentByIndex(0).getContent().getText().equals(commentText));
    }

    @Test
    public void verifyCommentDeletingWithRepliesTest() {
        String commentText = UUID.randomUUID().toString();

        NewsPage newsPage = loginAndGoToCreateNews();
        int commentsNumberBeforePostingComment = newsPage.numbersOfComments();
        newsPage.createAndPublicComment(commentText);
        int commentsNumberAfterPostingComment = newsPage.numbersOfComments();

        assertTrue(commentsNumberAfterPostingComment == commentsNumberBeforePostingComment + 1);
        assertTrue(newsPage.getCommentByIndex(0).getContent().getText().equals(commentText));

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
        String replyText = "Reply";
        NewsListCommentComponent newsListCommentComponent = new NewsPage(driver)
                .createAndPublicComment("Comment")
                .getCommentByIndex(0)
                .createOneReplyToComment(replyText);
        for (int i = 0; i < 10; i++) {
            newsListCommentComponent.createAnotherReply(replyText);
        }
        newsListCommentComponent.clickViewReplyButton();
        int numberOfRepliesOnFirstSection = newsListCommentComponent.numberOfReplies();
        newsListCommentComponent.clickNextRepliesButton();
        int numberOfRepliesOnSecondSection = newsListCommentComponent.numberOfReplies();
        assertTrue(numberOfRepliesOnFirstSection + numberOfRepliesOnSecondSection == 11);
    }
}

