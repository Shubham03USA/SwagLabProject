package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Inventory_Page;
import Base.TestBase;
import Pages.Cart_Page;
import Pages.CheckOutPage_1;
import Pages.CheckOutPage_2;
import Pages.LoginPage;
import Utilities.Capture_Screenshot;

public class CheckOutPage_2_Test extends TestBase
{
	// here we created page object globally
	
		LoginPage login;
		Inventory_Page invent;
		Cart_Page cp;
		CheckOutPage_1 check1;
		CheckOutPage_2 check2;

		@BeforeMethod
		public void setup() throws InterruptedException, IOException
		{
			initialization();
			login = new LoginPage();
			invent = new Inventory_Page();
			cp = new Cart_Page();
			check1 = new CheckOutPage_1();
			check2 = new CheckOutPage_2();
			login.loginToApplication();
			invent.add6product();
			invent.ClickcartCount();
			cp.clickOnCheckOutBtn();
			check1.inputInformation();
		}
		
		@Test
		
		public void verifyLableTest()
		{
			String expLable = "Checkout: Overview";
			String actLable =  check2.verifyLable();
			Assert.assertEquals(actLable, expLable);
			Reporter.log("Lable of check out page 2 = "+actLable);
		}
		
		@Test
		
		public void clickOnFinishBtnTest()
		{
			String expURL = "https://www.saucedemo.com/checkout-complete.html";
			String actURL =  check2.clickOnFinishBtn();
			Assert.assertEquals(expURL,actURL);
			Reporter.log("Url of the complete page = "+actURL);
		}
		
		
		// This code is specially designed for ScreenShot

		@AfterMethod(alwaysRun = true)
		public void CloseBrowser(ITestResult it) throws IOException {
			if (it.FAILURE == it.getStatus()) {
				Capture_Screenshot.screenshot(it.getName());

			}
			driver.close();
		}



}
