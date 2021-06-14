package com.demo.base;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demo.utils.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;

	public TestBase() {
	
		try {
			prop = new Properties();

			String propFileName = "config.properties";

			ClassLoader classLoader = getClass().getClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream(propFileName);

			prop.load(inputStream);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		//Initialized Extent report 
		extent = new ExtentReports();
		reporter = new ExtentSparkReporter("target/reports/report.html");
		extent.attachReporter(reporter);
		
	}

}
