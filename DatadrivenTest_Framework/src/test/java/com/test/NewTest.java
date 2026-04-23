package com.test;

import org.testng.annotations.Test;


import com.utilities.Test_1;


	

	import java.time.Duration;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	

	public class NewTest {

		private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

		@BeforeMethod
		public void setup() {
		    System.out.println("Start the test");
		    WebDriver driver1 = new ChromeDriver();
		    driver.set(driver1);
		    driver1.get("https://www.demoblaze.com/");
		    driver1.manage().window().maximize();
		}



		@Test(dataProvider="Valid", dataProviderClass=Test_1.class)
		public void valid(String name, String password) {
			WebDriver driver1 = driver.get();
			driver1.findElement(By.id("login2")).click();
			WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
			driver1.findElement(By.id("loginpassword")).sendKeys(password);
			driver1.findElement(By.xpath("//button[text()='Log in']")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id=\"nameofuser\"]")));
			String actual = driver1.findElement(By.xpath("//a[@id=\"nameofuser\"]")).getText();
			System.out.println(actual);
			Assert.assertEquals(actual, "Welcome Admin@5", "Login not successful");
		}

		@Test(dataProvider="Invalid", dataProviderClass=Test_1.class)
		public void Invalid1(String name, String password) {
			WebDriver driver1 = driver.get();
			driver1.findElement(By.id("login2")).click();

			WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
			driver1.findElement(By.id("loginpassword")).sendKeys(password);
			driver1.findElement(By.xpath("//button[text()='Log in']")).click();
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver1.switchTo().alert();
			alert.accept();
			System.out.println("Invalid 1 run successful!");
		}
		@Test(dataProvider="Invalidpwd", dataProviderClass=Test_1.class)
		public void Invalid(String name, String password) {
			WebDriver driver1 = driver.get();
			driver1.findElement(By.id("login2")).click();

			WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
			driver1.findElement(By.id("loginpassword")).sendKeys(password);
			driver1.findElement(By.xpath("//button[text()='Log in']")).click();
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver1.switchTo().alert();
			String msg=alert.getText();
			Assert.assertEquals(msg, "Wrong password.");
			alert.accept();
			System.out.println("Invalid 1 run successful!");
		}
		@AfterMethod
		public void tearDown() {
			WebDriver driver1 = driver.get();
			if (driver1 != null)
				driver1.quit();
		}

	}