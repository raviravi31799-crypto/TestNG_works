package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

public class loginpage {
	WebDriver driver;
	By username = By.xpath("//input[@placeholder=\\\"Username\\\"]");
	By password = By.name("//input[@placeholder=\\\"Password\\\"]");
	By login = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
	By titleText = By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");
	
public loginpage(WebDriver driver) {
	this.driver=driver;
}
public void setUsername(String username) {
	driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
	}
public void setPassword(String password) {
	driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
	
}
public void clicklogin() {
	driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
}
public String getLogintext() {
	return driver.findElement(titleText).getText();
}
public void login(String username,String password) {
	this.setUsername(username);
	this.setPassword(password);
	this.clicklogin();
}

  
}
//To remove or avoid warning ---allow all origins
