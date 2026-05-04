package com.test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BaseTest {
	WebDriver driver1;
	
	    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    public static WebDriver getDriver() {
	        return driver.get();
	    }
	
	public static Logger log=LogManager.getLogger(BaseTest.class);
 @BeforeMethod
 public void beforetest() {
	 log.info("Launching demoblaze in chrome");
	 driver1 =new ChromeDriver();
	 driver1.manage().window().maximize();
	 driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver1.get("https://demoblaze.com/");
 }
 @AfterMethod
 public void aftertest() {
	 log.info("Quitting browser");
	 driver1.quit();
 }
 
}
