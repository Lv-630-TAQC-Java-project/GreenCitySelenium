package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.CredentialProperties;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.elements.Button;
import com.ss.ita.greencity.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyReplyTest extends TestRuner {
    @Test
    public void emptyReplyTest(){
        Button postReplyButton = new HomePage(driver).getHeader()
                .login(new CredentialProperties().getTestUserLogin(),
                        new CredentialProperties().getTestUserPassword())
                .clickHomePageLink()
                .clickEcoNewsLink()
                .getNews().get(0)
                .click()
                .createAndPublicComment("Test comment")
                .getCommentByIndex(0)
                .clickReplyButton()
                .getPublishReplyButton();
        Assert.assertFalse(postReplyButton.isEnabled());
    }
}
