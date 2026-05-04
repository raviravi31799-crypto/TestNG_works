package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.Dashboardpage;
import com.pages.loginpage;

public class DashboardpageTest extends BaseTest{
	Dashboardpage objDashboardpage;
	@Test(priority=0)
	  public void logintest() {
			//create login page object
			objLogin=new loginpage(driver);
			objLogin.login("Admin", "admin123");
			objDashboardpage=new Dashboardpage(driver);
			//verify dashboard page
			Assert.assertTrue(objDashboardpage.getHomePageText().contains("Dashboard"));
	  }
	
}
