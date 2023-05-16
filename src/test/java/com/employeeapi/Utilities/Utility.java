/**
 * 
 */
package com.employeeapi.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * @author Disha Dabhi
 *
 */
public class Utility 
{
	public static String empName() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Jena" + generatedString);
	}

	public static String empSal() 
	{
		String generatedString = RandomStringUtils.randomNumeric(5);
		return (generatedString);
	}
	
	public static String empAge() 
	{
		String generatedString = RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}

	public static void captureScreenshot (WebDriver driver , String Testid) throws IOException
	{
		SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy hh-mm-ss");
		Date date = new Date ();
		String result = formatter.format(date);
		System.out.println(result);
	 
		TakesScreenshot t = (TakesScreenshot) driver ;
		File source = t.getScreenshotAs(OutputType.FILE);
		
	    File dest = new File("test-output\\Screenshot\\Test-" + Testid + " " + result + ".jpeg");
		FileHandler.copy(source, dest);
		
	}
	
	
}
