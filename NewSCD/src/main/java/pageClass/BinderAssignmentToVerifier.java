
package pageClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class BinderAssignmentToVerifier extends BaseClass{
	String usrName="";
	@FindBy(id="sidebarCollapse")
	WebElement Expandbutton;
	
	@FindBy(xpath="//button[@id='btnActivity']")
	WebElement activityBtn;
	
	@FindBy(xpath="//a[@id='2013']")
	WebElement verifierQueue;
	
	@FindBy(xpath="//div[@id='lblfavouteIcon']")
	WebElement addVerifierbtn;
	
	@FindBy(xpath="//input[@id='txtteamgdSearch']")
	WebElement VerifierSearch;
	
	@FindBy(xpath="//input[@class='k-checkbox colclick']")
	WebElement verifierCheckBox;
	
	
	@FindBy(xpath="//button[@id='Add']")
	WebElement verifierAddButton;
	
	@FindBy(xpath="//button[@id='cancel']")
	WebElement verifierCancelButton;
		
	@FindBy(xpath="//a[@id='searchIcon']")
	WebElement binderSearchBtn;
	
	@FindBy(xpath="//input[@id='txtgdSearch']")
	WebElement searchTextBoxBinder;
	
	@FindBy(xpath="//table/tbody/tr[1]//td[1]//input[@class='k-checkbox']")
	WebElement binderCheckBox;
	
	@FindBy(xpath="//a[@id='clearFilter']")
	WebElement BindrSrchClearBtn;
	
	@FindBy(xpath="//button[@id='btnAssign']")
	WebElement binderAssigntoVerifier;
	
	/*@FindBy(xpath=""+xp+"")
	WebElement FormDetailComments;*/
	
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
	
	public BinderAssignmentToVerifier()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void ExpandAndOpenActivity() throws InterruptedException
	{
		Thread.sleep(2000);
		Expandbutton.click();
		Thread.sleep(2000);
		activityBtn.click();
		Thread.sleep(2000);
		
	}
	
	public void BinderAssignToVerifier() throws IOException, org.json.simple.parser.ParseException   {
		
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, waitPeriod);
		activityBtn.click();
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		verifierQueue.click();
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		JSONParser jparser= new JSONParser();
		FileReader fr=new FileReader("C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/TeamLeadLoginData.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("Credentials");
		
		for(int i=0;i<jarray.size();i++)
		{
		
		JSONObject cred=(JSONObject) jarray.get(i);
		String	VerifierName=(String)cred.get("VerifierName");
		String	BinderId=(String)cred.get("BinderId");
		
		String[] bindrList=BinderId.split("/");
		String xp="//div[@id='teamLeader']//*[contains(text(),'"+ VerifierName +"')]";	
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		addVerifierbtn.click();
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		VerifierSearch.click();
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		VerifierSearch.sendKeys(VerifierName);
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(verifierCheckBox));
		if(verifierCheckBox.isSelected()==false) {
			verifierCheckBox.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		verifierAddButton.click();
		}
		else 
			verifierCancelButton.click();
		
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		
		for(int j=0;j<bindrList.length;j++) {
		if(bindrList[j]!="") {
		if(binderSearchBtn.isEnabled()==true)
		binderSearchBtn.click();
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		searchTextBoxBinder.sendKeys(bindrList[j]);
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(binderCheckBox));
		if(binderCheckBox.isSelected()==false)
		binderCheckBox.click();
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		
		/*if(BindrSrchClearBtn.isEnabled()==true) {
			BindrSrchClearBtn.click();
		}*/
		}
		}
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xp)).click();
		if(binderAssigntoVerifier.isEnabled()==true)
			binderAssigntoVerifier.click();
		driver.manage().timeouts().implicitlyWait(waitPeriod, TimeUnit.SECONDS);		
	}
	}
  }