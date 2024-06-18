package TestCasesFlipkart;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PomFlipkart.HomePage;
import PomFlipkart.ProductPage;
import PomFlipkart.SearchPage;
import Utilities.ExcelUtil;



public class ProductPageTest extends baseTest {
	
	@DataProvider(name = "ProductDetailTestData")
	public Object[][] productDetaiPageTestData()
	{
		return ExcelUtil.getTestData(".\\src\\test\\resources\\testExitData.xlsx", "Sheet1", "TC_11");
	}
	
	
	@Test(priority = 1, dataProvider = "ProductDetailTestData", enabled=true)
	public void testProductDetailPage(String searchTerm, String isValidSearch)
	{
		//if("Product detail Page test".equalsIgnoreCase(description))
		logger.info("Executing product Detail page test case with serach term : " + searchTerm);
		
		HomePage homePage = new HomePage(driver);
		homePage.searchProduct(searchTerm);
			
		if(isValidSearch.equalsIgnoreCase("Yes"))
		{
			//click on the first product of search results
			SearchPage searchResultsPage = new SearchPage(driver);
			searchResultsPage.clickOnFirstProduct();
				
			//verify product details page elements
			ProductPage productDetailsPage = new ProductPage(driver);
			Assert.assertTrue(productDetailsPage.isAddToCartDisplayed(), "Expected add to cart displayed");
				
				
			//String productName = productDetailsPage.getproductName();
			//Assert.assertNotNull(productName, "Expected product name to be displayed");
				
			//String productPrice = productDetailsPage.getProductPrice();
			//Assert.assertNotNull(productPrice, "Expected product price to be displayed");
				
			logger.info(" product Detail page test case passed. ");
		}
	}
}
