package PomFlipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DryFruitsPage extends BasePage {
	
	@FindBy(xpath = "//h1[text()='Dry Fruit, Nut & Seed'] ")
	private WebElement textDryFruit;

	public DryFruitsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDryFruitNutsHeadingDisplayed()
	{
		
		return textDryFruit.isDisplayed();
	}
}
