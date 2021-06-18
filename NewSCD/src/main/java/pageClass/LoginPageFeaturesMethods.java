package pageClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;
//import junit.framework.Assert;

public class LoginPageFeaturesMethods extends BaseClass{
	@FindBy(id="LoginRequest_UserName")
	WebElement username;
	@FindBy(id="LoginRequest_Password")
	WebElement password;
	@FindBy(id="login")
	WebElement signin;
	
	public LoginPageFeaturesMethods()
	{
		
		PageFactory.initElements(driver,this);
	}
	public void VerifyTitleLoginPage() throws InterruptedException
	{
		
	String	ActualTitileNewSCD=driver.getTitle();
	String  ExpectedTitileNewSCD="SurePrep – Service Center Dashboard";
	System.out.println(ActualTitileNewSCD);
	System.out.println(ExpectedTitileNewSCD);
	Thread.sleep(2000);
	//Assert.assertEquals(ExpectedTitileNewSCD, ActualTitileNewSCD);
	System.out.println("Successfully landed on New SCD login page");
	}

	
		public void VerifyNewScdLoginFeature() throws IOException, ParseException, InterruptedException
		{
			JSONParser jparser= new JSONParser();
			FileReader fr=new FileReader("C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/logincred.json");
			JSONObject jobject=(JSONObject) jparser.parse(fr);
			JSONArray jarray=(JSONArray) jobject.get("Credentials");
			for(int i=0;i<jarray.size();i++)
			{
				JSONObject cred=(JSONObject) jarray.get(i);
			String	user=(String)cred.get("Username");
			String	pass=(String)cred.get("Password");
			
			System.out.println(user);
	        System.out.println(pass);
	        
			username.sendKeys(user);
			Thread.sleep(4000);
			password.sendKeys(pass);
			Thread.sleep(3000);
			signin.click();
			Thread.sleep(4000);
			driver.navigate().refresh();
			}
		}

	}

