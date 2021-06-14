package com.demo.pages;

import com.demo.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.pages.RoutePage;

public class FavouritesPage extends TestBase {
	
	// Initializing the Page Objects:
	public FavouritesPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='https://www.translink.ca/next-bus/results/#/text/route/99/']")
	WebElement myFavLink;

	public RoutePage clickMyFavLink() {
		myFavLink.click();
		return new RoutePage();
	}
	
	public String getLinkName() {
		return myFavLink.getText();
	}
}
