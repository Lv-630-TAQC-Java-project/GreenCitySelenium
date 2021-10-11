package com.ss.ita.econews;

import com.ss.ita.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ss.ita.data.UserSignInData.TARAS_KRASITSKYI;
import static com.ss.ita.data.UserSignInData.VLAD_DMYTRIV;

public class PreviewTest extends TestRuner {

    @Test
    public void preview() {
        String title = "test title";
        String source = "test source";
        String content = "test content preview";
        new HomePage(driver)
                .getHeader()
                .login(VLAD_DMYTRIV.getEmail(), VLAD_DMYTRIV.getPassword());
        PreviewPage previewPage = new HomePage(driver)
                .getHeader()
                .clickEcoNewsLink()
                .getHeader()
                .clickCreateButton()
                .setTitle(title)
                .setSource(source)
                .setContent(content)
                .clickPreviewButton();
        Assert.assertEquals(title,previewPage.getTitle());
        Assert.assertEquals(source,previewPage.getSource());
        Assert.assertTrue(previewPage.getContent().contains(content));
    }
}
