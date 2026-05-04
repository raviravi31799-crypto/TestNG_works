package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.loginpage;

public class loginTest extends BaseTest {
	loginpage objLogin;
  
	
	@Test(priority=0)
  public void logintest() {
		//create login page object
		objLogin=new loginpage(driver);
		//verify login page text
		String loginpageTitle=objLogin.getLogintext();
		Assert.assertTrue(loginpageTitle.contains("Login"));
  }
}
