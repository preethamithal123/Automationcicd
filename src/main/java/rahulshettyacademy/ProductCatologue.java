package rahulshettyacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahushettyacademy.AbstractComponents.AbstractComponents;

public class ProductCatologue extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCatologue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	//driver.findElement(By.cssSelector(".ng-animating"))
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spineer;
	By prodBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	
	
	public List<WebElement> getProductList()
	{
		waitElementToAppear(prodBy);
		return products;
	}
	
	public WebElement getProductByName(String ProductName)
	{
		
		WebElement prod=products.stream().
				filter(product->product.findElement(By.cssSelector("b")).
						getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String ProductName) throws InterruptedException
	{
	WebElement prod=	getProductByName( ProductName);
		prod.findElement(addToCart).click();
		waitElementToAppear(toastMessage);
		waitElementToDisappear(spineer);
		
		
	}
	
	

}
