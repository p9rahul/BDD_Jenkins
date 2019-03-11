package StepDefination;

import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class FirstDef {

	@Before
	public void beforeMyHook()
	{
		System.out.println("=======Start======");
		System.out.println("Launch Browser");
		System.out.println("Enter URL");
	}
	
	
	@After
	public void afterMyHook()
	{
		System.out.println("close the Browser");
		System.out.println("=======End======");
	}
	@Given("^Launch the browser \"([^\"]*)\"$")
	public void launch_the_browser(String arg1) throws Throwable {
	    System.out.println("test 1");
	    Assert.assertTrue(true, "test");
//	    Assert.assertTrue(false, "test");
//	    Assert.assertEquals(5, 2, "not matched");
//	    Reporter.log("pass", false);
//	    Reporter.log("Application Launched successfully | ");
	    
	}

	@When("^user have valid credentials \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_have_valid_credentials(String arg1, String arg2) throws Throwable {
		System.out.println("test 1");
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
		System.out.println("test 1");
	}

	@Then("^check login sucessfully$")
	public void check_login_sucessfully() throws Throwable {
		System.out.println("test 1");
	}
	
	@Given("^Launch  browser \"([^\"]*)\"$")
	public void launch_browser(String arg1) throws Throwable {
		System.out.println("test 2");
	}

	@When("^user have a valid credentials \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_have_a_valid_credentials(String arg1, String arg2) throws Throwable {
		System.out.println("test 2");
	}

	@When("^click on the  login button$")
	public void click_on_the_login_button() throws Throwable {
		System.out.println("test 2");
	}

	@Then("^check login is sucessfully$")
	public void check_login_is_sucessfully() throws Throwable {
		System.out.println("test 2");
	}

	
	}
