package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages.LoginPage;
import Utilities.Capture_Screenshot;

public class VerifyMultipleCredentialsTest extends TestBase
{
	LoginPage login;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException 
	{
		initialization();
		login = new LoginPage();
	}
	
	// here we use parameterization method

	@Test(dataProvider = "credentials")
	public void LoginToApplicationWithMultipleDataTest(String un,String pass) throws IOException 
	{
		SoftAssert s = new SoftAssert();
		String expURL = "https://www.saucedemo.com/inventory.html";
		String actUrl = login.LoginToApplicationWithMultipleData(un,pass);
		s.assertEquals(expURL, actUrl);
		s.assertAll();

	}

	// here we use multiple data for login
	// Multiple set of data

	@DataProvider(name = "credentials")
	public Object[][] getData() 
	{
		return new Object[][]  // o/p => 1 pass and 3fails
	    {
			{"standard_user","secret_sauce"},  
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"}, 
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}

		};

	}

	@AfterMethod(alwaysRun = true)
	public void CloseBrowser(ITestResult it) throws IOException {
		if (it.FAILURE == it.getStatus()) {
			Capture_Screenshot.screenshot(it.getName());

		}
		driver.close();
	}

}
