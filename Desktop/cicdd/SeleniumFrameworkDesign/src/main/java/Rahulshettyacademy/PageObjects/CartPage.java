package Rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement>cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	
	
	public Boolean verifyProductname(String ProductName)
	{
		 Boolean match= cartproducts.stream().anyMatch(x->x.getText().equalsIgnoreCase(ProductName));
		return match;
		
	}

	
	public CheckOut ClickCheckout() {
		
		checkout.click();
		return new CheckOut(driver);
		
	}
	
	
	

}
