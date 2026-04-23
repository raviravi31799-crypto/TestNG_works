package com.test;

import org.testng.annotations.Test;

import com.util.DP_Excel;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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
	
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Start the test");
		  driver=new ChromeDriver();
		  driver1.set(driver);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get("https://tutorialsninja.com/demo/");
		  driver.manage().window().maximize();
	  }
	
		
		@Test(dataProvider="ValidexcelData",dataProviderClass=DP_Excel.class)
	  public void f( String username,String password) {
			
		 driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		 driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li[2]")).click();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			 driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
			WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[5]/a")));
			String msg=message.getText();
			String msg1="Logout";
			Assert.assertEquals(msg1, msg,"Login successful");
			System.out.println("Login successful");
		
		    }
		@Test(dataProvider="InValidexcelData",dataProviderClass=DP_Excel.class)//@Test(dataProvider="excelData",dataProviderClass=Test_1.class,indices{0})
		 public void invalidusername( String username,String password) {
			driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
			 driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li[2]")).click();
				driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
				driver.findElement(By.xpath("//input[@value='Login']")).click();
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			   WebElement warning=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
			   String msg=warning.getText();
		       String msg1="Warning: No match for E-Mail Address and/or Password.";
			  Assert.assertEquals(msg1, msg,"Login failed");
			  System.out.println(" Invalid Login successful");
			}
	@Test(dataProvider="InValidexcelData1",dataProviderClass=DP_Excel.class)
		  public void invalidpassword(String username,String password) {
			  driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
			 driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li[2]")).click();
				driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
				driver.findElement(By.xpath("//input[@value='Login']")).click();
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			  
			   WebElement warning=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
			   String msg=warning.getText();
		       String msg1="Warning: No match for E-Mail Address and/or Password.";
			  Assert.assertEquals(msg1, msg,"Login failed");
			  System.out.println(" Invalid Login_1 successful");
			}
	
	@Test
	@Parameters("keyword")
	public void search(String keyword) {
		driver.findElement(By.xpath("//input[@class='form-control input-lg']")).sendKeys(keyword);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement product=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='iMac']")));
        if(product.getText().contains(keyword)) {
          System.out.println("Search is valid");
        }
		
	}
	@Test
	@Parameters("invalidkeyword")
	public void invalidsearch(String keyword) {
		driver.findElement(By.xpath("//input[@class='form-control input-lg']")).sendKeys(keyword);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement msg=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='button-search']/following-sibling::p")));
        msg.getText();
        Assert.assertEquals(msg, "There is no product that matches the search criteria.");
         System.out.println("Search is invalid");
        }
		
	
	
	
	 
	  @AfterMethod
	  public void afterMethod() {
		  if(driver!=null) {
			  driver.quit();
		  }
		  System.out.println("End the test");
	  }
	 
	}
	
	

	
