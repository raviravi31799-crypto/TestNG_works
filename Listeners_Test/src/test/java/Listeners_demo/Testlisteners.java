package Listeners_demo;
import org.testng.annotations.Test;




import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
	
	
	@Listeners(listeners_fail.class)
	
	public class Testlisteners {
		   public static Logger log=LogManager.getLogger(Testlisteners.class);
	       public WebDriver driver;
	       
		    @BeforeMethod
		    public void beforeTest() {
		    	log.info("Browser is launching tutorialsninja");
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        driver.get("https://tutorialsninja.com/demo/index.php");
		    }
		   
		    @Test
		    public void loginTest() {
		    	log.info("Login");
		        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		        driver.findElement(By.id("input-email")).sendKeys("joshitha@gamil.com");
		        driver.findElement(By.id("input-password")).sendKeys("123");
		        driver.findElement(By.xpath("//input[@value='Login']")).click();

		        String title = driver.getTitle();
		        Assert.assertTrue(title.contains("Account"));
		    }

		    @AfterMethod
		    public void afterTest() {
		    	log.info("Closing browser");
		        if (driver != null) {
		            driver.quit();
		        }
		    }
		}