package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Inventory_Page;
import Base.TestBase;
import Pages.LoginPage;
import Utilities.Capture_Screenshot;
import Utilities.ReadData;

public class Inventory_Page_Test extends TestBase
{
	
	// here we created page object globally
	LoginPage login;
	Inventory_Page invent;
	
	@BeforeMethod(alwaysRun =  true)
	
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
		invent = new Inventory_Page();
		login.loginToApplication();
	}
	
	@Test(enabled = true,groups = {"retest"})
	public void verifyproductLableTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String explable = ReadData.readExcel(0, 3); //(0,3)
		String actlable = invent.verifyproductLable();
		Assert.assertEquals(explable, actlable);
		Reporter.log("Lable of Invetory Page = "+actlable);
		Thread.sleep(3000);
	}
	
	@Test(enabled = true,groups = {"regression"})
	public void verifyTwitterLogoTest() throws InterruptedException
	{
		boolean result = invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of the twitter Logo = "+result);
		Thread.sleep(3000);
	}
	
	@Test(enabled = true,groups = {"reset","sanity"})
	
	public void add6productTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount = ReadData.readExcel(0, 4); // (0,4)
		String actCount = invent.add6product();
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Total product added to cart = "+actCount);
		Thread.sleep(3000);
	}
	
	@Test(enabled = true,groups = {"reset","sanity"})
	
	public void remove2ProductTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount = ReadData.readExcel(0, 5); // (0,5)
		String actCount = invent.removing2Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count of product after removing = "+actCount);
		Thread.sleep(3000);
	}
	
	
	// This code is specially designed for ScreenShot
	
	@AfterMethod(alwaysRun = true)
	public void CloseBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Capture_Screenshot.screenshot(it.getName());
			
		}
		driver.close();
	}

	

}
