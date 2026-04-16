package TestNG_works;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_annotations {
	@BeforeTest
	public void Beforetest() {
		System.out.println("Before Test");
	}
	@AfterTest
	public void AfterTest() {
		System.out.println("After Test");
	}
	@BeforeMethod
	public void Beforemethod() {
		System.out.println("Before Method");
	
	}
	@AfterMethod
	public void Aftermethod() {
		System.out.println("After method");
	}
	@BeforeSuite
	public void Beforesuite() {
		System.out.println("Before suite");
	}
	@AfterSuite
	public void Aftersuite() {
		System.out.println("After suite");
	}
	@BeforeClass
	public void Beforeclass() {
		System.out.println("Before class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}
  @Test
  public void login() {
	  System.out.println("Login");
  }
  @Test
  public void logout() {
	  System.out.println("Logout");
  }
}
