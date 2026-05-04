package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Dashboardpage {
	WebDriver driver;
	By dashboardtitle=By.xpath("//h6[normalize-space()='Dashboard']");
			public Dashboardpage(WebDriver driver) {
		this.driver=driver;
	}
  public String getHomePageText() {
	  return driver.findElement(dashboardtitle).getText();
  }
}
