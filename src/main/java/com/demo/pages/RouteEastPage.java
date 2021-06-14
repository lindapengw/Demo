package com.demo.pages;

import com.demo.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.pages.RouteEastUBCStopPage;

public class RouteEastPage extends TestBase {
	
	// Initializing the Page Objects:
	public RouteEastPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='/text/stop/61935/route/099']")
	public WebElement ubcStop;
	
	@FindBy(css = "iframe[title='Next Bus']")
	public WebElement nextBusIframe;
	
	public RouteEastUBCStopPage clickUbcStop() {
		ubcStop.click();
		return new RouteEastUBCStopPage();
	}
}
