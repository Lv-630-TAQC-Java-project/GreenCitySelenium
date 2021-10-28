package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.CredentialProperties;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.news.NewsListCommentComponent;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EditOwnReplyOnNew extends TestRuner {

    @Test
    public void verifyEditReplyOnNew()  {
        NewsListCommentComponent commentComponent = new HomePage(driver)
                .getHeader()
                .login(new CredentialProperties().getTestUserGC871Login(),
                        new CredentialProperties().getTestUserGC871Password())
                .getHeader().clickEcoNewsLink()
                 .getNews()
                .get(0).click()
                .setCommentText("test example")
                .clickCommentButton()
                .getCommentByIndex(0)
                .createOneReplyToComment("testText")
                .editReply("edited");

        String expectedMessage = "edited";
        Assert.assertEquals(commentComponent.getTextFromReply(),expectedMessage);
    }
}
