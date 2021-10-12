package com.ss.ita.elements;

import org.openqa.selenium.WebDriver;

import com.ss.ita.locators.BaseLocator;

public class TextArea extends BaseWebElement {

	public TextArea(WebDriver driver, BaseLocator locator) {
		super(driver, locator);
		
	}
	public void clearTextArea() {
		this.webElement.clear();
	}
	public void clicTextArea() {
		this.webElement.click();
	}
	 public void sendKeysTextArea(String text) {
		 this.webElement.sendKeys(text);
	 }
	 
	 public String getBorderColor() {
		 return this.webElement.getCssValue("border-color");
	 }
	 
	 
}
