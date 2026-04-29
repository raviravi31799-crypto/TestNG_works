package Listeners_demo;

import org.testng.annotations.Test;
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
	
public class listeners_fail implements ITestListener {

	       public static Logger log=LogManager.getLogger(listeners_fail.class);
		    public void onTestStart(ITestResult result) {
		       log.info(result.getName() + " test started");
		    }

		    public void onTestSuccess(ITestResult result) {
		       log.info("Test PASSED: " + result.getName());
		    }

		    public void onTestFailure(ITestResult result) {
		        log.error("Test FAILED: " + result.getName());

		        Object testClass = result.getInstance();
		        WebDriver driver = ((Testlisteners) testClass).driver;

		        TakesScreenshot ts = (TakesScreenshot) driver;
		        File source = ts.getScreenshotAs(OutputType.FILE);

		        String path = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";

		        try {
		            FileUtils.copyFile(source, new File(path));
		           log.info("Screenshot saved at: " + path);
		        } catch (IOException e) {
		           log.error("Screenshot failed: " + e.getMessage());
		        }
		    }

		    public void onTestSkipped(ITestResult result) {
		        log.warn("Test SKIPPED: " + result.getName());
		    }
		}