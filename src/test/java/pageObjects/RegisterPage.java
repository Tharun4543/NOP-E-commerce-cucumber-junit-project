package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameInp;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameInp;
	
	
	@FindBy(id = "input-email")
	private WebElement emailInp;
	
	@FindBy(id = "input-telephone")
	private WebElement telphoneInp;
	
	@FindBy(id = "input-password")
	private WebElement passwordinp;
	
	@FindBy(id = "input-confirm") 
	private WebElement confirmPassInp;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyCheckBox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;
	
	public void setRegisterData(String firstname,
								String lastname, 
								String email,
								String telphone,
								String pass,
								String confirmpass
								) {
		enterText(firstNameInp, firstname);
		enterText(lastNameInp, lastname);
		enterText(emailInp, email);
		enterText(telphoneInp, telphone);
		enterText(passwordinp, pass);
		enterText(confirmPassInp, confirmpass);
		clickElement(privacyCheckBox);
		clickElement(continueBtn);
	}
}
