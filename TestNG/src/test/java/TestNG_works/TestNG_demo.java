package TestNG_works;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

  
public class TestNG_demo {
	WebDriver driver;
  @Test
  public void validation() {
	  driver.findElement(By.id("login2")).click();
	driver.findElement(By.id("loginusername")).sendKeys("Admin@5");
	driver.findElement(By.id("loginpassword")).sendKeys("12345");
	driver.findElement(By.xpath("//button[@onclick='logIn()']"));
  }
  @BeforeTest
  public void beforeTest() {
	  ChromeOptions options=new ChromeOptions();
	  options.addArguments("---start-maximized--");
	  options.addArguments("--headless");//non-GUI mode
	  driver = new ChromeDriver(options);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.get("https://demoblaze.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
