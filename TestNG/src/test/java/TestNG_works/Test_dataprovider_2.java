package TestNG_works;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Test_dataprovider_2 {
	WebDriver driver;
 
    @Test(dataProvider = "testData", dataProviderClass=DP_class3.class)
	  public void f( String keyword) {
		  WebElement txtbox=driver.findElement(By.id("sb_form_q"));
		  txtbox.sendKeys(keyword);
		  System.out.println("Keyword entered is:"+keyword);
		  txtbox.sendKeys(Keys.ENTER);
		  System.out.println("Search result is displayed");
	  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Start the test");
	  driver=new ChromeDriver();
	  driver.get("https://bing.com");
	  driver.manage().window().maximize();
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("End the test");
  }

  }

