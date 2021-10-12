package com.ss.ita.locators;

import org.openqa.selenium.By;

public enum CreateNewsPageLocators implements BaseLocator {
	CONTENT_TEXT_AREA(By.name("main-area")),
	TEXT_AREA_DESCRIPTION(By.cssSelector("p.textarea-description"));

	private final By path;

	CreateNewsPageLocators(By path) {
		this.path = path;
	}

	@Override
	public By getPath() {
		return path;
	}

}
