package com.test;

import org.testng.annotations.Test;


import com.utilities.Test_1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;
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

public class NewTest {
	WebDriver driver1;
	private static final ThreadLocal <WebDriver> driver=new ThreadLocal <WebDriver>();
	 @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Start the test");
		  driver1=new ChromeDriver();
         driver.set(driver1);
		  
		  driver1.get("https://demoblaze.com/");
		  driver1.manage().window().maximize();
	  }
	
		
		@Test(dataProvider="Valid",dataProviderClass=Test_1.class)
	  public void f( String username,String password) {
			
		 driver1.findElement(By.id("login2")).click();
			driver1.findElement(By.id("loginusername")).sendKeys(username);
			driver1.findElement(By.id("loginpassword")).sendKeys(password);
			driver1.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			WebDriverWait wait=new WebDriverWait(driver1,Duration.ofSeconds(15));
			WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
			String msg=message.getText();
			String msg1="Welcome Admin@5";
			Assert.assertEquals(msg1, msg,"Login successful");
		
		  
	  }
		@Test(dataProvider="Invalid",dataProviderClass=Test_1.class)//@Test(dataProvider="excelData",dataProviderClass=Test_1.class,indices{0})
		 public void invalidusername( String username,String password) {
			  driver1.findElement(By.id("login2")).click();
			driver1.findElement(By.id("loginusername")).sendKeys(username);
			driver1.findElement(By.id("loginpassword")).sendKeys(password);
			driver1.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			WebDriverWait wait=new WebDriverWait(driver1,Duration.ofSeconds(15));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver1.switchTo().alert();
			String msg=alert.getText();
			String msg1="User does not exist.";
			alert.accept();
			Assert.assertEquals(msg1, msg,"Login failed");
			}
		@Test(dataProvider="Invalid",dataProviderClass=Test_1.class)
		  public void invalidpassword(String username,String password) {
			  driver1.findElement(By.id("login2")).click();
			driver1.findElement(By.id("loginusername")).sendKeys(username);
			driver1.findElement(By.id("loginpassword")).sendKeys(password);
			driver1.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			WebDriverWait wait=new WebDriverWait(driver1,Duration.ofSeconds(15));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver1.switchTo().alert();
			String msg=alert.getText();
			String msg1="Wrong password.";
			alert.accept();
			Assert.assertEquals(msg1, msg,"Login failed");
			}
		 
	  
	

	  @AfterMethod
	  public void afterMethod() {
		  if(driver1!=null) {
		  driver1.quit();
		  }
		  System.out.println("End the test");
	  }
	 
	}
	
	

	
