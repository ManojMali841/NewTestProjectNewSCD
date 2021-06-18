package DesktopPBFApp;

import java.net.MalformedURLException;

import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.WiniumDriverService;

import baseClass.BaseClass;

public class RunDesktopFun extends BaseClass{

	
	public void ProcessWorkflow(String path) throws InterruptedException, MalformedURLException {
		//Thread.sleep(40000);
		desktopInitialization(path);
		//Thread.sleep(40000);
		WebDriverWait wait = new WebDriverWait(windriver,120);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*[contains(@AutomationId,'frmlogoscreen')]/*[contains(@AutomationId,'Button2')]"))).click();
		//windriver.findElementByXPath("/*[contains(@AutomationId,'frmlogoscreen')]/*[contains(@AutomationId,'Button2')]").click();
		boolean flag=CheckAndProcessReviewWizard();
		
		flag=CheckAndProcessVarificationWizard();
		
		
		
		
		
	}
	public boolean CheckAndProcessReviewWizard() {
		boolean flag=false;
		WebDriverWait wait=new WebDriverWait(windriver, 30);
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*[contains(@AutomationId,'Verification')]/*[contains(@AutomationId,'MainChkBox')]"))).click();
		//windriver.findElementByXPath("/*[contains(@AutomationId,'Verification')]/*[contains(@AutomationId,'MainChkBox')]").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*[contains(@AutomationId,'Verification')]/*[contains(@AutomationId,'Button1')]"))).click();
		flag=true;
		}catch(Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean CheckAndProcessVarificationWizard() {
	boolean flag=false;

	WebDriverWait wait=new WebDriverWait(windriver, 180);
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*[contains(@AutomationId,'SPVContainer')]")));
	try {
			wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("/*[@AutomationId='SPVContainer']"))));
			//String h=a.getAttribute("Name");
		if(windriver.findElement((By.xpath("/*[@AutomationId='SPVContainer']"))).isEnabled()) {
			String b=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@ClassName='WindowsForms10.STATIC.app.0.6255dd_r30_ad1' and starts-with(@Name,' of ')]"))).getAttribute("Name");
			//RemoteWebElement a=(RemoteWebElement)windriver.findElement(By.xpath("//*[contains(ControlType'ControlType.Pane' and AutomationId='UCSPVToolbar']"));
			//a=(RemoteWebElement)a.findElement(By.xpath("/*[AutomationId='UCSPVToolbar']"));
			//RemoteWebElement a=(RemoteWebElement)windriver.findElement(By.xpath("/*[starts-with(@Name,' of ')]"));
			//String b =a.getAttribute("Name");
					b=b.replace("of", " ");
			b=b.trim();
			int pageCount=Integer.parseInt(b);
			
		
			if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*[contains(@ControlType,'ControlType.Hyperlink')]/[contains(@Name,'Reviewed')]"))).isEnabled()) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/*[contains(@ControlType,'ControlType.Hyperlink')]/[contains(@Name,'Reviewed')]"))).click();////*[contains(@ControlType, ) and contains(@AutomationId,'lblReviewed')]"))).click();
				//String winHandle=windriver.getWindowHandle();
				//winHandle.length();
				//windriver.switchTo().window(winHandle);
				windriver.findElement(By.xpath("//*[contains(@AutomationId,'RbtnMoveNext')]")).click();
				windriver.findElement(By.xpath("//*[contains(@AutomationId,'btnOk')]")).click();
				windriver.switchTo().defaultContent();
			}
			/*	do {
			
			}while(pageCount>0);*/
	
		}
	flag=true;
	}catch(Exception e) {
		return flag;
	}
	return flag;
  }
}