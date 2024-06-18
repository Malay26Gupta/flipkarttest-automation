package PomFlipkart;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	
	@FindBy(xpath ="//div[contains(text(), 'Sorry, no results found!')]")
	private WebElement noResultMessage;
	
	@FindBy(xpath ="//div[normalize-space()='Price -- Low to High']")
	private WebElement priceFilter;
	
	@FindBy(xpath ="//div[@class='DOjaWF gdgoEp']")
	private List<WebElement> productResults;
	
	private By productListLocator = By.xpath("//div[@class='DOjaWF gdgoEp']");
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}

	public boolean areResultsFound()
	{
		logger.info("Checking if search results are found. ");
		return productResults.size() > 0;
	}
	
	public boolean areResultsNotFound()
	{
		logger.info("Checking if no search results are found. ");
		return isElementVisible(noResultMessage);
	}
	
	public void NavigateToFilterPriceLowToHigh()
	{
		logger.info("Navigating to Price Low to High");
		click(priceFilter);
	}
	
	public void clickOnFirstProduct()
	{
		//store to current window handle
		String originalWindow = driver.getWindowHandle();
		
		List<WebElement> products = driver.findElements(productListLocator);
		if(!products.isEmpty())
		{
			for (WebElement product : products)
			{
				try
				{
					//ensure products opens in same window
					((JavascriptExecutor) driver).executeScript("arguments[0].target='_self';",product);
					
					//click on product link
					product.click();
					
					//handle the new tab /window if it opens
					Set<String> windowHandles = driver.getWindowHandles();
					for (String handle : windowHandles)
					{
						if(!handle.equals(originalWindow))
						{
							driver.switchTo().window(handle);
							break;
						}
					}
					
					//close the new tab and switch to original tab if necessary
					if(driver.getWindowHandle().equals(originalWindow))
					{
						driver.close();
						driver.switchTo().window(originalWindow);
					}
					break;	
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		else
		{
			System.out.println("No products found in search result.");
		}
	}

}
