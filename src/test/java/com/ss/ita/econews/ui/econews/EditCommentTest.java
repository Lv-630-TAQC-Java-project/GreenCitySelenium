package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.data.UserSignInData;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EditCommentTest extends TestRuner {

    /**
     * This test case verifies, that logged user can
     * edit its own comment on the 'News' page
     */
    @Test
    public void verifyUserCanEditCommentTest() {
        String primaryComment = System.currentTimeMillis() + "";
        String secondaryComment = primaryComment + "s";

        String actual = new HomePage(driver)
                .getHeader()
                .login(UserSignInData.TEST_USER.getEmail(), UserSignInData.TEST_USER.getPassword())
                .getHeader().clickEcoNewsLink()
                .clickCreateNewsButton()
                .setTitle("Edit comment test")
                .clickTagNewsButton()
                .setContent("This test case verifies, that logged user can edit its own comment on the 'News' page")
                .clickPublishButton()
                .getNewsByIndex(0).click()
                .createAndPublicComment(primaryComment)
                .getCommentByIndex(0)
                .editComment(secondaryComment)
                .getContent()
                .getText();

        Assert.assertEquals(actual, secondaryComment);
    }
}
