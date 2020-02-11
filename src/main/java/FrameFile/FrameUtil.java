package FrameFile;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Logfile.LoggerUtil;


public class FrameUtil {

	private WebDriver driver;
	private Logger log = LoggerUtil.getLogger(FrameUtil.class);
	
	public FrameUtil(WebDriver driver){
		this.driver = driver;
	}
	
	public void switchToFrame(int frameIndex){
		driver.switchTo().frame(frameIndex);
		log.info("switched to :"+ frameIndex+" frame");
	}
	
	public void switchToFrame(String frameName){
		driver.switchTo().frame(frameName);
		log.info("switched to :"+ frameName+" frame");
	}

	public void switchToFrame(WebElement element){
		driver.switchTo().frame(element);
		log.info("switched to frame "+element.toString());
	}
}
