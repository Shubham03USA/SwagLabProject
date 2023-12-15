package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.mongodb.diagnostics.logging.Logger;

import Base.TestBase;
import Utilities.ReadData;

public class LoginPage extends TestBase
{
	
	// Object Repository fined out by @Findby annotation
	
	@FindBy(xpath = "//input[@name='user-name']") private WebElement userTxtBox;
	@FindBy(xpath = "//input[@name='password']") private WebElement passwordTxtBox;
	@FindBy(xpath = "//input[@name='login-button']") private WebElement loginbtn;
	
	
	
	public LoginPage()
	{
		super();
		PageFactory.initElements(driver,this);
	}
	
	public String loginToApplication() throws IOException
	{
		logger = report.createTest("Login to sauce lab Appliction");
		
		userTxtBox.sendKeys(ReadData.readPropertyFile("UserName"));
		logger.log(Status.INFO,"User name is entered"); // extent report code
		
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO,"Password is entered");// extent report code
		
		loginbtn.click();;
		logger.log(Status.INFO, "Login Button is clicked");// extent report code
		logger.log(Status.PASS, "Login is successful");// extent report codes
		
		return driver.getCurrentUrl();
		
	}
	// Data set example 
	
	public String LoginToApplicationWithMultipleData(String un,String pass)
	{
		userTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pass);
		loginbtn.click();
		return driver.getCurrentUrl();
	}

	public String verifyTitleofApplication()
	{
		return driver.getTitle();
	}
	
	public String verifyURLofApplication()
	{
		return driver.getCurrentUrl();
	}

}
