package com.test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.Loginpage;
import com.util.DPExcel;



public class LoginTest extends BaseTest {
	 Loginpage objLogin;
	 public static Logger log=LogManager.getLogger(LoginTest.class);
  @Test
  public void login() {
	  objLogin= new Loginpage(driver1); 
	  log.info("Login Action");
	  String logout=objLogin.getLogouttext();
	  log.info("Validating login");
	  Assert.assertTrue(logout.contains(logout));
	  System.out.println("Login successful");
	  
  }
  @Test(dataProvider="ValidexcelData",dataProviderClass=DPExcel.class)
  public void loginvalid(String username,String password) {
	  objLogin= new Loginpage(driver1); 
	  log.info("Login Action");
	  String logout=objLogin.getLogouttext();
	  log.info("Validating login");
	  Assert.assertTrue(logout.contains(logout));
	  log.info("Login successful");
	  
  }
  @Test(dataProvider="InValidexcelData",dataProviderClass=DPExcel.class)
  public void loginInvalid(String username,String password) {
	  objLogin= new Loginpage(driver1); 
	  log.info("Login Action");
	  String logout=objLogin.getLogouttext();
	  log.info("Validating login");
	  WebDriverWait wait=new WebDriverWait(driver1,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert=driver1.switchTo().alert();
	  String msg=alert.getText();
	  Assert.assertEquals(msg,"User does not exist.");
	 log.info ("InvalidLogin successful");
	  
  }
  
}
