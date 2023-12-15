package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utilities.Handling_Dropdown_List;

public class Inventory_Page extends TestBase
{
	// Object Repository
	
	@FindBy(xpath = "//span[@class='title']")private WebElement productLable;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement CartCount;
	
	@FindBy(xpath = "//select[@class='product_sort_container']")private WebElement dropDown;
	@FindBy(xpath = "//a[text()='Twitter']")private WebElement twitterLogo;
	
	// Added product into the cart
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")private WebElement backPackProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")private WebElement bikeLightProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement boltTShirtProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")private WebElement fleeceJacketProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")private WebElement onsieProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")private WebElement RedTshirtProduct;
	
	// Removed product from cart 
	
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")private WebElement removedbackPackProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")private WebElement removedbikeLightProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement removedboltTShirtProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement removedfleeceJacketProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']")private WebElement removedonsieProduct;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']")private WebElement removedRedTshirtProduct;
	
	// Constructor
	
	public Inventory_Page() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyproductLable()
	{
		
		return productLable.getText();
		
	}
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();//true
		
	}
	
	// Adding element in cart
	
	public String add6product() throws InterruptedException
	{
		Handling_Dropdown_List.handleSelectClass(dropDown,"Price (low to high)");
		backPackProduct.click();
		bikeLightProduct.click();
		boltTShirtProduct.click();
		fleeceJacketProduct.click();
		onsieProduct.click();
		RedTshirtProduct.click();
		
		return CartCount.getText();
	}
	
	// removing added element from cart

	public String removing2Product() throws InterruptedException
	{
		add6product();
		Thread.sleep(3000);
		removedbackPackProduct.click();
		removedbikeLightProduct.click();
		
		return CartCount.getText(); 
		
	}

	public void ClickcartCount() 
	{
		CartCount.click();
		
	}

	
	

}
