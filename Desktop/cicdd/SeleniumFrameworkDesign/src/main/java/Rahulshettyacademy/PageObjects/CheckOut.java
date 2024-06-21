package Rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CheckOut extends AbstractComponents {
     WebDriver driver;
     String cvvnum="5577";
     String nameOnCard="Sandeep";
	public CheckOut(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".form-group input[class='input txt text-validated']")
	private WebElement searchcountry;
	
	@FindBy(xpath="//button[@class='ta-item list-group-item ng-star-inserted']/span")
	 List<WebElement>searchlist;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	private WebElement submit;
	
	@FindBy(xpath="(//input[@class='input txt'])[1]")
	 private WebElement cvv;
	
	@FindBy(xpath="(//input[@class='input txt'])[2]")
	private WebElement name;
	
    By list=By.cssSelector(".ta-results list-group ng-star-inserted");
	  
	public void selectCountry(String countryName)
	{
		searchcountry.sendKeys(countryName);
		cvv.sendKeys(cvvnum);
		name.sendKeys(nameOnCard);
		/*WaitForElement(list);
		
		List<WebElement>sl=searchlist;
		 for(WebElement s:sl)
		   {
			  String name= s.getText();
			  if(name.equalsIgnoreCase("india"))
			  {
				  s.click();
				  break;
			  }
		   }
		   */
	}
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}

}
