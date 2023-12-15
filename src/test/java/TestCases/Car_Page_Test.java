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
import Pages.Cart_Page;
import Pages.LoginPage;
import Utilities.Capture_Screenshot;
import Utilities.ReadData;

public class Car_Page_Test extends TestBase
{
	// here we created page object globally
		LoginPage login;
		Inventory_Page invent;
		Cart_Page cp;
		
		@BeforeMethod
		public void setup() throws InterruptedException, IOException
		{
			initialization();
			login = new LoginPage();
			invent = new Inventory_Page();
			cp = new Cart_Page();
			login.loginToApplication();
			invent.add6product();
			invent.ClickcartCount();
		}
		
		@Test
		public void verifyURLOfTheApplication() throws EncryptedDocumentException, IOException
		{
			String expURL = ReadData.readExcel(0, 6);  //https://www.saucedemo.com/cart.html
			String actURl = cp.verifyCartPageURL();
			Assert.assertEquals(expURL,actURl);
			Reporter.log("URL of the Page = "+actURl);
		}
		
		@Test
		public void verifyLableCartPageTest() throws EncryptedDocumentException, IOException
		{
			String expLable = ReadData.readExcel(0, 7); //Your Cart
			String actLable = cp.verifyCartLable();
			Assert.assertEquals(expLable, actLable);
			Reporter.log(" Lable of the Cart Page = " + actLable);
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
