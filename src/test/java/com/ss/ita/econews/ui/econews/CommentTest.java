package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.*;
import com.ss.ita.greencity.ui.pages.news.NewsListCommentComponent;
import com.ss.ita.greencity.ui.pages.news.NewsPage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


import static com.ss.ita.econews.ui.data.UserSignInData.*;
import static org.testng.Assert.*;

public class CommentTest extends TestRuner {

    private NewsPage loginAndOpenNews() {
        Header header = new HomePage(driver).getHeader();
        header.login(VLAD_DMYTRIV.getEmail(), VLAD_DMYTRIV.getPassword());
        return header
                .clickEcoNewsLink()
                .getNews()
                .get(0)
                .click();
    }

    @Test
    public void verifyCommentPublishingTest() {
        String commentText = "Comment";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        NewsPage newsPage = loginAndOpenNews();
        int commentNumber = newsPage.NumbersOfComments();
        newsPage.createAndPublicComment(commentText);
        int secondCommentNumber = newsPage.NumbersOfComments();

        assertTrue(secondCommentNumber == commentNumber + 1);
        assertTrue(newsPage.getFirstCommentText().equals(commentText));
    }

    @Test
    public void verifyCommentDeletingTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        NewsPage newsPage = loginAndOpenNews()
                .createAndPublicComment("Comment");
        NewsListCommentComponent comment = newsPage
                .getComment()
                .get(0);
        comment
                .clickReplyButton()
                .createAndPublicReply("reply")
                .createAndPublicReply("REPLY");
        comment
                .deleteComment();
    }
}