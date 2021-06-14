package com.demo.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import com.demo.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
    public void takeScreenShot( WebDriver driver, String methodName, String filePath) {
   	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           String imagePath = filePath + methodName + ".png";
   	    
           try {
				FileUtils.copyFile(scrFile, new File(imagePath));
				
			} catch (IOException e) {
				e.printStackTrace();
			}

   }
	
}
