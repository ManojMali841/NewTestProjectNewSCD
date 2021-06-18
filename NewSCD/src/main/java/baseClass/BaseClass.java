package baseClass;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.core.plugin.Options;
import io.cucumber.java.Scenario;
import utilities.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static WiniumDriver windriver;
	public BaseClass()
	{
		try
		{
			
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/configuration/Config.properties");
			prop.load(fis);
	}
		catch(IOException e)
		
		{
			e.getMessage();
			
		}
	}

	public static void initialization() throws MalformedURLException
	{
	String browsername=prop.getProperty("Browser");
	if(browsername.equals("chrome"))
			{
		System.setProperty("webdriver.chrome.driver","C:/Manoj/chromedriver/chromedriver.exe");
		driver =new ChromeDriver();
		
			}
	else if(browsername.equals("firefox"))
	{
System.setProperty("webdriver.chrome.driver","C:/Manoj/chromedriver/chromedriver");
driver =new FirefoxDriver();

	}
	driver.manage().window().maximize();;
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("Url"));
	
	}
	public static void desktopInitialization(String path) throws MalformedURLException
	{
		String appPath = path;//"C:/Program Files (x86)/SurePrepLLC/PBFX/SurePrep.PortableBinderFormat(PBF).exe";
        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(appPath);
        option.setDebugConnectToRunningApp(false);
        option.setLaunchDelay(5);
		windriver = new WiniumDriver(new URL("http://localhost:9999"),option);
	//	windriver.manage().window().maximize();;
	//windriver.manage().deleteAllCookies();
	//windriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	//windriver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	
	}
	
	
	
}
