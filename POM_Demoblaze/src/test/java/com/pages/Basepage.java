package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Basepage {
	public  WebDriver driver;
	//WebDriverWait wait;
	
	public Basepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	//	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	/*public void elementvisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}*/
	
 
}
