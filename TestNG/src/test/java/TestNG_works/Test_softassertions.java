package TestNG_works;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

  
public class Test_softassertions {
	WebDriver driver;
	SoftAssert sa =new SoftAssert();
  @Test
  public void validation() {
	  driver.findElement(By.id("login2")).click();
	driver.findElement(By.id("loginusername")).sendKeys("Admin@5");
	driver.findElement(By.id("loginpassword")).sendKeys("12345");
	driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
	String msg=message.getText();
	String msg1="Welcome Admin@5";
	sa.assertEquals(msg1, msg,"Login successful");
	
	}
  @Test
  public void invalidusername() {
	  driver.findElement(By.id("login2")).click();
	driver.findElement(By.id("loginusername")).sendKeys("Admi12");
	driver.findElement(By.id("loginpassword")).sendKeys("12345");
	driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.alertIsPresent());
	Alert alert=driver.switchTo().alert();
	String msg=alert.getText();
	String msg1="User does not exist.";
	alert.accept();
	sa.assertEquals(msg1, msg,"Login failed");
	
	}
  @Test
  public void invalidpassword() {
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
	sa.assertEquals(msg1, msg,"Login failed");
	
	}
 
  
  @BeforeMethod
  public void beforeTest() {
	  ChromeOptions options=new ChromeOptions();
	  options.addArguments("---start-maximized--");
	  options.addArguments("--headless");//non-GUI mode
	  driver = new ChromeDriver(options);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.get("https://demoblaze.com/");
  }

  @AfterMethod
  public void afterTest() {
	  driver.quit();
  }

}
