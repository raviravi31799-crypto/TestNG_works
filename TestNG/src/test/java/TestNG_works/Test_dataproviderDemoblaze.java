package TestNG_works;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Test_dataproviderDemoblaze {
	WebDriver driver;
  @Test(dataProvider = "Login")
  public void f( String username,String password) {
	 driver.findElement(By.id("login2")).click();
		driver.findElement(By.id("loginusername")).sendKeys(username);
		driver.findElement(By.id("loginpassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		String msg=message.getText();
		String msg1="Welcome Admin@5";
		Assert.assertEquals(msg1, msg,"Login successful");
		System.out.println("Login successful");
	  
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
      new Object[] {  "Admin@5","12345" }
     };
  }
}
