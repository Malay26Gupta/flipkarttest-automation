package PomFlipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
		@FindBy(xpath = "//div[@class='_16ZfEv']")
		private WebElement mainBanner;
		
		@FindBy(xpath = "//span[text()='Login']")
		private WebElement loginButton;
		
		@FindBy(name = "q")
		private WebElement searchBox;
		
	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement searchButton;
	    
	    @FindBy(xpath = "//a[@class='_3RX0a-']")
	    private WebElement cartIcon;
	    
	    @FindBy(xpath = "//a[@class='_3RX0a- _3jeYYh']")
	    private WebElement sellOnlineIcon;
	  
	    @FindBy(xpath = "//span[text()='Fashion']")
	    private WebElement fashionLink;
	    
	    @FindBy(xpath = "//a[text()='Kids']")
	    private WebElement kidsLink;
	    
	    @FindBy(xpath = "//a[normalize-space()='Girls Dresses']")
	    private WebElement girlsDressesLink;
	    
	    @FindBy(xpath = "//span[text()='Electronics']")
	    private WebElement electronicsLink;
	    
	    @FindBy(xpath = "//a[text()='Gaming']")
	    private WebElement gamingLink;
	    
	    @FindBy(xpath = "//a[text()='Gaming Keyboards']")
	    private WebElement gamingKeyboardLink;
	    
	    @FindBy(xpath = "//span[text()='Home & Furniture']")
	    private WebElement homeFurnitureLink;
	    
	    @FindBy(xpath = "//a[text()='Home Furnishings']")
	    private WebElement furnishingLink;
	    
	    @FindBy(xpath = "//a[text()='Bedsheets']")
	    private WebElement BedsheetLink;
	    
	    @FindBy(xpath = "//span[text()='Beauty, Toys & More']")
	    private WebElement beautyToysLink;
	    
	    @FindBy(xpath = "//a[text()='Food & Drinks']")
	    private WebElement foodsLink;
	    
	    @FindBy(xpath = "//a[text()='Nuts & Dry Fruits']")
	    private WebElement NutsDryfruitsLink;
	    
	    public HomePage(WebDriver driver)
	    {
	    	super(driver);
	    }
	    
	    Actions actions = new Actions(driver);
		
	    public void moveFashionLink()
		{
	    	//click(fashionLink);
			actions.moveToElement(fashionLink).build().perform();
		}
		
		public void movekidsLink()
		{
			//Actions actions = new Actions(driver);
			actions.moveToElement(kidsLink).perform();
		}
		
		public void clickGirlsDressesLink()
		{
			Actions actions = new Actions(driver);
			actions.moveToElement(girlsDressesLink).click().perform();
		}
		
		public void moveToElectronicsLink()
		{
			actions.moveToElement(electronicsLink).perform();
		}
		
		public void moveToGamingLink()
		{
			actions.moveToElement(gamingLink).perform();
		}
		
		public void clickGamingKeyboardLink()
		{
			actions.moveToElement(gamingKeyboardLink).click().perform();
		}
		
		public void moveToHomeFurnitureLink()
		{
			actions.moveToElement(homeFurnitureLink).perform();
		}
		
		public void moveToFurnishingLink()
		{
			actions.moveToElement(furnishingLink).perform();
		}
		
		public void clickBedsheetLink()
		{
			actions.moveToElement(BedsheetLink).click().perform();
		}
		
		public void moveToBeautyMoreLink()
		{
			actions.moveToElement(beautyToysLink).perform();
		}
		
		public void moveToFoodDrinksLink()
		{
			actions.moveToElement(foodsLink).perform();
		}
		
		public void clickNutsFruitsLink()
		{
			actions.moveToElement(NutsDryfruitsLink).click().perform();
		}
	    
	    public boolean isMainBannerDisplayed()
	    {
	    	logger.info("Checking if the main banner is displayed. ");
	    	return isElementVisible(mainBanner);
	    }
	    
	    public boolean isLoginButtonDisplayed()
	    {
	    	logger.info("Check if login button is displayed. ");
	    	return isElementVisible(loginButton);
	    }
	    
	    public void searchProduct(String searchTerm)
	    {
	    	logger.info("Searching for product: " + searchTerm);
	    	sendKeys(searchBox, searchTerm);
	    	click(searchButton);
	    }
	    
	    public void navigateToCart()
	    {
	    	logger.info("navigating to the cart page. ");
	    	click(cartIcon);
	    }
	    
	    public void navigateToSellOnline()
	    {
	    	logger.info("Navigating to the sell online page. ");
	    	click(sellOnlineIcon);
	    }
}
