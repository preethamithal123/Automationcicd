package rahulshettyacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahushettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	
	

	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	//List<WebElement> Cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
   @FindBy(css=".cartSection h3")
   List<WebElement> Cartproducts;
   
   // driver.findElement(By.cssSelector(".totalRow button")).click();
   @FindBy(css=".totalRow button")
   WebElement checkOut;
   
   
  public Boolean verifyProductDisplay(String ProductName)
  {
	  Boolean Match=Cartproducts.stream().anyMatch(Cartproduct->Cartproduct.getText().equalsIgnoreCase(ProductName));
	   return Match;
  }
  
  public CheckoutPage gotoCheckoutPage() {
	
	  checkOut.click();
	  return new CheckoutPage(driver);
	  
	  
  }
}