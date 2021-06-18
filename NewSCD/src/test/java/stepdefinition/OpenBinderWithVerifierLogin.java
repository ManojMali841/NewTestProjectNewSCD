package stepdefinition;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import DesktopPBFApp.RunDesktopFun;
import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageClass.AdminHomePage;
import pageClass.LoginPageFeaturesMethods;
import pageClass.OpenBinderForVerifier;

public class OpenBinderWithVerifierLogin {
	
	@Given("login New SCD with Verifier")
	public void login_New_SCD_with_Verifier() throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println("Logged in With Verifier");
	}
	@When("Search for a Binder")
	public void Search_for_a_Binder() throws Exception
	{
		//BaseClass.desktopInitialization();
		OpenBinderForVerifier Op=new OpenBinderForVerifier();
		Thread.sleep(3000);
		String path=Op.OpenBinderForVerifierFeature(); 
		System.out.println("Searched for a Binder");
		//RunDesktopFun b=new RunDesktopFun();
		//b.ProcessWorkflow(path);
	}
	
	@Then("click on Open Binder button")
	public void click_on_Open_Binder_button() throws InterruptedException 
	{ 
		Thread.sleep(3000);
		System.out.println("Binder Opened Successfully");
		AdminHomePage AHP=new AdminHomePage();
		AHP.UserLogout();
	}
	

}
