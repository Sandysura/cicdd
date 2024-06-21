package Rahulshettyacademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//td[@class='box']//label)[2]")
	WebElement verifyOrder;
	
	public String verifyO()
	{
		return verifyOrder.getText();
	}

}
