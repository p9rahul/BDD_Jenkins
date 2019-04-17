package com.pom.allpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	@FindBy(id = "email")
	WebElement emailID;

	@FindBy(id = "pass")
	WebElement password;

	@FindBy(xpath = "//input[@value='Log In']")
	WebElement submitLogin;

	@FindBy(xpath = "//*[contains(text(),'Sign up for Facebook')]")
	WebElement verifyLogin;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Login page launch successfull");
	}

	public void loginToFaceBook(String emailAddress, String password) {
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnLoginButton();
	}

	public void enterEmailAddress(String emailAddress) {
		this.emailID.sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickOnLoginButton() {
		this.submitLogin.click();
	}

	public boolean verifySuccessLoginMsg() {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		boolean status = this.verifyLogin.isDisplayed();
		return status;
	}
}
