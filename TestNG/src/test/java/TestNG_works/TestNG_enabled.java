package TestNG_works;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

  
public class TestNG_enabled{
	WebDriver driver;
  @Test
  public void validation() {
	  driver.findElement(By.id("login2")).click();
	driver.findElement(By.id("loginusername")).sendKeys("Admin@5");
	driver.findElement(By.id("loginpassword")).sendKeys("12345");
	driver.findElement(By.xpath("//button[@onclick='logIn()']"));
  }
  @Test(enabled =false)
  public void validation_1() {
	  driver.findElement(By.id("login2")).click();
	driver.findElement(By.id("loginusername")).sendKeys("Admin5");
	driver.findElement(By.id("loginpassword")).sendKeys("12345");
	driver.findElement(By.xpath("//button[@onclick='logIn()']"));
	
	
	
  }
  @Test
  public void validation_2() {
	  driver.findElement(By.id("login2")).click();
	driver.findElement(By.id("loginusername")).sendKeys("Admin@5");
	driver.findElement(By.id("loginpassword")).sendKeys("1234567");
	driver.findElement(By.xpath("//button[@onclick='logIn()']"));
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
