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
import Pages.CheckOutPage_1;
import Pages.LoginPage;
import Utilities.Capture_Screenshot;
import Utilities.ReadData;

public class CheckOutPage_1_Test extends TestBase 
{
	// here we created page object globally
	
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cp;
	CheckOutPage_1 check1;

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
		cp.clickOnCheckOutBtn();
		check1 = new CheckOutPage_1();
	}

	@Test
	public void verifyURLCheckOutPage1Test() throws EncryptedDocumentException, IOException
	{
		String expURL ="https://www.saucedemo.com/checkout-step-one.html";
		String actURL = check1.verifyURLOfCheckOutPage1();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Checkout Page 1 Url is = "+actURL);
	}
	
	@Test
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle ="Checkout: Your Information";//ReadData.readExcel(0,9);
		String actTitle = check1.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of the checkout Page = "+actTitle);
	}
	
	@Test
	public void inputInformationTest() throws EncryptedDocumentException, IOException
	{
		String expURL = "https://www.saucedemo.com/checkout-step-two.html";//ReadData.readExcel(0,10);
		String actURL = check1.inputInformation();
		Assert.assertEquals(actURL, expURL);
		Reporter.log("URL of the Checkout page 2 = "+actURL);
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
