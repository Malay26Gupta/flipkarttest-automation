package PomFlipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GirlsDressesPage extends BasePage {
	

	@FindBy(xpath = "//h1[text()='Dresses']")
	private WebElement textDress;
	
	public GirlsDressesPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDressHeadingDisplayed()
	{
		return textDress.isDisplayed();
	}

}
