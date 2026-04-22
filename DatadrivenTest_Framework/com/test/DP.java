package com.test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP {
	 @DataProvider(name="exceldata",parallel=true)
		public Object[][] excelDataProvider() throws IOException{
			String[][] arrObj=Test_1.getExcelData("C:\\Selenium Basics\\DatadrivenTest_Framework\\src\\test\\resources\\dataset.xlsx","Sheet1");
			return arrObj;
		}
}
