package PomFlipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	@FindBy(xpath = "//div[@class='s2gOFd']")
	private WebElement emptyCartMessage;

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isCartEmpty()
	{
		logger.info("Checking if cart is empty. ");
		return isElementVisible(emptyCartMessage);
	}
}
