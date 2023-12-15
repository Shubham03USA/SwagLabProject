package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utilities.Capture_Screenshot;
import Utilities.ReadData;

public class LoginTestPage extends TestBase
{
	LoginPage login;
	
	@BeforeMethod (alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
		
	}
	
	// KeyWords => 1)Priority,2)enable,3)dependsOnMethod,4)Groups
	
	// {enabled} is an keyword and it is used to run specific test case if we use [enabled = true];
	// if we use [enabled = false] then it will not run that specific test case	
	// {dependsOnMethod} is a keyword , which is used for depend on other method or group 
	
	//@Test(enabled = true, groups = {"regression"})/*(priority = 1,dependsOnMethods = "verifyURLofApplication")*/
	
	@Test(enabled =  true)
	public void verifyTitleofApplication() throws EncryptedDocumentException, IOException
	{
		String expTitle = ReadData.readExcel(0, 0); // Swag Labs(0,0)  
		String actTitle = login.verifyTitleofApplication();
		Assert.assertEquals(expTitle,actTitle);
	}
	
	
	//@Test(enabled = true,groups = {"sanity"})//(priority = 3,enabled = true,groups = "reset")
	
	@Test(enabled = true)
	public void verifyURLofApplication() throws EncryptedDocumentException, IOException
	{
		String expURL = ReadData.readExcel(0, 1); // (0,1) // here we want to fail these test case and then check the dependsOnMethods 
		String actURL = login.verifyURLofApplication();
		Assert.assertEquals(expURL, actURL);
	}
	
	//@Test(enabled = true,groups = {"reset","sanity"})//(priority = 2,enabled = true)
	@Test (enabled = true)
	public void loginToApplication() throws IOException
	{
		String expURL = ReadData.readExcel(0, 2); //(0,2) 
		String actURL = login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
	}
	
		
	@AfterMethod(alwaysRun = true)
	public void CloseBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Capture_Screenshot.screenshot(it.getName());
			
		}
		report.flush();
		driver.close();
	}
	
	

}
