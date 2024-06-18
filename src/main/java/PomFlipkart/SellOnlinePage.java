package PomFlipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellOnlinePage extends BasePage {

	@FindBy(xpath = "//span[text()='Sell Online with Flipkart']")
	private WebElement sellOnlineMessage;
	
	@FindBy(xpath = "//ul[@class='sd-header-list-container clearfix']//a[@class='sd-header-link'][normalize-space()='Learn']")
	private WebElement LearnButton;
	
	@FindBy(xpath = "//a[@class='sd-header-sub-link'][normalize-space()='Seller Blogs']")
	private WebElement bestSellerbutton;
	
	@FindBy(xpath = "//span[@class='styles__ColoredSpan-sc-9gh8xq-2 enNEVb']")
	private WebElement wouldyouLikeTextVisible;
	
	@FindBy(xpath = "//div[@class='styles__InputContainer-cql555-0 iRkbXM collection-input-container']")
	private WebElement mobileNumber;
	
	@FindBy(xpath = "//div[@class='styles__InputContainer-cql555-0 iRkbXM collection-text-area-input-container']")
	private WebElement enterMessage;
	
	@FindBy(xpath = "//button[text()='Send Request']")
	private WebElement sendRequestButton;

	public SellOnlinePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean issellerTextVisible()
	{
		logger.info("Checking if cart is empty. ");
		return isElementVisible(sellOnlineMessage);
	}
	
	public void clickOnLearntab()
	{
		click(LearnButton);
	}
	
	public void clickSellerBlogsLink()
	{
		click(bestSellerbutton);
	}
	
	public boolean isTextvisible()
	{
		logger.info("Checking if text is visible.");
		return isElementVisible(wouldyouLikeTextVisible);
	}
	
	public void fillDetails(String number, String message)
	{
		sendKeys(mobileNumber, number);
		sendKeys(enterMessage, message);
		click(sendRequestButton);
	}
}
