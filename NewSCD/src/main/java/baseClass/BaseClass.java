package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Scenario;
import utilities.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public BaseClass()
	{
		try
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:/Manoj/WorkSpace/NewSCD/src/main/java/configuration/Config.properties");
			prop.load(fis);
	}
		catch(IOException e)
		
		{
			e.getMessage();
			
		}
	}

	public static void initialization()
	{
		
	String browsername=prop.getProperty("Browser");
	if(browsername.equals("chrome"))
			{
		System.setProperty("webdriver.chrome.driver","C:/Manoj/chromedriver/chromedriver.exe");
		driver =new ChromeDriver();
		
			}
	else if(browsername.equals("firefox"))
	{
System.setProperty("webdriver.chrome.driver","C:/Manoj/chromedriver/chromedriver.exe");
driver =new FirefoxDriver();

	}
	driver.manage().window().maximize();;
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("Url"));
	}
	
	
	
}
