package com.test;

import org.testng.annotations.Test;

import com.util.DP_Excel;


import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Test_ninjatutorial {
	WebDriver driver;
	private static final ThreadLocal <WebDriver> driver1=new ThreadLocal <WebDriver>();
	
		
		@Test(dataProvider="ValidexcelData",dataProviderClass=DP_Excel.class)
	  public void f( String username,String password) {
			
		 driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		 driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li[2]")).click();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
			driver.findElement(By.xpath("//input[@value='Login']]")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li[5]")));
			String msg=message.getText();
			String msg1="Logout";
			Assert.assertEquals(msg1, msg,"Login successful");
		
		  
	  }
		/*@Test(dataProvider="InValidexcelData",dataProviderClass=DP_Excel.class)//@Test(dataProvider="excelData",dataProviderClass=Test_1.class,indices{0})
		 public void invalidusername( String username,String password) {
			driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
			 driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li[2]")).click();
				driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
				driver.findElement(By.xpath("//input[@value='Login']]")).click();
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			   wait.until(ExpectedConditions.alertIsPresent());
			   Alert alert=driver.switchTo().alert();
			  String msg=alert.getText();
			  String msg1="Warning: No match for E-Mail Address and/or Password.";
			  alert.accept();
			  Assert.assertEquals(msg1, msg,"Login failed");
			}
	/*	@Test(dataProvider="excelData",dataProviderClass=DP_Excel.class)
		  public void invalidpassword(String username,String password) {
			  driver.findElement(By.id("login2")).click();
			driver.findElement(By.id("loginusername")).sendKeys("Admin@5");
			driver.findElement(By.id("loginpassword")).sendKeys("1234567");
			driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			String msg=alert.getText();
			String msg1="Wrong password.";
			alert.accept();
			Assert.assertEquals(msg1, msg,"Login failed");
			}
		 
	  */
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Start the test");
		  driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get("https://tutorialsninja.com/demo/");
		  driver.manage().window().maximize();
	  }

	  @AfterMethod
	  public void afterMethod() {
		  if(driver!=null) {
			  driver.quit();
		  }
		  System.out.println("End the test");
	  }
	 
	}
	
	

	
