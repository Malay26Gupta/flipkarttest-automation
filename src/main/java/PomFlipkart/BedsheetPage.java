package PomFlipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BedsheetPage extends BasePage {

	@FindBy(xpath = "//h1[text()='Bedsheets']")
	private WebElement textBedsheet;
	
	public BedsheetPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isBedsheetHeadingDisplayed()
	{
		
		return textBedsheet.isDisplayed();
	}
}
