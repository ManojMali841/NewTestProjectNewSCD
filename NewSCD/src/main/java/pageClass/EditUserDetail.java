package pageClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;
import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.ParseException;

public class EditUserDetail extends BaseClass {
	@FindBy(xpath="//i[text()='chevron_left ']")
	WebElement Expandbutton;
	
	@FindBy(xpath="//a[@id='3001']")
	WebElement UserMgmtButton;
	
	@FindBy(xpath="//a[@id='searchIcon']")
	WebElement Search;
	
	@FindBy(xpath="//input[@id='txtgdSearch']")
	WebElement SearchTxtBox;
	
	@FindBy(xpath="//button[@id='btnEditUser']")
	WebElement EditUserButton;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	WebElement ThreeDots;
	
	
	@FindBy(xpath="//button[@id='btnCreateUser']")
	WebElement CreateNewUserButton;
		
	@FindBy(id="UserDetailsRequest_UserName")
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
	
	@FindBy(xpath="//*[@id='CrtUsr_create_Form']//*[@class='form_caption']")
	WebElement verifyEditForm;
	
	public EditUserDetail()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void ExpandAndUsrMgmt() throws InterruptedException
	{
		Thread.sleep(5000);
		Expandbutton.click();
		Thread.sleep(2000);
		UserMgmtButton.click();
		Thread.sleep(2000);
		
	}
	
	public void EditUser() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
		Thread.sleep(5000);
		Expandbutton.click();
		Thread.sleep(2000);
		UserMgmtButton.click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		JSONParser jparser= new JSONParser();
		FileReader fr=new FileReader("C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/EditUserDetailsAndDelete.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("EditUserDetails");
		for(int i=0;i<jarray.size();i++)
		{
		
		JSONObject cred=(JSONObject) jarray.get(i);
		String	user=(String)cred.get("Username");
		
		String	Userrol=(String)cred.get("Role");
		String	Dept=(String)cred.get("Department");
		
		
		Thread.sleep(2000);
		Search.click();
		Thread.sleep(2000);
		SearchTxtBox.sendKeys(user);
		Thread.sleep(8000);
		List<WebElement> UserRoleVal=driver.findElements(By.xpath("//*[@role='row']//*[@data-field='UserName']"));
		System.out.println(UserRoleVal.size());
		List<WebElement> editbtn = driver.findElements(By.xpath("//*[@role='row']//*[@role='button']"));
		
		for(int k=0;k<UserRoleVal.size();k++)
		{
			System.out.println(UserRoleVal.get(k).getText());
			String val=UserRoleVal.get(k).getText();
			val.trim();
			System.out.println("JSON"+user);
			if(val.contains(user))
			{
				Thread.sleep(10000);
				ThreeDots.click(); 
			    Thread.sleep(10000);
			    
			    EditUserButton.click();
				if(verifyEditForm.getText().contains("You can Edit the details of the user")) {
					//WebElement roleDropdown= driver.findElement(By.xpath("//*[@class='k-reset']"));
					Thread.sleep(2000);
					UserRoles.click();
					List<WebElement> expand=driver.findElements(By.xpath("//span[@class='k-icon k-i-expand']"));
					for(int t=0;t<expand.size();t++) {
				    	if(expand.get(t).isEnabled())	
				    	{
				    		Thread.sleep(5000);
				    		expand.get(t).click();
				    		
				    	}
					}
					
					List<WebElement> oldlistRole=driver.findElements(By.xpath("//input[@type='checkbox']"));
					for(int t=0;t<oldlistRole.size();t++) {
									
				    	if(oldlistRole.get(t).isSelected()) {
				    		Thread.sleep(5000);
				    		oldlistRole.get(t).click();
				    		Thread.sleep(2000);
				    		
				    		
				    	}
					}
					List<WebElement> listRole=driver.findElements(By.xpath("//li[@role='treeitem']"));
					for(int t=0;t<=listRole.size();t++) {
				    	if((listRole.get(t).getText()).contentEquals(Userrol)) {
				    		Thread.sleep(2000);
				    		listRole.get(t).click();
				    		break;
				    	}
					}
					
				    Thread.sleep(2000);
				    Department.click();
					Thread.sleep(2000);
					List<WebElement> listDept=driver.findElements(By.xpath("//li[@class='k-item']"));
				    for(int j=0;j<listDept.size();j++) {
				    	if((listDept.get(j).getText()).contentEquals(Dept)) {
				    		Thread.sleep(2000);
				    		listDept.get(j).click();
				    		break;
				    	}
				    }
				   
				}
				 break;
			}
		
			
		}
		Thread.sleep(10000);
		js.executeScript("arguments[0].scrollIntoView();",FormDetailSave);
		Thread.sleep(2000);
		FormDetailSave.click();
		Thread.sleep(2000);
		Search.click();
		Thread.sleep(2000);
		SearchTxtBox.sendKeys(user);
		Thread.sleep(8000);
		
		
		
	}
  }}