package com.demo.pages;

import com.demo.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RouteEastUBCStopPage extends TestBase {

	// Initializing the Page Objects:
	public RouteEastUBCStopPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "stopNo")
	public WebElement ubcStopName;

	public String getUbcStopName() {
		return ubcStopName.getText();
	}
}
