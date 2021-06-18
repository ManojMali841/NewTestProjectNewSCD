package pageClass;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class DeleteUser extends BaseClass{
	@FindBy(xpath="//a[@id='searchIcon']")
	WebElement Search;
	
	@FindBy(xpath="//input[@id='txtgdSearch']")
	WebElement SearchTxtBox;
	
	@FindBy(xpath="//button[@id='btnDeleteUser']")
	WebElement DeleteButton;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	WebElement ThreeDots;
	
	
	@FindBy
	
	
	
	
	
	(xpath="//button[text()='Yes']")
	WebElement YesButton;
	
	@FindBy(xpath="//table/tbody/tr/td[2]")
	WebElement UsernameColumn;
	
	
	
	
	public DeleteUser()
	{
		
		PageFactory.initElements(driver,this);
	}
	
	
	public void DeleteUsrFrmAdmin() throws IOException, ParseException, InterruptedException
	{
		JSONParser jparser= new JSONParser();
		FileReader fr=new FileReader("C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/EditUserDetailsAndDelete.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("EditUserDetails");
		for(int i=0;i<jarray.size();i++)
		{
			JSONObject cred=(JSONObject) jarray.get(i);
		String	user=(String)cred.get("DeleteUserName");
		
		
		System.out.println(user);
		 Thread.sleep(2000);
	        Search.click();
	        Thread.sleep(2000);
	        SearchTxtBox.sendKeys(user);
	        Thread.sleep(8000);
	        ThreeDots.click();
	        Thread.sleep(8000);
	        DeleteButton.click();
	        Thread.sleep(5000);
	        YesButton.click();
	        Thread.sleep(5000);
	        Search.click();
	        Thread.sleep(2000);
	        SearchTxtBox.sendKeys(user);
	        Thread.sleep(5000);
	        
		}
	}

}
