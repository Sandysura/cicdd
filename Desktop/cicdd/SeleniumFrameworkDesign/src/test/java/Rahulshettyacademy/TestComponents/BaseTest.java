package Rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Rahulshettyacademy.PageObjects.PageLanding;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public  WebDriver driver;
    public PageLanding pl;
    Properties prop=new Properties();
    String browsername;
	public WebDriver setUp() throws IOException
	{
		
	      if(driver==null)
	      {
	         FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Resources/GlobalData.properties");
		     prop.load(fis);
		  
		     browsername=System.getProperty("browsername")!=null?System.getProperty("browsername"):prop.getProperty("browsername");
	      }
	      
		if(browsername.equalsIgnoreCase("chrome"))
		{
	    	WebDriverManager.chromedriver().setup();
	    	ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
	        driver=new ChromeDriver(options);
	    	
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
	        driver=new EdgeDriver(options);
	    	
		}
		else if(browsername.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();			
	        driver=new SafariDriver();
	    	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshot(WebDriver driver,String testname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File desti=new File(System.getProperty("user.dir")+"/reports"+testname+".png");
		FileUtils.copyFile(source, desti);
		return System.getProperty("user.dir")+"/reports/"+testname+".png";
		
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void launchBrowser() throws IOException
	{
		driver=setUp();
	    pl=new PageLanding(driver);
	    
	}
	
	
	public PageLanding initiateDriver()
	{
		return pl;
	}

	public List<HashMap<String, String>> getJsontoMap(String filepath) throws IOException
	{
		// json to string
		String jsoncontent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8); 
		//String to map ...add json databind dependency
		
		ObjectMapper mapper=new ObjectMapper();
		
		List<HashMap<String,String>>data=mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}

	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
}
