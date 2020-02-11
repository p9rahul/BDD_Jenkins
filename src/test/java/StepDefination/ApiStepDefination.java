package StepDefination;

import com.API.jsonPack.FindJsonPath;
import com.API.jsonPack.JsonUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApiStepDefination {

	JsonUtility jsonUtility = new JsonUtility();

	@Given("^Send a get request$")
	public void send_a_get_request() {
		jsonUtility.getRequest("https://reqres.in/api/users?page=2");
	}

	@When("^user has a valid URL$")
	public void user_has_a_valid_URL() {
		System.out.println("this is valid");
	}

	@Then("^verify the status code$")
	public void verify_the_status_code() {
		System.out.println("Status code :"+ jsonUtility.findStatusCode());
	}

	@Then("^verify the email id$")
	public void verify_the_email_id() {
		String email = jsonUtility.getValueFromResponse(FindJsonPath.firstEmail);

		System.out.println(email);
	}

	@Then("^verify the first name and last name$")
	public void verify_the_first_name_and_last_name() {
		String name = jsonUtility.getValueFromResponse(FindJsonPath.first_name) + " "
				+ jsonUtility.getValueFromResponse(FindJsonPath.last_name);
		System.out.println(name);
	}

}
