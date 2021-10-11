package com.ss.ita.pages;

import org.openqa.selenium.WebDriver;

import com.ss.ita.elements.Link;
import static com.ss.ita.locators.MySpaceLocators.HOME_PAGE_LINK;

public class MySpacePage extends BasePage {
	private Link homePageLink;

	public MySpacePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
