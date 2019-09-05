package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	
	public static long PAGE_LOAD_TIMEOUT=70;
	public static long IMPLICIT_WAIT=80;
	
	public static String TEST_DATA_SHEET_PATH="D:\\jbk\\FreeCrMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\Contacts.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object [][] getTestData(String sheetName) throws Exception{
	FileInputStream file=null;
	try{
		file = new FileInputStream(TEST_DATA_SHEET_PATH);
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	try{
		book=WorkbookFactory.create(file);
		
	}catch(InvalidFormatException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}
	 sheet=book.getSheet(sheetName);
	 Object [][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 for(int i=0;i<sheet.getLastRowNum();i++)
		 for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
			 data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			 
		 }
	return data;
}
	public static void takeScreenshotAtEndOfTest() throws Exception{
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir=System.getProperty("user.dir");
		FileUtils.copyFile(srcfile, new File(currentdir +"/Screenshots/"+System.currentTimeMillis()+".png" ));
		
		
		
		
		
		
	}
}