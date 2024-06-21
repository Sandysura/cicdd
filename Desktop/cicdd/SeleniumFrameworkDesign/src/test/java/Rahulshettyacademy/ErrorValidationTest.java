package Rahulshettyacademy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Rahulshettyacademy.PageObjects.CartPage;
import Rahulshettyacademy.PageObjects.ProductCatlog;
import Rahulshettyacademy.TestComponents.BaseTest;
import Rahulshettyacademy.TestComponents.Retry;


public class ErrorValidationTest extends BaseTest{
	
	
	@Test(groups="ErrorHandling",retryAnalyzer=Retry.class)
	public void errorMessage()
	{
		String ProductName="ZARA COAT 3";
		pl=initiateDriver();
		pl.goTo();
		pl.LoginPageApplication("sandysura23@gmail.com", "sandy123@");
		
		Assert.assertEquals("Incorrect email  password.",pl.getErrorMessage());
	}

	@Test
	public void submitOrder() throws IOException,InterruptedException
	{
		String ProductName="ZARA COAT 3";
		pl=initiateDriver();
		pl.goTo();
		ProductCatlog pc=pl.LoginPageApplication("sandysura123@gmail.com", "Sandy123@");
		List<WebElement>products =pc.getProductsList();
	    CartPage cp=	pc.addToCart(ProductName);
		cp.gotoCart();
		Boolean match=cp.verifyProductname(ProductName);
	    Assert.assertTrue(match);
	}
}
