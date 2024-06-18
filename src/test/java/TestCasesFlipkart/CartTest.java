package TestCasesFlipkart;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import PomFlipkart.CartPage;
import PomFlipkart.HomePage;
import Utilities.ExcelUtil;

public class CartTest extends baseTest
{
	
	@DataProvider(name = "searchData")
    public Object[][] searchData() {
        // Specify the Excel file path, sheet name, and testCaseID
        String filePath = ".\\src\\test\\resources\\testExitData.xlsx";
        String sheetName = "Sheet1";
        String testCaseID = "TC_13"; // Example testCaseID, replace with actual value

        return ExcelUtil.getTestData(filePath, sheetName, testCaseID);
    }
	
	@Test(dataProvider = "searchData", priority = 1)
	public void testCartIsEmptyDefault(String searchTerm, String isValidSearch)
	{
		logger.info("Executing test case: Verify cart is empty by default");
		
		HomePage homePage = new HomePage(driver);
		//navigate to the cart page
		homePage.navigateToCart();
		
		//check if cart is empty by default
		CartPage cartPage = new CartPage(driver);
		boolean isCartEmpty = cartPage.isCartEmpty();
		Assert.assertTrue(isCartEmpty, "Expected cart to be empty byb default. ");
		
		logger.info("Verify cart is empty by default test passed.");
	}
}
