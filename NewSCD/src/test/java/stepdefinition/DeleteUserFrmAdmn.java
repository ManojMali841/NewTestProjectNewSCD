package stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import baseClass.BaseClass;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.DeleteUser;
import pageClass.EditUserDetail;

public class DeleteUserFrmAdmn extends BaseClass {
	

	@Before 
	public void setup()
	{
		System.out.println("start");
	};
	
	@After
	public void tearDown(Scenario scenario) {
	if(scenario.isFailed())
	{
	final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	
		scenario.attach(screenshot, "image/png","please find below screenshot");
	}
	}
	
	@Given("^login New SCD with Admin$")
    public void login_New_SCD_with_Admin() throws Throwable {
		EditUserDetail edtusr=new EditUserDetail();
		edtusr.ExpandAndUsrMgmt();
        
	}
	@And("^click on NewSCD user mgmt$")
    public void click_on_NewSCD_user_mgmt() throws Throwable {
		System.out.println("serah a user and delete");
        
    }

    @When("^Search for a user and click on three dots$")
    public void Search_for_a_user_and_click_on_three_dots() throws Throwable {
    	DeleteUser  delusr=new DeleteUser();
        delusr.DeleteUsrFrmAdmin();
    }
    @And("^select delete user and click on OK$")
    public void select_delete_user_and_click_on_OK() throws Throwable {
        
    }

    @Then("^confirm user is deleted successfully$")
    public void confirm_user_is_deleted_successfully() throws Throwable {
        
    }

    

    

}
