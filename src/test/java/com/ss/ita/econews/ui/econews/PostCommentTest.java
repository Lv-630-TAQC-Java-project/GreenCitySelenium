package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.data.UserSignInData;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.news.NewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostCommentTest extends TestRuner {
    @Test
    public void verifyCommentLabelIsUpdatedTest() {
        NewsPage page = new HomePage(driver)
                .getHeader()
                .login(UserSignInData.TEST_USER.getEmail(), UserSignInData.TEST_USER.getPassword())
                .getHeader()
                .clickEcoNewsLink()
                .clickCreateNewsButton()
                .setTitle("Post comment test")
                .clickTagNewsButton()
                .setContent("Some content to reach 20 symbols")
                .clickPublishButton()
                .getNewsByIndex(0).click()
                .createAndPublicComment("some comment");

        int commentsListSize = page.numbersOfComments();
        int commentsCountInLabel = page.getCommentsCountFromLabel();
        Assert.assertEquals(commentsCountInLabel, commentsListSize);
    }
}
