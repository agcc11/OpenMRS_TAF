package com.vstl.generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;


public class TestUtils {

	public void loggerReport(boolean action, String strmsg) {
		if (action) {
			Assert.assertTrue(true, strmsg);
		} else {
			this.captureScreenshot("failedtestcase");
			Assert.assertTrue(false, strmsg);
		}
	}
	
	public void captureScreenshot(String strFilename)
	{	
		try{
			File source = ((TakesScreenshot)Pojo.getDriver()).getScreenshotAs(OutputType.FILE);
			File dest=new File(System.getProperty("user.dir")+"/src/test/resources/external resources/screenshots/"+strFilename+TimeStamp()+".png");
			FileUtils.copyFile(source, dest);
			System.out.println("Screenshot Captured ");
	      
		}catch(Exception e){
			System.out.println("Screenshot not Captured and Expection is:  "+e.getMessage());
			e.printStackTrace();
		
		}
	}
	
	public static String TimeStamp()
	{
	String t=new SimpleDateFormat("MMM dd HH.mm.ss").format(Calendar.getInstance().getTime());
	return t;

	}
}
