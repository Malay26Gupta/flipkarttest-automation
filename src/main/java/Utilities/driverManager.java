package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class driverManager {

private static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		if(driver == null)
		{
			String browser = configReader.getProperty("browser");
			boolean headless = configReader.isheadless();
			int globalWaitTime = configReader.getGlobalWaitTime();
			
			/*if("chrome".equalsIgnoreCase(browser))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\malaygupta\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				driver = initChromeDriver(headless);
			}
			else if("firefox".equalsIgnoreCase(browser))
			{
				System.setProperty("webdriver.gecko.driver", "");
				driver = initFirefoxDriver(headless);
			}
			else
			{
				throw new IllegalArgumentException("Browser not supported!");
			}*/
			
			if(browser.equalsIgnoreCase("chrome")) {
				if(headless) {
					ChromeOptions opt=new ChromeOptions();
					opt.addArguments("--headless=new");
					driver=new ChromeDriver(opt);
				}
				else {
					driver=new ChromeDriver();
				}
				
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(globalWaitTime));
			driver.manage().window().maximize();
		}
		return driver;
	}

	/*private static WebDriver initFirefoxDriver(boolean headless) {
		FirefoxOptions options = new FirefoxOptions();
		if(headless)
		{
			options.addArguments("--headless");
		}
		return new FirefoxDriver(options);
	}

	private static WebDriver initChromeDriver(boolean headless) {
		ChromeOptions options = new ChromeOptions();
		if(headless)
		{
			options.addArguments("--headless");
		}
		return new ChromeDriver(options);
	}*/
	
	public static void quitDriver()
	{
		if(driver != null)
		{
			driver.quit();
			//driver = null;
		}
	}
}
