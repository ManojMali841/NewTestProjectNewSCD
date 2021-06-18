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

public class BinderAssignmentToTeamLead extends BaseClass{
	String usrName="";
	@FindBy(xpath="//a[@id='searchIcon']")
	WebElement Search;
	
	@FindBy(xpath="//input[@id='txtgdSearch']")
	WebElement SearchTxtBox;
	
	@FindBy(xpath="//button[@id='btnDeleteUser']")
	WebElement DeleteButton;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	WebElement ThreeDots;
	
	
	@FindBy	(xpath="//button[text()='Yes']")
	WebElement YesButton;
	
	@FindBy(xpath="//table/tbody/tr/td[2]")
	WebElement UsernameColumn;
	
	@FindBy(id="sidebarCollapse")
	WebElement Expandbutton;
	
	@FindBy(xpath="//button[@id='btnActivity']")
	WebElement activityBtn;
	
	@FindBy(xpath="//a[@id='2011']")
	WebElement managerQueue;
	
	@FindBy(xpath="//div[@id='lblfavouteIcon']")
	WebElement addTeamLeadbtn;
	
	@FindBy(xpath="//input[@id='txtteamgdSearch']")
	WebElement teamLeadSearch;
	
	@FindBy(xpath="//input[@class='k-checkbox colclick']")
	WebElement teamLeadCheckBox;
		
	@FindBy(xpath="//button[@id='Add']")
	WebElement teamLeadAddButton;
	
	@FindBy(xpath="//button[@id='cancel']")
	WebElement teamLeadCancelButton;
		
	@FindBy(xpath="//a[@id='searchIcon']")
	WebElement binderSearchBtn;
	
	@FindBy(xpath="//input[@id='txtgdSearch']")
	WebElement searchTextBoxBinder;
	
	@FindBy(xpath="//table/tbody/tr/td/input[@class='k-checkbox']")////table/tbody/tr[1]//td[1]//input[@class='k-checkbox']")
	WebElement binderCheckBox;
	
	@FindBy(xpath="//a[@id='clearFilter']")
	WebElement BindrSrchClearBtn;
	
	@FindBy(xpath="//button[@id='btnAssign']")
	WebElement binderAssigntoTL;
	
	@FindBy(xpath="//button[@id='btnAdministrative']")
	WebElement adminitvBtn;
	
	@FindBy(xpath="//a[@id='3001']")
	WebElement userMgmtBtn;
		
	public BinderAssignmentToTeamLead()
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
		Thread.sleep(20000);
		
		//Expandbutton.click();
		CheckDeleteUsrFun();
		WebDriverWait wait=new WebDriverWait(driver,40);
		Thread.sleep(5000);
		activityBtn.click();
		Thread.sleep(5000);
		managerQueue.click();
		Thread.sleep(5000);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		JSONParser jparser= new JSONParser();
		FileReader fr=new FileReader("C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/ManagerLoginData.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("Credentials");
		
		for(int i=0;i<jarray.size();i++)
		{
		
		JSONObject cred=(JSONObject) jarray.get(i);
		String	TeamLeadName=(String)cred.get("TeamLeadName");
		String	BinderId=(String)cred.get("BinderId");
		String[] bindrList=BinderId.split("/");
		String xp="//div[@id='teamLeader']//*[contains(text(),'"+ TeamLeadName +"')]";	
		Thread.sleep(5000);
		addTeamLeadbtn.click();
		Thread.sleep(5000);
		teamLeadSearch.click();
		Thread.sleep(5000);
		teamLeadSearch.sendKeys(TeamLeadName);
		Thread.sleep(5000);
		if(teamLeadCheckBox.isSelected()==false) {
		teamLeadCheckBox.click();
		Thread.sleep(5000);
		teamLeadAddButton.click();
		}
		else 
		teamLeadCancelButton.click();
		
		Thread.sleep(5000);
		
		for(int j=0;j<bindrList.length;j++) {
		if(bindrList[j]!="") {
		if(binderSearchBtn.isEnabled()==true)
		binderSearchBtn.click();
		Thread.sleep(5000);
		searchTextBoxBinder.sendKeys(bindrList[j]);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(20000);
		//if(binderCheckBox.isSelected()==false) {
			wait.until(ExpectedConditions.elementToBeClickable(binderCheckBox)).click();//binderCheckBox.click();
		//}
			Thread.sleep(5000);
		
		//if(BindrSrchClearBtn.isEnabled()==true) {
			//BindrSrchClearBtn.click();
		
		}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath(xp)).click();
		if(binderAssigntoTL.isEnabled()==true)
		binderAssigntoTL.click();
		Thread.sleep(5000);
		
	
		
	}
	}
	public void CheckDeleteUsrFun() throws IOException, ParseException, InterruptedException, org.json.simple.parser.ParseException
	{
		
		Thread.sleep(5000);
		adminitvBtn.click();
		Thread.sleep(5000);
		if(userMgmtBtn.isEnabled()) {
		userMgmtBtn.click();
		Thread.sleep(5000);
	    ThreeDots.click();
	    Thread.sleep(5000);
	        try {
	        if(DeleteButton.isDisplayed()==false)
	        System.out.println("Delete functionality is not Available");
		    
	        } catch(Exception e) {
	        	System.out.println("button not Present  ---- Passed");
	        	}
  }
}
}