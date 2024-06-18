package PomFlipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamingKeybordPage extends BasePage {
	
	@FindBy(xpath = "//h1[text()='Keyboards']")
	private WebElement textKeyboard;

	public GamingKeybordPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isKeyboardHeadingDisplayed()
	{
		
		return textKeyboard.isDisplayed();
	}
}
