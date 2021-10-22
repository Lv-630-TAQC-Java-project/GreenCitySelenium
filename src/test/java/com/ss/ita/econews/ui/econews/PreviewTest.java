package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.*;
import org.testng.annotations.Test;

import static com.ss.ita.econews.ui.data.UserSignInData.VLAD_DMYTRIV;
import static org.testng.Assert.*;

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
        assertEquals(title, previewPage.getTitle());
        assertEquals(source, previewPage.getSource());
        assertTrue(previewPage.getContent().contains(content));
    }
}
