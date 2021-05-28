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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class AdminHomePage extends BaseClass {
	@FindBy(xpath="//i[text()='chevron_left ']")
	WebElement Expandbutton;
	
	@FindBy(xpath="//a[@id='3001']")
	WebElement UserMgmtButton;
	
	
	@FindBy(xpath="//button[@id='btnCreateUser']")
	WebElement CreateNewUserButton;
		
	@FindBy(xpath="//input[@id='UserDetailsRequest_UserName']")
	WebElement FormDetailUsername;
	
	@FindBy(xpath="//input[@id='UserDetailsRequest_FirstName']")
	WebElement FormDetailFirstname;
	
	@FindBy(xpath="//input[@id='UserDetailsRequest_LastName']")
	WebElement FormDetailLastname;
	
	@FindBy(xpath="//input[@id='UserDetailsRequest_EMail']")
	WebElement FormDetailEmail;
	
	@FindBy(xpath="//input[@id='UserDetailsRequest_UserPassword']")
	WebElement FormDetailPassword;
	
	@FindBy(xpath="//textarea[@id='UserDetailsRequest_Comments']")
	WebElement FormDetailComments;
	
	@FindBy(xpath="//button[@id='saveNewUser']")
	WebElement FormDetailSave;
	
	@FindBy(xpath="//div[@id='containerlocation']")
WebElement Location;
	
	@FindBy(xpath="//div[@id='containeruserroles']")
WebElement UserRoles;

	@FindBy(xpath="//div[@id='containerdepartment']")
	WebElement Department;
	
	
	
	
	
	
	public AdminHomePage()
	{
		
		PageFactory.initElements(driver,this);
	}
	
	public void CreateNewUser() throws InterruptedException
	{
		Thread.sleep(2000);
		Expandbutton.click();
		Thread.sleep(2000);
		UserMgmtButton.click();
		Thread.sleep(2000);
		CreateNewUserButton.click();
		Thread.sleep(2000);
	}
	
	public void EnterCreateUserFormDetails() throws InterruptedException, IOException, ParseException
	{
		JSONParser jparser= new JSONParser();
		String vari="Verification";
		FileReader fr=new FileReader("C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/CreateNewUserFormDetails.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("FormDetails");
		for(int i=0;i<jarray.size();i++)
		{
			JSONObject cred=(JSONObject) jarray.get(i);
		String	user=(String)cred.get("Username");
		String	firstNam=(String)cred.get("FirstName");
		String	LastNam=(String)cred.get("LastName");
		String	Email=(String)cred.get("Email");
		String	pass=(String)cred.get("Password");
		String	Loc=(String)cred.get("Location");
		String	Com=(String)cred.get("Comments");
		String	Userrol=(String)cred.get("UserRole");
		String	Dept=(String)cred.get("Department");
		
		
        
        
        FormDetailUsername.sendKeys(user);
        Thread.sleep(1000);
        FormDetailFirstname.sendKeys(firstNam);
        Thread.sleep(1000);
        FormDetailLastname.sendKeys(LastNam);
        Thread.sleep(1000);
        FormDetailEmail.sendKeys(Email);
        Thread.sleep(1000);
        FormDetailPassword.sendKeys(pass);
       
driver.findElement(By.xpath("//body")).click();

        Thread.sleep(5000);
		Location.click();
		Thread.sleep(5000);
		
	List<WebElement> LocDrpVal=driver.findElements(By.xpath("//li[@class='k-item']"));
	System.out.println(LocDrpVal.size());
	
	for(int k=0;k<LocDrpVal.size();k++)
	{
		
		if(LocDrpVal.get(k).getText().equals(Loc))
		{
			LocDrpVal.get(k).click();
			break;
		}
	}
	Thread.sleep(3000);
	UserRoles.click();
	driver.findElement(By.xpath("//li[@role='treeitem']//*[contains(text(),'"+vari+"')]/preceding::span[@class='k-icon k-i-expand']")).click();
	Thread.sleep(3000);
	List<WebElement> UserRolDrpVal=driver.findElements(By.xpath("//li[@role='treeitem']"));
	System.out.println(UserRolDrpVal.size());
	
	for(int k=0;k<UserRolDrpVal.size();k++)
	{
		
		if(UserRolDrpVal.get(k).getText().equals(Userrol))
		{
			UserRolDrpVal.get(k).click();
			break;
		}
	}
	Thread.sleep(3000);
	Department.click();
	Thread.sleep(3000);
	List<WebElement> DepartmentDrpVal=driver.findElements(By.xpath("//li[@class='k-item']"));
	System.out.println(DepartmentDrpVal.size());
	
	for(int k=0;k<DepartmentDrpVal.size();k++)
	{
		
		if(DepartmentDrpVal.get(k).getText().equals(Dept))
		{
			DepartmentDrpVal.get(k).click();
			break;
		}
	}
	FormDetailComments.sendKeys(Com);
		}
		Thread.sleep(1000);
		FormDetailSave.click();	 
}
	public void UserLogout() throws InterruptedException {
		driver.findElement(By.xpath("//i[text()='settings']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("log-out-btn")).click();
		//driver.close();
	}
}
