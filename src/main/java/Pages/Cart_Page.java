package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class Cart_Page extends TestBase
{
	
	@FindBy(xpath = "//span[text()='Your Cart']")private WebElement lable;
	@FindBy(xpath = "//button[@name='checkout']")private WebElement checkOutButton;
	
	public Cart_Page()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyCartPageURL()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyCartLable()
	{
		return lable.getText();
		
	}
	public void clickOnCheckOutBtn()
	{
		checkOutButton.click();
	}
	

}
