package stepdefinition;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageClass.AdminHomePage;
import pageClass.LoginPageFeaturesMethods;

public class LoginPage extends BaseClass{
	
	@Given("launch new SCD url")
	public void launch_new_SCD_url() throws InterruptedException
	{
		BaseClass.initialization();
		Thread.sleep(2000);
	}
	@When("check title of login page")
	public void check_title_of_login_page() throws InterruptedException
	{
	LoginPageFeaturesMethods Lp=new LoginPageFeaturesMethods();
	Lp.VerifyTitleLoginPage();
	}
	
	@Then("^verify actual title with expected title of New SCD login page$")
	public void verify_actual_title_with_expected_title_of_New_SCD_login_page() throws InterruptedException 
	{ 
		Thread.sleep(3000);
		System.out.println("New SCD Title verfied successfully-user landed on New SCD login page");
	}
	
	@Given("^user click on New SCD username text field$")
    public void user_click_on_new_scd_username_text_field(){
		System.out.println("user enters invalid credentials");
        
    }

    @When("^user enters invalid username and password$")
    public void user_enters_invalid_username_and_password() throws IOException, ParseException, InterruptedException {
    	LoginPageFeaturesMethods Lp=new LoginPageFeaturesMethods();
		Lp.VerifyNewScdLoginFeature();
        
        
    }
    @And("^click on sign in button to login into New SCD$")
    public void click_on_sign_in_button_to_login_into_new_scd() throws Throwable {
    	System.out.println("user failed to login  with invalid credentials");
    }

    @And("^user refresh the login page$")
    public void user_refresh_the_login_page() throws Throwable {
    	System.out.println("page refresh");  
    }

    @Then("^user enters valid username and password$")
    public void user_enters_valid_username_and_password() throws Throwable {
    	System.out.println("user enters valid credentials");
    }

    
    @And("^user click on sign in button to login into New SCD$")
    public void user_click_on_sign_in_button_to_login_into_new_scd() throws Throwable {
    	System.out.println("login successfully with valid credentials");
    }
	
	
	
}