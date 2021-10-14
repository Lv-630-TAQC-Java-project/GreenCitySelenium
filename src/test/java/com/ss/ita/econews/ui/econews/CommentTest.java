package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.NewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.ss.ita.econews.ui.data.UserSignInData.VLAD_DMYTRIV;

public class CommentTest extends TestRuner {

    @Test
    public void comment() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String commentText = "comment";
        new HomePage(driver)
                .getHeader()
                .login(VLAD_DMYTRIV.getEmail(), VLAD_DMYTRIV.getPassword());
        NewsPage newsPage = new HomePage(driver)
                .getHeader()
                .clickEcoNewsLink()
                .clickFffNewsButton();
        int commentNumber = new NewsPage(driver).CommentNumber();
        newsPage
                .setComment(commentText)
                .clickCommentButton();
        int secondCommentNumber = new NewsPage(driver).CommentNumber();
        Assert.assertTrue(secondCommentNumber == commentNumber + 1);
        Assert.assertTrue(newsPage.getFirstCommentText().equals(commentText));
    }
}
