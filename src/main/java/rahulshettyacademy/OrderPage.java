package rahulshettyacademy;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahushettyacademy.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	

	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	 @FindBy(css=".totalRow button")
	   WebElement checkOut;
	   
	 @FindBy(css="tr td:nth-child(3)")
	   List<WebElement> productNames;
	 
	  
	  public Boolean verifyOrderDisplay(String ProductName)
	  {
		  Boolean Match=productNames.stream().anyMatch(Cartproduct->Cartproduct.getText().equalsIgnoreCase(ProductName));
		   return Match;
	  }

	  
}
