package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.ajay.BaseClass;
import com.pom.allpage.LoginPage;

public class TestcaseAjay extends BaseClass {

	@Test(description = "Login test with invalid credentials")
	public void testLoginToApplication() {

		LoginPage login1 = new LoginPage(driver);
		login1.loginToFaceBook("abc@gmail.com", "Demo@123");
		boolean status = login1.verifySuccessLoginMsg();
		Assert.assertTrue(status);
	}
}
