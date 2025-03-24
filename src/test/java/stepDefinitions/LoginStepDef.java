package stepDefinitions;
import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.MyAccountHomePage;
import pageObjects.MyDashboardPage;
import utilities.DataReader;

public class LoginStepDef {
	 WebDriver driver;
	 MyAccountHomePage hp = new MyAccountHomePage(BaseClass.getDriver());
     LoginPage lp = new LoginPage(BaseClass.getDriver());
     MyDashboardPage macc = new MyDashboardPage(BaseClass.getDriver());
     Logger logger = BaseClass.getLogger();
     List<HashMap<String, String>> datamap;
	@Given("user is on login page")
	public void user_is_on_login_page() {
	   logger.info("Clicking on my account");
	   hp.clickOnMyAcc();
	   logger.info("Clicking on login account");
	   hp.clickOnMyaccLoginBtn();
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    lp.setLoginEmail(email);
	    lp.setLoginPass(password);
	    logger.info("Entered username and password");
	}

	@When("click on login button")
	public void click_on_login_button() {
		lp.clickOnLoginBtn();
		logger.info("Clicked on login button");
	}

	@Then("verify my account header exists")
	public void verify_my_account_header_exists() {
		Boolean myAccountStat = macc.isMyAccountHeaderDisplayed();
		Assert.assertTrue(myAccountStat);
		logger.info("Login scenario got completed");
	}
	
	@Then("the user should be redirected to the MyAccount Page by passing email {string}, password {string}, and status {string}")
	public void the_user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password(String email,
																								   String password,
																								   String status) {
		logger.info(email);
		logger.info(status);
		boolean loginStatus = lp.verifyUserLoginDTT(hp.myAccountBtnEle, 
							  macc.myAccountHeader, 
							  email, 
							  password, 
							  status,
							  hp.logoutBtn);
		
		Assert.assertTrue(loginStatus);
	}
	
	@Then("the user should be redirected to the MyAccount Page by passing email, password with row index {string}")
	public void loginDDT(String rows) {
		datamap = DataReader.dataReader(System.getProperty("user.dir")+"\\testdata\\login-test-data.xlsx", "Sheet1");
        int index = Integer.parseInt(rows) - 1;
        String email = datamap.get(index).get("username");
        String password = datamap.get(index).get("password");
        String status = datamap.get(index).get("status");
    	boolean loginDDTStatus = lp.verifyUserLoginDTT(hp.myAccountBtnEle, 
				  macc.myAccountHeader, 
				  email, 
				  password, 
				  status,
				  hp.logoutBtn);
    	Assert.assertTrue(loginDDTStatus);
	}
}
