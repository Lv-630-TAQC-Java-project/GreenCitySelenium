package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoToEcoNewsTest extends TestRuner {

    @Test
    public void goToEconews() {
        EcoNewsPage ecoNewsPage = new HomePage(driver).
                getHeader().
                clickEcoNewsLink();
        String title = ecoNewsPage.getMainHeader().getText();
        Assert.assertEquals(title, "Eco news");
    }
}
