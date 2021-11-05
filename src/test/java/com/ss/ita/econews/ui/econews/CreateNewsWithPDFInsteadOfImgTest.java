package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.CredentialProperties;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.CreateNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import java.io.File;

public class CreateNewsWithPDFInsteadOfImgTest extends TestRuner {

    @Test
    public void createNewsWithPDFInsteadOfImgTest() {
        CreateNewsPage createNewsPage = new HomePage(driver)
                .getHeader()
                .login(new CredentialProperties().getNastiaSydorLogin(),
                        new CredentialProperties().getNastiaSydorPassword())
                .getHeader()
                .clickEcoNewsLink()
                .clickCreateNewsButton();


           String filePath = new File("src/test/resources/TestData/Tests.pdf").getAbsolutePath();

        createNewsPage.uploadFile(filePath);

        softAssert.assertEquals(createNewsPage.getPictureWarningMessage().getText(), "Download PNG or JPG only. File size should be less than 10MB");
        softAssert.assertEquals(Color
                .fromString(createNewsPage
                        .getPictureWarningArea()
                        .getBackgroundColour())
                .asHex(), "#fef1f2");
        softAssert.assertTrue(createNewsPage.getPictureWarningArea().isDisplayed());
        softAssert.assertAll();
    }
}
