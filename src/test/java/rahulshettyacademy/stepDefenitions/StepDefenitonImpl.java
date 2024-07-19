package rahulshettyacademy.stepDefenitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

//import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.CartPage;
import rahulshettyacademy.CheckoutPage;
import rahulshettyacademy.ConfirmationPage;
import rahulshettyacademy.LandingPage;
import rahulshettyacademy.ProductCatologue;
import rahulshettyacademy.TestComponents.BaseTest;

public class StepDefenitonImpl extends BaseTest  {
	  public LandingPage landingpage;
	  public ProductCatologue productCatologue;
	  public ConfirmationPage confirmationpage;
	 
	@Given("I landed on Ecommerce page ")
	 public void I_landed_on_Ecommerce_page() throws IOException {
		
		
		landingpage=launchApplication();
		 //throw new io.cucumber.java.PendingException();
	}
	
	@Given("^Logged in with username (.*) and password (.*)$")
    public void loggedInWithUsernameAndPassword(String username, String password) { 
		 
		 
		 productCatologue = landingpage.loginApplication(username,password);
		 
	 }


@When("^I add the Product (.*) to cart$")
public void i_add_the_product_to_cart(String productName) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions

	List<WebElement> products = productCatologue.getProductList();
	productCatologue.addProductToCart(productName);
	  //throw new io.cucumber.java.PendingException();

}

@When("^checkout (.*) and submit the order$")
public void checkout_and_submit_the_order(String productName) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	
	CartPage cartpage = productCatologue.goToCartPage();

	Boolean Match = cartpage.verifyProductDisplay(productName);
	CheckoutPage checkoutpage = cartpage.gotoCheckoutPage();
	Assert.assertTrue(Match);
	checkoutpage.selectCountryByName("india");
	 confirmationpage = checkoutpage.submitOrder();

    //throw new io.cucumber.java.PendingException();
}



@Then(" {string} verify_the_confirmation_message_is_displayed")
public void verify_the_confirmation_message_is_displayed(String msg) {
    // Write code here that turns the phrase above into concrete actions
	String ConfirmationMessage = confirmationpage.getConfirmationPage();
	Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
   // throw new io.cucumber.java.PendingException();
}

	
	
	
	

}
