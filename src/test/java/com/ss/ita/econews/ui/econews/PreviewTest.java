package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.data.UserSignInData;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.PreviewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PreviewTest extends TestRuner {

    @Test
    public void preview() {
        String title = "test title";
        String source = "test source";
        String content = "test content preview";
        new HomePage(driver)
                .getHeader()
                .login(UserSignInData.VLAD_DMYTRIV.getEmail(), UserSignInData.VLAD_DMYTRIV.getPassword());
        PreviewPage previewPage = new HomePage(driver)
                .getHeader()
                .clickEcoNewsLink()
                .getHeader()
                .clickCreateButton()
                .setTitle(title)
                .setSource(source)
                .setContent(content)
                .clickPreviewButton();
        Assert.assertEquals(title, previewPage.getTitle());
        Assert.assertEquals(source, previewPage.getSource());
        Assert.assertTrue(previewPage.getContent().contains(content));
    }
}
