package TestCasesFlipkart;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import Utilities.configReader;
import Utilities.driverManager;

public class baseTest {
	
	protected WebDriver driver;
	protected final Logger logger = LogManager.getLogger(this.getClass());
	
	@BeforeClass
	public void setup()
	{
		logger.info("Initializing webDriver");
		driver = driverManager.getDriver();
		driver.get(configReader.getProperty("url"));
		logger.info("Navigating to URL: " + configReader.getProperty("url"));
	}
	
	/*@AfterClass
	public void tearDown()
	{
		logger.info("Quit the webDriver");
		driverManager.quitDriver();
	}*/
	
	//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
}
