package PomFlipkart;

import java.time.Duration;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.configReader;

public abstract class BasePage {
	

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected final Logger logger = LogManager.getLogger(this.getClass());
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		int globalWaitTime = Integer.parseInt(configReader.getProperty("globalWaitTime"));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(globalWaitTime));
		PageFactory.initElements(driver, this);
	}

	protected void waitForVisibility(WebElement element)
	{
		logger.info("Waiting for visibility of element: " + element);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void click(WebElement element)
	{
		waitForVisibility(element);
		logger.info("Click on the element: " + element);
		element.click();
	}
	
	protected void sendKeys(WebElement element, String text)
	{
		waitForVisibility(element);
		logger.info("Sending keys to element: " + element);
		element.sendKeys(text);
	}
	
	protected String getText(WebElement element)
	{
		waitForVisibility(element);
		logger.info("Getting text from element: " + element);
		return element.getText();
	}
	
	protected void scrollToElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		logger.info("Scroll to element: " + element);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	protected boolean isElementVisible(WebElement element)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Element is visible: " + element);
			return true;
		}
		catch(Exception e)
		{
			logger.warn("Element is not visible : " + element);
			return false;
		}
	}
	
	protected boolean isElementClickable(WebElement element)
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
			logger.info("Element is clickable: " + element);
			return true;
		}
		catch(Exception e)
		{
			logger.warn("Element is not clickable:" + element);
			return false;
		}
	}
	
	protected void waitForPageToLoad()
	{
		new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configReader.getProperty("globalWaitTime"))))
				.until(new Function<WebDriver, Object>() {
					@Override
					public Object apply(WebDriver webDriver) {
						return ((JavascriptExecutor) webDriver)
						.executeScript("return document.readyState").equals("complete");
					}
				});
		logger.info("Page has loaded completely");
	}
}

