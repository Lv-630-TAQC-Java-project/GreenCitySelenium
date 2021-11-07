package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FilterByNewsTest extends TestRuner {

    @Test
    public void filterByNewsTest() {
        EcoNewsPage ecoNewsPage = new HomePage(driver)
                .getHeader().clickEcoNewsLink()
                .clickFilterByNews();
        String filterBackgroundColor = ecoNewsPage
                .getFilterByNews()
                .getBackgroundHexColor();
        String filterText = ecoNewsPage
                .getFilterByNews()
                .getText();
        String newsArticleTagText = ecoNewsPage
                .getNewsByIndex(0)
                .getNewsTag()
                .getText();
        softAssert.assertEquals(filterBackgroundColor, "#13aa57");
        softAssert.assertEquals(filterText, "News");
        softAssert.assertEquals(newsArticleTagText, "NEWS");
        softAssert.assertAll();
    }
}
