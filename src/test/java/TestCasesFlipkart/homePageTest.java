package TestCasesFlipkart;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PomFlipkart.BedsheetPage;
import PomFlipkart.DryFruitsPage;
import PomFlipkart.GamingKeybordPage;
import PomFlipkart.GirlsDressesPage;
import PomFlipkart.HomePage;
import Utilities.ExcelUtil;


public class homePageTest extends baseTest {
	
	@DataProvider(name = "HomeDataLoad")
	public Object[][] HomeDataValid()
	{
		return ExcelUtil.getTestData(".\\src\\test\\resources\\testExitData.xlsx", "Sheet1", "TC_01");
	}
	
	@DataProvider(name = "DressesDataLoad")
	public Object[][] DataDressesValid()
	{
		return ExcelUtil.getTestData(".\\src\\test\\resources\\testExitData.xlsx", "Sheet1", "TC_02");
	}
	
	@DataProvider(name = "GamingDataLoad")
	public Object[][] GamingKeyboardDataValid()
	{
		return ExcelUtil.getTestData(".\\src\\test\\resources\\testExitData.xlsx", "Sheet1", "TC_03");
	}
	
	@DataProvider(name = "BedsheetDataLoad")
	public Object[][] DataBedValid()
	{
		return ExcelUtil.getTestData(".\\src\\test\\resources\\testExitData.xlsx", "Sheet1", "TC_04");
	}
	
	@DataProvider(name = "BeautyToysDataLoad")
	public Object[][] DataToysValid()
	{
		return ExcelUtil.getTestData(".\\src\\test\\resources\\testExitData.xlsx", "Sheet1", "TC_05");
	}
	
	@DataProvider(name = "LoginDataLoad")
	public Object[][] loginDataValid()
	{
		return ExcelUtil.getTestData(".\\src\\test\\resources\\testExitData.xlsx", "Sheet1", "TC_06");
	}
	
	
	@Test(priority = 3, dataProvider = "HomeDataLoad", enabled = true)
	public void testHomePageLoad(String searchTerm, String isValidSearch)
	{
		logger.info("Executing home page load test: ");
		HomePage homePage = new HomePage(driver);
		boolean isBannerDisplayed = homePage.isMainBannerDisplayed();
		Assert.assertTrue(isBannerDisplayed, "Main banner is not dispalyed on home page. ");
		
		boolean isLoginButtondisplayed = homePage.isLoginButtonDisplayed();
		Assert.assertTrue(isLoginButtondisplayed, "Login button is not visible");
		
		logger.info("Home page load test passed. ");
	}
	
	
	@Test(priority = 4, dataProvider = "DressesDataLoad", enabled = true)
	public void testhoverAndClickGirlsDresses(String searchTerm, String isValidSearch)
	{
		logger.info("Executing hover to fashion functionality :  ");
		
		HomePage homePage = new HomePage(driver);
		homePage.moveFashionLink();
		homePage.movekidsLink();
		homePage.clickGirlsDressesLink();
		
		//verify that user is on girls dress page
		GirlsDressesPage girlsDressPage = new GirlsDressesPage(driver);
		Assert.assertTrue(girlsDressPage.isDressHeadingDisplayed(), "Dresses heading is not displayed");
		
		String expectedTitle = "Store - Buy Store Online at Best Prices In India | Flipkart.com";
		String actualTitle = getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match");
		
		logger.info("Hover to fashion functionality test passed. ");
	}
	
	@Test(priority = 5, dataProvider = "GamingDataLoad", enabled = true)
	public void testhoverAndClickGamingKeyboard(String searchTerm, String isValidSearch)
	{
		logger.info("Executing hover to electronics functionality :  ");
		HomePage homePage = new HomePage(driver);
		homePage.moveToElectronicsLink();
		homePage.moveToGamingLink();
		homePage.clickGamingKeyboardLink();
		
		//verify user landed on gaming keyboard page 
		GamingKeybordPage gamingKeyboard = new GamingKeybordPage(driver);
		Assert.assertTrue(gamingKeyboard.isKeyboardHeadingDisplayed(),"keyboard heading is not displayed");
		
		String expectedTitle = "Gaming Keyboards - Buy Gaming Keyboards Online at Best Prices in India | Flipkart.com";
		String actualTitle = getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match");
		
		
		logger.info("Hover to electronics functionality test passed. ");
	}
	
	@Test(priority = 6, dataProvider = "BedsheetDataLoad", enabled = true)
	public void testhoverAndClickBedsheets(String searchTerm, String isValidSearch)
	{
		logger.info("Executing hover to home & furniture functionality :  ");
		HomePage homePage = new HomePage(driver);
		homePage.moveToHomeFurnitureLink();
		homePage.moveToFurnishingLink();
		homePage.clickBedsheetLink();
		
		//verify user landed on bedsheet page 
		BedsheetPage bedsheetPage = new BedsheetPage(driver);
		Assert.assertTrue(bedsheetPage.isBedsheetHeadingDisplayed(), "Bedsheet heading is not displayed");
		
		String expectedTitle = "Bedsheets/Blankets Online in India | 12-Jun-24";
		String actualTitle = getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match");
		
		
		logger.info("Hover to home & furniture functionality test passed. ");
	}
	

	@Test(priority = 7, dataProvider = "BeautyToysDataLoad", enabled = true)
	public void testhoverAndClickBeautyToys(String searchTerm, String isValidSearch)
	{
		logger.info("Executing hover to beauty toys and more functionality :  ");
		HomePage homePage = new HomePage(driver);
		homePage.moveToBeautyMoreLink();
		homePage.moveToFoodDrinksLink();
		homePage.clickNutsFruitsLink();
		
		//verify user landed on nuts and dry fruits page 
		DryFruitsPage dryFruitsnut = new DryFruitsPage(driver);
		Assert.assertTrue(dryFruitsnut.isDryFruitNutsHeadingDisplayed(), "Dryfruits heading is not displayed");

		
		logger.info("Hover to beauty,toys and more functionality test passed. ");
	}
	
	@Test(priority = 8, dataProvider = "LoginDataLoad", enabled = true)
	public void testLoginButtonNotVisible(String searchTerm, String isValidSearch)
	{
		logger.info("Executing neagtive test case : ");
		
		//verify login button is not visible
		HomePage homePage = new HomePage(driver);
		boolean isLoginButtonVisible = homePage.isLoginButtonDisplayed();
		Assert.assertFalse(isLoginButtonVisible, "login button is not visible, but it should not be ");
		
		logger.info("negative  test passed. ");
	}
}
