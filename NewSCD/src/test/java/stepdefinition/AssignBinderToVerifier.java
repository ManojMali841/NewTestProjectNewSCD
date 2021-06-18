package stepdefinition;



import java.io.IOException;

import org.json.simple.parser.ParseException;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.AdminHomePage;
import pageClass.BinderAssignmentToVerifier;

public class AssignBinderToVerifier {	
	
	@Given ("login New SCD with Verification Team Lead")
	public void login_New_SCD_with_Verification_Team_Lead()
	{
		System.out.println("expand button");	
		
	}
	@And ("click on Activity button")
	public void click_on_Activity_button() {
		
	}
	@When  ("Search for Team Lead Assignment queue link and click on it") 
	public void Search_for_Team_Lead_Assignment_queue_link_and_click_on_it()
	{
		System.out.println("user mgmt button");
	}
	
	@And ("Click on Add Verifiers link")
	public void Click_on_Add_Verifiers_link()
	{
		System.out.println("enter details & save");
	}
	@And ("Add Verifier into Verifier List pane")
	public void Add_Verifier_into_Verifier_List_pane()
	{
		System.out.println("enter details & save");
	}
	@And ("Select an UnAssigned Binder and select Verifier")
	public void Select_an_UnAssigned_Binder_and_select_Verifier()
	{
		System.out.println("enter details & save");
	}
@Then("click on Binder Assignment button")
public void click_on_Binder_Assignment_button() throws InterruptedException, io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.ParseException, IOException, ParseException
{
	BinderAssignmentToVerifier A=new BinderAssignmentToVerifier();
	A.BndrAssignmentToTL();
	//AdminHomePage AHP=new AdminHomePage();
	//AHP.UserLogout();
	
}
}

