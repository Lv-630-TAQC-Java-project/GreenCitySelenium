package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsListComponent;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import org.testng.annotations.Test;

public class AllEcoNewsTest extends TestRuner {

    @Test
    public void verifyLoadAllNews() {
        EcoNewsListComponent ecoNews = new HomePage(driver).getHeader().clickEcoNewsLink().getNews().loadAllEcoNews();
        System.out.println("first pause in test" + " :" + ecoNews.pause(2000));
        System.out.println(ecoNews.sizeEcoNewsListComponent());
        System.out.println("second pause in test" + " :" + ecoNews.pause(5000));
    }
}
