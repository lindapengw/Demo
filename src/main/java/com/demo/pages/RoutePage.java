package com.demo.pages;

import com.demo.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.pages.FavouritesPage;

public class RoutePage extends TestBase {

	// Initializing the Page Objects:
	public RoutePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "AddDelFav")
	WebElement addFavBtn;

	@FindBy(xpath = "//a[@href='/next-bus/favourites']")
	WebElement myFavsBtn;

	@FindBy(name = "newFavourite")
	WebElement newFavField;

	@FindBy(xpath = "//Button[text()='Add to Favourites']")
	WebElement addBtn;

	@FindBy(className = "txtRouteTitle")
	// @FindBy(xpath="//*[contains(text(), '99 Commercial')]")
	WebElement titleTxt;

	@FindBy(xpath = "//a[@href='/text/route/099/direction/EAST']")
	WebElement eastLink;
	
	@FindBy(css = "iframe[title='Next Bus']")
	public WebElement nextBusIframe;

	public void clickAddFavBtn() {
		addFavBtn.click();

	}

	public void enterNewFav(String name) {
		newFavField.clear();
		newFavField.sendKeys(name);
	}

	public void clickAddBtn() {
		addBtn.click();
	}

	public FavouritesPage clickMyFavBtn() {
		myFavsBtn.click();
		return new FavouritesPage();
	}
	
	public String getTitleName() {
		return titleTxt.getText();
	}

	public RouteEastPage clickEastLink() {
		eastLink.click();
		return new RouteEastPage();
	}



}