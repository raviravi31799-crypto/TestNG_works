package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Loginpage extends Basepage {
	public  Loginpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id="login2")
	public WebElement login;
	@FindBy(id="loginusername")
	public WebElement Username;
	@FindBy(id="loginpassword")
	public WebElement Password;
	@FindBy(xpath="//button[@onclick='logIn()']")
	public WebElement loginbtn;
	@FindBy (id="login2")
	public WebElement logouttext;
	
	
	
	public void Loginpage(String username,String password ) {
	    login.click();
	    //elementvisible(Username);
		Username.sendKeys(username);
		//elementvisible(Password);
		Password.sendKeys(password);
		loginbtn.click();
		
		
	}
	public String getLogouttext() {
		return logouttext.getText();
		
	}
 
}
