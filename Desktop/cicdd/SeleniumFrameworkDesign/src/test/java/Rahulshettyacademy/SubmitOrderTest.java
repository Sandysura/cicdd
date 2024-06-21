package Rahulshettyacademy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Rahulshettyacademy.PageObjects.CartPage;
import Rahulshettyacademy.PageObjects.CheckOut;
import Rahulshettyacademy.PageObjects.OrderPage;
import Rahulshettyacademy.PageObjects.PageLanding;
import Rahulshettyacademy.PageObjects.ProductCatlog;
import Rahulshettyacademy.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest
{
	PageLanding pl;
	String ProductName="ZARA COAT 3";
	@Test(dataProvider="getData",groups={"purchase"})
	public void submitOrder(HashMap<String,String>input) throws IOException,InterruptedException
	{
		
		String countryName="India";	
		pl=initiateDriver();
		pl.goTo();
		ProductCatlog pc=pl.LoginPageApplication(input.get("email"), input.get("password"));
		List<WebElement>products =pc.getProductsList();
	    CartPage cp=	pc.addToCart(input.get("ProductName"));
		cp.gotoCart();
		Boolean match=cp.verifyProductname(input.get("ProductName"));
	    Assert.assertTrue(match);
		CheckOut co=cp.ClickCheckout();
		co.selectCountry(countryName);
		//ConfirmationPage cpp=co.submitOrder();
		//String OrderId=cpp.verifyO();
		//System.out.println(OrderId);
		
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistory()
	{
		pl=initiateDriver();
		pl.goTo();
		ProductCatlog pc=pl.LoginPageApplication("sandysura123@gmail.com", "Sandy123@");
		OrderPage op=pc.gotoMyorders();
		Assert.assertTrue(op.verifyOrderHistory(ProductName));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		
		List<HashMap<String,String>>data=getJsontoMap(System.getProperty("user.dir")+"/src/test/java/Rahulshettyacademy/data/purchaseOrder.json");
		return new Object[][] { {data.get(0)},{data.get(1)}};
	}
	}
	/*
HashMap<String,String>map=new HashMap<String,String>();
map.put("email","sandysura123@gmail.com");
map.put("password","Sandy123@");
map.put("ProductName","ZARA COAT 3" );

HashMap<String,String>map1=new HashMap<String,String>();
map1.put("email","pavan321@gmail.com");
map1.put("password","Pavan123@");
map1.put("ProductName","ADIDAS ORIGINAL" );
*/
