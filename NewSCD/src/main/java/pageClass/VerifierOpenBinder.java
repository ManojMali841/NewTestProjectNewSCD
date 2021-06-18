package pageClass;




import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;
//import junit.framework.Assert;

public class VerifierOpenBinder extends BaseClass{
	@FindBy(xpath="//button[@id='btnActivity']")
	WebElement activityBtn;
	
	@FindBy(xpath="//a[@id='2014']")
	WebElement verifierQueue;
	
	@FindBy(xpath="//a[@id='searchIcon']")
	WebElement binderSearchBtn;
	
	@FindBy(xpath="//input[@id='txtgdSearch']")
	WebElement searchTextBoxBinder;
	
	@FindBy(xpath="//a[@id='clearFilter']")
	WebElement BindrSrchClearBtn;
	
	@FindBy(xpath="//div[@id='divBinderOpen']")
	WebElement openBinderBtn;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	WebElement ThreeDots;
	
	
	public VerifierOpenBinder()
	{
		
		PageFactory.initElements(driver,this);
	}
	

	public void OpenBinderForVerifierFeature() throws IOException, ParseException, InterruptedException
	{
		Thread.sleep(20000);
		JSONParser jparser= new JSONParser();
		FileReader fr=new FileReader("C:/Users/Deepak.Badgotya/eclipse-workspace/NewSCD/src/main/java/testData/VerifierLogin.json");//"C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/logincred.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("Credentials");
		for(int i=0;i<jarray.size();i++)
		{
			JSONObject cred=(JSONObject) jarray.get(i);
		String	binderId=(String)cred.get("BinderId");
		//String	pass=(String)cred.get("Password");
		//driver.wait(20000);
		Thread.sleep(5000);
		activityBtn.click();
		Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		verifierQueue.click();
		Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		binderSearchBtn.click();
		Thread.sleep(10000);
		searchTextBoxBinder.sendKeys(binderId);
		Thread.sleep(3000);
		if(openBinderBtn.isEnabled()==true)
		openBinderBtn.click();
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		}
	}

}


