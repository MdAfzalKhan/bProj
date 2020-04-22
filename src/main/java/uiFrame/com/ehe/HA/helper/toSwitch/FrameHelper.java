package uiFrame.com.ehe.HA.helper.toSwitch;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uiFrame.com.ehe.HA.helper.logger.LoggerHelper;

public class FrameHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	/**
	 * switch to frame based on index
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		log.info("switched to : " + index + " frame");
	}
	/**
	 * switch to frame based on name
	 * @param name
	 */
	public void switchToFrame(String name) {
		driver.switchTo().frame(name);
		log.info("switched to : " + name + " frame");
	}
	/**
	 * based on web element
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		log.info("switched to frame : " + element.toString());
	}

}
