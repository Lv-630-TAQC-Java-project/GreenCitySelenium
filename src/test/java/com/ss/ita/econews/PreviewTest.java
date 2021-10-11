package com.ss.ita.econews;

import com.ss.ita.pages.*;
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
                .login("Vladdmutriv@gmail.com","1203Vlad01*");
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
