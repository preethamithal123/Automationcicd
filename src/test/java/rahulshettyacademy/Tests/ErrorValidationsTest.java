package rahulshettyacademy.Tests;

import java.io.IOException;

//import java.io.IOException;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
//import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.CartPage;
import rahulshettyacademy.CheckoutPage;
import rahulshettyacademy.ConfirmationPage;
import rahulshettyacademy.LandingPage;
import rahulshettyacademy.ProductCatologue;
import rahulshettyacademy.TestComponents.BaseTest;
public class ErrorValidationsTest extends  BaseTest{
	
	
	@Test(groups= {"ErrorHandling"})
public void loginErrorValidation() throws InterruptedException, IOException
	 {
		//String ProductName = "ADIDAS ORIGINAL";
		// TODO Auto-generated method stub
		
		 
		 landingpage.loginApplication("ithal@gmail.com", "Iwillget7+*");
		Assert.assertEquals("Incorrect email or password.",  landingpage.getErrorMessage());
		 
		
	}
	
	@Test
	public void productErrorValidation() throws InterruptedException {
		String ProductName = "ADIDAS ORIGINAL";
		// TODO Auto-generated method stub
		
		 
		ProductCatologue productCatologue = landingpage.loginApplication("ithal@gmail.com", "Iwillget7@+*");

		List<WebElement> products = productCatologue.getProductList();
		productCatologue.addProductToCart(ProductName);
		CartPage cartpage = productCatologue.goToCartPage();

		Boolean Match = cartpage.verifyProductDisplay("ADIDAS O1RIGINAL");
		CheckoutPage checkoutpage = cartpage.gotoCheckoutPage();
		Assert.assertFalse(Match);
		
		
	}

}
