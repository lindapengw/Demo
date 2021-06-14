package com.demo.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demo.base.TestBase;
import com.demo.pages.FavouritesPage;
import com.demo.pages.HomePage;
import com.demo.pages.RouteEastPage;
import com.demo.pages.RouteEastUBCStopPage;
import com.demo.pages.RoutePage;
import com.demo.utils.TestUtil;

public class MainTest extends TestBase {

	private static HomePage homePage;
	private static RoutePage routePage;
	private static FavouritesPage favouritesPage;
	private static RouteEastPage routeEastPage;
	private static RouteEastUBCStopPage routeEastUBCStopPage;
	TestUtil testUtil;
	ExtentTest test;
	WebDriverWait wait;

	public MainTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		routePage = new RoutePage();
		favouritesPage = new FavouritesPage();
		routeEastPage = new RouteEastPage();
		routeEastUBCStopPage = new RouteEastUBCStopPage();
		wait = new WebDriverWait(driver, 10);

	}

	@Test()
	public void mainTest() {

		test = extent.createTest("Demo Test case #1");

		homePage.clickNextBusTab();
		homePage.enterBusNum("99");
		routePage = homePage.clickFindBusBtn();
		routePage.clickAddFavBtn();

		// Validate Translink Auto Homework link is present
		routePage.enterNewFav("Translink Auto Homework");
		routePage.clickAddBtn();
		favouritesPage = routePage.clickMyFavBtn();
		test.log(Status.INFO, "Validate Translink Auto Homework link is present");
		assertEquals("Translink Auto Homework", favouritesPage.getLinkName());
		test.pass("PASS");

		// Validate 99 Commercial-Broadway / UBC (B-Line) is displayed on page
		routePage = favouritesPage.clickMyFavLink();
		driver.switchTo().frame(routePage.nextBusIframe);
		test.log(Status.INFO, "Validate 99 Commercial-Broadway / UBC (B-Line) text is present");
		assertEquals("99 Commercial-Broadway / UBC (B-Line)", routePage.getTitleName());
		test.pass("PASS");

		// Validate Stop # 61935 is displaying
		routeEastPage = routePage.clickEastLink();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(routeEastPage.ubcStop));
		routeEastUBCStopPage = routeEastPage.clickUbcStop();
		wait.until(ExpectedConditions.visibilityOf(routeEastUBCStopPage.ubcStopName));
		test.log(Status.INFO, "Validate Stop # 61935 text is present");
		assertEquals("Stop # 61935", routeEastUBCStopPage.getUbcStopName());
		test.pass("PASS");
	}

	@AfterMethod
	public void tearDown(ITestResult testResult) {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			testUtil.takeScreenShot(driver, testResult.getName(), "target/reports/screenshot/");
			String screenshotFilePath = "screenshot/" + testResult.getName() + ".png";
			test.addScreenCaptureFromPath(screenshotFilePath);
			test.fail(testResult.getThrowable() + " is failed");
		}
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		driver.quit();
	}

}
