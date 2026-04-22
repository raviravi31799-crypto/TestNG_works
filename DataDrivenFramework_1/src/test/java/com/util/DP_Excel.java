package com.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP_Excel {
	
		
		@DataProvider(name="ValidexcelData",parallel = true)
		public Object[][] ValidexcelDataProvider() throws IOException{
			Object[][] arrObj = getExcelData("C:\\Selenium Basics\\DataDrivenFramework_1\\src\\test\\resources\\data.xlsx","Sheet1");
			return new Object[][] { arrObj[0]};
		}
		
	/*	@DataProvider(name="InValidexcelData",parallel = true)
		public Object[][] InvalidexcelDataProvider() throws IOException{
			Object[][] arrObj = getExcelData("C:\\Selenium Basics\\DataDrivenFramework_1\\src\\test\\resources\\data.xlsx","Sheet1");
			return new Object[][] { arrObj[1],arrObj[2]};
		}*/

		
		public String[][] getExcelData(String fileName,String sheetName) throws IOException{
			String [][] data=null;
			
		
		try {
			FileInputStream file=new FileInputStream(fileName);
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet =workbook.getSheet(sheetName);
			XSSFRow row=sheet.getRow(0);
			int noOfRows=sheet.getPhysicalNumberOfRows();
			int noOfColumns=row.getLastCellNum();
			Cell cell;
			data=new String[noOfRows -1][noOfColumns];
			
			for(int i=1;i<noOfRows;i++) {
				for(int j=0;j<noOfColumns;j++) {
					row=sheet.getRow(i);
					cell=row.getCell(j);
					data[i-1][j]=cell.getStringCellValue();
				}
			}
		}
		catch(Exception e) {
			System.out.println("The Exception is:"+e.getMessage());
		}
	    return data;
			
		}

  @Test
  public void f() {
  }
}
