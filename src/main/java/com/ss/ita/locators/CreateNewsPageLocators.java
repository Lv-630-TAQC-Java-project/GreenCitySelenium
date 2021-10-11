package com.ss.ita.locators;

import org.openqa.selenium.By;

public enum CreateNewsPageLocators implements BaseLocator {
	CONTENT_TEXT_AREA(By.name("main-area"));

	private final By path;

	CreateNewsPageLocators(By path) {
		this.path = path;
	}

	@Override
	public By getPath() {
		return path;
	}

}
