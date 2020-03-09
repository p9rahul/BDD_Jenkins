package DockerPack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DockerUtil {
	
	@Test
	public void testCase1() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),cap);
		driver.get("http://google.com/");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("Rahul padey");
		Thread.sleep(3000);
		System.out.println("Pass");
		driver.quit();
	}

}
