package rahulshettyacademy.Tests;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		String ProductName="ADIDAS ORIGINAL";
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("ithal@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iwillget7@+*");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	WebElement prod=products.stream().
			filter(product->product.findElement(By.cssSelector("b")).
					getText().equals(ProductName)).findFirst().orElse(null);
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	
	driver.findElement(By.cssSelector("[routerlink*=cart]")).click();
	List<WebElement> Cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean Match=Cartproducts.stream().anyMatch(Cartproduct->Cartproduct.getText().equalsIgnoreCase(ProductName));
    Assert.assertTrue(Match);
    
    driver.findElement(By.cssSelector(".totalRow button")).click();
    Actions a=new Actions(driver);
    a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
    driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".action__submit ")).click();
    Thread.sleep(1000);
   String ConfirmationMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
  Assert.assertTrue( ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
  driver.close();
    
	}

}
