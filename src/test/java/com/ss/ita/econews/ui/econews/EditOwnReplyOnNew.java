package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.news.NewsListCommentComponent;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ss.ita.econews.ui.data.UserSignInData.TEST_USER;

public class EditOwnReplyOnNew extends TestRuner {

    @Test
    public void verifyEditReplyOnNew()  {
        NewsListCommentComponent commentComponent = new HomePage(driver)
                .getHeader()
                .login(TEST_USER.getEmail(),TEST_USER.getPassword())
                .getHeader().clickEcoNewsLink()
                 .getNews()
                .get(0).click()
                .setCommentText("test ex")
                .clickCommentButton()
                .getCommentByIndex(0)
                .setReplyText("testText")
                .editReply("edited");

        String expectedMessage = "edited";
        Assert.assertEquals(commentComponent.getTextFromReply(),expectedMessage);

    }
}
