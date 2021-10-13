package com.ss.ita.econews.ui.econews;

import com.ss.ita.greencity.ui.pages.CreateNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.econews.ui.runner.TestRuner;
import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.ss.ita.econews.ui.data.UserSignInData.TARAS_KRASITSKYI;
import static org.testng.Assert.assertTrue;


public class ContentTextAreaTest extends TestRuner {

    private CreateNewsPage createNewsPage;

    @DataProvider
    public static Object[][] dpTextAreaDescriptionIsRedTest() {
        return new Object[][]{{"too short text", "#ff0000"},
                {"", "#ff0000"},
                {"almost enogth text)", "#ff0000"}};
    }

    @BeforeClass
    public void beforeContentTextAreaTest() {
        createNewsPage = new HomePage(driver)
                .getHeader()
                .login(TARAS_KRASITSKYI.getEmail(), TARAS_KRASITSKYI.getPassword())
                .clickHomePageLink()
                .clickEcoNewsLink()
                .clickCreateNewsButton();
    }

    @Test(dataProvider = "dpTextAreaDescriptionIsRedTest")
    public void textAreaDescriptionIsRedTest(String shortText, String expectedTextColor) {
        createNewsPage = createNewsPage
                .setTextArea(shortText)
                .clickTextAreaDescription();
        String colorTextParagraph = Color.fromString(createNewsPage.getParagraph()
                        .getColorTextParagraph())
                .asHex();


        softAssert.assertEquals(colorTextParagraph, expectedTextColor);

        softAssert.assertEquals(Color
                .fromString(createNewsPage
                        .getTextArea()
                        .getBorderColor())
                .asHex(), expectedTextColor);
        softAssert.assertAll();
    }

    @Test(dataProvider = "dpTextAreaDescriptionIsRedTest")
    public void borderAreaDescriptionIsRedTest(String shortText, String expectedTextColor) {
        createNewsPage = createNewsPage
                .setTextArea(shortText)
                .clickTextAreaDescription();
        assertTrue((Color
                .fromString(createNewsPage
                        .getTextArea()
                        .getBorderColor())
                .asHex())
                .equals(expectedTextColor));
    }

}