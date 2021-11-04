package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsListComponent;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllEcoNewsTest extends TestRuner {

    @Test
    public void verifyLoadAllNews() {
        EcoNewsListComponent ecoNews = new HomePage(driver).getHeader().clickEcoNewsLink().getNews().loadAllEcoNews();
        int expectedCountNews = ecoNews.countNewsFromLabel();
        int actualCountNews = ecoNews.sizeEcoNewsListComponent();
        Assert.assertEquals(actualCountNews, expectedCountNews );
    }
}
