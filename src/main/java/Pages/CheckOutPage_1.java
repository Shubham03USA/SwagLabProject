package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckOutPage_1 extends TestBase
{
	// Object Rep
	
	@FindBy(xpath = "//span[@class='title']")private WebElement titleOfCheckOutPage;
    @FindBy(xpath = "//input[@name='firstName']")private WebElement FirstNameTextBox;
    @FindBy(xpath = "//input[@name='lastName']")private WebElement LastNameTextBox;
    @FindBy(xpath = "//input[@name='postalCode']")private WebElement ZipCodeTextBox;
    @FindBy(xpath = "//input[@name='continue']")private WebElement ContinueBtn;
   // @FindBy(xpath = "//button[@name='cancel']")private WebElement Cancelbtn;
    
    public CheckOutPage_1()
    {
    	PageFactory.initElements(driver, this);
    }
    
    public String verifyURLOfCheckOutPage1()
    {
    	return driver.getCurrentUrl();
    }
    
    public String verifyTitleOfApplication()
    {
    	return titleOfCheckOutPage.getText();
    }
    
    public String inputInformation()
    {
    	FirstNameTextBox.sendKeys("Mohan");
    	LastNameTextBox.sendKeys("Jain");
    	ZipCodeTextBox.sendKeys("112412");
    	ContinueBtn.click();
    	return driver.getCurrentUrl();
    }

}
