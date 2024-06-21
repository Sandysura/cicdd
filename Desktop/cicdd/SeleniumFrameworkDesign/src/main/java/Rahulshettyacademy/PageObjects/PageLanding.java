package Rahulshettyacademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class PageLanding extends AbstractComponents {

	WebDriver driver;
	public PageLanding(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement error;
	
	
	public void goTo()
	{
		System.out.println("Testfghjkl");
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	public String  getErrorMessage()
	{
		WaitForWebElement(error);
		 return error.getText();
		
		
	}
	public ProductCatlog LoginPageApplication(String user,String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		
		ProductCatlog pc=new ProductCatlog(driver);
		return pc;
	}
	

}
