package stepdefinition;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.AdminHomePage;

public class AdminPageHome extends BaseClass {
	
	
	@Given ("click on expand button")
	public void click_on_expand_button()
	{
		System.out.println("expand button");	
		
	}
	@When  ("click on user management") 
	public void click_on_user_management()
	{
		System.out.println("user mgmt button");
	}
	@Then  ("click on create new user")
	public void click_on_create_new_user() throws InterruptedException, IOException, ParseException
	{
		
		AdminHomePage AHP=new AdminHomePage();
		AHP.CreateNewUser();
		AHP.EnterCreateUserFormDetails();
		}
	
	@And ("enter details in create user form and save")
	public void enter_details_in_create_user_form_and_save()
	{
		System.out.println("enter details & save");
	}
@Then("click on logout button")
public void click_on_logout_button() throws InterruptedException
{
	AdminHomePage AHP=new AdminHomePage();
	AHP.UserLogout();
	
}
}


