package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckOutPage_2 extends TestBase
{
	@FindBy(xpath = "//span[@class='title']")private WebElement checkOutpage2lable;
	@FindBy(xpath = "//button[@name='finish']")private WebElement finishBtn;
	@FindBy(xpath = "//button[@name='cancel']")private WebElement cancelBtn;
	
	public CheckOutPage_2()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLable()
	{
		return checkOutpage2lable.getText();
	}
	
	public String clickOnFinishBtn()
	{
		 finishBtn.click();
		 return driver.getCurrentUrl();
	}

}
