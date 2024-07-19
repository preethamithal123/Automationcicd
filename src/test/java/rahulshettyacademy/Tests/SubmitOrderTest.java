package rahulshettyacademy.Tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.CartPage;
import rahulshettyacademy.CheckoutPage;
import rahulshettyacademy.ConfirmationPage;
import rahulshettyacademy.LandingPage;
import rahulshettyacademy.OrderPage;
import rahulshettyacademy.ProductCatologue;
import rahulshettyacademy.TestComponents.BaseTest;
public class SubmitOrderTest extends  BaseTest{
	String ProductName = "ADIDAS ORIGINAL";
	
	@Test(dataProvider="getDta" , groups="purchase")
public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException
	 {
	
		// TODO Auto-generated method stub
		
		 
		ProductCatologue productCatologue = landingpage.loginApplication(input.get("email"),input.get("password") );

		List<WebElement> products = productCatologue.getProductList();
		productCatologue.addProductToCart(input.get("product"));
		CartPage cartpage = productCatologue.goToCartPage();

		Boolean Match = cartpage.verifyProductDisplay(input.get("product"));
		CheckoutPage checkoutpage = cartpage.gotoCheckoutPage();
		Assert.assertTrue(Match);
		checkoutpage.selectCountryByName("india");
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		Thread.sleep(1000);
		String ConfirmationMessage = confirmationpage.getConfirmationPage();
		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	

	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryPage() {
		
		ProductCatologue productCatologue = landingpage.loginApplication("ithal@gmail.com", "Iwillget7@+*");
	OrderPage orderPage=	productCatologue.goToOrderPage();
	 Assert.assertTrue(orderPage.verifyOrderDisplay(ProductName));
	}
	 

	
	
	@DataProvider
	public Object[][] getDta() throws IOException
	{
		
		
		List<HashMap<String,String>> data=getJasonDtaToHashMap (new File( System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\dataProvider\\DataProvider.json"));
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		
		
	}
	
	
	
	

	//*HashMap<String,String> map=new HashMap<String,String>();
	//map.put("email", "ithal@gmail.com");
	//map.put("password", "Iwillget7@+*");
	//map.put("product", "ADIDAS ORIGINAL");
	
	//HashMap<String,String> map1=new HashMap<String,String>();
	//map1.put("email", "ananth@gmail.com");
	//map1.put("password", "iAMdoctor123*@");
	//*map1.put("product", "IPHONE 13 PRO");
	
	
	
	
	
	
	
	//return new Object[][] {{"ithal@gmail.com","Iwillget7@+*","ADIDAS ORIGINAL"}, {"ananth@gmail.com","iAMdoctor123*@","IPHONE 13 PRO"}};
}



