package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "input-email")
	public WebElement userEmail;
	
	@FindBy(id = "input-password")
	public WebElement userPassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginBtn;
	
	public void setLoginEmail(String email) {
		enterText(userEmail, email);
	}
	
	public void setLoginPass(String pass) {
		enterText(userPassword, pass);
	}
	
	public void clickOnLoginBtn() {
		clickElement(loginBtn);
	}
	
	
	public boolean verifyUserLoginDTT(WebElement mah,
			WebElement mdp,
            String emailLogin,
            String passwordLogin,
            String accountStatusLogin,
            WebElement logout) {
		boolean currentAccStatus = false;  // Initialize with default value
		waitUntilEleDisplayed(userEmail);
		enterText(userEmail, emailLogin);
		enterText(userPassword, passwordLogin);
		clickElement(loginBtn);
		boolean isLoggedIn;
		try {
			 isLoggedIn = isElementDisplayed(mdp); // Store login status
		}
		catch (Exception e) {
			isLoggedIn = false;
		}
		if (isLoggedIn && accountStatusLogin.equals("valid")) {
			currentAccStatus = true;
			logOut(mah, logout);
			
		}
		else if (!isLoggedIn && accountStatusLogin.equals("invalid")) {
			currentAccStatus = true;
		} 
		else if(isLoggedIn && accountStatusLogin.equals("invalid")){
			currentAccStatus = false;
			logOut(mah, logout);
			
		}
		else if(!isLoggedIn && accountStatusLogin.equals("valid")){
			currentAccStatus = false;
		}
		return currentAccStatus;
	}
	
	public void logOut(WebElement mah, WebElement logout) {
		waitUntilEleDisplayed(mah);
		clickElement(mah);
		clickElement(logout);
	}
}
