package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyDashboardPage extends BasePage{

	public MyDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	public WebElement myAccountHeader;
	
	public boolean isMyAccountHeaderDisplayed() {
		return isElementDisplayed(myAccountHeader);
	}
	
	
}
