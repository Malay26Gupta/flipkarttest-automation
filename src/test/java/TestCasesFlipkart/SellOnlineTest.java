package TestCasesFlipkart;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PomFlipkart.HomePage;
import PomFlipkart.SellOnlinePage;
import Utilities.ExcelUtil;


public class SellOnlineTest extends baseTest {
	
	@DataProvider(name = "searchData")
    public Object[][] searchData() {
        // Specify the Excel file path, sheet name, and testCaseID
        String filePath = ".\\src\\test\\resources\\testExitData.xlsx";
        String sheetName = "Sheet1";
        String testCaseID = "TC_14"; // Example testCaseID, replace with actual value

        return ExcelUtil.getTestData(filePath, sheetName, testCaseID);
    }
	
	@DataProvider(name = "sellData")
    public Object[][] sellonlineData() {
        // Specify the Excel file path, sheet name, and testCaseID
        String filePath = ".\\src\\test\\resources\\testExitData.xlsx";
        String sheetName = "Sheet1";
        String testCaseID = "TC_15"; // Example testCaseID, replace with actual value

        return ExcelUtil.getTestData(filePath, sheetName, testCaseID);
    }
	

	@Test(dataProvider = "searchData", priority = 1)
	public void testUserInSellOnline(String searchTerm, String isValidSearch)
	{
		logger.info("Executing test case: Verify user landed on sell online page. ");
		
		HomePage homePage = new HomePage(driver);
		//navigate to the sell online page
		homePage.navigateToSellOnline();
		
		SellOnlinePage sellonlinePage = new SellOnlinePage(driver);
		//check if seller text is visble
		boolean sellonlineWithFlipkart = sellonlinePage.issellerTextVisible();
		Assert.assertTrue(sellonlineWithFlipkart, "Expected text is visble. ");
		
		logger.info("Verify user landed on sell online page test passed.");
	}
	
	@Test(dataProvider = "sellData", priority = 2)
	public void testCoverTopicOfYourChoice(String searchTerm, String isValidSearch)
	{
		logger.info("Executing test case: Verify user landed on sell online page. ");
		
		HomePage homePage = new HomePage(driver);
		//navigate to the sell online page
		homePage.navigateToSellOnline();
		
		SellOnlinePage sellonlinePage = new SellOnlinePage(driver);
		//check if cart is empty by default
		boolean sellonlineWithFlipkart = sellonlinePage.issellerTextVisible();
		Assert.assertTrue(sellonlineWithFlipkart, "Expected text is visble. ");
		
		sellonlinePage.clickOnLearntab();
		sellonlinePage.clickSellerBlogsLink();
		
		boolean wouldLikeVisible = sellonlinePage.isTextvisible();
		Assert.assertTrue(wouldLikeVisible, "Expected text is visible. ");
		
		sellonlinePage.fillDetails(null, null);
		
		logger.info("failed test passed.");
	}
}
