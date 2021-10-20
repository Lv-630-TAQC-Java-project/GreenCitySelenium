package com.ss.ita.greencity.ui.pages.news;

import com.ss.ita.greencity.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.List;

import static com.ss.ita.greencity.ui.locators.NewsListLocators.*;

public class NewsListComponent extends BasePage {
    private List<NewsListCommentComponent> comments;

    public NewsListComponent(WebDriver driver) {
        super(driver);
        init();
    }

    public List<NewsListCommentComponent> init() {
        if (comments == null) {
            comments = new LinkedList<>();
            driver.findElements(COMMENTS.getPath())
                    .forEach(webElement -> comments.add(new NewsListCommentComponent(driver, webElement)));
        }
        return comments;
    }

    public NewsListCommentComponent get(int i) {
        return comments.get(i);
    }
}
