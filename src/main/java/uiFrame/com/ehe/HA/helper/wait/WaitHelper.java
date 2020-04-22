package uiFrame.com.ehe.HA.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import uiFrame.com.ehe.HA.helper.logger.LoggerHelper;

public class WaitHelper {
	
	//as rule of thump we have to get log of every helper class at beginning of that class
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	//other class has to provide Webdriver to make an object of this class and driver will be initialized this way
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	private WebDriver driver;
	
	//method to set implicit wait
	/**
	 * This is implicit wait help
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit Wait has been set to : " + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
		
	}
	
	/**
	 * this will help us to get WebDriverWait object
	 * @param timeOutInSeconds
	 * @param pollingEvery
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
 		return wait;
	}
	
	/**
	 * this method will make sure element is visible
	 * @param element
	 * @param timeOutInsce
	 * @param pollingEveryMilliSec
	 */
	public void waitForElementVisibleWithPollingTime(WebElement element, int timeOutInsce, int pollingEveryMilliSec) {
		log.info("waiting for : " + element.toString() + " for : " + timeOutInsce + " seconds");
		WebDriverWait wait = getWait(timeOutInsce, pollingEveryMilliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}
	/**
	 * this method will make sure element is clickable
	 * @param element
	 * @param timeOutInsce
	 * @param pollingEveryMilliSec
	 */
	public void waitForElementClickableWithPollingTime(WebElement element, int timeOutInsce, int pollingEveryMilliSec) {
		log.info("waiting for : " + element.toString() + " for : " + timeOutInsce + " seconds");
		WebDriverWait wait = getWait(timeOutInsce, pollingEveryMilliSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element is clickable now");
	}
	
	
	/**
	 * this method will make sure element is invisible
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
		log.info("waiting for : " + element.toString() + " for : " + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is invisible now");
	}
	
	/**
	 * this will wait for frame and switched to it
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForFrameToBeAvailable(WebElement element, long timeOutInSeconds) {
		log.info("waiting for : " + element.toString() + " for : " + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is available and switched");
	}
	
	/**
	 * get FluentWait
	 * @param timeOutInSec
	 * @param pollingInEveryMiliSec
	 * @return
	 */
	private FluentWait<WebDriver> getFluentWait(int timeOutInSec, int pollingInEveryMiliSec) {
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSec))
				.pollingEvery(Duration.ofMillis(pollingInEveryMiliSec))
				.ignoring(NoSuchElementException.class);
		return fwait;
	}
	
	/**
	 * return element that requires fluent wait
	 * @param element
	 * @param timeOutInSec
	 * @param pollingInEveryMiliSec
	 */
	public WebElement waitForElement(WebElement element, int timeOutInSec, int pollingInEveryMiliSec) {
		FluentWait<WebDriver> fwait = getFluentWait(timeOutInSec, pollingInEveryMiliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	/**
	 * metod to apply page time out
	 * @param timeOut
	 * @param unit
	 */
	public void pageLoadTime(long timeOut, TimeUnit unit) {
		log.info("waiting for page to laod for : " + unit);
		driver.manage().timeouts().pageLoadTimeout(timeOut, unit);
		
	}
	
	
	
	
	
	
	
	
	
	

}
