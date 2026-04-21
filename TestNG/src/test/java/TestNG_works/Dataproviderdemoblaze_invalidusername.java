package TestNG_works;

import org.testng.annotations.Test;
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
import org.testng.annotations.DataProvider;

public class Dataproviderdemoblaze_invalidusername {
	WebDriver driver;

	 @Test(dataProvider = "Login")
	  public void f( String username,String password) {
		 driver.findElement(By.id("login2")).click();
			driver.findElement(By.id("loginusername")).sendKeys(username);
			driver.findElement(By.id("loginpassword")).sendKeys(password);
			driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			String msg=alert.getText();
			String msg1="User does not exist.";
			alert.accept();
			Assert.assertEquals(msg1, msg,"Login failed");
	 }
	 
	 @Test(dataProvider = "Login")
	  public void invalidpassword( String username,String password) {
		 driver.findElement(By.id("login2")).click();
			driver.findElement(By.id("loginusername")).sendKeys(username);
			driver.findElement(By.id("loginpassword")).sendKeys(password);
			driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			String msg=alert.getText();
			String msg1="Wrong password.";
			alert.accept();
			Assert.assertEquals(msg1, msg,"Login failed");
			}
	 
			  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Start the test");
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.get("https://demoblaze.com/");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("End the test");
  }


  @DataProvider(name="Login")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admi12" ,"12345" },
     
      
      
    };
  }
}
