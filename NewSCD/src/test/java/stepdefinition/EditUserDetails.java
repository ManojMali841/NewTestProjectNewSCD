package stepdefinition;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.AdminHomePage;
import pageClass.EditUserDetail;
import pageClass.LoginPageFeaturesMethods;

public class EditUserDetails extends BaseClass{

	
	   @Given("^login New SCD with Admin User$")
	    public void login_new_scd_with_admin_user() throws Throwable {
		   
		   System.out.println("smoke6");
	        
	    }
	   @And("^click on NewSCD user management$")
	    public void click_on_NewSCD_user_management() throws Throwable {
		   System.out.println("smoke611");
	    }
	    @When("^Search for a user and click on three dots against a user$")
	    public void Search_for_a_user_and_click_on_three_dots_against_a_user() throws Throwable {
	    	EditUserDetail editusrDet=new EditUserDetail();
	        editusrDet.EditUser();
	    }
	    @And("^select option edit user$")
	    public void select_option_edit_user() throws Throwable {
	       
	    }
	    @And("^edit user details$")
	    public void edit_user_details() throws Throwable {
	       
	    }

	    @And("^save the edited user details$")
	    public void save_the_edited_user_details() throws Throwable {
	        
	    }
	    @Then("^check edited details are saved successfully$")
	    public void check_edited_detsils_are_saved_successfully() throws Throwable {
	        
	    }

	   

	    

	    

}
