package PomFlipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
	
	@FindBy(xpath = "//span[@class='VU-ZEz']")
	private WebElement productName;
	
	@FindBy(xpath = "//div[@class='Nx9bqj CxhGGd']")
	private WebElement productPrice;
	
	@FindBy(xpath = "//button[@class='QqFHMw vslbG+ In9uk2']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//")
	private WebElement productRating;
	
	@FindBy(xpath = "//")
	private WebElement productImage;

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	

	public String getproductName()
	{
		return productName.getText();
	}
	
	public String getProductPrice()
	{
		return productPrice.getText();
	}
	
	public boolean isAddToCartDisplayed()
	{
		return addToCartButton.isDisplayed();
	}
	
	public boolean isProductRatingDisplayed()
	{
		return productRating.isDisplayed();
	}
	
	public boolean isProductImageDisplayed()
	{
		return productImage.isDisplayed();
	}
	
	public void clickAddCartButton()
	{
		click(addToCartButton);
	}

}
