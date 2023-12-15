package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class Capture_Screenshot extends TestBase
{
	public static String getDate()
	{
		return new SimpleDateFormat("dd-mm-yyyy hh-mm-ss").format(new Date());
	}
	
	public static void screenshot(String nameOfMethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("D:\\Eclipse_Selenium_Framework_Project\\Selenium_Framework_Project_KeyWords\\ScreenShot\\" + nameOfMethod+"--"+getDate()+".jpeg");
		FileHandler.copy(source, destination);
		
		
	}

}
