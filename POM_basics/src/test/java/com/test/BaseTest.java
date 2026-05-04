package com.test;

import org.testng.annotations.Test;

import com.pages.Dashboardpage;
import com.pages.loginpage;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;

public class BaseTest {
	 public static WebDriver driver;
	  loginpage objLogin;
	  Dashboardpage objDashboardpage;
 
  @BeforeClass
  public void beforeClass() {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
