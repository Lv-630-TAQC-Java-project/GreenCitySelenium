package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.data.UserSignInData;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;

import com.ss.ita.greencity.ui.pages.SingleNewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditOwnReplyNews extends TestRuner {

    @Test
    public void editRepliesOnNew()  {
        SingleNewPage singleNewPage = new HomePage(driver)
                .getHeader()
                .login(UserSignInData.TEST_USER_GC_871.getEmail(),UserSignInData.TEST_USER_GC_871.getPassword())
                .clickHomePageLink()
                .clickEcoNewsLink()
                .clickOnSingleNewPage()
                .setReply("test data3")
                .editReply("edited");

        String expectedMessage = "edited";

        Assert.assertEquals(singleNewPage.getTextFromReply(),expectedMessage);

    }
}
