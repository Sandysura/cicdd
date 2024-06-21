package Rahulshettyacademy.Stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Rahulshettyacademy.PageObjects.CartPage;
import Rahulshettyacademy.PageObjects.CheckOut;
import Rahulshettyacademy.PageObjects.PageLanding;
import Rahulshettyacademy.PageObjects.ProductCatlog;
import Rahulshettyacademy.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends BaseTest {
	public PageLanding pl;
	public ProductCatlog pc;
	public CartPage cp;

	
	@Given("I landed on Ecommerce Page")
	public void i_landed_on_ecommerce_page() throws IOException
	{
		launchBrowser();
    	pl=initiateDriver();
     	pl.goTo();
	    
	}

	@When("Logged in with username {string} and {string}")
	public void logged_in_with_username_and(String username, String password)
	{
		 pc=pl.LoginPageApplication(username, password);
	    
	}
	@When("I add product {string} to cart")
	public void i_add_product_to_cart(String ProductName) {
		List<WebElement>products =pc.getProductsList();
	    cp=	pc.addToCart(ProductName);
	}

	@Then("checkout {string} and submit the order")
	public void checkout_and_submit_the_order(String ProductName) {
		cp.gotoCart();
	    Boolean match=cp.verifyProductname(ProductName);
        Assert.assertTrue(match);
	    CheckOut co=cp.ClickCheckout();
	    co.selectCountry("India");
	    driver.close();
	}

	@Then("{string} message is displayed")
	public void message_is_displayed(String string) 
	{
		Assert.assertEquals(string ,pl.getErrorMessage());
		driver.close();
	}

}
