package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Categoriespage extends Basepage {
	public Categoriespage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id="cat")
	public WebElement categories;
	public String getcategoriestext() {
	//	elementvisible(categories);
		return categories.getText();
	}
  
}
