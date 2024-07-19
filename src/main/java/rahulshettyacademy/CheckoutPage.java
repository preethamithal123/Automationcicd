package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahushettyacademy.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{

	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
    /*	 a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
	  */// driver.findElement(By.cssSelector(".action__submit ")).click();
	  
	  @FindBy(css="[placeholder='Select Country']")
	  WebElement country;
	  
	  @FindBy(css=".ta-item:nth-child(3)")
	  WebElement selectcountry;
	  
	  @FindBy(css=".action__submit")
	  WebElement submit;
	By results=  By.cssSelector(".ta-results");
	
      public void selectCountryByName(String countryname) {
    	  
    	  Actions a=new Actions(driver);
    	  a.sendKeys(country, countryname).build().perform();
    	  waitElementToAppear(results);
  	    //driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
  	  selectcountry.click();
      }
      
      public ConfirmationPage submitOrder() {
    	  submit.click();
    	  return new ConfirmationPage(driver);
    	  
      }
	
}
