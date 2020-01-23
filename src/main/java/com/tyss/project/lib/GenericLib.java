package com.tyss.project.lib;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

//import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.tyss.project.init.IConstants;

public class GenericLib {
	
	/*
	 * @Author:Srinidhi R.V
	 * 
	 * Description: To read the data from the Excelsheet 
	 * 
	 */
	
	public static String getExecelData(String sheet,int row,int col)
	{
		String data=null;
		try
		{
			FileInputStream fin = new FileInputStream(IConstants.EfilePath);
			Workbook workbook = WorkbookFactory.create(fin);
			Sheet sht = workbook.getSheet(sheet);
			Cell cl = sht.getRow(row).getCell(col);
			
			data=cl.getStringCellValue();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;	
	}
	
	/*
	 * @Author:Srinidhi R.V
	 * 
	 * Description: To read the data from the Properties file 
	 * 
	 */

	public static String getPropData(String key)
	{
		String data = null;
		try
		{
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(IConstants.PfilePath);
		prop.load(fin);
		data=prop.getProperty(key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/*
	 * @Author:Srinidhi R.V
	 * 
	 * Description: To take the screenshot of the browser 
	 * 
	 */
	
	public static void takeScreenShot(WebDriver driver,String name)
	{
		try
		{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		Reporter.log("Taking ScreenShot of "+name);
		File desc = new File(IConstants.screenShotPath+name+".png");
		FileUtils.copyFile(src, desc);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * @Author:Srinidhi R.V
	 * 
	 * Description: To read the expected Result from the Excel file 
	 * 
	 */
	
	public static String getExpected(String sheet,int row,int col)
	{
		String data = getExecelData(sheet,row,col);
		String[] eData = data.split("-");
		return eData[0];
		
	}
}
