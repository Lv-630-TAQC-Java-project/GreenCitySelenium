package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsListItemComponent;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsListTest extends TestRuner {

    @Test
    public void testFirstNews() {
        EcoNewsListItemComponent ecoNewsItem = new HomePage(driver).
                getHeader().
                clickEcoNewsLink().
                getNews()
                .get(0);
        softAssert.assertEquals(ecoNewsItem.getTitle().getText(), "Test News");
        softAssert.assertEquals(ecoNewsItem.getContent().getText(), "Description for test news");
        softAssert.assertAll();
        }
}
