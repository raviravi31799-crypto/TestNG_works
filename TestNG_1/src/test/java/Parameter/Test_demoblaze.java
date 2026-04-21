package Parameter;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;

public class Test_demoblaze {
	 
		
		@DataProvider(name="testData")
		public Object[][] dataprovfunc(){
			return new Object[][] {{"Admin@5","12345"},{"Admi12","12345"},{"Admin@5","1234567"}};
		}
		public WebDriver driver;
		  @BeforeMethod
		  @Parameters({"browser","url"})
		  public void beforeTest(String browser,String url) {
			  if(browser.equalsIgnoreCase("chrome")) {
				  ChromeOptions options=new ChromeOptions();
				  options.addArguments("---start-maximized--");
				  options.addArguments("--headless");
				  driver = new ChromeDriver(options);
				  System.out.println("Browser started: "+browser);
			  }
			  else if (browser.equalsIgnoreCase("firefox")) {
				  FirefoxOptions options=new FirefoxOptions();
				  options.addArguments("---start-maximized--");
				  options.addArguments("--headless");
				  driver = new FirefoxDriver(options);
			  }
			
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			  driver.get(url);
		  }

		 @Test(dataProvider="testData")
			public void validation(String username,String password) {
				  driver.findElement(By.id("login2")).click();
				driver.findElement(By.id("loginusername")).sendKeys(username);
				driver.findElement(By.id("loginpassword")).sendKeys(password);
				driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
				 System.out.println("login successful");
				
				
				}
			  @Test (dataProvider="testData")
			  public void invalidusername(String invalidusername,String password) {
				  driver.findElement(By.id("login2")).click();
				driver.findElement(By.id("loginusername")).sendKeys(invalidusername);
				driver.findElement(By.id("loginpassword")).sendKeys(password);
				driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
				
				}
			  		  
			
			  @AfterMethod
			  public void afterTest() {
				  driver.quit();
			  }
	}