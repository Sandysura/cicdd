package Rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ProductCatlog extends AbstractComponents{

	WebDriver driver;
	public ProductCatlog(WebDriver driver) 
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	
	
	
	@FindBy(css=".mb-3")
	List<WebElement>products;
	
	
    By ProductsBy     =	By.cssSelector(".mb-3");
    By addbutton      = By.cssSelector("div[class='card-body'] button:last-of-type");
    By toastmessage   = By.cssSelector("#toast-container");
    By animate        = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductsList()
	{
		WaitForElement(ProductsBy);
		return products;
		
	}
	public WebElement getProductByname(String ProductName)
	{
		WebElement pro=getProductsList().stream().filter(product->
		product.findElement(By.cssSelector("h5 b")).getText().equals(ProductName)).findFirst().orElse(null);
		
		return pro;
	}
	public CartPage addToCart(String ProductName)
	{
		WebElement pro=getProductByname(ProductName);
		pro.findElement(addbutton).click();
		WaitForElement(toastmessage);
		WaitForElementDisappear(animate);
		CartPage cp=new CartPage(driver);
		return cp;

	}
	

}
