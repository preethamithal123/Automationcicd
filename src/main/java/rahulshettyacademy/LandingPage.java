package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahushettyacademy.AbstractComponents.AbstractComponents;

//import rahushettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}

	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatologue loginApplication(String email,String password)
	{
		
		useremail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();	
		ProductCatologue productCatologue=new ProductCatologue(driver);
		return productCatologue;
		
	}
	
	public String getErrorMessage() {
		
		waitWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	
	public void goTo() 
	{
	 
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

}
