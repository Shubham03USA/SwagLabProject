package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.TestBase;

public class ExtentReportManager extends TestBase
{
	static ExtentReports report;
	public static ExtentReports getReportInstance()
	{
		if(report==null)
		{ 
			String reportName = new SimpleDateFormat("DD-MM-YYYY hh-mm-ss").format(new Date());
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("D:\\Eclipse_Selenium_Framework_Project\\Selenium_Framework_Project_KeyWords\\ExtentReport\\report.html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("OS","Windows");
			report.setSystemInfo("Enviroment", "SIT");
			report.setSystemInfo("Build Number", "102.02.02.126");
			report.setSystemInfo("Browser", "Chrome");
			htmlReporter.config().setDocumentTitle("UI Testing Document");
			htmlReporter.config().setReportName("UI Test Report");
			
		}
		return report;
		
	}

}
