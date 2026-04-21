package TestNG_works;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Test_dataprovider {
	WebDriver driver;
  @Test(dataProvider = "testData")
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


  @DataProvider(name="testData")
  public Object[][] dataProvFunc() {
    return new Object[][]{
      new Object[] { "Selenium" },
      new Object[] { "TestNG" }
    };
  }
}
