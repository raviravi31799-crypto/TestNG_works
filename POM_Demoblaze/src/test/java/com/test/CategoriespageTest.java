package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.Categoriespage;
import com.pages.Loginpage;
import com.util.DPExcel;

public class CategoriespageTest extends BaseTest {
	Loginpage objLogin;
	Categoriespage objcategory;
	public static Logger log =LogManager.getLogger(CategoriespageTest.class);
  
	@Test(priority=0,dataProvider="ValidexcelData",dataProviderClass=DPExcel.class)
 
  public void categories(String username ,String password) {
	  objLogin=new Loginpage(driver1);
	  objLogin.Loginpage(username,password);
	  log.info("Object of category page");
	  objcategory=new Categoriespage(driver1);
	  String text=objcategory.getcategoriestext();
	  log.info("Validating category page visibility");
	  Assert.assertTrue(text.contains(text));
	  log.info("Categories are visible");
  }
}
