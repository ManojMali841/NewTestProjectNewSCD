package stepdefinition;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.AdminHomePage;
import pageClass.BinderAssignmentToTeamLead;

public class AssignBinderToTeamLead extends BaseClass{
	
	
	@Given ("login New SCD with Verification Manager")
	public void login_New_SCD_with_Verification_Manager()
	{
		System.out.println("expand button");	
		
	}
	@And ("click on NewSCD Activity button")
	public void click_on_NewSCD_Activity_button() {
		
	}
	@When  ("Search for Manager Assignment queue link and click on it") 
	public void Search_for_Manager_Assignment_queue_link_and_click_on_it()
	{
		System.out.println("user mgmt button");
	}
	
	@And ("Click on Add Team Leads link")
	public void Click_on_Add_Team_Leads_link()
	{
		System.out.println("enter details & save");
	}
	@And ("Add Team Lead into Team Lead List pane")
	public void Add_Team_Lead_into_Team_Lead_List_pane()
	{
		System.out.println("enter details & save");
	}
	@And ("Select an UnAssigned Binder and select Team Lead")
	public void Select_an_UnAssigned_Binder_and_select_Team_Lead()
	{
		System.out.println("enter details & save");
	}
@Then("click on Assign button")
public void click_on_Assign_button() throws io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.ParseException, InterruptedException, IOException, ParseException 
{
	BinderAssignmentToTeamLead A=new BinderAssignmentToTeamLead();
	A.BndrAssignmentToTL();
	//AdminHomePage AHP=new AdminHomePage();
	//AHP.UserLogout();
	
}
}
