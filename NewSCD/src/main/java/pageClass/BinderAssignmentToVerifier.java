
package pageClass;

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
		Thread.sleep(5000);
		Expandbutton.click();
		Thread.sleep(5000);
		activityBtn.click();
		Thread.sleep(5000);
		
	}
	
	public void BndrAssignmentToTL() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
	
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		Thread.sleep(5000);
		activityBtn.click();
		Thread.sleep(5000);
		verifierQueue.click();
		Thread.sleep(5000);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
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
		Thread.sleep(5000);
		addVerifierbtn.click();
		Thread.sleep(5000);
		VerifierSearch.click();
		Thread.sleep(5000);
		VerifierSearch.sendKeys(VerifierName);
		Thread.sleep(5000);
		if(verifierCheckBox.isSelected()==false) {
			verifierCheckBox.click();
			Thread.sleep(5000);
		verifierAddButton.click();
		}
		else 
			verifierCancelButton.click();
		
		Thread.sleep(5000);
		
		for(int j=0;j<bindrList.length;j++) {
		if(bindrList[j]!="") {
		if(binderSearchBtn.isEnabled()==true)
		//binderCheckBox.click();//
			binderSearchBtn.click();
		Thread.sleep(5000);
		searchTextBoxBinder.sendKeys(bindrList[j]);
		
		Thread.sleep(30000);
		if(binderCheckBox.isSelected()==false)
			wait.until(ExpectedConditions.elementToBeClickable(binderCheckBox)).click();//binderCheckBox.click();
		Thread.sleep(5000);
		
		/*if(BindrSrchClearBtn.isEnabled()==true) {
			BindrSrchClearBtn.click();
		}*/
		}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath(xp)).click();
		if(binderAssigntoVerifier.isEnabled()==true)
			binderAssigntoVerifier.click();
		Thread.sleep(5000);
		
		
		
	}
	}
  }