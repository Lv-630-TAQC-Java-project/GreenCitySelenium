package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.Link;
import org.openqa.selenium.WebDriver;

import static com.ss.ita.greencity.ui.locators.MySpaceLocators.HOME_PAGE_LINK;

public class MySpacePage extends BasePage {
    private Link homePageLink;

    public MySpacePage(WebDriver driver) {
        super(driver);

    }

    public Link getHomepageLink() {
        if (homePageLink == null) {
            homePageLink = new Link(driver, HOME_PAGE_LINK);
        }
        return homePageLink;
    }

    public Header clickHomePageLink() {
        getHomepageLink().click();
        return new Header(driver);

    }

}
