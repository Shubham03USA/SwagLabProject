package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Handling_Dropdown_List 
{
	public static void handleSelectClass(WebElement element, String value )
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
		
	}
	
	

}
