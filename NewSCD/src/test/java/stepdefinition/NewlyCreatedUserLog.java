package stepdefinition;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.NewlyCreatedUserLogin;

public class NewlyCreatedUserLog extends BaseClass{
	
	@Given("^login with newly created user login credentials$")
    public void login_with_newly_created_user_login_credentials() throws Throwable {
		NewlyCreatedUserLogin NewuserLogin=new NewlyCreatedUserLogin();
		NewuserLogin.VerifyNewUserScdLogin();
		System.out.println("login with newly created user");  
    }

    @And("^Answer All Security questions$")
    public void Answer_all_security_questions() throws Throwable {
    	System.out.println("all security question answered");
        
    }

    @And("^enter new password and confirm password$")
    public void enter_new_password_and_confirm_password() throws Throwable {
    	System.out.println("confirm password");
        
        }
    @And("^click on submit button$")
    public void click_on_submit_button() throws Throwable {
    	System.out.println("click on submit button");
        }
   
    @Then("^redirect to New SCD Login Window$")
    public void redirect_to_new_scd_login_window() throws Throwable {
    	System.out.println("redirect to New SCD Login Window"); 
    }
    @Given("^relogin with new credentials of newly created user$")
    public void relogin_with_new_credentials_of_newly_created_user() throws Throwable {
    	NewlyCreatedUserLogin NewuserLogin=new NewlyCreatedUserLogin();
		NewuserLogin.VerifyNewUserLoginWithConfirmPass();
		System.out.println("relogin with new credentials of newly created user");
		}

    @When("^click on sign in button$")
    public void click_on_sign_in_button() throws Throwable {
    	System.out.println("click on sign in button");   
    }

   

    @Then("^user is on New SCD homepage$")
    public void user_is_on_new_scd_homepage() throws Throwable {
    	System.out.println("user is on New SCD homepage"); 
    }

    
    }

