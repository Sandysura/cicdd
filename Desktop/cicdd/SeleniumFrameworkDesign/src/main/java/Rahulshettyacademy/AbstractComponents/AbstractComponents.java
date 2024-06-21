package Rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rahulshettyacademy.PageObjects.CartPage;
import Rahulshettyacademy.PageObjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartheader;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	

	public void WaitForElement(By findBy)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void WaitForWebElement(WebElement findBy)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public CartPage gotoCart()
	{
		cartheader.click();
		CartPage cp=new CartPage(driver);
		return cp;
	
	}
	
	public OrderPage gotoMyorders() 
	{
		orderHeader.click();
		OrderPage op=new OrderPage(driver);
		return op;
	}
	
	
	public void WaitForElementDisappear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
}
