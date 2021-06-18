package pageClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;

public class NewlyCreatedUserLogin extends BaseClass {
	
	
	@FindBy(id="LoginRequest_UserName")
	WebElement username;
	@FindBy(id="LoginRequest_Password")
	WebElement password;
	@FindBy(id="login")
	WebElement signin;
	@FindBy(xpath="//button[@id='next']")
	WebElement nextButton;
	@FindBy(xpath="//*[@id='ConfirmPassword']")
	WebElement confirmPassword;
	@FindBy(xpath="//*[@id='NewPassword']")
	WebElement newPassword;
	@FindBy(id="submitCreatePassword")
	WebElement subCreatPass;
	
	public NewlyCreatedUserLogin()
	{
		PageFactory.initElements(driver,this);
	}
	public void VerifyNewUserScdLogin() throws  InterruptedException, IOException, ParseException
	{
		 
		JSONParser jparser= new JSONParser();
		FileReader fr=new FileReader("C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/CreateNewUserFormDetails.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("FormDetails");
		for(int i=0;i<jarray.size();i++)
		{
		JSONObject cred=(JSONObject) jarray.get(i);
		String	user=(String)cred.get("Username");
		String	pass=(String)cred.get("Password");
		
		System.out.println(user);
        System.out.println(pass);
        
		username.sendKeys(user);
		Thread.sleep(2000);
		password.sendKeys(pass);
		Thread.sleep(2000);
		signin.click();
		
		SetSecurityFeaturesQuestions(i);
		
		}
	}
	
	public void SetSecurityFeaturesQuestions(int i) throws IOException, ParseException, InterruptedException {
		JSONParser jparser= new JSONParser();
		FileReader fr=new FileReader("C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/CreateNewUserFormDetails.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("FormDetails");
		
		JSONObject cred=(JSONObject) jarray.get(i);
		String	qtn1=(String)cred.get("SecurityQuestion1");
		String	qtn2=(String)cred.get("SecurityQuestion2");
		String	qtn3=(String)cred.get("SecurityQuestion3");
		String	ans1=(String)cred.get("answer1");
		String	ans2=(String)cred.get("answer2");
		String	ans3=(String)cred.get("answer3");
		String	newPass=(String)cred.get("newpassword");
		String	conPass=(String)cred.get("newpassword");
		
		
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='questionResponseFirstSection']"))).click();
		Thread.sleep(3000);
		List<WebElement> seqQtnVal=driver.findElements(By.xpath("//*[@id='QuestionResponseFirstSection_QuestionID1_listbox']"));
		System.out.println(seqQtnVal.size());
		
		for(int k=0;k<seqQtnVal.size();k++)
		{
			
			if(seqQtnVal.get(k).getText().equals(qtn1))
			{
				seqQtnVal.get(k).click();
				break;
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='QuestionResponseFirstSection_QuestionID1_listbox']//*[contains(text(),'In which city you were born ?')]"))).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='QuestionResponseFirstSection_Answer']"))).sendKeys(ans1);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='questionResponseSecondSection']"))).click();
		WebDriverWait wait1= new WebDriverWait(driver,20);
		Thread.sleep(3000);
		List<WebElement> seqQtnVal1=driver.findElements(By.xpath("//*[@id='QuestionResponseSecondSection_QuestionID2_listbox']"));
		System.out.println(seqQtnVal1.size());
		
		for(int k=0;k<seqQtnVal1.size();k++)
		{
			
			if(seqQtnVal1.get(k).getText().equals(qtn2))
			{
				seqQtnVal1.get(k).click();
				break;
			}
		}
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='QuestionResponseSecondSection_QuestionID2_listbox']//*[contains(text(),'In which city was your first job ?')]"))).click();
		
		
		Thread.sleep(3000);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='QuestionResponseSecondSection_Answer']"))).sendKeys(ans2);
		Thread.sleep(3000);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='questionResponseThirdSection']"))).click();
		Thread.sleep(3000);
		List<WebElement> seqQtnVal2=driver.findElements(By.xpath("//*[@id='QuestionResponseThirdSection_QuestionID3_listbox']"));
		System.out.println(seqQtnVal2.size());
		
		for(int k=0;k<seqQtnVal2.size();k++)
		{
			
			if(seqQtnVal2.get(k).getText().equals(qtn3))
			{
				seqQtnVal2.get(k).click();
				break;
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='QuestionResponseThirdSection_QuestionID3_listbox']//*[contains(text(),'What is the name of you favorite author ?')]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='QuestionResponseThirdSection_Answer']"))).sendKeys(ans3);
		Thread.sleep(3000);
		nextButton.click();
		Thread.sleep(3000);
		newPassword.sendKeys(newPass);
		Thread.sleep(3000);
		confirmPassword.sendKeys(conPass);
		Thread.sleep(3000);
		subCreatPass.click();
		
	}
	public void VerifyNewUserLoginWithConfirmPass() throws IOException, ParseException, InterruptedException
	{
		 
		JSONParser jparser= new JSONParser();
		FileReader fr=new FileReader("C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/CreateNewUserFormDetails.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("FormDetails");
		for(int i=0;i<jarray.size();i++)
		{
			JSONObject cred=(JSONObject) jarray.get(i);
		String	user=(String)cred.get("Username");
		String	pass=(String)cred.get("newpassword");
		
		System.out.println(user);
        System.out.println(pass);
        
		username.sendKeys(user);
		Thread.sleep(2000);
		password.sendKeys(pass);
		Thread.sleep(3000);
		signin.click();
		Thread.sleep(3000);
		//driver.close();
		
		
	}
		
	}
	


}