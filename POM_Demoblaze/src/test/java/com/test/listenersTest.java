package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class listenersTest implements ITestListener {

	public static Logger log=LogManager.getLogger(listenersTest.class);
    
	public void onTestStart(ITestResult result) {
	log.info(result.getName() +"Test Started");
}
	public void onTestSuccess(ITestResult result) {
		log.info("Test PASSED"+result.getName() );
	}
	public void onTestFailure(ITestResult result) {
		log.info("Test FAILED"+result.getName());
		
	 WebDriver driver=BaseTest.getDriver();
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			new File(System.getProperty("user.dir") + "/screenshots/").mkdirs();

			String path = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";

			FileUtils.copyFile(src, new File(path));

		}
		catch(IOException e) {
			log.error("Screenshot Failed"+e.getMessage());
		}
	
	}
	public void onTestSkipped(ITestResult result) {
		log.warn("Test SKIPPED"+result.getName());
	}
}
