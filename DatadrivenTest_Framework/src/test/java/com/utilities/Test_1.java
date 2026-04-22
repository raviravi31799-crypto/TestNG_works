package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Test_1 {
	
	

	
		
		@DataProvider(name="Valid",parallel=true)
		public Object[][] excelDataprovider1() throws IOException{
			Object[][] arrobj=getExcelData("src\\test\\resources\\dataset.xlsx","Sheet1");
			return new Object[][] {
			arrobj[0]
			};
		}

		@DataProvider(name="Invalid",parallel=true)
		public Object[][] excelDataprovider2() throws IOException{
			Object[][] arrobj=getExcelData("src\\test\\resources\\dataset.xlsx","Sheet1");
			return new Object[][] {
			arrobj[1],
			arrobj[2]
			};
		}
		
		public String[][] getExcelData(String fileName,String sheetName) throws IOException{
			String[][] data=null;
			try {
				FileInputStream fis=new FileInputStream(fileName);
				XSSFWorkbook workbook=new XSSFWorkbook(fis);
				XSSFSheet sheet=workbook.getSheet(sheetName);
				XSSFRow row=sheet.getRow(0);
				int noOfRows=sheet.getPhysicalNumberOfRows();
				int noOfCloms=row.getLastCellNum();
				Cell cell;
				data = new String[noOfRows -1][noOfCloms];
				
				for(int i=1;i<noOfRows;i++) {
					for(int j=0;j<noOfCloms;j++) {
						row = sheet.getRow(i);
						cell=row.getCell(j);
						DataFormatter formatter = new DataFormatter();
						String value = formatter.formatCellValue(cell);
						data[i-1][j]=value;				}
				}
			}
			catch (Exception e){
				System.out.println("The exception is:"+e.getMessage());
			}
			return data;
		}

	}