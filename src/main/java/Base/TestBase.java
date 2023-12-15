package Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReportManager;
import Utilities.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
	// these code basically for extend report only 
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	
	public static WebDriver driver;
	
	public void initialization() throws InterruptedException, IOException
	{
		String browser = ReadData.readPropertyFile("Browser");
		 
		if(browser.equals("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("FireFox"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("Edge"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(ReadData.readPropertyFile("URL"));
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
	}

}
