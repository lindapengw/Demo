package com.demo.pages;

import com.demo.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.pages.RoutePage;

public class HomePage extends TestBase {

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "next-bus")
	WebElement nextBusTab;

	@FindBy(id = "NextBusSearchTerm")
	WebElement nextBusSearchField;

	@FindBy(xpath = "//button[text()='Find my next bus']")
	WebElement findBusBtn;

	public void clickNextBusTab() {
		nextBusTab.click();
	}

	public void enterBusNum(String busNumber) {
		nextBusSearchField.clear();
		nextBusSearchField.sendKeys(busNumber);
	}

	public RoutePage clickFindBusBtn() {
		findBusBtn.click();
		return new RoutePage();
	}

}
