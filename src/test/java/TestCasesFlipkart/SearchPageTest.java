package TestCasesFlipkart;

//import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PomFlipkart.HomePage;
import PomFlipkart.SearchPage;
import Utilities.ExcelUtil;


public class SearchPageTest extends baseTest {
	
	@DataProvider(name = "searchDataValid")
	public Object[][] searchDataValid()
	{
		return ExcelUtil.getTestData(".\\src\\test\\resources\\testExitData.xlsx", "Sheet1", "TC_09");
	}
	
	@DataProvider(name = "searchDataInValid")
	public Object[][] searchDataInValid()
	{
		return ExcelUtil.getTestData(".\\src\\test\\resources\\testExitData.xlsx", "Sheet1", "TC_10");
	}
	
	@DataProvider(name = "searchData")
	public Object[][] searchDataPricelowtoHigh()
	{
		return ExcelUtil.getTestData(".\\src\\test\\resources\\testExitData.xlsx", "Sheet1", "TC_12");
	}

	
	@Test(dataProvider = "searchDataValid", priority = 1)
	public void testSearchValidProduct(String searchTerm, String isValidSearch)
	{
		logger.info("Executing serch product test with searchterm: " + searchTerm);
		HomePage homePage = new HomePage(driver);
		
		homePage.searchProduct(searchTerm);
		
		if(isValidSearch.equalsIgnoreCase("Yes"))
		{
			SearchPage searchResultsPage = new SearchPage(driver);
			boolean resultsFound = searchResultsPage.areResultsFound();
			Assert.assertTrue(resultsFound, "Expected search results are not be found.");
			logger.info("Valid search test completed for searchTerm: " + searchTerm);
		}
	}
	
	@Test(dataProvider = "searchDataInValid", priority = 2)
	public void testInvalidSearch(String searchTerm, String isValidSearch)
	{
		if(isValidSearch.equalsIgnoreCase("No"))
		{
			logger.info("executing invalid search product test with searchterm: " + searchTerm);
			HomePage homePage = new HomePage(driver);
			
			homePage.searchProduct(searchTerm);
			
			SearchPage searchResultsPage = new SearchPage(driver);
			boolean noResultsFound = searchResultsPage.areResultsNotFound();
			Assert.assertTrue(noResultsFound, "Expected mesaage is not return by invalid search ");
			logger.info("Invalid test search test completed for " + searchTerm);
		}
	}
	
	@Test(dataProvider = "searchData", priority = 3)
	public void testFilterPriceLowToHigh(String searchTerm, String isValidSearch)
	{
		//String expectedResult = testData.get("ExpectedResult");
		
		if(isValidSearch.equalsIgnoreCase("Yes"))
		{
			logger.info("Executing test case to filter price Low to High : " + searchTerm);
			
			HomePage homePage = new HomePage(driver);
			homePage.searchProduct(searchTerm);
			
			SearchPage searchResultsPage = new SearchPage(driver);
			searchResultsPage.NavigateToFilterPriceLowToHigh();
			
			logger.info("Filter price based on low to high test passed for . " + searchTerm);
		}
	}
}
