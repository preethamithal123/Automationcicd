package rahushettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.CartPage;
import rahulshettyacademy.OrderPage;

public class AbstractComponents {
	WebDriver driver;


	public AbstractComponents(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="[routerlink*=cart]")
	WebElement gotocart;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement goToOrderHeader;
	
	
	public void waitElementToAppear(By findBy)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitWebElementToAppear(WebElement findBy)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	
	public void waitElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		
	}
	//driver.findElement(By.cssSelector("[routerlink*=cart]")).click();
	public CartPage goToCartPage()
	{
		gotocart.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
		
	}
	
	public OrderPage goToOrderPage() {
		goToOrderHeader.click();
		OrderPage  orderPage=new OrderPage(driver);
		return orderPage;
		
	}
}
