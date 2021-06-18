
package pageClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;
//import junit.framework.Assert;

public class OpenBinderForVerifier extends BaseClass{
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
	
	@FindBy(xpath="//div[@id='divHoldnClose' and starts-with(@class,'Hold-n-Stop ')]")
	WebElement HoldBinderBtn;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	WebElement ThreeDots;
	
	
	public OpenBinderForVerifier()
	{
		
		PageFactory.initElements(driver,this);
	}
	

	public String OpenBinderForVerifierFeature() throws Exception
	{
		String filePath=null;
		Thread.sleep(5000);
		JSONParser jparser= new JSONParser();
		FileReader fr=new FileReader("C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/VerifierDataFile.json");//"C:/Users/manoj.mali/git/repository2/NewSCD/src/main/java/testData/logincred.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("Credentials");
		for(int i=0;i<jarray.size();i++)
		{
			JSONObject cred=(JSONObject) jarray.get(i);
		String	binderId=(String)cred.get("BinderId");
		//String	pass=(String)cred.get("Password");
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(5000);
		activityBtn.click();
		Thread.sleep(5000);
		verifierQueue.click();
		Thread.sleep(5000);
		binderSearchBtn.click();
		Thread.sleep(5000);
		searchTextBoxBinder.sendKeys(binderId);
		Thread.sleep(3000);
		/*if(HoldBinderBtn.isEnabled()==true &&wait.until(ExpectedConditions.elementToBeClickable(HoldBinderBtn)).isEnabled()==true) {
			HoldBinderBtn.click();
		}*/
		Thread.sleep(3000);
		if(openBinderBtn.isEnabled()==true)
		openBinderBtn.click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		//driver.findElement(By.name("Downloads bar")).click();
		File path= new File("C:/Users/manoj.mali/Downloads");
		File url=waitForDownloadToComplete(path, binderId);
		 filePath=url.getPath();
		//Runtime.getRuntime().exec(filePath);
		//desktopInitialization(filePath);
		//return filePath;
		}
		return filePath;
	}
	public static File waitForDownloadToComplete(File downloadPath, String fileName) throws Exception {
        boolean isFileFound = false;
        int waitCounter = 0;
        while (!isFileFound) {
            for (File tempFile : downloadPath.listFiles()) {
                if (tempFile.getName().contains(fileName)) {
                    String tempEx = tempFile.getName();
                    // crdownload - For Chrome, part - For Firefox
                    if (tempEx.equalsIgnoreCase("crdownload") || tempEx.equalsIgnoreCase("part")) {
                        Thread.sleep(1000);
                    } else {
                        isFileFound = true;
                        System.out.println("File opened");
                       // URI url=tempFile.toURI();
                        return tempFile;
                        //Runtime.getRuntime().exec(tempFile.getPath());
                        //windriver.get(tempEx);
                    }
                }
            }
            Thread.sleep(1000);
            waitCounter++;
            if (waitCounter > 25) {
                isFileFound = true;
            }
        }
        throw new Exception("File Not Downloaded");
    }

}


