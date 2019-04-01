package StepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStep {

	WebDriver driver = null;

	@Given("^Starts on the \"([^\"]*)\"$")
	public void starts_on_the(String url) throws Throwable {
		driver.get(url);
		// Verify application lunches successfully
		String textVerify = driver.findElement(By.xpath("//*[@class='jumbotron__title']")).getText();
		Assert.assertEquals("We Deliver 2 Billion Forecasts Per Day", textVerify);
		
	}

	@When("^Enters an invalid city name \"([^\"]*)\"$")
	public void enters_an_invalid_city_name(String city) throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Your city name']")).sendKeys(city);
	}

	@Then("^Enters an valid city name \"([^\"]*)\"$")
	public void enters_an_valid_city_name(String city) throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Your city name']")).sendKeys(city);
	}

	@Then("^Searches for the weather$")
	public void searches_for_the_weather() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-orange']")).click();
	}

	@And("^Verifies that website suggests city is \"([^\"]*)\"$")
	public void verifies_that_website_suggests_city_is(String msg) throws Throwable {
		String resultText = driver.findElement(By.xpath("//div[text()='Not found']")).getText();
		if (!resultText.contains(msg)) {
			Assert.fail("Message " + msg + " not found in the page");
		}
	}

	@And("^Verifies that website successfully returns weather details for the city \"([^\"]*)\"$")
	public void verifies_that_website_successfully_returns_weather_details_for_the_city(String city) throws Throwable {
		String verifyCity = driver.findElement(By.xpath("//table[@class='table']//tr")).getText();
		if (!verifyCity.contains(city)) {
			Assert.fail("Message " + city + " not found in the page");
		}
	}

	@When("^Click on the \"([^\"]*)\" dropdown link$")
	public void click_on_the_dropdown_link(String arg1) throws Throwable {
		driver.findElement(By.xpath("//a[@class='nav__link dropdown-toggle bg-hover-color']")).click();
	}

	@Then("^verify below links inside the maps$")
	public void verify_below_links_inside_the_maps(DataTable table) throws Throwable {

		List<String> listData = table.asList(String.class);
		int sublinks = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a")).size();
		for (int i = 1; i <= sublinks; i++) {
			String subText = driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[" + i + "]/a")).getText();
			System.out.println(subText);
			if (listData.contains(subText)) {
				System.out.println("pass");
			} else {
				Assert.fail(subText + "not found on the page");
			}
		}
	}

	@Then("^verify below links on the website$")
	public void verify_below_links_on_the_website(DataTable table) throws Throwable {

		String linksName = "";

		List<String> listData = table.asList(String.class);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (WebElement link : allLinks) {
			linksName = linksName + "," + link.getText();
		}

		for (String data : listData) {
			if (linksName.contains(data)) {
				System.out.println("pass");
			} else {
				Assert.fail(data + " not found on the page");
			}
		}
	}

	@Before
	public void hookBefore() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\M1051616\\Selenium Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void afterHook() {
		driver.close();
	}
}
