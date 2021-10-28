package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.Button;
import com.ss.ita.greencity.ui.elements.Paragraph;
import com.ss.ita.greencity.ui.elements.TextArea;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import org.openqa.selenium.WebDriver;

import static com.ss.ita.greencity.ui.locators.CreateNewsPageLocators.*;

public class CreateNewsPage extends BasePage {

    private TextArea content;
    private Paragraph textAreaDescription;
    private TextArea title_area;
    private Button news_button;
    private Button ads_button;
    private Button events_button;
    private Button initiatives_button;
    private Button education_button;
    private Button publish_button;

    public CreateNewsPage(WebDriver driver) {
        super(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public TextArea getTextArea() {
        if (content == null) {
            content = new TextArea(driver, CONTENT_TEXT_AREA);
        }

        return content;
    }

    public CreateNewsPage setTextArea(String text) {
        getTextArea().clickTextArea();
        getTextArea().clearTextArea();
        getTextArea().sendKeysTextArea(text);
        return this;
    }

    public Paragraph getParagraph() {
        if (textAreaDescription == null) {
            textAreaDescription = new Paragraph(driver, TEXT_AREA_DESCRIPTION);
        }

        return textAreaDescription;

    }

    public CreateNewsPage clickTextAreaDescription() {
        getParagraph().clickParagraph();
        return this;
    }

    public TextArea setContentArea() {
        getTextArea().sendKeysTextArea("Description for test Create News");
        return new TextArea(driver, CONTENT_TEXT_AREA);
    }

    public TextArea getTitle_area() {
        if (title_area == null) {
            title_area = new TextArea(driver, TITLE_TEXT_AREA);
        }
        return title_area;
    }

    public TextArea setTitleTextArea(String text) {
        getTitle_area().sendKeysTextArea(text);
        return new TextArea(driver, TITLE_TEXT_AREA);
    }

    public Button getTag_News_button() {
        if (news_button == null) {
            news_button = new Button(driver, NEWS_TAG_BUTTON);
        }
        return news_button;
    }

    public CreateNewsPage clickTagNewsButton() {
        getTag_News_button().clickButton();
        return new CreateNewsPage(driver);
    }

    public Button getTag_Ads_button() {
        if (ads_button == null) {
            ads_button = new Button(driver, ADS_TAG_BUTTON);
        }
        return ads_button;
    }

    public CreateNewsPage clickTagAdsButton() {
        getTag_Ads_button().clickButton();
        return new CreateNewsPage(driver);
    }

    public Button getTag_Events_button() {
        if (events_button == null) {
            events_button = new Button(driver, EVENTS_TAG_BUTTON);
        }
        return events_button;
    }

    public CreateNewsPage clickTagEventsButton() {
        getTag_Events_button().clickButton();
        return new CreateNewsPage(driver);
    }

    public Button getTag_Initiatives_button() {
        if (initiatives_button == null) {
            initiatives_button = new Button(driver, INITIATIVES_TAG_BUTTON);
        }
        return initiatives_button;
    }

    public CreateNewsPage clickTagInitiativesButton() {
        getTag_Initiatives_button().clickButton();
        return new CreateNewsPage(driver);
    }

    public Button getTag_Education_button() {
        if (education_button == null) {
            education_button = new Button(driver, EDUCATION_TAG_BUTTON);
        }
        return education_button;
    }

    public CreateNewsPage clickTagEducationButton() {
        getTag_Education_button().clickButton();
        return new CreateNewsPage(driver);
    }

    public Button getPublishButton() {
        if (publish_button == null) {
            publish_button = new Button(driver, PUBLISH_BUTTON);
        }
        return publish_button;
    }

    public EcoNewsPage clickPublishButton() {
        getPublishButton().clickButton();
        return new EcoNewsPage(driver);
    }

    public void createNews() {
        driver.findElement(TITLE_AREA.getPath()).sendKeys("Test News");
        driver.findElement(NEWS_BUTTON.getPath()).click();
        driver.findElement(ADS_BUTTON.getPath()).click();
        driver.findElement(EVENTS_BUTTON.getPath()).click();
        driver.findElement(CONTENT_AREA.getPath()).sendKeys("Description for test news");
        driver.findElement(PUBLISH_BUTTON.getPath()).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public CreateNewsPage setTitle(String title) {
        driver.findElement(TITLE_AREA.getPath()).sendKeys(title);
        return this;
    }

    public CreateNewsPage setSource(String source) {
        driver.findElement(SOURCE_AREA.getPath()).sendKeys(source);
        return this;
    }

    public CreateNewsPage setContent(String content) {
        driver.findElement(CONTENT_AREA.getPath()).sendKeys(content);
        return this;
    }

    public PreviewPage clickPreviewButton() {
        driver.findElement(PREVIEW_BUTTON.getPath()).click();
        return new PreviewPage(driver);
    }


}
